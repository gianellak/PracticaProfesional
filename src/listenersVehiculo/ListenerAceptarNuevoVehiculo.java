package listenersVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.VehiculoController;

public class ListenerAceptarNuevoVehiculo implements ActionListener {

	VehiculoController vc;

	public ListenerAceptarNuevoVehiculo(VehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onAceptarNuevoVehiculo();
	}

}
