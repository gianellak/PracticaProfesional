package moduloUsuarios.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moduloUsuarios.UsuarioController;

public class ListenerEmpleadoAlta implements ActionListener {


	private UsuarioController uc;


	public ListenerEmpleadoAlta(UsuarioController uc){
		this.uc = uc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		uc.showAltaE();
		
		
	}
	
}
