package moduloPrincipal;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;

import objetos.Usuario;
import moduloLogin.LoginController;
import moduloLogin.LoginDB;
import moduloLogin.LoginInterface;
import moduloLogin.LoginView;
import moduloLogin.LoginDB;
import moduloUsuarios.UsuarioDB;
import connections.ConnectionProvider;
import connections.DBConnection;
import connections.SchemaGenerator;
import exceptions.DBException;

public class SistemaPrincipal {

	
	public static void main(String[] args) throws SQLException,
			InterruptedException, DBException {
		// TODO Auto-generated method stub
		

		System.out.println( Toolkit.getDefaultToolkit().getScreenSize());
		
		Boolean hayTabla = false;

		ConnectionProvider conn = new DBConnection();

		try {
			conn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		SchemaGenerator s = new SchemaGenerator(conn);

		try {
			s.generateSchemaEmpleado();
			s.generateSchema();
			s.generateSchemaPersona();
			s.generateSchemaDetalleVenta();
			if (s.generateSchemaUsuario() == true) {
				hayTabla = true;
			}
			;
			s.generateSchemaVehiculo();
			s.generateSchemaVenta();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (hayTabla) {
			Usuario u = new Usuario("admin", "admin", 00000000, 0, "Usuario",
					"Administrador", false);

			UsuarioDB uDB = new UsuarioDB(conn);

			uDB.insert(u);
		}


		LoginInterface ventanaL = new LoginView();

		LoginDB lgDB = new LoginDB(conn);

		LoginController lg = new LoginController(lgDB, ventanaL);

		lg.showLogin();

	}

}
