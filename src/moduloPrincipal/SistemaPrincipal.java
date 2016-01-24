package moduloPrincipal;


import java.sql.Connection;
import java.sql.SQLException;

import objetos.Usuario;
import moduloPrincipal.login.LoginController;
import moduloPrincipal.login.LoginInterface;
import moduloPrincipal.login.LoginView;
import moduloPrincipal.loginDB.LoginDB;
import moduloPrincipal.loginDB.LoginDBInterface;
import moduloPrincipal.loginDB.UserDB;
import connections.ConnectionProvider;
import connections.DBConnection;

public class SistemaPrincipal {


	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		ConnectionProvider conn = new DBConnection();
		
		try {
			conn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		LoginInterface ventanaL = new LoginView();
		
		LoginDBInterface loginDB = new UserDB(conn);
		
		LoginDB lgDB = new LoginDB(loginDB);
		
		PrincipalInterface p = new PrincipalView();
		
		LoginController lg= new LoginController(lgDB, ventanaL);
		
		lg.showLogin();
		
		Thread.sleep(9000);
		
		Usuario user = lg.getUser();
		
		System.out.println(user.getNombre());
		
		PrincipalController pc = new PrincipalController(user, p, conn);
		
		pc.showPrincipal();
		
		
	}
		
		
	
}
