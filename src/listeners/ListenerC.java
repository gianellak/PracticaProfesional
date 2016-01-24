package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloPrincipal.login.LoginController;

public class ListenerC implements ActionListener {

	private LoginController lc;
	

	public ListenerC(LoginController lc) {
		super();
		this.lc = lc;
	}


	public void actionPerformed(ActionEvent e) {

		lc.onCancel();
	}

	

}
