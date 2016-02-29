package moduloCaja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connections.ConnectionProvider;
import exceptions.DBException;
import objetos.*;
import utilitarios.DBUtil;


public class CajaDB {

	private static final String SQL_INSERT_MOVIMIENTO = "INSERT INTO Movimiento VALUES (?, ?, ?, ?, ?, ?)";

	private static final String SQL_FIND_BY_ID = "SELECT * FROM Movimiento WHERE id=?";
	
	private static final String SQL_FIND_ALL_MOVIMIENTOS = "SELECT * FROM Movimiento";

	private static final String SQL_FIND_BY_DAY = "SELECT * FROM Movimiento WHERE fecha=?";

	private static final String SQL_DELETE = null;
	
	private static final String SQL_UPDATE_MOVIMIENTO = "UPDATE FROM Movimiento WHERE id = ?";

	private static final int MYSQL_DUPLICATE_PK = -104;


	private ConnectionProvider connectionProvider;

	public CajaDB(ConnectionProvider connection) {
		this.connectionProvider = connection;
	}

	public boolean delete(int u) throws DBException {

		Object[] values = { u };

		try (Connection connection = this.connectionProvider.getConnection();

				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_DELETE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException("Falló eliminar movimiento");

			} else {
				return true;
			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

	}

	public Movimiento getMovimiento(int id) throws DBException {
		Movimiento movimiento = null;

		Object[] values = { id };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				movimiento = mapMovimiento(resultSet);
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}

		return movimiento;
	}

	private Movimiento mapMovimiento(ResultSet rs) throws SQLException {
		
		Movimiento movimiento = new Movimiento (
				
				rs.getInt("Id"),
				rs.getString("Descripcion"),
				rs.getInt("Ingreso"),
				rs.getInt("Egreso"),
				rs.getString("Fecha"),
				rs.getString("Usuario"),
				rs.getBoolean("Marca")
				
				);
		
	return movimiento;
	
	}

	public boolean insert(Movimiento m) throws DBException {
		Object[] values = { m.getId(), m.getDescripcion(), m.getIngreso(), m.getEgreso(),
				m.getFecha(), m.getUsuario(), m.isMarca() };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_INSERT_MOVIMIENTO, false, values);) {
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

	public Movimiento findId(int id) throws DBException {

		Movimiento mov = null;

		Object[] values = { id };

		try (Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(
						connection, SQL_FIND_BY_ID, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				mov = mapMovimiento(resultSet);
			}

		} catch (SQLException e) {
			throw new DBException(e);
		}

		return mov;
	}

	public List<Movimiento> findAll() {
		List<Movimiento> movimientos = new ArrayList<>();

        try (
        	Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_MOVIMIENTOS);
            ResultSet rs = statement.executeQuery();
        ) {
        	while (rs.next()){
    			
        		int id = rs.getInt(1);
        		String descripcion = rs.getString(2);
        		int ingreso = rs.getInt(3);
        		int egreso = rs.getInt(4);
        		String fecha = rs.getString(5);
        		String usuario = rs.getString(6);
        		Boolean marca = rs.getBoolean(7);
        		
        		Movimiento mov  =new Movimiento(id, descripcion, ingreso, egreso, fecha, usuario, marca);
        	       		
        		movimientos.add(mov);
            }
        } catch (SQLException e) {
            try {
				throw new DBException(e);
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        return movimientos;
		
	}
	
	
	public Boolean update(int id, Movimiento mov) throws DBException {

		Object[] values = {
				
				mov.getId(),
				mov.getDescripcion(),
				mov.getIngreso(),
				mov.getEgreso(),
				mov.getFecha(),
				mov.getUsuario(),
				mov.isMarca()
				
				};

		try
		
		(Connection connection = this.connectionProvider.getConnection();
		PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE_MOVIMIENTO, false, values);)

		{
			statement.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
				throw new DBException("Duplicated Key, cannot modify movimiento");
			} else {
				throw new DBException(e);
			}
		}

		return null;
	}

	
	
	public List<Movimiento> findByDay(String stringDate) {
		
		
		List<Movimiento> movimientos = new ArrayList<>();

        try (
        	Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement =  DBUtil.prepareStatement(connection, SQL_FIND_BY_DAY, false, stringDate);
            ResultSet rs = statement.executeQuery();
        ) {
        	while (rs.next()){
    			
        		int id = rs.getInt(1);
        		String descripcion = rs.getString(2);
        		int ingreso = rs.getInt(3);
        		int egreso = rs.getInt(4);
        		String fecha = rs.getString(5);
        		String usuario = rs.getString(6);
        		Boolean marca = rs.getBoolean(7);
        		
        		Movimiento mov  =new Movimiento(id, descripcion, ingreso, egreso, fecha, usuario, marca);
        	       		
        		movimientos.add(mov);
            }
        } catch (SQLException e) {
            try {
				throw new DBException(e);
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        return movimientos;
	}

}
