package moduloUsuarios;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Empleado;
import objetos.Usuario;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;

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

	// *************************************
	// MENU PRINCIPAL USUARIO - LISTENERS:
	// VOLVER(getBack)
	// ALTA(showAlta)
	// VER USUARIO(showUnUsuario)
	// MOSTRARLISTA USUARIOS(showUsuarios)]

	public void getBack() {

		pc.getBack();

	}

	public void showAlta() {

		ui.onAlta();

	}

	public void showUsuarios() throws DBException {

		System.out.println("Ver Usuarios - Controller");

		List<Usuario> lista = uDB.findAll();

		ui.onVerLista(lista);

	}

	public void showUnUsuario() {

		ui.onBuscarUsuario();

	}

	// ******************************************
	// OPCION ALTA
	// ACEPTAR (altaUsuario)
	// VOLVER (cleanUsuario)

	public void altaUsuario() throws DBException {

		Usuario usuario = ui.getNuevoUsuario();

		if (uDB.insert(usuario)) {

			ui.insertOk();

		} else {

			ui.insertBad();
		}

	}

	public void cleanUsuario() {

		ui.cleanPanelUsuario();

	}

	// *********************************
	// ON OPCION BUSCAR UN USUARIO [LISTENER]

	public void buscarUnUsuario() throws DBException {

		
		
		if (!ui.getUsuarioABuscar().isEmpty()){
			
			System.out.println("BUSCO EN LA DB AL USUARIO");
			
			Usuario u  = uDB.findId(ui.getUsuarioABuscar());
			
			if(u != null){
				
				ui.verUsuario(u);
			}else
			{
				ui.showNotFound();
			}
			
		}else {
		
			String g = String.valueOf(ui.getEmpleadoABuscar());
		
			if(!g.isEmpty()){
				
			
				System.out.println("BUSCO EN LA DB AL EMP");
			
			
				Empleado e = uDB.findIdEmpleado(ui.getEmpleadoABuscar());
			
			
				if(e != null){
				
					ui.verEmpleado(e);
			
				}else{
					
				ui.showNotFound();
			}
		}else{
			ui.msjNoIngresoBusqueda();
			}
		}
		

	}

	// **************
	// MENU BUSCAR USUARIO - LISTENER BAJA USUARIO

	public void bajaUsuario() throws DBException {

		String u = ui.getBajaUsuario();

		Usuario user = uDB.findId(u);

		if (user != null) {

			int codigo = ui.showToDelete(user);

			if (codigo == JOptionPane.YES_OPTION) {
				if (uDB.delete(u)) {

					ui.deleteOk();
				} else {
					ui.deleteBad();
				}
			} else if (codigo == JOptionPane.NO_OPTION) {
				ui.onBaja();
			}

		} else {
			ui.showNotFound();
		}

	}

	// *************
	// MENU BUSCAR USUARIO - MODIFICAR USUARIO

	public void showMod() {
		ui.onMod();

	}

	public void modUsuario() throws DBException {

		Usuario user = ui.getModUsuario();

		
		if(user != null){
		
			Usuario userDB = uDB.findDNIu(user.getDniUsuario());

			if(userDB!= null){
				
				int codigo = ui.showToUpdate(userDB);
			 
				if (codigo==JOptionPane.YES_OPTION){
				
					if(uDB.update(user)){
						
						ui.updateOk();
					}else
					{
						ui.updateBad();
					}
		        }else if(codigo==JOptionPane.NO_OPTION){
		            ui.onMod();
		        }
			
			} else{
				//USUARIO NO EXISTENTE
			}
		}
		
	}

	public void showModE() {
		ui.onModE();
		
	}

	public void bajaEmpleado() throws DBException {

		int dni = ui.getBajaEmpleado();
		
		
		Empleado e = uDB.findIdEmpleado(dni);
		
		
		if(e != null){
		
		int codigo = ui.showToDelete(e);
		
		 if (codigo==JOptionPane.YES_OPTION){
			 if(uDB.deleteEmpleado(e.getIdEmpleado())){
					
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

	public void validarE() throws DBException {
		
		Empleado e = uDB.findIdEmpleado(ui.getEmpNuevoUsuario());
		
		if(e!= null){
			ui.lockDni(e.getNombre(), e.getApellido());
		} else{
			ui.showNotFound();
		}
		
	}

	public void modEmpleado() throws DBException {
	
		Empleado e = ui.getModEmpleado();
		
		if(e != null){
			
			int codigo = ui.showToUpdateE(e);
			
			 if (codigo==JOptionPane.YES_OPTION){
				 if(uDB.updateEmpleado(e)){
						
						ui.updateOk();
					}else
					{
						ui.updateBad();
					}
		        }else if(codigo==JOptionPane.NO_OPTION){
		            ui.onModE();
		        }
			
		}
	}

	// RESETEAR USUARIO

	public void resetUsuario() throws DBException {

		String username = ui.getResetUsuario();
		
		Usuario u = uDB.findId(username);
		
		if (u != null) {

			int codigo = ui.showToReset(u);

			if (codigo == JOptionPane.YES_OPTION) {
				
				u.setBloqueo(false);
				
				if (uDB.update(u)) {
					ui.updateOk();
				} else {
				
					ui.updateBad();
					
				}
				
			} else if (codigo == JOptionPane.NO_OPTION) {
			
				ui.onMod();
				
			}

			
		}

		
	}
				

	public void showAltaE() {
		ui.onAltaE();
		
	}

	public void altaEmpleado() throws DBException {
		System.out.println("Alta Em");
		
		Empleado e = ui.getModEmpleado();

		if (uDB.inserE(e)) {

			ui.insertOkE();
			
		} else {
			
			ui.insertBadE();
		}

		
	}

	

}
