package moduloPrincipal.listenerPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloPrincipal.PrincipalController;
import moduloVehiculo.vehiculoController;
import moduloVehiculo.vehiculoInterface;
import moduloVehiculo.vehiculoView;


public class ListenerVehiculo implements ActionListener {

	private vehiculoInterface vi;
	private PrincipalController pc;

	public ListenerVehiculo(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Listener Stock");

		vi = new vehiculoView();

		vehiculoController vc = new vehiculoController(vi, pc);
		
		vc.onMenuVehiculo();
		pc.onCancel();

	}

}
