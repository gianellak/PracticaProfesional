package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.VehiculoController;

public class ListenerBuscarVehiculo implements ActionListener {

	VehiculoController vc;

	public ListenerBuscarVehiculo(VehiculoController vc) {
		super();
		this.vc = vc;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.onBuscarPorPatente();

	}

}
