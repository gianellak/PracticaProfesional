package moduloClientes;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;

public interface ClientesInterface {

	public void dispose();

	public List<Usuario> findAll() throws DBException;

	public void showMenuUsuario(ClientesController uc, JFrame frame, Usuario u);

	public void onAlta();
	
	public void insertOk();

	public void insertBad();

	public void onBaja();

	public int getBajaUsuario();

	public void cleanPanelUsuario();

	public void onMod();

	public void showNotFound();

	public int showToDelete(Persona persona);

	public void deleteOk();

	public void deleteBad();

	void onVer(List<Usuario> lista);

	public Persona getNuevoCliente();

}
