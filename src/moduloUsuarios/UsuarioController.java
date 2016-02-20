package moduloUsuarios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Usuario;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioView;

public class UsuarioController {

	private UsuarioInterface ui;
	private PrincipalController pc;
	private UsuarioDB uDB;
	
	public UsuarioController(UsuarioInterface ui, PrincipalController pc) {
		this.ui = ui;
		this.pc = pc;
	}

	public void showUsuario() {
		
		ui.showMenuUsuario(this, pc.getView(), pc.getUser());
	
		this.conectar();
		
		
	}

	public void dispose() {
		ui.dispose();
		
	}

	public void verUsuarios() throws DBException {
		
		System.out.println("Ver Usuarios - Controller");
		
		
		
		List<Usuario> lista= uDB.findAll();
		
		ui.onVer(lista);
		
	}

	private void conectar() {
		
		ConnectionProvider pro = new DBConnection();
		
		try {
			pro.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		uDB = new UsuarioDB(pro);
		
	}

	public void getBack() {
		
		pc.getBack();
		
		
	}
	
	public void cleanUsuario(){
		
		ui.cleanPanelUsuario();
		
	}

	public void showAlta() {
		
		ui.onAlta();
		
	}
	
	public void bajaUsuario() throws DBException{
		
		String u = ui.getBajaUsuario();
		
		
		Usuario user = uDB.findId(u);
		
		
		if(user != null){
		
		int codigo = ui.showToDelete(user);
		 if (codigo==JOptionPane.YES_OPTION){
			 if(uDB.delete(u)){
					
					ui.deleteOk();
				}else
				{
					ui.deleteBad();
				}
	        }else if(codigo==JOptionPane.NO_OPTION){
	            ui.onBaja();
	        }
		
		}else{
			ui.showNotFound();
		}
		

	}

	
	public void altaUsuario() throws DBException {
		
		Usuario usuario = ui.getNuevoUsuario();
		
		if(uDB.insert(usuario)){
			
			ui.insertOk();
		}else
		{
			ui.insertBad();
		}
		
		
		
	}

	public void showBaja() {

		ui.onBaja();
		
	}

	public void showMod() {
		ui.onMod();
		
	}

	

	

	

	

}