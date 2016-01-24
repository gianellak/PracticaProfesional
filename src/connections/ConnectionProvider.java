package connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionProvider  {
	
	
	public Connection getConnection() throws SQLException;

	public void close() throws SQLException;
	
	
	
}
