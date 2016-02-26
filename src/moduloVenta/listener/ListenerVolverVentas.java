package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerVolverVentas implements ActionListener {


	private VentasController vc;


	public ListenerVolverVentas(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.cleanVentas();
		
		
	}
	
}
