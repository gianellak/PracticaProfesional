package moduloUsuarios;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
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
		System.out.println("BUCOEN LA DB AL USUARIO");

		Usuario u = uDB.findId(ui.getUsuarioABuscar());

		if (u != null) {

			ui.verUsuario(u);
		} else {
			ui.showNotFound();
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

		if (user != null) {

			int codigo = ui.showToUpdate(user);

			if (codigo == JOptionPane.YES_OPTION) {
				if (uDB.update(user)) {

					ui.updateOk();
				} else {
					ui.updateBad();
				}
			} else if (codigo == JOptionPane.NO_OPTION) {
				ui.onMod();
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

}
