package moduloCobranzas.ventas;

import java.sql.SQLException;
import java.util.List;

import connections.ConnectionProvider;
import exceptions.DBException;
import moduloCobranzas.ventasDB.VentasDB;
import moduloCobranzas.ventasDB.VentasDBInterface;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalInterface;
import objetos.Persona;
import objetos.Usuario;
import objetos.Vehiculo;
import objetos.Venta;

public class VentasController {
	
	private VentasInterface ventas;
	private VentasDBInterface ventasDB;
	private PrincipalController pc;

	public VentasController(VentasInterface vi, PrincipalController pc) {
		super();
		this.ventas = vi;
		this.pc = pc;
		
	}
	
	


	public void showVenta() throws SQLException {
		
		ventasDB = new VentasDB(pc.getConn());
		
		ventas.showVenta(this);
		
		
	}


	public void onCancel() {
		ventas.closeVentas();
	}


	public void buscarVenta() throws DBException {
		if (ventas.getDNI() != 0){
			System.out.println("Ingreso DNI" + ventas.getDNI());
			List<Venta> lista = ventasDB.traerVentas(ventas.getDNI());
			//System.out.println(lista.get(0));
			//ventas.mostrarCompras(lista);
			mostrarUnaVenta(lista.get(0));
			
		}else{
			System.out.println("Ingreso Patente");
			String String = ventas.getPatente();
		}
		
	}
	
	public void mostrarUnaVenta(Venta venta) throws DBException {
		
		Persona cliente = ventasDB.getPersona(venta.getDniComprador());
		System.out.println("Cliente devuelto: " + cliente.getNombre());
		
		Vehiculo vehiculo = ventasDB.getVehiculo(venta.getPatente());
		System.out.println("Vehiculo devuelto: " + vehiculo.getPatente());
		
		Persona garante = ventasDB.getPersona(venta.getDniGarante());
		System.out.println("Garante devuelto: " + garante.getNombre());
		
		
	}

	public void onNueva() {
		ventas.mostrarAltA();		
	}

	public void onVolver() {
		ventas.refreshVenta();	
	}




	public void onAlta() throws DBException {
	
		Venta v = ventas.getNuevaVenta();
	//	ventas.refreshVenta(); //Deberia Avisar que estuvo ok, y llevar a cargarcliente. Primero busca si no existe ya.
		System.out.println(v.getDniComprador() +"-"+ v.getDniGarante()  +"-"+ v.getDesc()  +"-"+ v.getPatente()  +"-"+ v.getIdVenta());
		
		Persona p = ventasDB.getPersona(v.getDniComprador());
		
		if(p == null){
			ventas.altaCliente(v.getDniComprador());
		}
		else{
			System.out.println("Persona: " + p.getApellido() );
			ventas.mostrarCliente(p);
		}
	
		
	}




	public void onInsertar() throws DBException {

		Persona p = ventas.getNuevaPersona();
		ventasDB.altaPersona(p);
		
	}


}
