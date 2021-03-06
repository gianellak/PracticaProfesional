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

	private static final String SQL_UPDATE_VEHICULO = "UPDATE Vehiculo SET "
				+ "patente=?, " 
				+ "marca=?, "
				+ "modelo=?, "
				+ "year=?, "
				+ "color=?, "
				+ "km=?, "
				+ "dominio=?, "
				+ "pvc=?, "
				+ "fechaIngreso=?, "
				+ "fechaVenta=?, "
				+ "condicion=?, "
				+ "idProveedor=?, "
				+ "idCliente=?, "
				+ "comentarios=? WHERE motor=? OR patente=?";

	private static final String SQL_FIND_BY_PATENTE = "SELECT * FROM Vehiculo WHERE patente=? OR motor=?";

	private static final String SQL_SELECT_BY_COMBO = "SELECT * FROM Vehiculo WHERE marca=? OR year=?";

	private static final String SQL_ALL_BY_COMBO = "SELECT * FROM Vehiculo WHERE marca=? AND year=?";

	private static final String SQL_SELECT_LIST_MODELO = "SELECT DISTINCT modelo FROM Vehiculo";
	
	private static final String SQL_SELECT_LIST_YEAR = "SELECT DISTINCT year FROM Vehiculo";
	
	private static final String SQL_SELECT_LIST_MARCA = "SELECT DISTINCT marca FROM Vehiculo";
	
	

	private static final int MYSQL_DUPLICATE_PK = -104;

	private ConnectionProvider connectionProvider;

	

	public VehiculosDB(ConnectionProvider connection) {
		this.connectionProvider = connection;
	}

	/**
	 * getVehiculo. Dado un string con una patente o nro de motor devuelve el
	 * veh�culo correspondiente.
	 */
	public Vehiculo getVehiculo(String patenteInput) {

		Vehiculo vehiculo = null;
		
		System.out.println(patenteInput);
		Object[] values = {
				patenteInput,
				patenteInput
		};

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_FIND_BY_PATENTE, false, values);
				
				ResultSet rs = statement.executeQuery();) {
			
			if (rs.next()) {
				
				vehiculo = map(rs);
				return vehiculo;
				
			}else{
				return null;
			}

		} catch (SQLException e) {
			// throw new DBException(e);
		}
		return vehiculo;
	}

	private Vehiculo map(ResultSet rs) throws SQLException {
		
		String year = rs.getString("year");
		String fechaIngreso = rs.getString("fechaIngreso");
		String fechaVenta = rs.getString("fechaventa");
		Integer km = rs.getInt("km");
		String patente = rs.getString("patente");
		String marca = rs.getString("marca");
		String modelo = rs.getString("modelo");
		String color = rs.getString("color");
		String motor = rs.getString("motor");
		String dominio = rs.getString("dominio");
		Integer pvc = rs.getInt("pvc");
		String condicion = rs.getString("condicion");
		Integer idProveedor = rs.getInt("idproveedor");
		Integer idCliente = rs.getInt("idcliente");
		String comentarios = rs.getString("comentarios");

		return new Vehiculo(patente, marca, modelo, year, color,
				km, motor, dominio, pvc, fechaIngreso, fechaVenta,
				condicion, idProveedor, idCliente, comentarios);
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
				
				stock.add(map(rs));

			}
		} catch (SQLException e) {
			throw new DBException(e);
		}

		return stock;
	}
	/**
	 * getAllVehiculos by ComboList selection. devuelve una lista de todos los vehiculos en base a los filtros aplicados.
	 * 
	 */
	public List<Vehiculo> getFilterVehiculos(String marca, String year) throws DBException {
		
		List<Vehiculo> stock = new ArrayList<>();
		
		Object[] values = {
				marca,
				year
		};

		
		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_SELECT_BY_COMBO, false, values);
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {
				
				stock.add(map(rs));
				
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return stock;
	}
	
	
	public ArrayList<String> getComboModelo() throws DBException {

		ArrayList<String> combo = new ArrayList<>();
		
		combo.add("-");
		
		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SQL_SELECT_LIST_MODELO);
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {
				
				combo.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return combo;
	}
	
	public ArrayList<String> getComboMarca() throws DBException {
		
		ArrayList<String> combo = new ArrayList<>();
		
		combo.add("-");
		
		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SQL_SELECT_LIST_MARCA);
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {
				
				combo.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return combo;
	}
	public ArrayList<String> getComboYear() throws DBException {
		
		ArrayList<String> combo = new ArrayList<>();
		
		combo.add("-");
		
		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SQL_SELECT_LIST_YEAR);
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {
				
				combo.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return combo;
	}

	/**
	 * createVehiculo. Dado un objeto vehiculo como parametro se crea el
	 * registro en la BD.
	 */
	public Boolean createVehiculo(Vehiculo vehiculo) throws DBException {
		
		
		
		Object[] values = {
				
				vehiculo.getMotor(),
				vehiculo.getPatente(),
				vehiculo.getMarca(),
				vehiculo.getModelo(),
				vehiculo.getYear(),
				vehiculo.getColor(),
				vehiculo.getKm(),
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
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException(
						"Inserting user failed, no rows affected.");

			} else {
				return true;
			}
		} catch (SQLException e) {
			if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
				throw new DBException("Duplicated Key, cannot insert vehiculo");
			} else {
				throw new DBException(e);
			}
		}
	}

	/**
	 * updateVehiculo. Modifica datos.
	 * @throws DBException 
	 */
	public Boolean updateVehiculo(Vehiculo vehiculo) throws DBException {

		Object[] values = {
				
				vehiculo.getPatente(),
				vehiculo.getMarca(),
				vehiculo.getModelo(),
				vehiculo.getYear(),
				vehiculo.getColor(),
				vehiculo.getKm(),
				vehiculo.getDominio(),
				vehiculo.getPvc(),
				vehiculo.getFechaIngreso(),
				vehiculo.getFechaVenta(),
				vehiculo.getCondicion(),
				vehiculo.getIdProveedor(),
				vehiculo.getIdCliente(),
				vehiculo.getComentarios(),
				vehiculo.getMotor(),
				vehiculo.getPatente()
				
				};

		try
		
		(Connection connection = this.connectionProvider.getConnection();
		PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE_VEHICULO, false, values);)

		{
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

	public List<Vehiculo> getBothFilters(String marca, String year) throws DBException {
		
		List<Vehiculo> stock = new ArrayList<>();
				
		Object[] values = {
					marca,
					year
			};

			
			try (Connection connection = this.connectionProvider.getConnection();
					PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_ALL_BY_COMBO, false, values);
					ResultSet rs = statement.executeQuery();) {
				while (rs.next()) {
					
					stock.add(map(rs));
					
				}
			} catch (SQLException e) {
				throw new DBException(e);
			}
			
			return stock;
		}
	
}

