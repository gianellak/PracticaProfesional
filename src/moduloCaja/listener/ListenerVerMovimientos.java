package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloCaja.CajaController;
import moduloClientes.ClientesController;


public class ListenerVerMovimientos implements ActionListener {


	private CajaController cc;


	public ListenerVerMovimientos(CajaController cc){
		this.cc = cc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			cc.verMovimientos();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
