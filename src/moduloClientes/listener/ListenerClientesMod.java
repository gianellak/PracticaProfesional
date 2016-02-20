package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloClientes.ClientesController;
public class ListenerClientesMod implements ActionListener {


	private ClientesController cc;


	public ListenerClientesMod(ClientesController cc){
		this.cc = cc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.showMod();
		
		
	}
	
}
