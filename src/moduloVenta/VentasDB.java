package moduloVenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import connections.ConnectionProvider;
import exceptions.DBException;
import objetos.Cuota;
import objetos.DetalleVenta;
import objetos.Movimiento;
import objetos.Persona;
import objetos.Usuario;
import objetos.Venta;
import utilitarios.DBUtil;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.PanelAux;

public class VentasDB {

	private static final String SQL_INSERT_PERSONA = "INSERT INTO Persona VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SQL_INSERT_DVENTA = "INSERT INTO detalleventa VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SQL_INSERT_CUOTAS = "INSERT INTO cuota VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_INSERT_VENTA = "INSERT INTO Venta VALUES (?, ?, ?, ?, ?)";

	private static final String SQL_COUNT_VENTA = "SELECT COUNT(idVenta) AS count FROM Venta";

	private static final String SQL_FIND_BY_ID = "SELECT * FROM Persona WHERE dni=?";

	private static final String SQL_FIND_VENTA_BY_DNI = "SELECT * FROM Venta WHERE idCliente = ?";

	private static final String SQL_FIND_CUOTAS_BY_ID = "SELECT * FROM Cuota WHERE cuota LIKE ?";

	private static final String SQL_FIND_VENTA_BY_ID = "SELECT * FROM Venta WHERE idVenta = ?";
	
	private static final String SQL_FIND_DVENTA_BY_ID = "SELECT * FROM detalleVenta WHERE idVenta = ?";

	private static final String SQL_UPDATE = "UPDATE Persona SET telefono_p=?, telefono_c=?, telefono_l=?, nombre=?, apellido=?, domicilio=?,"
			+ "ciudad=?, provincia=?, domicilio_l=?, empresa=? WHERE DNI=?";

	private static final String SQL_DELETE = "DELETE FROM Persona WHERE dni = ?";

	private static final int MYSQL_DUPLICATE_PK = -104;

	private ConnectionProvider connectionProvider;

	public VentasDB(ConnectionProvider connection) {
		this.connectionProvider = connection;
	}

	public boolean delete(int u) throws DBException {

		Object[] values = { u };

		try (Connection connection = this.connectionProvider.getConnection();

				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_DELETE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException("Deleting user failed, no rows affected.");

			} else {
				return true;
			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

	}

	public boolean insertVenta(Venta v) throws DBException {

		Object[] values = { v.getIdVenta(), v.getFecha(), v.getIdCliente(),
				v.getIdGarante(), v.getIdVendedor() };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_INSERT_VENTA, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException(
						"Inserting user failed, no rows affected.");

			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertDVenta(DetalleVenta v) throws DBException {
		
		Object[] values = { v.getIdVenta(), v.getIdVehiculo(), v.getPrecio(), v.getCuotas(),v.getDeuda(),
				v.getAdelanto(),v.getComision(), v.getDescuento(), v.getDetalle()};
		
		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_INSERT_DVENTA, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException(
						"Inserting user failed, no rows affected.");
				
			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int countAll() {

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SQL_COUNT_VENTA);
				ResultSet rs = statement.executeQuery();) {
			rs.next();

			return rs.getInt("count");

		} catch (SQLException e) {
			try {
				throw new DBException(e);
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return 0;

	}

	public Persona getPersona(int dni) throws DBException {
		Persona persona = null;

		Object[] values = { dni };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				persona = mapPersona(resultSet);
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}

		return persona;
	}

	private Persona mapPersona(ResultSet resultSet) throws SQLException {
		Persona persona = new Persona(resultSet.getInt("dni"),
				resultSet.getString("telefono_p"),
				resultSet.getString("telefono_c"),
				resultSet.getString("telefono_l"),
				resultSet.getString("nombre"), resultSet.getString("apellido"),
				resultSet.getString("domicilio"),
				resultSet.getString("ciudad"),
				resultSet.getString("provincia"),
				resultSet.getString("domicilio_l"),
				resultSet.getString("empresa"));

		return persona;
	}

	public boolean insert(Persona p) throws DBException {
		Object[] values = { p.getDni(), p.getTelefonoP(), p.getEmail(),
				p.getTelefonoL(), p.getNombre(), p.getApellido(),
				p.getDomicilio(), p.getCiudad(), p.getProvincia(),
				p.getDomicilioL(), p.getEmpresa() };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_INSERT_PERSONA, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException(
						"Inserting user failed, no rows affected.");

			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public Persona findId(int dni) throws DBException {

		Persona persona = null;

		Object[] values = { dni };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				persona = mapPersona(resultSet);
			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return persona;
	}

	public List<Venta> findByDNI(int dni) throws DBException {

		List<Venta> venta = new ArrayList<Venta>();

		Object[] values = { dni };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_VENTA_BY_DNI, false, values);
				ResultSet rs = statement.executeQuery();) {
	
			while (rs.next()) {
				
				venta.add(mapVenta(rs));

			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return venta;
	}

	private Venta mapVenta(ResultSet resultSet) throws SQLException {
		Venta v = new Venta(resultSet.getInt("idVenta"),
				resultSet.getString("fecha"), resultSet.getInt("idCliente"),
				resultSet.getInt("idGarante"), resultSet.getInt("idVendedor")
		);

		return v;
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatePersona(Persona p) throws DBException {

		Object[] values = { p.getTelefonoP(), p.getEmail(), p.getTelefonoL(),
				p.getNombre(), p.getApellido(), p.getDomicilio(),
				p.getCiudad(), p.getProvincia(), p.getDomicilioL(),
				p.getEmpresa(), p.getDni() };

		try (

		Connection connection = this.connectionProvider.getConnection();

				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_UPDATE, false, values);) {

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {

				throw new DBException("Updating user failed, no rows affected.");
			} else {
				return true;
			}

		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public boolean insertCuota(Cuota c) throws DBException {
		Object[] values = { c.getCuota(), c.getVencimiento(), c.getValor(), c.getAdelanto(), c.getRecibo(), c.getIntereses(),
				c.getPago(), c.getSaldo()};

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_INSERT_CUOTAS, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException(
						"Inserting cuota failed, no rows affected.");

			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public Venta findVenta(int idVenta) throws DBException {
		
		Venta v = null;

		Object[] values = { idVenta };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_VENTA_BY_ID, false, values);
				ResultSet rs = statement.executeQuery();) {
	
			while (rs.next()) {
				
				v = mapVenta(rs);

			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return v;
	}

	public DetalleVenta findDetalle(int idVenta) throws DBException {
		
		DetalleVenta dv = null;

		Object[] values = { idVenta };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_DVENTA_BY_ID, false, values);
				ResultSet rs = statement.executeQuery();) {
	
			while (rs.next()) {
				
				dv = mapDetalleVenta(rs);

			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return dv;
	}

	private DetalleVenta mapDetalleVenta(ResultSet resultSet) throws SQLException {
		DetalleVenta dv = new DetalleVenta(resultSet.getInt("idVenta"),
				resultSet.getString("idvehiculo"), resultSet.getDouble("precio"),
				resultSet.getInt("cuotas"), resultSet.getDouble("deuda"), resultSet.getDouble("adelanto"),
				resultSet.getDouble("comision"), resultSet.getDouble("descuento"),resultSet.getString("detalle")
		);

		return dv;
	}

	public List<Cuota> findCuotas(String idC) throws DBException {
		
		List<Cuota> c = new ArrayList<Cuota>();

		Object[] values = { idC };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_CUOTAS_BY_ID, false, values);
				ResultSet rs = statement.executeQuery();) {
	
			while (rs.next()) {
				
				c.add(mapCuota(rs));

			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return c;
	}

	private Cuota mapCuota(ResultSet resultSet) throws SQLException {
		Cuota c = new Cuota(resultSet.getString("cuota"),
				resultSet.getString("vencimiento"), resultSet.getDouble("valor"),
				resultSet.getDouble("adelanto"), resultSet.getString("recibo"),
				resultSet.getDouble("intereses"), resultSet.getDouble("pago"),resultSet.getDouble("saldo")
		);

		return c;
	}

}
