package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloCobranzas.ventas.VentasController;

public class ListenerBuscar implements ActionListener {

	private VentasController vc;


	public ListenerBuscar(VentasController ventasController) {
			super();
			this.vc = ventasController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			vc.buscarVenta();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
