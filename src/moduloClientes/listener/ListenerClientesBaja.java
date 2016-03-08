package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import exceptions.LexicalException;
import moduloClientes.ClientesController;

public class ListenerClientesBaja implements ActionListener {



	private ClientesController cc;


	public ListenerClientesBaja(ClientesController cc) {
		this.cc = cc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			cc.bajaPersona();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
