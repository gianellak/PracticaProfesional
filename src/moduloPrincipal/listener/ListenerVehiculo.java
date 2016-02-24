package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloPrincipal.PrincipalController;
import moduloVehiculos.VehiculosController;
//import moduloVehiculo.vehiculoController;
//import moduloVehiculo.vehiculoInterface;
import moduloVehiculos.VehiculosView;
//import moduloVehiculo.vehiculoView;


public class ListenerVehiculo implements ActionListener {

	private VehiculosView vi;
//	private vehiculoInterface vi;
	private PrincipalController pc;

	public ListenerVehiculo(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Listener Vehiculo");

		//vi = new vehiculoView();
		vi = new VehiculosView();

//		vehiculoController vc = new vehiculoController(vi, pc);
		VehiculosController vc = new VehiculosController(vi, pc);
		
		vc.onMenuVehiculo();
	//	pc.onCancel();
		

	}

}
