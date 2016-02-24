package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVehiculo.vehiculoController;
import moduloVehiculos.VehiculosController;

public class ListenerBuscarVehiculo implements ActionListener {

	vehiculoController vc;

	public ListenerBuscarVehiculo(vehiculoController vc2) {
		super();
		this.vc = vc2;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.onBuscarPorPatente();

	}

}
