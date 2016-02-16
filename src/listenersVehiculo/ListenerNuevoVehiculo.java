package listenersVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import objetos.Vehiculo;
import vehiculo.ABM.VehiculoController;

public class ListenerNuevoVehiculo implements ActionListener {

	VehiculoController vc;

	public ListenerNuevoVehiculo(VehiculoController vc) {
		super();
		this.vc = vc;
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
