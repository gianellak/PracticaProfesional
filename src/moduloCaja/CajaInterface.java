package moduloCaja;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Movimiento;
import objetos.Persona;
import objetos.Usuario;

public interface CajaInterface {

	
	// CONSULTAS 
	
	void onVer(int i, List<Movimiento> lista);

	public Movimiento getNuevoMovimiento();
	
	//public void onMod(); NO HAY MODIFICACIÓN DE MOVIMIENTOS. PERO LO DEJO POR LAS DUDAS POR SI LO VES!
	
	// PANTALLA
	
	void showMenuCaja(CajaController cc, JFrame f, Usuario u);

	

	void verOtrosMovimientos();
	void abroCaja();
	void onVerOtro(List<Movimiento> lista, String stringDate);
	void cleanPanelCaja();
	String getMovimientoTabla();
	void mostrarMovimientoMod(Movimiento m);
	void cierroCaja(int i);

	void onVerCierre(int i, List<Movimiento> lista);
	
}
