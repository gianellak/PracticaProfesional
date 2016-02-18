package moduloUsuarios.listenerUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import exceptions.DBException;
import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloStock.StockController;
import moduloStock.StockInterface;
import moduloStock.StockView;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;

public class ListenerUsuarioMenu implements ActionListener {

private UsuarioView usuarioView;
private PrincipalController pc;
private Connection conn;

	public ListenerUsuarioMenu(PrincipalController pc){
		super();
		this.pc = pc;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {

		usuarioView = new UsuarioView();
		
		UsuarioController uc = new UsuarioController(usuarioView, pc);
		
		System.out.println("ListenerUsuarioMenu");
		
		uc.showUsuario(pc);
		
		
	}
	
}
