package moduloUsuarios;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Empleado;
import objetos.Usuario;
import utilitarios.Mensajes;
import utilitarios.Sintaxis;
import utilitarios.StringMsj;
import exceptions.DBException;
import exceptions.LexicalException;
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

		if (!usuario.getUsername().isEmpty()
				&& !usuario.getPassword().isEmpty()
				&& !usuario.getApellido().isEmpty()
				&& usuario.getPermisos() != 99)
			try {
				if (Sintaxis.analizoUsuario(usuario.getUsername())
						&& Sintaxis.analizoPass(usuario.getPassword())
						&& Sintaxis.analizoNumero(String.valueOf(usuario
								.getPermisos()))) {

					if ((uDB.findIdEmpleado(usuario.getDniUsuario()) != null)) { // SI
																					// ES
																					// EMPLEADO

						if ((uDB.findDNIu(usuario.getDniUsuario()) == null)) { // SI
																				// NO
																				// EXISTE
																				// ESE
																				// DNI
																				// EN
																				// TABLA
																				// USUARIOS

							if (uDB.findId(usuario.getUsername()) == null) { // SI
																				// NO
																				// EXISTE
																				// ESE
																				// USERNAME
																				// EN
																				// TABLA
																				// USUARIOS

								if (uDB.insert(usuario)) { // QUE HAGA EL INSERT

									ui.insertOk();

								} else {

									ui.insertBad();
								}

							} else {
								// QUE MUESTRE CARTEL INFORMANDO QUE YA EXISTE
								// UN USUARIO CON ESE USERNAME.
								ui.showMensaje("Ya existe un usuario registrado con ese nombre de usuario. Elija otro y vuelva a intentar.");
							}

						} else {
							// QUE MUESTRE CARTEL INFORMANDO QUE YA EXISTE UN
							// USUARIO CON ESE DNI.
							ui.showMensaje("Ya existe un usuario registrado con ese DNI.");
						}
					} else {
						// QUE MUESTRE CARTEL INFORMANDO QUE NO ES EMPLEADO.
						ui.showMensaje("La persona no está registrada como empleado en el sistema. Por favor, ingreselo y vuelva a intentar.");
					}

				} else {

					Mensajes.mensajeWarning(StringMsj.MSG_BAD_DATA);
				}
			} catch (LexicalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else {
			Mensajes.mensajeWarning(StringMsj.MSG_OBLI);
		}

	}

	public void cleanUsuario() {

		ui.cleanPanelUsuario();

	}

	// *********************************
	// ON OPCION BUSCAR UN USUARIO [LISTENER]

	public void buscarUnUsuario() throws DBException, LexicalException {

		String u = ui.getUsuarioABuscar();

		String e = String.valueOf(ui.getEmpleadoABuscar());

		if (e.equals("0") && u.isEmpty()) {

			Mensajes.mensajeInfo(StringMsj.MSG_INPUT_MISSING);

		} else {

			if (u.isEmpty()) {

				if (Sintaxis.analizoDNI(e)) {

					Empleado empleado = uDB.findIdEmpleado(ui
							.getEmpleadoABuscar());

					if (empleado != null) {
						ui.cleanPanelUsuario();
						ui.verEmpleado(empleado);

						Usuario usuario = uDB
								.findDNIu(empleado.getIdEmpleado());

						if (usuario != null) {
							ui.verUsuario(usuario);
						} else {
							ui.empleadoSinUsuario();
						}

					} else {
						Mensajes.mensajeInfo(StringMsj.MSG_EMP_NOT_FOUND);
					}

				} else {
					Mensajes.mensajeInfo(StringMsj.MSG_DNI_NOT_VALID);
				}

			} else {

				if (Sintaxis.analizoUsuario(u)) {

					Usuario usuario = uDB.findId(ui.getUsuarioABuscar());

					if (usuario != null) {

						ui.cleanPanelUsuario();

						Empleado empleado = uDB.findIdEmpleado(usuario
								.getDniUsuario());

						if (empleado != null) {

							ui.verEmpleado(empleado);
							ui.verUsuario(usuario);
						}

					} else {
						Mensajes.mensajeInfo(StringMsj.MSG_USER_NOT_FOUND);
					}

				} else {
					Mensajes.mensajeWarning(StringMsj.MSG_USER_NOT_VALID);
				}

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

					Mensajes.mensajeInfo(StringMsj.MSG_USER_DEL_OK);

					ui.empleadoSinUsuario();

				} else {
					Mensajes.mensajeInfo(StringMsj.MSG_USER_DEL_BAD);
				}
			}

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

			Usuario userDB = uDB.findDNIu(user.getDniUsuario());

			if (userDB != null) {

				int codigo = ui.showToUpdate(userDB);

				if (codigo == JOptionPane.YES_OPTION) {

					if (uDB.update(user)) {

						ui.updateOk();
					} else {
						ui.updateBad();
					}
				} else if (codigo == JOptionPane.NO_OPTION) {
					ui.onMod();
				}

			} else {
				// USUARIO NO EXISTENTE
			}
		}

	}

	public void showModE() {
		ui.onModE();

	}

	public void bajaEmpleado() throws DBException {

		int dni = ui.getBajaEmpleado();

		Usuario u = uDB.findDNIu(dni);

		Empleado e = uDB.findIdEmpleado(dni);

		if (u != null) {

			if (ui.showToDeleteBoth(u) == JOptionPane.YES_OPTION) {
				if (uDB.delete(u.getUsername())) {

					Mensajes.mensajeInfo(StringMsj.MSG_USER_DEL_OK);

					eliminarEmpleado(e, dni);

				} else {
					ui.showNotFound();
				}

			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_USER_DEL_BAD);
			}

		} else {

			eliminarEmpleado(e, dni);

		}
	}

	public void eliminarEmpleado(Empleado e, int dni) throws DBException {
		if (e != null) {

			if (ui.showToDelete(e) == JOptionPane.YES_OPTION) {
				if (uDB.deleteEmpleado(dni)) {
					Mensajes.mensajeInfo(StringMsj.MSG_EMP_DEL_OK);
				} else {
					Mensajes.mensajeInfo(StringMsj.MSG_EMP_DEL_BAD);
				}
			}
		}

	}

	public void validarE() throws DBException {

		Empleado e = uDB.findIdEmpleado(ui.getEmpNuevoUsuario());

		if (e != null) {
			ui.lockDni(e.getNombre(), e.getApellido());
		} else {
			ui.showMensaje("La persona no está registrada como empleado en el sistema. Por favor, ingreselo y vuelva a intentar.");
		}

	}

	public void modEmpleado() throws DBException {

		Empleado e = ui.getModEmpleado();

		if (e.getIdEmpleado() != 0 && !e.getNombre().isEmpty()
				&& !e.getApellido().isEmpty() && !e.getTelefono().isEmpty()) {

			try {
				if (e.getIdEmpleado() != 0
						&& Sintaxis
								.analizoDNI(String.valueOf(e.getIdEmpleado()))
						&& Sintaxis.analizoTexto(e.getNombre())
						&& Sintaxis.analizoTexto(e.getApellido())
						&& Sintaxis.analizoTelefono(e.getTelefono())) {

					if (uDB.updateEmpleado(e)) {

						Mensajes.mensajeInfo(StringMsj.MSG_EMP_MOD_OK);
						;
						cleanUsuario();

					} else {
						Mensajes.mensajeWarning(StringMsj.MSG_EMP_MOD_BAD);
					}
				} else {
					Mensajes.mensajeWarning(StringMsj.MSG_BAD_DATA);
				}
			} catch (LexicalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			Mensajes.mensajeInfo(StringMsj.MSG_OBLI);
		}

	}

	// RESETEAR USUARIO

	public void resetUsuario() throws DBException {

		Usuario user = ui.getModUsuario();

		System.out.println("Rachel. Usuario " + user.getNombre());

		if (user != null) {
			int codigo = ui.showToReset(user);

			if (codigo == JOptionPane.YES_OPTION) {
				user.setBloqueo(false);

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

	public void showAltaE() {
		ui.onAltaE();

	}

	public void altaEmpleado() throws DBException {

		Empleado e = ui.getModEmpleado();

		if (e.getIdEmpleado() != 0 && !e.getNombre().isEmpty()
				&& !e.getApellido().isEmpty() && !e.getTelefono().isEmpty()) {

			try {
				if (e.getIdEmpleado() != 0
						&& Sintaxis
								.analizoDNI(String.valueOf(e.getIdEmpleado()))
						&& Sintaxis.analizoTexto(e.getNombre())
						&& Sintaxis.analizoTexto(e.getApellido())
						&& Sintaxis.analizoTelefono(e.getTelefono())) {

					if (uDB.inserE(e)) {

						Mensajes.mensajeInfo(StringMsj.MSG_EMP_INS_OK);
						;
						cleanUsuario();

					} else {
						Mensajes.mensajeWarning(StringMsj.MSG_EMP_INS_BAD);
					}
				} else {
					Mensajes.mensajeWarning(StringMsj.MSG_BAD_DATA);
				}
			} catch (LexicalException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			Mensajes.mensajeInfo(StringMsj.MSG_OBLI);
		}
	}

}
