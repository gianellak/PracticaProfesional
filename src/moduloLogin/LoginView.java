package moduloLogin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import exceptions.DBException;
import exceptions.LoginException;
import objetos.Usuario;
import moduloLogin.listeners.ListenerC;
import moduloLogin.listeners.ListenerLogin;
import moduloLogin.listeners.ListenerLogin;

public class LoginView implements LoginInterface {
	
	private JFrame frmLogin;
	private JPanel panel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JButton cancelButton;
	private ListenerC listenerCan;
	private ListenerLogin listenerLog;
	private LoginController lc;

	public LoginView(){
		
		frmLogin = new JFrame("Login");
		frmLogin.setBounds(500, 100, 300, 150);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmLogin.add(panel);
		
		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(180, 80, 80, 25);
		
		
		panel.add(loginButton);
		panel.add(cancelButton);
		
		
	
	}


	@Override
	public void viewLogin(LoginController loginController) {
		
		lc = loginController;
		
		listenerCan = new ListenerC(lc);
		listenerLog = new ListenerLogin(lc);
		
		loginButton.addActionListener(listenerLog);
		cancelButton.addActionListener(listenerCan);
		
		frmLogin.setVisible(true);
		
	}

	@Override
	public void closeLogin() {
		
		frmLogin.dispose();
		
	}

	@Override
	public String getPasswordInput() {
		
		return new String(passwordText.getPassword());
	}

	@Override
	public String getUsernameInput() {
		
		return userText.getText();	
	}

	@Override
	public boolean loginSuccessful(Usuario user) {
		
	
		JOptionPane.showMessageDialog(null, "Hola " + user.getNombre()+ " " + user.getApellido());
		this.closeLogin();
		return true;
		
	}

	@Override
	public void loginFailed() {
		
		JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos.");
		
	}


	@Override
	public void insert(Usuario usuario) throws DBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Usuario usuario) throws DBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Usuario usuario) throws DBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Usuario findId(String idUser) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Usuario> findAll() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Usuario login(String usernameInput, String passwordInput)
			throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showLogin(LoginController loginController) {
		// TODO Auto-generated method stub
		
	}

}
