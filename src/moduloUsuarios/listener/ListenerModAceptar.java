package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import exceptions.DBException;
import moduloUsuarios.UsuarioController;

public class ListenerModAceptar implements ActionListener {


	private UsuarioController uc;
	


	public ListenerModAceptar(UsuarioController uc){
		
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			uc.modUsuario();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
