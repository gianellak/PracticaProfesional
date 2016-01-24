package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import objetos.Persona;
import moduloCobranzas.ventas.VentasController;

public class ListenerNuevoCliente implements ActionListener{

	private VentasController vc;
	private Persona p;


	public ListenerNuevoCliente(VentasController ventasController) {
			super();
			this.vc = ventasController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			vc.onInsertar();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
