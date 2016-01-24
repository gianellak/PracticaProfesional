package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloCobranzas.ventas.VentasController;

public class ListenerAltaV implements ActionListener{

		private VentasController vc;


		public ListenerAltaV(VentasController ventasController) {
				super();
				this.vc = ventasController;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				vc.onAlta();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}


}
