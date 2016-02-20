package moduloVehiculo;

import java.util.List;

import exceptions.DBException;
import objetos.Vehiculo;

public interface vehiculoInterfaceDB {
	
	Vehiculo getVehiculo(String patente);
	List<Vehiculo> getAllVehiculos() throws DBException;
	Boolean createVehiculo(Vehiculo vehiculo) throws DBException;
	Boolean updateVehiculo(Vehiculo vehiculo, Vehiculo newVehiculo);
	
}