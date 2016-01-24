package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloCobranzas.ventas.VentasController;

public class ListenerVolverV implements ActionListener{
	
	private VentasController vc;


	public ListenerVolverV(VentasController ventasController) {
			super();
			this.vc = ventasController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onVolver();
		
	}


}
