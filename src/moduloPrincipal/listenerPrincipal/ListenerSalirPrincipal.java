package moduloPrincipal.listenerPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloPrincipal.PrincipalController;
import moduloPrincipal.login.LoginController;

public class ListenerSalirPrincipal implements ActionListener {

	private PrincipalController pc;
	

	public ListenerSalirPrincipal(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		pc.onCancel();
		
	}

}
