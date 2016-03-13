package moduloClientes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Persona;
import objetos.Usuario;
import utilitarios.*;
import exceptions.DBException;
import exceptions.LexicalException;
import moduloPrincipal.PrincipalController;
import moduloVenta.VentasController;
import moduloVenta.VentasView;

public class ClientesController {

	
	
	private ClientesInterface ci;
	private PrincipalController pc;
	private ClientesDB cDB;
	private VentasView vi;
	
	public ClientesController(ClientesView ci, PrincipalController pc) {
		this.ci = ci;
		this.pc = pc;
	}

	public void verClientes() throws DBException {
		
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
		
		try {
			ci.onAlta(0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void bajaPersona() throws DBException{
		
		int u = ci.getBajaPersona();
		
		
		Persona persona = cDB.findId(u);
		
		
		if(persona != null){
		
		int codigo = Mensajes.showToDelete(persona);
		
		 if (codigo==JOptionPane.YES_OPTION){
			 if(cDB.delete(u)){
					
					Mensajes.mensajeInfo(StringMsj.MSG_CLI_DEL_OK);
					PantallaUtil.remove(ci.getPanelClientes());
					
				}else
				{
					Mensajes.mensajeWarning(StringMsj.MSG_CLI_DEL_BAD);
				}
	        }
		
		}else{
			Mensajes.mensajeInfo(StringMsj.MSG_CLI_NOT_FOUND);
		}
		

	}

	
	public void altaPersona() throws DBException{
		
		Persona persona = ci.getUpdatePersona();
		
		try {
			if(persona.getDni() != 0 && 
							Sintaxis.analizoDNI(String.valueOf(persona.getDni())) &&
							Sintaxis.analizoTexto(persona.getNombre()) &&
							Sintaxis.analizoTexto(persona.getApellido()) &&
							Sintaxis.analizoTelefono(persona.getTelefonoP())
									){
					
						if(cDB.insert(persona)){
						
							Mensajes.mensajeInfo(StringMsj.MSG_CLI_INS_OK);;			
							PantallaUtil.remove(ci.getPanelClientes());
					
						}else{
							Mensajes.mensajeWarning(StringMsj.MSG_CLI_INS_BAD);
							}
					}else{
						Mensajes.mensajeInfo(StringMsj.MSG_NOT_OBLI);
					}
		} catch (LexicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		try {
			if(Sintaxis.analizoDNI(String.valueOf(dni)))
			{
				Persona p = cDB.findId(dni);
				
				if(p != null){
					
					ci.verCliente(p);
					
				}else{
				
					int codigo = Mensajes.msjOkCancel(StringMsj.MSG_NEW_CLIENT, "Not Found");
					
					if (codigo ==JOptionPane.YES_OPTION){
						
						ci.onAlta(dni);
						
					}
				}
			}else{
				Mensajes.mensajeInfo(StringMsj.MSG_DNI_NOT_VALID);
			}
		} catch (LexicalException | ParseException e) {
			e.printStackTrace();
		}
	}

	
	public void update() throws DBException {
		
		Persona persona = ci.getUpdatePersona();
		
		
			try {
				if(persona.getDni() != 0 && 
					Sintaxis.analizoDNI(String.valueOf(persona.getDni())) &&
					Sintaxis.analizoTexto(persona.getNombre()) &&
					Sintaxis.analizoTexto(persona.getApellido()) &&
					Sintaxis.analizoTelefono(persona.getTelefonoP())){
					
						int codigo = Mensajes.showToUpdate(persona);
				
						if (codigo==JOptionPane.YES_OPTION){
							if(cDB.updatePersona(persona)){
							
								Mensajes.mensajeInfo(StringMsj.MSG_CLI_MOD_OK);;
								PantallaUtil.remove(ci.getPanelClientes());
							}else{
								Mensajes.mensajeWarning(StringMsj.MSG_CLI_MOD_BAD);
							}
						}
				}else{
					Mensajes.mensajeInfo(StringMsj.MSG_NOT_OBLI);
				}
			} catch (LexicalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void nuevaVenta() {		

		vi = new VentasView();
		
		VentasController vc = new VentasController(vi, pc);
		
		String dni = ci.clienteVenta();
		
		vc.ventaDesdeCliente(dni);
		
		
	}

	

}
