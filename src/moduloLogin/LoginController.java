package moduloLogin;


import java.sql.SQLException;

import connections.ConnectionProvider;
import connections.DBConnection;
import exceptions.LoginException;
import objetos.Usuario;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalInterface;
import moduloPrincipal.PrincipalView;

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
		login.viewLogin(this);
		
	}
	
	public void onCancel() {		
		login.closeLogin();
		
	}
	
	public Usuario login(String usuario, String password) {
		
		try {
			Usuario u = logindb.findId(usuario);
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
	
	public Usuario onLogin() throws LoginException, SQLException {
		
		String u = login.getUsernameInput();
		String p = login.getPasswordInput();
		
		System.out.println(u + p);
		
		Usuario user = this.login(u, p);
			System.out.println(user);
			 if (user!= null) {
				 
				 login.loginSuccessful(user);
				 PrincipalInterface pi = new PrincipalView();
				 PrincipalController pc = new PrincipalController(user, pi, conn);
				 pc.showPrincipal();
			      
			       
			      }else{
			 
				 login.loginFailed();
				 	
			      }
			return unUsuario;
			 
		
		
	}




	public Usuario getUser() throws SQLException {
		
		 login.closeLogin();
		 return unUsuario;
		
	}




	


	




}

