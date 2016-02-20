package moduloClientes;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;

public interface ClientesInterface {

	public void dispose();

	public List<Usuario> findAll() throws DBException;

	public void onAlta();
	
	public void insertOk();

	public void insertBad();

	public void onMod();

	public void showNotFound();

	public int showToDelete(Persona persona);

	public void deleteOk();

	public void deleteBad();

	void onVer(List<Usuario> lista);

	public Persona getNuevoCliente();

	public void showMenuClientes(ClientesController clientesController,
			JFrame view, Usuario user);

	int getBajaPersona();

	void cleanPanelClientes();
	
	public void verMod();

	public int getModPersona();

	public void verCliente(Persona p);

}
