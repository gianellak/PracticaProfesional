package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVehiculo.vehiculoController;

public class ListenerModificarVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerModificarVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
