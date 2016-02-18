package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.vehiculoController;

public class ListenerSalirVehiculo implements ActionListener {

	private vehiculoController vc;

	public ListenerSalirVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onCancel();
	}

}
