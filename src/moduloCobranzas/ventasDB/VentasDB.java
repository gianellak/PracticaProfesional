package moduloCobranzas.ventasDB;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connections.ConnectionProvider;
import objetos.Persona;
import objetos.Usuario;
import objetos.Vehiculo;
import objetos.Venta;
import utilitarios.DBUtil;
import exceptions.DBException;
import exceptions.LoginException;
import moduloPrincipal.loginDB.LoginDBInterface;

public class VentasDB implements VentasDBInterface {
	
	private static final String SQL_CLIENT_BY_ID =
	        "SELECT * FROM Cliente WHERE dni=?";
	
	private static final String SQL_INSERT_PERSONA =
			 "INSERT INTO Persona VALUES (?, ?, ?, ?, ?)";	
	
	private static final String SQL_INSERT_VEHICULO =
			"INSERT INTO Persona VALUES (?, ?, ?, ?, ?)";	
	
	private static final String SQL_INSERT_VENTA =
			"INSERT INTO Persona VALUES (?, ?, ?, ?, ?)";	
	
	
	private static final String SQL_FIND_BY_ID =
			"SELECT * FROM Persona WHERE dni=?";
	
	private static final String SQL_VENTAS_BY_ID =
			"SELECT * FROM Ventas WHERE comprador=?";
	
	private static final String SQL_CAR_BY_ID =
			"SELECT * FROM vehiculo WHERE patente=?";
	
	private static final int MYSQL_DUPLICATE_PK = -104;

	private ConnectionProvider connectionProvider;


	 
	  public VentasDB(ConnectionProvider connection) {
	    this.connectionProvider = connection;
	  }



	

	@Override
	public Persona getPersona(int dni) throws DBException {
		Persona persona = null;
		
		Object[] values = {
				dni
		};
		
		try (
				Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_FIND_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();
				) 
				{
			if (resultSet.next()) {
				persona = map(resultSet);
			}
			} catch (SQLException e) {
			throw new DBException(e);
		}
		
		
		return persona;
	}
	

	

	private Persona map(ResultSet resultSet) throws SQLException {
		Persona persona = new Persona(
				resultSet.getInt("dni"),
				resultSet.getInt("telefono_p"), 
				resultSet.getInt("telefono_c"), 
				resultSet.getInt("telefono_l"), 
				resultSet.getString("nombre"), 
				resultSet.getString("apellido"),
				resultSet.getString("domicilio"),
				resultSet.getString("ciudad"),
				resultSet.getString("provincia"),
				resultSet.getString("domicilio_l"),
				resultSet.getString("empresa"));
		
		return persona;
	}



	private Venta mapVenta(ResultSet resultSet) throws SQLException {
		Venta venta = new Venta(
				resultSet.getInt("id_venta"),
				resultSet.getInt("comprador"),
				resultSet.getString("patente"),
				resultSet.getInt("garante"),
				resultSet.getString("descripcion"));
		
		return venta;
	}

	private Vehiculo mapVehiculo(ResultSet resultSet) throws SQLException {
		Vehiculo vehiculo = new Vehiculo(
				resultSet.getString("patente"),
				resultSet.getString("marca"),
				resultSet.getString("modelo"),
				resultSet.getDate("fecha_ingreso"),
				resultSet.getDate("fecha_venta"),
				resultSet.getString("comentarios"));
		
		return vehiculo;
	}

	@Override
	public List<Venta> traerVentas(int dni) throws DBException {
		
		List<Venta> lista = new ArrayList<Venta>();
		
		Object[] values = {
				dni
		};
		
		try (
				Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_VENTAS_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();
				) {
			
			if (resultSet.next()) {
				
				Venta a = mapVenta(resultSet);
				
				System.out.println(a.getIdVenta());
				
				lista.add(a);
			}
			
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return lista;
	}

	@Override
	public Vehiculo getVehiculo(String patente) throws DBException {
		Vehiculo vehiculo = null;
		
		Object[] values = {
				patente
		};
		
		try (
				Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_CAR_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();
				) {
			
			if (resultSet.next()) {
				vehiculo = mapVehiculo(resultSet);
			}
			
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		
		
		return vehiculo;
	}





	@Override
	public void altaPersona(Persona p) throws DBException {
		Object[] values = {
	            p.getDni(),
	            p.getTelefonoP(),
	            p.getTelefonoC(),
	            p.getTelefonoL(),
	            p.getNombre(),
	            p.getApellido(),
	            p.getDomicilio(),
	            p.getCiudad(),
	            p.getProvincia(),
	            p.getDomicilioL(),
	            p.getEmpresa()
	        };

	        try (
	            Connection connection = this.connectionProvider.getConnection();
	            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_INSERT_PERSONA, true, values);
	        ) 
	            
	        	{
		        	 statement.executeUpdate();
		        	 
		       } catch (SQLException e) {
		    	   if(e.getErrorCode() == MYSQL_DUPLICATE_PK){
		    		   throw new DBException("Duplicated Key, cannot insert product");
		    	    }else{
	            throw new DBException(e);}
	        }

	}





	
	

}