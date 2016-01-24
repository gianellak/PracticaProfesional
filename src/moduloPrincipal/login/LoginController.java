package moduloPrincipal.login;


import java.sql.SQLException;

import connections.ConnectionProvider;
import connections.DBConnection;
import exceptions.LoginException;
import objetos.Usuario;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalInterface;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.loginDB.LoginDB;

public class LoginController {
	
	private LoginInterface login;
	private PrincipalInterface principalView;
	private LoginDB logindb;
	private ConnectionProvider conn;
	private Usuario unUsuario;
	private boolean ok;
	
	
	public LoginController(LoginDB lgDB, LoginInterface l) {
		super();
		this.login = l;
		this.logindb = lgDB;
		}




	public void showLogin() {
		login.showLogin(this);
	}
	
	public void onCancel() {		
		login.closeLogin();
		
	}
	
	public void onLogin() throws LoginException, SQLException {
		
		String u = login.getUsernameInput();
		String p = login.getPasswordInput();
		
		System.out.println(u + p);
		
		Usuario user = logindb.login(u, p);
			System.out.println(user);
			 if (user!= null) {
			       login.loginSuccessful(user);
			       
			       unUsuario = user;
			       
			      
			       
			      }else{
			 
				 login.loginFailed();
				 	
			      }
			 
		
		
	}




	public Usuario getUser() throws SQLException {
		
		 logindb.close();
		 return unUsuario;
		
	}




	


	




}

