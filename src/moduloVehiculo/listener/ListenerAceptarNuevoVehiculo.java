package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVehiculo.vehiculoController;

public class ListenerAceptarNuevoVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerAceptarNuevoVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onAceptarNuevoVehiculo();
	}

}
