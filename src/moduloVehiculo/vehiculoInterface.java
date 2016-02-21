package moduloVehiculo;

import java.util.List;

import exceptions.DBException;
import objetos.Stock;
import objetos.Vehiculo;


public interface vehiculoInterface {

	
	
	// CONSULTAS

	public Vehiculo getVehiculoPorPatente(String patente);  // Busca un veh por esa patente.
	public Vehiculo getDatosModificarVehiculo(Vehiculo vehiculo); //Patente, precio, estado (baja vehiculo = no disponible).
	public Vehiculo getDatosNuevoVehiculo(); // trae los datos del form nuevo veh y se los da al controller para que haga la consulta en veh DB.

	// PANTALLA
	public void closeVehiculo();
	public void refresh();
	public void showStock(List<Stock> listaStockVehiculos); // Mostrar form stock, grilla - excepto vendidos y no disponible
	public void showVehiculo(vehiculoController vc); // muestra form menu veh con todos los botones (nuevo, modificar, stock, buscar por patente).
	public void showFormNuevoVehiculo(); // Mostrar form nuevo veh.
	public void showFormModificarVehiculo();
	
	// MENSAJES
	
	public void insertOk();
	public void insertError();
	
	
	
}
