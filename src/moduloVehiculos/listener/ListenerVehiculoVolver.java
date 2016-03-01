package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloVehiculos.VehiculosController;

public class ListenerVehiculoVolver implements ActionListener {


	private VehiculosController vc;


	public ListenerVehiculoVolver(VehiculosController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		vc.getBack();
		
		
	}
	
}
