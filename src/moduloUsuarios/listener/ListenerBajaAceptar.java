package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import objetos.Usuario;
import exceptions.DBException;
import moduloUsuarios.UsuarioController;

public class ListenerBajaAceptar implements ActionListener {


	private UsuarioController uc;
	private String usuario;


	public ListenerBajaAceptar(UsuarioController uc){
		
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