package vehiculo.ABM;

import java.sql.SQLException;
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


	public void onCreateVehiculo() throws DBException{

		
		Vehiculo v = vehiculo.getNuevoVehiculo();
		
		vehiculoDB.createVehiculo(v);
		
			
	}
	
	
	public void onAceptarNuevoVehiculo(){
		
//		
//		Venta v = ventas.getNuevaVenta();
//		// ventas.refreshVenta(); //Deberia Avisar que estuvo ok, y llevar a
//		// cargarcliente. Primero busca si no existe ya.
//		System.out.println(v.getDniComprador() + "-" + v.getDniGarante() + "-"
//				+ v.getDesc() + "-" + v.getPatente() + "-" + v.getIdVenta());
//
//		Persona p = ventasDB.getPersona(v.getDniComprador());
//
//		if (p == null) {
//			ventasDB.altaVenta(v);
//			ventas.altaCliente(v.getDniComprador());
//		} else {
//			System.out.println("Persona: " + p.getApellido());
//			ventas.mostrarCliente(p);
//		}
		
	}
	
	public void onBuscarPorPatente(){
		String patente = null;
		vehiculo.getVehiculoPorPatente(patente);
	}
	
	public void onVolver(){
		vehiculo.refresh();
	}
	
	
	
}
