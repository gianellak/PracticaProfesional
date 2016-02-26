package moduloUsuarios;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Usuario;

public interface UsuarioInterface {

	public void showMenuUsuario(UsuarioController uc, JFrame frame, Usuario u);

//***********************************************
//	MENU USUARIO PRINCIPAL - USUARIO CONTROLLER:
//	SHOWALTA(onAlta)
//	SHOWUNUSUARIO(onBuscarUsuario)
//	SHOWUSUARIOS(onVerLista)
	
	public void onAlta();
	public void onVerLista(List<Usuario> lista);
	public void onBuscarUsuario();
	
//**************************************************
// onAlta()

	public void insertOk();
	public void insertBad();

//	showUnUsuario()
	public String getUsuarioABuscar();	
	public void verUsuario(Usuario u);
	public void showNotFound();

//	onVerLista
	
	void mostrarListaUsuario(List<Usuario> lista);
	
//showUnUsuario() - Modificar
	


	public Usuario getNuevoUsuario();


	public void onBaja();

	public String getBajaUsuario();

	public void cleanPanelUsuario();

	public int showToDelete(Usuario user);

	public void deleteOk();

	public void deleteBad();
	
	public void onMod();

	public int showToUpdate(Usuario user);

	public Usuario getModUsuario();

	public void updateOk();

	public void updateBad();






}
