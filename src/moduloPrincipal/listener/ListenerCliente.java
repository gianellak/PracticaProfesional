package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloClientes.ClientesController;
import moduloClientes.ClientesView;
import moduloLogin.LoginController;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerCliente implements ActionListener {

	private PrincipalController pc;
	private ClientesView clientesView;
	

	public ListenerCliente(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		clientesView = new ClientesView();
		
		ClientesController cc = new ClientesController(clientesView, pc);
		
		System.out.println("ListenerClienteMenu");
		
		cc.showClientes();
	}

}
