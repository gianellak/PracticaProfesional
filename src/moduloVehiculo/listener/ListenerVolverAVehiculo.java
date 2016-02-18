package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.vehiculoController;

public class ListenerVolverAVehiculo implements ActionListener {

	vehiculoController vc;
	
	
	public ListenerVolverAVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onVolver();
		
	}

}
