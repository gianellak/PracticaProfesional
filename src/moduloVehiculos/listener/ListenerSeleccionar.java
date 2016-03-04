package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculos.VehiculosController;
import moduloVenta.VentasController;



public class ListenerSeleccionar implements ActionListener {


	private VehiculosController vc;


	public ListenerSeleccionar(VehiculosController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.seleccionaVehiculo();
		
		
	}
	
}
