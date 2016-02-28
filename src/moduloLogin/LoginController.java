package moduloLogin;


import java.sql.SQLException;

import connections.ConnectionProvider;
import exceptions.DBException;
import exceptions.LoginException;
import objetos.Usuario;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalInterface;
import moduloPrincipal.PrincipalView;

public class LoginController {
	
	private LoginInterface login;
	private LoginDB logindb;
	private ConnectionProvider conn;
	private Usuario unUsuario;
	private int logAttemp;
	
	
	public LoginController(LoginDB lgDB, LoginInterface l) {
		super();
		this.login = l;
		this.logindb = lgDB;
		}

	public void showLogin() {
		logAttemp = 0;
		login.viewLogin(this);
		
	}
	
	public void onCancel() {		
		login.closeLogin();
		
	}
	
	public Usuario login(String usuario, String password) throws DBException {
		System.out.println("login");
		
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
		
		if(logAttemp == 2){
		
			Usuario u = logindb.findId(usuario);
			u.setBloqueo(true);
			logindb.update(u);
			login.loginOut();

			System.exit(0);
		
		}
		
		return null; 
		
	}
	
	public Usuario onLogin() throws LoginException, SQLException, DBException {
		System.out.println("On login");
		
		String u = login.getUsernameInput();
		String p = login.getPasswordInput();
		
		System.out.println(u + p);
		
		
			Usuario user = this.login(u, p);
			System.out.println(logAttemp);
			
				
			System.out.println(user);
		 
			if (user!= null) {
				 
			
				login.loginSuccessful(user);
				PrincipalInterface pi = new PrincipalView();
				PrincipalController pc = new PrincipalController(user, pi, conn);
				pc.showPrincipal();
			}else{
				logAttemp ++;
				login.loginFailed();
			}
		
		return unUsuario;
			
	}

	public Usuario getUser() throws SQLException {
		
		 login.closeLogin();
		 return unUsuario;
		
	}


}

