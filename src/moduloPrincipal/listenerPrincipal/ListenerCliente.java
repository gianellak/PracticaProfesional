package moduloPrincipal.listenerPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloLogin.LoginController;
import moduloPrincipal.PrincipalController;

public class ListenerCliente implements ActionListener {

	private PrincipalController pc;
	

	public ListenerCliente(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		pc.onCancel();
		
	}

}
