package moduloVehiculo;

import java.text.ParseException;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import objetos.Vehiculo;


public class vehiculoController {

	private vehiculoInterface vehiculo;
	private vehiculoInterfaceDB vehiculoDB;
	private PrincipalController pc;

	public vehiculoController(vehiculoInterface vehiculo, PrincipalController pc) {
		super();
		this.vehiculo = vehiculo;
		this.pc = pc;

	}
	
	public void onMenuVehiculo (){
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
