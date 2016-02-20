package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloClientes.ClientesController;


public class ListenerBuscarCliente implements ActionListener {


	private ClientesController cc;


	public ListenerBuscarCliente(ClientesController cc){
		this.cc = cc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			cc.verUnClienteMod();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
