package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.LoginException;
import moduloPrincipal.login.LoginController;


public class ListenerL implements ActionListener {

	private LoginController lc;


	public ListenerL(LoginController lc) {
		super();
		this.lc = lc;
	}


	public void actionPerformed(ActionEvent e) {
		
		
			try {
				lc.onLogin();
			} catch (LoginException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}



}
