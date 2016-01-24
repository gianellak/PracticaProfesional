package moduloPrincipal.login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;









import exceptions.LoginException;
import objetos.Usuario;
import listeners.ListenerC;
import listeners.ListenerL;

public class LoginView implements LoginInterface {
	
	private JFrame frmLogin;
	private JPanel panel;
	private JTextField userText;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JButton cancelButton;
	private ListenerC listenerCan;
	private ListenerL listenerLog;
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
	public void showLogin(LoginController loginController) {
		
		lc = loginController;
		
		listenerCan = new ListenerC(lc);
		listenerLog = new ListenerL(lc);
		
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

}
