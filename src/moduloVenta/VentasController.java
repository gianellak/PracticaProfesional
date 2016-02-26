package moduloVenta;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Persona;
import objetos.Usuario;
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
					if(codigo==JOptionPane.NO_OPTION){
					}
					
					
				}
			}
		}
	}

//Doy de alta en un cliente. Vengo de la pantalla de Venta -> Nueva Venta -> Validar Cliente -> Cliente no encontrado -> Alta
	public void altaClienteV() throws DBException {

		if(cDB.insert(vi.getPersonaAlta())){
			vi.insertOk();
			
		}else
		{
			vi.insertBad();
			
		}
		
	}

//Doy de alta en un Garante. Vengo de la pantalla de Venta -> Nueva Venta -> Validar Garante -> Garante no encontrado -> Alta
	public void altaGaranteV() throws DBException {
		
		if(cDB.insert(vi.getPersonaAlta())){
			System.out.println("insertGaranteOk");
			vi.insertGaranteOk();
			
		}else
		{
			vi.insertBad();
			
		}
		
	}
	
			
}
