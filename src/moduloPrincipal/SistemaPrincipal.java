package moduloPrincipal;

import java.sql.Connection;
import java.sql.SQLException;

import objetos.Usuario;
import moduloLogin.LoginController;
import moduloLogin.LoginDB;
import moduloLogin.LoginInterface;
import moduloLogin.LoginView;
import moduloLogin.LoginDB;
import connections.ConnectionProvider;
import connections.DBConnection;
import connections.SchemaGenerator;

public class SistemaPrincipal {

	public static void main(String[] args) throws SQLException,
			InterruptedException {
		// TODO Auto-generated method stub

		ConnectionProvider conn = new DBConnection();

		try {
			conn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 //TABLA USUARIO
		
		 SchemaGenerator s = new SchemaGenerator(conn);
		
		 try {
			 s.generateSchemaEmpleado();
			 s.generateSchema();
			 s.generateSchemaPersona();
			 s.generateSchemaUsuario();
			 s.generateSchemaVehiculo();
			 s.generateSchemaVenta();
			 s.generateSchemaDetalleVenta();
		 } catch (SQLException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
		 }
		
		
		LoginInterface ventanaL = new LoginView();

		LoginDB lgDB = new LoginDB(conn);

		LoginController lg = new LoginController(lgDB, ventanaL);

		lg.showLogin();

	}

}
