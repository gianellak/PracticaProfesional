package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloClientes.ClientesController;


public class ListenerClientesVer implements ActionListener {


	private ClientesController cc;


	public ListenerClientesVer(ClientesController cc){
		this.cc = cc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.showMod();
		
		
	}
	
}
