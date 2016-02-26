package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloVenta.VentasController;



public class ListenerValidarVenta implements ActionListener {


	private VentasController vc;


	public ListenerValidarVenta(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

	
			vc.validarVenta();
		
		
		
	}
	
}
