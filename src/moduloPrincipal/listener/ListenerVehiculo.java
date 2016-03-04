package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloPrincipal.PrincipalController;
import moduloVehiculos.VehiculosController;
import moduloVehiculos.VehiculosView;


public class ListenerVehiculo implements ActionListener {

	private VehiculosView vi;
	private PrincipalController pc;

	public ListenerVehiculo(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Listener Vehiculo");

		vi = new VehiculosView();

		VehiculosController vc = new VehiculosController(vi, pc);
		
		vc.onMenuVehiculo();
		

	}

}
