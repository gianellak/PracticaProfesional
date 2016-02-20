package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerUsuarioAlta implements ActionListener {


	private UsuarioController uc;


	public ListenerUsuarioAlta(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		uc.showAlta();
		
		
	}
	
}
