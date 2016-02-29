package connections;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaGenerator {
	
	ConnectionProvider connection;

	public SchemaGenerator(ConnectionProvider connection) {
		super();
		this.connection = connection;
	}
	
	public boolean generateSchema() throws SQLException {
		
		Connection c = this.connection.getConnection();
				
		Statement statement = c.createStatement();
		
		String sql ="create table Movimiento (ID INTEGER PRIMARY KEY, Descripcion VARCHAR(140), Ingreso Real, Egreso Real, Fecha VARCHAR(8), Usuario VARCHAR(8), Marca BOOLEAN)";

		try {
			
	    	
	    	statement.execute(sql);
	    	
	    	return true;
			
		} catch (SQLException e) {
			
		
			return false;
		}
		
	}
	
	public boolean generateSchemaUsuario() throws SQLException{
		
		Connection c = this.connection.getConnection();
		
		Statement statement = c.createStatement();
		
		String sql ="create table Usuario (Username VARCHAR(8) PRIMARY KEY, Password VARCHAR(8), Permisos INTEGER, Nombre VARCHAR(15), Apellido VARCHAR(15))";

		try {
			
	    	
	    	statement.execute(sql);
	    	
	    	return true;
			
		} catch (SQLException e) {
			
		
			return false;
		}
		
		
		
	}
	
	public boolean generateSchemaVehiculo() throws SQLException{
		
		Connection c = this.connection.getConnection();
		
		Statement statement = c.createStatement();
		
		String sql ="create table Vehiculo (motor VARCHAR(10) PRIMARY KEY,"
				+ "patente VARCHAR(6), " 
				+ "marca VARCHAR(10), "
				+ "modelo VARCHAR(25), "
				+ "year VARCHAR(4), "
				+ "color VARCHAR(15), "
				+ "km INTEGER, "
				+ "dominio VARCHAR(10), "
				+ "pvc INTEGER, "
				+ "fechaIngreso VARCHAR(8), "
				+ "fechaVenta VARCHAR(8), "
				+ "condicion VARCHAR(10), "
				+ "idProveedor VARCHAR(10), "
				+ "idCliente INTEGER, "
				+ "comentarios VARCHAR(25))";
				
		System.out.println("ACA");
		try {
			
			
			statement.execute(sql);
			
			return true;
			
		} catch (SQLException e) {
			
			
			return false;
		}
		
		
		
	}
	
}
