package moduloCaja.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import moduloCaja.CajaController;
import moduloClientes.ClientesController;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerAltaMovimiento implements ActionListener {

	private CajaController cc;

	public ListenerAltaMovimiento(CajaController cc) {
		this.cc = cc;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			cc.altaMovimiento();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
