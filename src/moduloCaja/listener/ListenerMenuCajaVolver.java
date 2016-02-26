package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloClientes.ClientesController;

public class ListenerMenuCajaVolver implements ActionListener {

	private ClientesController cc;

	public ListenerMenuCajaVolver(ClientesController cc) {
		this.cc = cc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.cleanClientes();

	}

}
