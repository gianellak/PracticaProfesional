package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVenta.VentasController;



public class ListenerNuevaVenta implements ActionListener {


	private VentasController vc;


	public ListenerNuevaVenta(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.showNuevaVenta();
		
		
	}
	
}
