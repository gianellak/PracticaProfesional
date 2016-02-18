package moduloUsuarios;

import java.sql.Connection;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioView;

public class UsuarioController {

	private UsuarioInterface ui;
	private PrincipalController pc;
	
	public UsuarioController(UsuarioInterface ui, PrincipalController pc) {
		this.ui = ui;
		this.pc = pc;
	}

	public void showUsuario(PrincipalController pc) {
		
		ui.showMenuUsuario(this);
	
		
	}

	public void dispose() {
		ui.dispose();
		
	}

	public void verUsuarios() throws DBException {
		
		System.out.println("Ver Usuarios - Controller");
		
		UsuarioDB uDB = new UsuarioDB(pc);
		
		uDB.findAll();
		
	}

	

}
