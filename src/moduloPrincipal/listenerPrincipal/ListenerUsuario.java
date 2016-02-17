package moduloPrincipal.listenerPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloPrincipal.PrincipalController;
import moduloPrincipal.login.LoginController;

public class ListenerUsuario implements ActionListener {

	private PrincipalController pc;
	

	public ListenerUsuario(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		pc.onCancel();
		
	}

}
