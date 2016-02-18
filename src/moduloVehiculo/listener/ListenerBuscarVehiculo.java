package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVehiculo.vehiculoController;

public class ListenerBuscarVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerBuscarVehiculo(vehiculoController vc) {
		super();
		this.vc = vc;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.onBuscarPorPatente();

	}

}
