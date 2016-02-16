package vehiculo.ABM;

import objetos.Vehiculo;


public interface VehiculoInterface {

	void showVehiculo(VehiculoController vc);
	void closeVehiculo();
	Vehiculo getNuevoVehiculo ();
	Vehiculo getVehiculoPorPatente(String patente);

}
