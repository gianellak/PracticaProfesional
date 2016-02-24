package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculo.vehiculoController;
import moduloVehiculos.VehiculosController;

public class ListenerNuevoVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerNuevoVehiculo(vehiculoController vc2) {
		super();
		this.vc = vc2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			vc.onCreateVehiculo();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
