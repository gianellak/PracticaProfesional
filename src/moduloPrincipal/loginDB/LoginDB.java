package moduloPrincipal.loginDB;

import java.sql.SQLException;
import java.util.List;

import connections.ConnectionProvider;
import objetos.Usuario;
import exceptions.DBException;
import exceptions.LoginException;

public class LoginDB {

	private Usuario user;
	private LoginDBInterface lg;

	public LoginDB(LoginDBInterface li) {
		
		this.lg = li;
	}
	
	
	public Usuario login(String usuario, String password) {
			
		try {
			Usuario u = lg.findId(usuario);
			System.out.println(password + "-" + u.getPassword());
			
			 if (password.equals(u.getPassword())) {
				 System.out.println("LoginOK");
			        return u;
			      } 
			 
		} catch (Exception e) {
			try {
				throw new LoginException( "Usuario o contraseña incorrectos" );
			} catch (LoginException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null; 
		
		
		

		
		
	}


	public void close() throws SQLException {
		lg.close();
		
	}




	




}