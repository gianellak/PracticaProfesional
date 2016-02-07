package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements ConnectionProvider{


	private Connection connection;

	public Connection getConnection() {
		
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			

		}


		connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"admin");
			
			return connection;
			

		} catch (SQLException e) {

			e.printStackTrace();
			

		}

	

		return connection;

	}

	@Override
	public void close() throws SQLException {
		
		connection.close();
		
	}

	
}
