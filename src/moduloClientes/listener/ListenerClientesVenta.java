package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloClientes.ClientesController;

public class ListenerClientesVenta implements ActionListener {


	private ClientesController cc;
	


	public ListenerClientesVenta(ClientesController uc){
		
		this.cc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		cc.nuevaVenta();
		
		
	}
	
}
