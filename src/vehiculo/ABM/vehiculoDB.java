package vehiculo.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import objetos.Usuario;
import objetos.Vehiculo;
import objetos.Venta;
import utilitarios.DBUtil;
import connections.ConnectionProvider;
import exceptions.DBException;

public class vehiculoDB implements vehiculoInterface {

	@SuppressWarnings("unused")
	private ConnectionProvider connectionProvider;

	public vehiculoDB(ConnectionProvider connection) {
		this.connectionProvider = connection;
	}

	public Vehiculo getVehiculo(int patente) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vehiculo> getStock() throws DBException {

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
}
