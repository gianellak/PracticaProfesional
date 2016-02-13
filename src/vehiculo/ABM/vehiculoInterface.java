package vehiculo.ABM;

import java.util.List;

import exceptions.DBException;
import objetos.Vehiculo;

public interface vehiculoInterface {
	
	Vehiculo getVehiculo(int patente);
	List<Vehiculo> getStock() throws DBException;

}
