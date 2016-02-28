package moduloVehiculos;

import java.util.List;

import javax.swing.JFrame;
import exceptions.DBException;
import objetos.Persona;
import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;

public interface VehiculosInterface {

	// CONSULTAS

		public Vehiculo getVehiculoPorPatente(String patente);  // Busca un veh por esa patente.
		public Vehiculo getDatosModificarVehiculo(Vehiculo vehiculo); //Patente, precio, estado (baja vehiculo = no disponible).
		public Vehiculo getDatosNuevoVehiculo(); // trae los datos del form nuevo veh y se los da al controller para que haga la consulta en veh DB.

		// PANTALLA
		public void closeVehiculo();
		public void refresh();
		public void showStock(List<Stock> listaStockVehiculos); // Mostrar form stock, grilla - excepto vendidos y no disponible
//	public void showVehiculo(VehiculosController vehiculosController); // muestra form menu veh con todos los botones (nuevo, modificar, stock, buscar por patente).
		public void showFormNuevoVehiculo(); // Mostrar form nuevo veh.
		public void showFormModificarVehiculo();
		
		// MENSAJES
		
		public void insertOk();
		public void insertError();
		void showVehiculo(VehiculosController vehiculosController, JFrame f,
				Usuario u);
		
		
}
