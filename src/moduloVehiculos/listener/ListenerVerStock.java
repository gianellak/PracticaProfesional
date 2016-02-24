package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVehiculo.vehiculoController;

public class ListenerVerStock implements ActionListener{

	vehiculoController vc;
	
	public ListenerVerStock(vehiculoController vc) {
		super();
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
