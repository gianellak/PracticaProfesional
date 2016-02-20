package moduloUsuarios;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Usuario;

public interface UsuarioInterface {

	public void dispose();

	public List<Usuario> findAll() throws DBException;

	public void showMenuUsuario(UsuarioController uc, JFrame frame, Usuario u);

	public void onAlta();

	public Usuario getNuevoUsuario();

	public void insertOk();

	public void insertBad();

	public void onBaja();

	public String getBajaUsuario();

	public void cleanPanelUsuario();

	public void onMod();

	public void showNotFound();

	public int showToDelete(Usuario user);

	public void deleteOk();

	public void deleteBad();

	void onVer(List<Usuario> lista);

}