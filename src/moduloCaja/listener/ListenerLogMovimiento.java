package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloCaja.CajaController;

public class ListenerLogMovimiento implements ActionListener{

	CajaController cc;


	public ListenerLogMovimiento(CajaController cc) {
		super();
		this.cc = cc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		cc.generarArchivoLog();
	}

}
