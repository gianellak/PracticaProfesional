package vehiculo.ABM;

import java.sql.SQLException;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import objetos.Vehiculo;


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

	public void onCreateVehiculo() throws DBException{
		Vehiculo v = vehiculo.getNuevoVehiculo();
		vehiculoDB.createVehiculo(v);
	}
	
	public void onBuscarPorPatente(){
		String patente = null;
		vehiculo.getVehiculoPorPatente(patente);
	}
	
	
}
