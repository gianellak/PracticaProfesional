package moduloClientes;

import java.util.List;

import javax.swing.JFrame;
import moduloClientes.paneles.PanelClientes;
import objetos.Persona;
import objetos.Usuario;

public interface ClientesInterface {

	public void onAlta();
	
	public void onMod();
	
	void onVer(List<Usuario> lista);

	public Persona getNuevoCliente();

	public void showMenuClientes(ClientesController clientesController,
			JFrame view, Usuario user);

	int getBajaPersona();

	void cleanPanelClientes();
	
	public void verMod();

	public int getModPersona();

	public void verCliente(Persona p);

	public Persona getUpdatePersona();

	public PanelClientes getPanelClientes();

}
