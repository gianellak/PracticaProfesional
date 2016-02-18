package moduloVehiculo;

import java.text.ParseException;
import objetos.Vehiculo;


public interface vehiculoInterface {

	void showVehiculo(vehiculoController vc);
	void showStock();
	void closeVehiculo();

	Vehiculo getNuevoVehiculo () throws NumberFormatException, ParseException;

	Vehiculo getVehiculoPorPatente(String patente);
	void refresh();
}
