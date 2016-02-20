package moduloCaja;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;

public interface CajaInterface {

	public void dispose();

	public List<Usuario> findAll() throws DBException;

	public void onAlta();
	
	public void insertOk();

	public void insertBad();

	public void onBaja();

	public void onMod();

	public void showNotFound();

	public int showToDelete(Persona persona);

	public void deleteOk();

	public void deleteBad();

	void onVer(List<Usuario> lista);

	public Persona getNuevoCliente();

	public void showMenuClientes(CajaController clientesController,
			JFrame view, Usuario user);

	int getBajaPersona();

	void cleanPanelClientes();

}
