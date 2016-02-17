package ModuloUsuario.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import ModuloUsuario.UsuarioController;
import ModuloUsuario.View.UsuarioView;
import exceptions.DBException;
import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloStock.StockController;
import moduloStock.StockInterface;
import moduloStock.StockView;

public class ListenerUsuarioVolver implements ActionListener {


	private UsuarioController uc;


	public ListenerUsuarioVolver(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		uc.dispose();
		
		
	}
	
}
