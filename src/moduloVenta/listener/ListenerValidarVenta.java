package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerValidarVenta implements ActionListener {


	private VentasController vc;


	public ListenerValidarVenta(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

	
			try {
				vc.validarVenta();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
	}
	
}
