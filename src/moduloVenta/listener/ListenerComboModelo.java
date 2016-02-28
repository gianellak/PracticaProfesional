package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerComboModelo implements ActionListener {


	private VentasController vc;


	public ListenerComboModelo(VentasController vc) {
		this.vc = vc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		vc.filtrarModelo();
		
		
	}
	
}
