package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import objetos.Usuario;
import exceptions.DBException;
import exceptions.LexicalException;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerBuscarUnUsuario implements ActionListener {


	private UsuarioController uc;
	


	public ListenerBuscarUnUsuario(UsuarioController uc){
		
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			uc.buscarUnUsuario();
		} catch (DBException | LexicalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
