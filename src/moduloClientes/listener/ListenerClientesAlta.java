package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloClientes.ClientesController;

public class ListenerClientesAlta implements ActionListener {


	private ClientesController cc;


	
	public ListenerClientesAlta(ClientesController cc) {
		this.cc = cc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		cc.showAlta();
		
		
	}
	
}
