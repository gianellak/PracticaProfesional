package listenersVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
			try {
				vc.onCreateVehiculo();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
