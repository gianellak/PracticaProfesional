package moduloLogin.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import exceptions.LoginException;
import moduloLogin.LoginController;

public class ListenerLogin implements ActionListener {

	private LoginController lc;

	public ListenerLogin(LoginController lc) {
		super();
		this.lc = lc;
	}

	public void actionPerformed(ActionEvent e) {

		try {
			try {
				lc.onLogin();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (LoginException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
