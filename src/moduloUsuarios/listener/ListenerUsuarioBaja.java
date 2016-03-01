package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerUsuarioBaja implements ActionListener {


	private UsuarioController uc;


	public ListenerUsuarioBaja(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
			
			try {
				uc.bajaUsuario();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
	
}
