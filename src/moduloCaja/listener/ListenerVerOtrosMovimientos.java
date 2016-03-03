package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloCaja.CajaController;

public class ListenerVerOtrosMovimientos implements ActionListener {

	private CajaController cc;

	public ListenerVerOtrosMovimientos(CajaController cc) {
		this.cc = cc;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		cc.verOtrosMovimientos();

	}

}
