package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.DBException;
import moduloUsuarios.UsuarioController;

public class ListenerResetearUsuario implements ActionListener {

	private UsuarioController uc;

	public ListenerResetearUsuario(UsuarioController uc) {

		this.uc = uc;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			System.out.println("Rachel. Listener Resetear ");
			uc.resetUsuario();
			
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}