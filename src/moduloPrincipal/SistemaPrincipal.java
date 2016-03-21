package moduloPrincipal;

import java.awt.Toolkit;
import java.sql.SQLException;

import objetos.Empleado;
import objetos.Usuario;
import moduloLogin.LoginController;
import moduloLogin.LoginDB;
import moduloLogin.LoginInterface;
import moduloLogin.LoginView;
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
		Boolean hayTablaE = false;

		ConnectionProvider conn = new DBConnection();

		try {
			conn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		SchemaGenerator s = new SchemaGenerator(conn);

		try {
			
			if(s.generateSchemaEmpleado())
				hayTablaE = true;
			
			s.generateSchema();
			s.generateSchemaCuotas();
			s.generateSchemaPersona();
			s.generateSchemaDetalleVenta();
			if (s.generateSchemaUsuario()) 
				hayTabla = true;
	
			s.generateSchemaVehiculo();
			s.generateSchemaVenta();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		if (hayTablaE){
			Empleado e = new Empleado(00000000, "Usuario", "Administrador", "", "", "", "");
			
			UsuarioDB uDB = new UsuarioDB(conn);
			
			uDB.inserE(e);
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
