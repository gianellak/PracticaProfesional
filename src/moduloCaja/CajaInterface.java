package moduloCaja;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Movimiento;
import objetos.Persona;
import objetos.Usuario;

public interface CajaInterface {

	public void dispose();

	public List<Movimiento> findAll() throws DBException;

	public void onAlta();
	
	public void insertOk();

	public void insertBad();

	public void onBaja();

	public void onMod();

	public void showNotFound();

	public void showToDelete(Movimiento movimiento);

	public void deleteOk();

	public void deleteBad();

	void onVer(List<Movimiento> lista);

	int getBajaPersona();

	void cleanPanelClientes();

	void showMenuCaja(CajaController cc, JFrame f, Usuario u);

	public Movimiento getNuevoMovimiento();

}
