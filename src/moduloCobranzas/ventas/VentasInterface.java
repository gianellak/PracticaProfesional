package moduloCobranzas.ventas;

import java.sql.Array;
import java.util.List;

import objetos.Persona;
import objetos.Venta;


public interface VentasInterface {

	Venta getNuevaVenta();
	
	void showVenta(VentasController vc);
	
	int getDNI();

	String getPatente();

	void closeVentas();

	void mostrarCompras(List<Venta> lista);

	void mostrarAltA();

	void refreshVenta();

	void altaCliente(int dniCliente);

	void mostrarCliente(Persona p);

	Persona getNuevaPersona();

	
}
