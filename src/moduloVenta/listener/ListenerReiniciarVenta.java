package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerReiniciarVenta implements ActionListener {


	private VentasController vc;


	public ListenerReiniciarVenta(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.showNuevaVenta();
		
	}
	
}
