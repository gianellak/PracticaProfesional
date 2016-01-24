package moduloPrincipal.login;

import exceptions.LoginException;
import objetos.Usuario;

public interface LoginInterface {
	
	
	void showLogin(LoginController loginController);

	void closeLogin();

	String getPasswordInput();

	String getUsernameInput();

	boolean loginSuccessful(Usuario user);

	void loginFailed();

}
