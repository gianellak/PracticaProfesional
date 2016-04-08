package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloVehiculos.VehiculosController;

public class ListenerStock implements ActionListener{

	VehiculosController vc;
	
	public ListenerStock(VehiculosController vc2) {
		super();
		this.vc = vc2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//vc.readCvs();
			vc.onStock();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
