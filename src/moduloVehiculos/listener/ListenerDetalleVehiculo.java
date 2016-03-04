package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculos.VehiculosController;
import moduloVenta.VentasController;



public class ListenerDetalleVehiculo implements ActionListener {


	private VehiculosController vc;


	public ListenerDetalleVehiculo(VehiculosController vc2){
		this.vc = vc2;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.mostrarDetalle();
		
		
	}
	
}
