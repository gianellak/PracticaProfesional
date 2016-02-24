package moduloVehiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connections.ConnectionProvider;
import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;
import objetos.Vehiculo;
import objetos.Venta;
import utilitarios.DBUtil;

public class VehiculosDB  {
	
	private static final String SQL_INSERT_VEHICULO = "INSERT INTO Vehiculo VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String SQL_SELECT_ALL_VEHICULO = "SELECT * FROM Vehiculo";

	private static final String SQL_UPDATE_VEHICULO = "UPDATE FROM Usuario WHERE motor = ?";

	private static final String SQL_FIND_BY_PATENTE = "SELECT * FROM Vehiculo WHERE patente= ? OR motor = ?";

	private static final int MYSQL_DUPLICATE_PK = -104;

	@SuppressWarnings("unused")
	private ConnectionProvider connectionProvider;

	

	public VehiculosDB(ConnectionProvider connection) {
		this.connectionProvider = connection;
	}

	/**
	 * getVehiculo. Dado un string con una patente o nro de motor devuelve el
	 * vehículo correspondiente.
	 */
	public Vehiculo getVehiculo(String patenteInput) {

		Vehiculo vehiculo = null;

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_BY_PATENTE, true, patenteInput);
				ResultSet rs = statement.executeQuery();) {
			if (rs.next()) {

				Integer year = rs.getInt(4);
				String fechaIngreso = rs.getString(10);
				String fechaVenta = rs.getString(11);
				Integer km = rs.getInt(6);
				String patente = rs.getString(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String color = rs.getString(5);
				String motor = rs.getString(7);
				String dominio = rs.getString(8);
				Integer pvc = rs.getInt(9);
				String condicion = rs.getString(12);
				Integer idProveedor = rs.getInt(13);
				Integer idCliente = rs.getInt(14);
				String comentarios = rs.getString(15);

				vehiculo = new Vehiculo(patente, marca, modelo, year, color,
						km, motor, dominio, pvc, fechaIngreso, fechaVenta,
						condicion, idProveedor, idCliente, comentarios);
			}

		} catch (SQLException e) {
			// throw new DBException(e);
		}
		return vehiculo;
	}

	/**
	 * getAllVehiculos. devuelve una lista de todos los vehiculos que alguna vez
	 * estuvieron registrados en la BD.
	 * 
	 */
	public List<Vehiculo> getAllVehiculos() throws DBException {

		List<Vehiculo> stock = new ArrayList<>();

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SQL_SELECT_ALL_VEHICULO);
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {

				Integer year = rs.getInt(4);
				String fechaIngreso = rs.getString(10);
				String fechaVenta = rs.getString(11);
				Integer km = rs.getInt(6);
				String patente = rs.getString(1);
				String marca = rs.getString(2);
				String modelo = rs.getString(3);
				String color = rs.getString(5);
				String motor = rs.getString(7);
				String dominio = rs.getString(8);
				Integer pvc = rs.getInt(9);
				String condicion = rs.getString(12);
				Integer idProveedor = rs.getInt(13);
				Integer idCliente = rs.getInt(14);
				String comentarios = rs.getString(15);

				Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, year,
						color, km, motor, dominio, pvc, fechaIngreso,
						fechaVenta, condicion, idProveedor, idCliente,
						comentarios);

				stock.add(vehiculo);

			}
		} catch (SQLException e) {
			throw new DBException(e);
		}

		return stock;
	}

	/**
	 * createVehiculo. Dado un objeto vehiculo como parametro se crea el
	 * registro en la BD.
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
				vehiculo.getCondicion(),
				vehiculo.getIdProveedor(),
				vehiculo.getIdCliente(),
				vehiculo.getComentarios()
				
				};


		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_INSERT_VEHICULO, false, values);)

		{
			statement.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
				throw new DBException("Duplicated Key, cannot insert vehiculo");
			} else {
				throw new DBException(e);
			}
		}

		return null;
	}

	/**
	 * updateVehiculo. Modifica datos.
	 * @throws DBException 
	 */
	public Boolean updateVehiculo(String motor, Vehiculo vehiculo) throws DBException {

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
				vehiculo.getCondicion(),
				vehiculo.getIdProveedor(),
				vehiculo.getIdCliente(),
				vehiculo.getComentarios()
				
				};

		try
		
		(Connection connection = this.connectionProvider.getConnection();
		PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE_VEHICULO, false, values);)

		{
			statement.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
				throw new DBException("Duplicated Key, cannot modify vehiculo");
			} else {
				throw new DBException(e);
			}
		}

		return null;
	}
}
