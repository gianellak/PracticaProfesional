package moduloPrincipal.listenerPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloLogin.LoginController;
import moduloPrincipal.PrincipalController;

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
