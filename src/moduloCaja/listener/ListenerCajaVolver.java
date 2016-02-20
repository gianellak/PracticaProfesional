package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import moduloCaja.CajaController;
import moduloClientes.ClientesController;
import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerCajaVolver implements ActionListener {

	private CajaController cc;


	public ListenerCajaVolver(CajaController cc){
		this.cc = cc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.getBack();
		
		
	}
	
}