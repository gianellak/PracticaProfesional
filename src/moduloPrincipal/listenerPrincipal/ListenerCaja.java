package moduloPrincipal.listenerPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloLogin.LoginController;
import moduloPrincipal.PrincipalController;

public class ListenerCaja implements ActionListener {

	private PrincipalController pc;
	

	public ListenerCaja(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		pc.onCancel();
		
	}

}
