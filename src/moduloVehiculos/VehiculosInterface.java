package moduloVehiculos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Persona;
import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;

public interface VehiculosInterface {

	
		// PANTALLA
		public void closeVehiculo();
		public void refresh();
		void showStock(List<Stock> listaStockVehiculos,
				ArrayList<String> comboMarca, ArrayList<String> comboModelo,
				ArrayList<String> comboYear); // Mostrar form stock, grilla - excepto vendidos y no disponible
//	public void showVehiculo(VehiculosController vehiculosController); // muestra form menu veh con todos los botones (nuevo, modificar, stock, buscar por patente).
		public void showFormNuevoVehiculo(); // Mostrar form nuevo veh.
		public void showFormModificarVehiculo();
		
		// MENSAJES
		
		public void insertOk();
		public void insertError();
		void showVehiculo(VehiculosController vehiculosController, JFrame f,
				Usuario u);
		public void cleanPanelVehiculo();
		public void onBuscarVehiculo();
		public String getPatenteABuscar();
		Vehiculo getVehiculoPorPatente(String patente);
		Vehiculo getDatosModificarVehiculo(Vehiculo vehiculo);
		public Vehiculo getDatosNuevoVehiculo();
		public void muestroStock(List<Stock> stockAMostrar,
				ArrayList<String> comboMarca, ArrayList<String> comboModelo,
				ArrayList<String> comboYear);
		public String getVehiculoTabla();
		public void mostrarDetalleVehiculo(Vehiculo vehiculo);
		public String getMarca();
		public String getYear();
		public void actualizoStock(List<Stock> stockAMostrar);
		public void copioVehiculo(Vehiculo vehiculo);
		public String vehiculoVenta();
	

		
		
		
}
