package moduloVenta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Persona;
import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;
import exceptions.DBException;
import moduloClientes.ClientesDB;
import moduloClientes.ClientesView;
import moduloPrincipal.PrincipalController;
import moduloVehiculos.VehiculosDB;
import moduloVehiculos.VehiculosView;

public class VentasController {

	private VentasInterface vi;
	private PrincipalController pc;
	private VentasDB vDB;
	private ClientesDB cDB;
	private VehiculosDB vhDB;
	private Persona cliente;
	private Persona garante;
	private Vehiculo vehiculo;
	private Boolean ventaOk = true;
	
	public VentasController(VentasInterface vi, PrincipalController pc) {
		this.vi = vi;
		this.pc = pc;
		
	}

	private void conectar() {
		
		ConnectionProvider pro = new DBConnection();
		
		try {
			pro.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vDB = new VentasDB(pro);
		cDB = new ClientesDB(pro);
		vhDB = new  VehiculosDB(pro);
		
	}

//Muestra el menu principal
	public void getBack() {
		
		pc.getBack();
		
		
	}
	
//	Viene de Menu Principal "Venta".
//	Muestra la pantalla Venta
	public void showVentas() {
		
		vi.showMenuVentas(this, pc.getView(), pc.getUser());
		
		this.conectar();
		
	}

	public void showNuevaVenta() {
		
		vi.showNuevaVenta();
		
	}

	public void validarCliente() throws DBException {

		int dni = vi.getDniBuscarC();
		 
		System.out.println(dni);
		
		if (dni == 0 ){
			
			vi.msjErrorDNI();
			
			ventaOk = false;
			
		} else{
			
			cliente = cDB.findId(dni);
			
			if(cliente != null){
				
				vi.mostrarCliente(cliente);
				
				
				
			}else{
			
				int codigo = vi.msjClienteNotFound();
				
				if (codigo ==JOptionPane.YES_OPTION){
					
					vi.altaCliente();
					
				}
				else{
					if(codigo==JOptionPane.NO_OPTION){
						ventaOk = false;
				}
			        
				
				}
			}
		}
	}

	public void validarGarante() throws DBException {
		
		int dni = vi.getDniBuscarG();
		
		System.out.println(dni);
		
		if (dni == 0 ){
			
			vi.msjErrorDNI();
			ventaOk = false;
			
		} else{
			
			garante = cDB.findId(dni);
			
			if(garante != null){
				
				vi.mostrarGarante(garante);

			}else{
				
				int codigo = vi.msjClienteNotFound();
				
				if (codigo ==JOptionPane.YES_OPTION){
					
					vi.altaGarante();
					
				}
				else{
					if(codigo==JOptionPane.CANCEL_OPTION){
						ventaOk = false;
					}
					
					
				}
			}
		}
	}

//Doy de alta en un cliente. Vengo de la pantalla de Venta -> Nueva Venta -> Validar Cliente -> Cliente no encontrado -> Alta
	public void altaClienteV() throws DBException {
		
		Persona p = vi.getPersonaAlta();

		if(cDB.insert(p)){
			
			vi.insertOk();
			
			ventaOk = true;
			
			vi.mostrarCliente(p);
			
		}else
		{
			ventaOk = false;
			vi.insertBad();
			
		}
		
	}

//Doy de alta en un Garante. Vengo de la pantalla de Venta -> Nueva Venta -> Validar Garante -> Garante no encontrado -> Alta
	public void altaGaranteV() throws DBException {
		
		Persona p = vi.getPersonaAlta();
		
		if(cDB.insert(p)){
			
			vi.insertGaranteOk();
			ventaOk = true;
			vi.mostrarGarante(p);
			
		}else
		{
			vi.insertBad();
			
			ventaOk = false;
			
		}
		
	}

	public void buscarVehiculo() throws DBException {
		
		String p = vi.getPatenteBuscar().toUpperCase();
		
		System.out.println("patente ingresada: " + p);
		
		
		if(p.isEmpty()){
			
			System.out.println("patente nula");
			
			int codigo = vi.msjSinPatente();
			
			if (codigo ==JOptionPane.YES_OPTION){
				
				List<Vehiculo> lista = vhDB.getAllVehiculos();
				
				muestroStock(lista);
				
				
				

			}
			else{
				if(codigo==JOptionPane.NO_OPTION){
					ventaOk = false;
			}
			
			}
				
		}else{

			vehiculo = vhDB.getVehiculo(p);
			
			
			if (vehiculo != null){
				
				vi.mostrarPatente(vehiculo);
				
				ventaOk = true;
				
			} else{
				
				int codigo = vi.msjSinPatente();
				
				if (codigo ==JOptionPane.YES_OPTION){

					List<Vehiculo> lista = vhDB.getAllVehiculos();
					
					muestroStock(lista);
					
				}
				else{
					if(codigo==JOptionPane.NO_OPTION){
						
						ventaOk = false;
					}
				
				}

				
			}
			
		}
		

		
	}

	
//Muestro el stock actual. 
	
	private void muestroStock(List<Vehiculo> lista) throws DBException {
		
		
		List<Stock> stockAMostrar = new ArrayList<Stock>();

		for (int i = 0; i < lista.size(); i++) {

			if (! ( (lista.get(i).getCondicion() == "Vendido") || (lista.get(i).getCondicion() == "No disponible"))) {

				Stock s = new Stock();
				
				String patenteActual = lista.get(i).getPatente();

				if (patenteActual == "000000"){
					s.setPatente(lista.get(i).getMotor());
				}
				
				s.setPatente(patenteActual);
				s.setMarca(lista.get(i).getMarca());
				s.setModelo(lista.get(i).getModelo());
				s.setYear(lista.get(i).getYear());
				s.setPvc(lista.get(i).getPvc());

				stockAMostrar.add(s);
			}
		}

		List<String> comboMarca = vhDB.getComboMarca();
		List<String> comboModelo = vhDB.getComboModelo();
		List<String> comboYear = vhDB.getComboYear();
		
		vi.muestroStock(stockAMostrar, comboMarca, comboModelo, comboYear);
		
	}

	public void cleanVentas() {
		System.out.println("clean");
		vi.cleanPanelVentas();
		
	}

	public void validarVenta() {
		
		Boolean botones = vi.getButtonState();
		
		if(ventaOk == true && cliente != null && vehiculo != null && garante != null && botones == true){
			System.out.println("Venta Ok");
		}else{
			vi.msjVentaIncompleta();
		}
		
	}

	public void seleccionaVehiculo() {
		
		String p = vi.getVehiculoTabla();
		
		vehiculo =vhDB.getVehiculo(p);
		
		ventaOk = true; 
		
		vi.mostrarPatente(vehiculo);
		
		
	}

	public void cleanStock() {
		vi.cleanStock();
		
	}

	public void mostrarDetalle() {
		
		String p = vi.getVehiculoTabla();
		
		vehiculo =vhDB.getVehiculo(p);
		
		vi.mostrarDetalleVehiculo(vehiculo);
		
	}

	public void filtrarModelo() {
		
		System.out.println("FILTRO");
		
	}

	
			
}
