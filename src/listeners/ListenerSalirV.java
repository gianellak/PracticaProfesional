package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloCobranzas.ventas.VentasController;
import moduloLogin.LoginController;

public class ListenerSalirV implements ActionListener{

	private VentasController vc;


	public ListenerSalirV(VentasController ventasController) {
			super();
			this.vc = ventasController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onCancel();
		
	}

}
