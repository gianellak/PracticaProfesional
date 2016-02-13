package vehiculo.ABM;

import java.util.List;

import exceptions.DBException;
import objetos.Vehiculo;

public interface vehiculoInterface {
	
	Vehiculo getVehiculo(String patente);
	List<Vehiculo> getStock() throws DBException;
	Boolean createVehiculo(Vehiculo vehiculo) throws DBException;

}
