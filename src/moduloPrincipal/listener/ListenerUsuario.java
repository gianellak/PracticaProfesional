package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerUsuario implements ActionListener {

private UsuarioView usuarioView;
private PrincipalController pc;

	public ListenerUsuario(PrincipalController pc){
		super();
		this.pc = pc;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {

		usuarioView = new UsuarioView();
		
		UsuarioController uc = new UsuarioController(usuarioView, pc);
		
		System.out.println("ListenerUsuarioMenu");
		
		uc.showUsuario();
		
		
	}
	
}
