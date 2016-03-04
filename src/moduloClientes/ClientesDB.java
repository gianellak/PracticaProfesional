package moduloClientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import connections.ConnectionProvider;
import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;
import objetos.Venta;
import utilitarios.DBUtil;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.PanelAux;

public class ClientesDB  {
	
	private static final String SQL_INSERT_PERSONA =
			 "INSERT INTO Persona VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
	
	private static final String SQL_FIND_BY_ID =
			"SELECT * FROM Persona WHERE dni=?";
	
	private static final String SQL_UPDATE =
			 "UPDATE Persona SET telefono_p=?, telefono_c=?, telefono_l=?, nombre=?, apellido=?, domicilio=?,"
			 + "ciudad=?, provincia=?, domicilio_l=?, empresa=? WHERE DNI=?";
	
	private static final String SQL_DELETE =
	        "DELETE FROM Persona WHERE dni = ?";
	
	private static final int MYSQL_DUPLICATE_PK = -104;


	private ConnectionProvider connectionProvider;
	
	



	 
	  public ClientesDB(ConnectionProvider connection) {
		    this.connectionProvider = connection;
		  }
	

	
	
	public boolean delete(int u) throws DBException {
		
		Object[] values = { 
	            u
	            };

	        try (
	        	Connection connection = this.connectionProvider.getConnection();
	            		
	            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_DELETE, false, values);
	        ) {
	        	 int affectedRows = statement.executeUpdate();
	             if (affectedRows == 0) {
	                 throw new DBException("Deleting user failed, no rows affected.");
	               
	             }else{
	            	 return true;
	             }

	        } catch (SQLException e) {
	            throw new DBException(e);
	        }
	

	}


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
				persona = mapPersona(resultSet);
			}
			} catch (SQLException e) {
			throw new DBException(e);
		}
		
		
		return persona;
	}
	
	private Persona mapPersona(ResultSet resultSet) throws SQLException {
		Persona persona = new Persona(
				resultSet.getInt("dni"),
				resultSet.getString("telefono_p"), 
				resultSet.getString("telefono_c"), 
				resultSet.getString("telefono_l"), 
				resultSet.getString("nombre"), 
				resultSet.getString("apellido"),
				resultSet.getString("domicilio"),
				resultSet.getString("ciudad"),
				resultSet.getString("provincia"),
				resultSet.getString("domicilio_l"),
				resultSet.getString("empresa"));
		
		return persona;
	}

	
	public boolean insert(Persona p) throws DBException {
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
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_INSERT_PERSONA, false, values);
			) {
	        	 int affectedRows = statement.executeUpdate();
	             if (affectedRows == 0) {
	                 throw new DBException("Inserting user failed, no rows affected.");
	               
	             } else {
	            	 return true;
	             }
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

	}
	
	

	public Persona findId(int dni) throws DBException {
		
		Persona persona = null;
		
		Object[] values = {
                dni
            };

        try (
            Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_FIND_BY_ID, false, values);
            ResultSet resultSet = statement.executeQuery();
        		) {
        	if (resultSet.next()) {
        		persona = mapPersona(resultSet);
        	}
    		
        } catch (SQLException e) {
            throw new DBException(e);
        } 

      
       
        return persona;
	}




	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}




	public boolean updatePersona(Persona p) throws DBException {
	
		Object[] values = {
	            p.getTelefonoP(),
	            p.getTelefonoC(),
	            p.getTelefonoL(),
	            p.getNombre(),
	            p.getApellido(),
	            p.getDomicilio(),
	            p.getCiudad(),
	            p.getProvincia(),
	            p.getDomicilioL(),
	            p.getEmpresa(),
	            p.getDni()
	        };
    
	
        try (
        		
            Connection connection = this.connectionProvider.getConnection();
        		
            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE, false, values);
        ) {
           
        	int affectedRows = statement.executeUpdate();
        	
            if (affectedRows == 0) {
            	
                throw new DBException("Updating user failed, no rows affected.");
            } else{
            	return true;
            }
           
           
        } catch (SQLException e) {
            throw new DBException(e);
        }
	}




	
	
	
}
