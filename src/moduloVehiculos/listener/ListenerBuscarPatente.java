package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVehiculos.VehiculosController;

public class ListenerBuscarPatente implements ActionListener {

	VehiculosController vc;

	public ListenerBuscarPatente(VehiculosController vc2) {
		super();
		this.vc = vc2;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			vc.onBuscarPorPatente();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
