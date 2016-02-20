package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloClientes.ClientesController;

public class ListenerClientesBaja implements ActionListener {



	private ClientesController cc;


	public ListenerClientesBaja(ClientesController cc) {
		this.cc = cc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		cc.showBaja();
		
		
	}
	
}
