package vehiculo.ABM;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import objetos.*;
import utilitarios.DBUtil;
import connections.ConnectionProvider;
import exceptions.DBException;

public class VehiculoDB implements vehiculoInterfaceDB {

	private static final String SQL_INSERT_VEHICULO = "INSERT INTO Vehiculo (patente, marca, modelo, year, color, km, motor, dominio, pvc, fechaIngreso, fechaVenta, idCondicion, idProveedor, idCliente, comentarios) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final int MYSQL_DUPLICATE_PK = -104;
	
	@SuppressWarnings("unused")
	private ConnectionProvider connectionProvider;

	public VehiculoDB(ConnectionProvider connection) {
		this.connectionProvider = connection;
	}

	/**
	 * getVehiculo. Dado un string con una patente, devuelve el Vehiculo que
	 * corresponde o null si no existe un vehiculo registrado con ese nro de
	 * patente.
	 */
	public Vehiculo getVehiculo(String patenteInput) {

		Vehiculo vehiculo = null;

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, "SELECT * FROM Vehiculo WHERE patente=?",
						false, patenteInput);
				ResultSet rs = statement.executeQuery();) {
			if (rs.next()) {

				Integer year = rs.getInt(4);
				Date fechaIngreso = rs.getDate(10);
				Date fechaVenta = rs.getDate(11);
				Integer km = rs.getInt(6);
				String patente = rs.getString(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String color = rs.getString(5);
				String motor = rs.getString(7);
				String dominio = rs.getString(8);
				Integer pvc = rs.getInt(9);
				Integer idCondicion = rs.getInt(12);
				Integer idProveedor = rs.getInt(13);
				Integer idCliente = rs.getInt(14);
				String comentarios = rs.getString(15);

				vehiculo = new Vehiculo(patente, marca, modelo, year, color,
						km, motor, dominio, pvc, fechaIngreso, fechaVenta,
						idCondicion, idProveedor, idCliente, comentarios);
			}

		} catch (SQLException e) {
			// throw new DBException(e);
		}
		return vehiculo;
	}

	/**
	 * getAllVehiculos. devuelve una lista de todos los vehiculos que alguna vez estuvieron registrados en la BD.
	 * 
	 */
	public List<Vehiculo> getAllVehiculos() throws DBException {

		List<Vehiculo> stock = new ArrayList<>();

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Vehiculo");
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {

				Integer year = rs.getInt(4);
				Date fechaIngreso = rs.getDate(10);
				Date fechaVenta = rs.getDate(11);
				Integer km = rs.getInt(6);
				String patente = rs.getString(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String color = rs.getString(5);
				String motor = rs.getString(7);
				String dominio = rs.getString(8);
				Integer pvc = rs.getInt(9);
				Integer idCondicion = rs.getInt(12);
				Integer idProveedor = rs.getInt(13);
				Integer idCliente = rs.getInt(14);
				String comentarios = rs.getString(15);

				Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, year,
						color, km, motor, dominio, pvc, fechaIngreso,
						fechaVenta, idCondicion, idProveedor, idCliente,
						comentarios);

				stock.add(vehiculo);

			}
		} catch (SQLException e) {
			throw new DBException(e);
		}

		return stock;
	}

	/**
	 * createVehiculo. Dado un objeto vehiculo como parametro se crea el registro en la BD. 
	 */
	public Boolean createVehiculo(Vehiculo vehiculo) throws DBException {
		Object[] values = { 
				vehiculo.getPatente(),
				vehiculo.getMarca(),
				vehiculo.getModelo(),
				vehiculo.getYear(),
				vehiculo.getColor(),
				vehiculo.getKm(),
				vehiculo.getMotor(),
				vehiculo.getDominio(),
				vehiculo.getPvc(),
				vehiculo.getFechaIngreso(),
				vehiculo.getFechaVenta(),
				vehiculo.getIdCondicion(),
				vehiculo.getIdProveedor(),
				vehiculo.getIdCliente(),
				vehiculo.getComentarios()
				};
		
		try (
	            Connection connection = this.connectionProvider.getConnection();
	            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_INSERT_VEHICULO, true, values);
	        ) 
	            
	        	{
		        	 statement.executeUpdate();
		       } catch (SQLException e) {
		    	   if(e.getErrorCode() == MYSQL_DUPLICATE_PK){
		    		   throw new DBException("Duplicated Key, cannot insert user");
		    	    }else{
	            throw new DBException(e);}
	        }

		return null;
	}

	/**
	 * updateVehiculo. Modifica datos.
	 */
	public Boolean updateVehiculo(Vehiculo vehiculo, Vehiculo newVehiculo) {
		
		return null;
	}
}
