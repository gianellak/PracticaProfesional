package moduloClientes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Persona;
import objetos.Usuario;
import utilitarios.Mensajes;
import utilitarios.PantallaUtil;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;

public class ClientesController {

	private ClientesInterface ci;
	private PrincipalController pc;
	private ClientesDB cDB;
	
	public ClientesController(ClientesView ci, PrincipalController pc) {
		this.ci = ci;
		this.pc = pc;
	}

	public void verClientes() throws DBException {
		
		System.out.println("Ver Usuarios - Controller");
		
		
		
		List<Usuario> lista= cDB.findAll();
		
		ci.onVer(lista);
		
	}

	private void conectar() {
		
		ConnectionProvider pro = new DBConnection();
		
		try {
			pro.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cDB = new ClientesDB(pro);
		
	}

	public void getBack() {
		
		pc.getBack();
		
		
	}
	
	public void cleanClientes(){
		
		ci.cleanPanelClientes();
		
	}

	public void showAlta() {
		
		ci.onAlta();
		
	}
	
	public void bajaPersona() throws DBException{
		
		int u = ci.getBajaPersona();
		
		
		Persona persona = cDB.findId(u);
		
		
		if(persona != null){
		
		int codigo = Mensajes.showToDelete(persona);
		
		 if (codigo==JOptionPane.YES_OPTION){
			 if(cDB.delete(u)){
					
					Mensajes.deleteOk(ci.getPanelClientes());
				}else
				{
					Mensajes.deleteBad();
				}
	        }else if(codigo==JOptionPane.NO_OPTION){
	            ci.verCliente(persona);
	        }
		
		}else{
			Mensajes.showNotFound();
		}
		

	}

	
	public void altaPersona() throws DBException {
		
		Persona persona = ci.getUpdatePersona();
		
		if(cDB.insert(persona)){
			
			Mensajes.insertOk(ci.getPanelClientes());
		}else
		{
			Mensajes.insertBad();
		}
		
	}


	public void showMod() {
		ci.onMod();
		
	}

	public void showClientes() {
		
		ci.showMenuClientes(this, pc.getView(), pc.getUser());
		
		this.conectar();
		
	}

	public void modPersona() {
		
		ci.verMod();
		
	}

	public void buscarCliente() throws DBException {
		
		int dni = ci.getModPersona();
		
		Persona p = cDB.findId(dni);
		
		if(p != null){
			
			ci.verCliente(p);
		}else
		{
			Mensajes.showNotFound();
		}
		
		
	}

	public void update() throws DBException {
		Persona cliente = ci.getUpdatePersona();
		
		if(cliente != null){
			
			int codigo = Mensajes.showToUpdate(cliente);
			
			 if (codigo==JOptionPane.YES_OPTION){
				 if(cDB.updatePersona(cliente)){
						
						Mensajes.updateOk(ci.getPanelClientes());
					}else
					{
						Mensajes.updateBad();
					}
		        }else if(codigo==JOptionPane.NO_OPTION){
		            ci.onMod();
		        }
			
			}
		
	}

	

}
