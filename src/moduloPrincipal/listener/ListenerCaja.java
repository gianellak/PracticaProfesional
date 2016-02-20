package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloCaja.CajaController;
import moduloCaja.CajaView;
import moduloLogin.LoginController;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerCaja implements ActionListener {

	private PrincipalController pc;
	private CajaView cajaView;
	

	public ListenerCaja(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		cajaView = new CajaView();
		
		CajaController cc = new CajaController(cajaView, pc);
		
		System.out.println("ListenerCajaMenu");
		
		cc.showCaja();
		
		
	}

}
