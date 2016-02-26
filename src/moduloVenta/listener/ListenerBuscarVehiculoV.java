package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerBuscarVehiculoV implements ActionListener {


	private VentasController vc;


	public ListenerBuscarVehiculoV(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.buscarVehiculo();
		
		
	}
	
}
