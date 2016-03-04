package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculos.VehiculosController;
import moduloVenta.VentasController;



public class ListenerComboModelo implements ActionListener {


	private VehiculosController vc;


	public ListenerComboModelo(VehiculosController vc2) {
		this.vc = vc2;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		vc.filtrarModelo();
		
		
	}
	
}
