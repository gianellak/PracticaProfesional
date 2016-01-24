package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.login.LoginController;
import moduloStock.StockController;
import moduloStock.StockInterface;
import moduloStock.StockView;

public class ListenerS implements ActionListener {

	private StockInterface si;
	

	@Override
	public void actionPerformed(ActionEvent e) {

		si = new StockView();
		
		StockController sc = new StockController(si);
		
	}

}
