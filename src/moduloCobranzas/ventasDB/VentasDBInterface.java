package moduloCobranzas.ventasDB;

import java.sql.Array;
import java.util.List;

import exceptions.DBException;
import objetos.Persona;
import objetos.Vehiculo;
import objetos.Venta;

public interface VentasDBInterface {

	List<Venta> traerVentas(int i) throws DBException;

	Persona getPersona(int dni) throws DBException;

	Vehiculo getVehiculo(String patente) throws DBException;
	


	void altaPersona(Persona p) throws DBException;


	void altaVenta(Venta v) throws DBException;



}
