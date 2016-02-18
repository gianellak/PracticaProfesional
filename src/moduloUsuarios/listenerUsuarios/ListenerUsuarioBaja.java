package moduloUsuarios.listenerUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloStock.StockController;
import moduloStock.StockInterface;
import moduloStock.StockView;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerUsuarioBaja implements ActionListener {


	private UsuarioController uc;


	public ListenerUsuarioBaja(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		uc.dispose();
		
		
	}
	
}
