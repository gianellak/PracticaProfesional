package moduloVehiculo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculo.vehiculoController;

public class ListenerStock implements ActionListener{

	vehiculoController vc;
	
	public ListenerStock(vehiculoController vc) {
		super();
		this.vc = vc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			vc.onStock();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
