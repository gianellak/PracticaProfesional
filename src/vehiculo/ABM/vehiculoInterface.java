package vehiculo.ABM;

import java.text.ParseException;

import objetos.Vehiculo;


public interface VehiculoInterface {

	void showVehiculo(VehiculoController vc);
	void showStock();
	void closeVehiculo();
	Vehiculo getNuevoVehiculo () throws NumberFormatException, ParseException;
	Vehiculo getVehiculoPorPatente(String patente);
	void refresh();
}
