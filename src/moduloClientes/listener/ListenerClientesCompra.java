package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloClientes.ClientesController;

public class ListenerClientesCompra implements ActionListener {


	private ClientesController cc;
	


	public ListenerClientesCompra(ClientesController uc){
		
		this.cc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			cc.altaPersona();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
