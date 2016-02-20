package moduloClientes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloClientes.ClientesController;

public class ListenerBajaAceptar implements ActionListener {


	private ClientesController cc;


	public ListenerBajaAceptar(ClientesController cc){
		
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