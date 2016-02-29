package moduloCaja;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Movimiento;
import objetos.Persona;
import objetos.Usuario;

public interface CajaInterface {

	
	// CONSULTAS 
	
	void onVer(List<Movimiento> lista);
	public void onAlta();
	public void onBaja();
	int getBajaMovimiento();
	public Movimiento getNuevoMovimiento();
	
	//public void onMod(); NO HAY MODIFICACIÓN DE MOVIMIENTOS. PERO LO DEJO POR LAS DUDAS POR SI LO VES!
	
	// PANTALLA
	
	void showMenuCaja(CajaController cc, JFrame f, Usuario u);
	void cleanPanelClientes();
	
	// MENSAJES
	
	public void insertOk();
	public void insertError();
	public void showToDelete(Movimiento movimiento);
	public void deleteOk();
	public void deleteError();

	public void showNotFound();
	public void dispose();
	void primerMovimiento();
}
