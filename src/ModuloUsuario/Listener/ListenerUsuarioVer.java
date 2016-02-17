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

public class ListenerUsuarioVer implements ActionListener {


	private UsuarioController uc;


	public ListenerUsuarioVer(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			uc.verUsuarios();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
