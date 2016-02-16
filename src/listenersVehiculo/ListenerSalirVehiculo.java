package listenersVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.VehiculoController;

public class ListenerSalirVehiculo implements ActionListener {

	private VehiculoController vc;

	public ListenerSalirVehiculo(VehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onCancel();
	}

}
