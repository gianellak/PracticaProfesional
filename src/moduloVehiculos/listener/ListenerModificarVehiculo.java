package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculo.vehiculoController;

public class ListenerModificarVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerModificarVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	try {
		vc.onUpdateVehiculo(null);
	} catch (DBException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

}
