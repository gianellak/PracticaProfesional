package moduloVenta;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import objetos.*;

public interface VentasInterface {

	void showMenuVentas(VentasController ventasController, JFrame view,
			Usuario user);

	void showNuevaVenta();

	int getDniBuscarC();

	void altaCliente(int dni);

	Persona getPersonaAlta();

	void mostrarCliente(Persona cliente);

	void mostrarGarante(Persona cliente);

	void altaGarante(int dni);

	
	int getDniBuscarG();

	String getPatenteBuscar();

	void mostrarPatente(Vehiculo vehiculo);

	void cleanPanelVentas();

	Boolean getButtonState();

	void msjVentaIncompleta();

	String getVehiculoTabla();

	int msjSinPatente();

	void cleanStock();

	void mostrarDetalleVehiculo(Vehiculo vehiculo);

	void muestroStock(List<Stock> lista, ArrayList<String> comboMarca,
			ArrayList<String> comboModelo, ArrayList<String> comboYear);

	void msjVentaError();

	
	int getCuotas();

	void cargarTabla(List<Cuota> lista);

	
	void ingresarDetalleVenta(int idVenta, String cliente, String garante,
			String vehiculo, int precio);

	Double getSaldo();






	
	

}
