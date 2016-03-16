package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloCaja.CajaController;

public class ListenerCajaVolver implements ActionListener {

	private CajaController cc;

	public ListenerCajaVolver(CajaController cc) {
		this.cc = cc;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.getBack();
	}

}
