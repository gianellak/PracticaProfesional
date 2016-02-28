package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloVehiculos.VehiculosController;

public class ListenerBuscarVehiculo implements ActionListener {

	VehiculosController vc;

	public ListenerBuscarVehiculo(VehiculosController vc2) {
		super();
		this.vc = vc2;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.onBuscarPorPatente();

	}

}
