package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerDetalleVehiculo implements ActionListener {


	private VentasController vc;


	public ListenerDetalleVehiculo(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.mostrarDetalle();		
	}
	
}
