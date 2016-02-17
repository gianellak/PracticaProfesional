package listenersVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vehiculo.ABM.VehiculoController;
import vehiculo.ABM.VehiculoInterface;
import vehiculo.ABM.VehiculoView;
import moduloPrincipal.PrincipalController;


public class ListenerVehiculo implements ActionListener {

	private VehiculoInterface vi;
	private PrincipalController pc;

	public ListenerVehiculo(PrincipalController pc) {
		super();
		this.pc = pc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Listener Stock");

		vi = new VehiculoView();

		VehiculoController vc = new VehiculoController(vi, pc);
		
		vc.showStock();
		pc.onCancel();

	}

}
