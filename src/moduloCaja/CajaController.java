package moduloCaja;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import connections.SchemaGenerator;
import objetos.Movimiento;
import objetos.Persona;
import objetos.Usuario;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioView;

public class CajaController {

	private CajaInterface ci;
	private PrincipalController pc;
	private CajaDB cDB;
	
	public CajaController(CajaView ci, PrincipalController pc) {
		this.ci = ci;
		this.pc = pc;
	}

	public void dispose() {
		ci.dispose();
		
	}

	public void verMovimientos() throws DBException {
		
		System.out.println("Ver Usuarios - Controller");
		
		
		
		List<Usuario> lista= cDB.findAll();
		
		ci.onVer(lista);
		
	}

	private void conectar() {
		
		ConnectionProvider pro = new DBConnection();
		
//		SchemaGenerator s = new SchemaGenerator(pro);
//		
//		try {
//			s.generateSchema();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try {
			pro.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cDB = new CajaDB(pro);
		
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
		
		int codigo = ci.showToDelete(persona);
		 if (codigo==JOptionPane.YES_OPTION){
			 if(cDB.delete(u)){
					
					ci.deleteOk();
				}else
				{
					ci.deleteBad();
				}
	        }else if(codigo==JOptionPane.NO_OPTION){
	            ci.onBaja();
	        }
		
		}else{
			ci.showNotFound();
		}
		

	}

	
	public void altaPersona() throws DBException {
		
		Movimiento movimiento = ci.getNuevoMovimiento();
		
		if(cDB.insert(movimiento)){
			
			ci.insertOk();
		}else
		{
			ci.insertBad();
		}
		
		
		
	}

	public void showBaja() {

		ci.onBaja();
		
	}

	public void showMod() {
		ci.onMod();
		
	}

	

	public void modPersona() {
		// TODO Auto-generated method stub
		
	}

	public void showCaja() {
		
		ci.showMenuCaja(this, pc.getView(), pc.getUser());
		
		this.conectar();
		
		
	}

}
