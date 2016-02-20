package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import objetos.Usuario;
import exceptions.DBException;
import moduloClientes.ClientesController;
import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerModAceptar implements ActionListener {


	private ClientesController cc;


	public ListenerModAceptar(ClientesController cc) {
		this.cc = cc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		cc.modPersona();
		
		
	}
	
}
