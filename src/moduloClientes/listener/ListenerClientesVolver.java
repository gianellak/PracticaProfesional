package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloClientes.ClientesController;

public class ListenerClientesVolver implements ActionListener {

	private ClientesController cc;


	public ListenerClientesVolver(ClientesController cc){
		this.cc = cc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.getBack();
		
		
	}
	
}
