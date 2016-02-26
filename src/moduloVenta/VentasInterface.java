package moduloVenta;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;
import objetos.Vehiculo;

public interface VentasInterface {

	void showMenuVentas(VentasController ventasController, JFrame view,
			Usuario user);

	void showNuevaVenta();

	int getDniBuscarC();

	void msjErrorDNI();

	int msjClienteNotFound();

	void altaCliente();

	Persona getPersonaAlta();

	void insertOk();

	void insertBad();

	void mostrarCliente(Persona cliente);

	void mostrarGarante(Persona cliente);

	void altaGarante();

	void insertGaranteOk();

	int getDniBuscarG();

	String getPatenteBuscar();

	void mostrarPatente(Vehiculo vehiculo);

	void cleanPanelVentas();

	Boolean getButtonState();

	void msjVentaIncompleta();
	
	

}
