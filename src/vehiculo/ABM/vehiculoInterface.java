package vehiculo.ABM;

<<<<<<< HEAD
import java.text.ParseException;

import objetos.Vehiculo;

=======
import objetos.Vehiculo;

>>>>>>> 55ca4cd6e85cf554b762872c4c39690ddd529990

public interface VehiculoInterface {

	void showVehiculo(VehiculoController vc);
	void showStock();
	void closeVehiculo();
<<<<<<< HEAD
	Vehiculo getNuevoVehiculo () throws NumberFormatException, ParseException;
=======
	Vehiculo getNuevoVehiculo ();
>>>>>>> 55ca4cd6e85cf554b762872c4c39690ddd529990
	Vehiculo getVehiculoPorPatente(String patente);
	void refresh();
}
