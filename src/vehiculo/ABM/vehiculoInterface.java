package vehiculo.ABM;

import objetos.Vehiculo;


public interface VehiculoInterface {

	void showVehiculo(VehiculoController vc);
	void showStock();
	void closeVehiculo();
	Vehiculo getNuevoVehiculo ();
	Vehiculo getVehiculoPorPatente(String patente);
	void refresh();
}
