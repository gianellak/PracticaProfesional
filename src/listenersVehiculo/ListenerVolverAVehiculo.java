package listenersVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.VehiculoController;

public class ListenerVolverAVehiculo implements ActionListener {

	VehiculoController vc;
	
	
	public ListenerVolverAVehiculo(VehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vc.onVolver();
		
	}

}
