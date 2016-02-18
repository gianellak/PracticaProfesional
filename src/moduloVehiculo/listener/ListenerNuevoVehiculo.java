package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import exceptions.DBException;
import objetos.Vehiculo;
import vehiculo.ABM.vehiculoController;

public class ListenerNuevoVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerNuevoVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			try {
				vc.onCreateVehiculo();
			} catch (NumberFormatException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
