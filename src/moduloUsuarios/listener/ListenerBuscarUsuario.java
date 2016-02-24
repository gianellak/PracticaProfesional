package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloClientes.ClientesController;
import moduloUsuarios.UsuarioController;


public class ListenerBuscarUsuario implements ActionListener {


	private UsuarioController uc;


	public ListenerBuscarUsuario(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		uc.showUnUsuario();
		
		
	}
	
}
