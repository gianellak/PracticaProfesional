package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import exceptions.DBException;
import moduloVenta.VentasController;



public class ListenerValidarG implements ActionListener {


	private VentasController vc;


	public ListenerValidarG(VentasController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			vc.validarGarante();
		} catch (DBException | NumberFormatException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
