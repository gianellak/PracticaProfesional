package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerValidarC implements ActionListener {


	private VentasController vc;


	public ListenerValidarC(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		
				try {
					vc.validarCliente();
				} catch (DBException | NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		
		
	}
	
}
