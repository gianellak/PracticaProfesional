package vehiculo.ABM;

import java.sql.SQLException;
import java.text.ParseException;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import objetos.Persona;
import objetos.Vehiculo;
import objetos.Venta;


public class VehiculoController {

	private VehiculoInterface vehiculo;
	private VehiculoInterfaceDB vehiculoDB;
	private PrincipalController pc;

	public VehiculoController(VehiculoInterface vehiculo, PrincipalController pc) {
		super();
		this.vehiculo = vehiculo;
		this.pc = pc;

	}
	
	public void showStock (){
		vehiculoDB = new VehiculoDB(pc.getConn());
		vehiculo.showVehiculo(this);
	}

	public void onCancel() {
		vehiculo.closeVehiculo();
	}

	public void onCreateVehiculo() throws DBException, NumberFormatException, ParseException{
		
		Vehiculo v = vehiculo.getNuevoVehiculo();
		
		vehiculoDB.createVehiculo(v);			
	}
	
	
	public void onAceptarNuevoVehiculo(){
			
	}
	
	public void onBuscarPorPatente(){
		String patente = null;
		vehiculo.getVehiculoPorPatente(patente);
	}
	
	public void onVolver(){
		vehiculo.refresh();
	}
	
	
	
}
