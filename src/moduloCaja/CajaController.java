package moduloCaja;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import connections.*;
import objetos.*;
import utilitarios.Mensajes;
import utilitarios.StringMsj;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;

public class CajaController {

	private CajaInterface ci;
	private PrincipalController pc;
	private CajaDB cDB;

	public CajaController(CajaView ci, PrincipalController pc) {
		this.ci = ci;
		this.pc = pc;
	}

	

	public void verMovimientos() throws DBException {

		System.out.println("Ver Movimientos - Controller");

		
		String format = new String("dd/MM/yy");
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(d);
		System.out.println(stringDate);

		List<Movimiento> lista = cDB.findByDay(stringDate);
		
		if(lista.size() == 0){
			ci.primerMovimiento();
			ci.abroCaja();
		} else{
			
			ci.onVer(lista);
		}

		

	}

	private void conectar() {

		ConnectionProvider pro = new DBConnection();

		SchemaGenerator s = new SchemaGenerator(pro);
		

		try {
			pro.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			s.generateSchema();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		cDB = new CajaDB(pro);

	}

	public void getBack() {

		pc.getBack();
	}



	
	public void bajaMovimiento() throws DBException {

		int u = ci.getBajaMovimiento();

		Movimiento movimiento = cDB.findId(u);

		if (movimiento != null) {

			ci.showToDelete(movimiento);

			// PEGAR ESTO ADENTRO DEL IF yes option pane

			Movimiento mov = movimiento;
			mov.setMarca(false);

			cDB.update(movimiento.getId(), movimiento);
			cDB.insert(mov);

			// int codigo = ci.showToDelete(movimiento);
			//
			// if (codigo==JOptionPane.YES_OPTION){
			// if(cDB.delete(u)){
			//
			// ci.deleteOk();
			// }else
			// {
			// ci.deleteBad();
			// }
			// }else if(codigo==JOptionPane.NO_OPTION){
			// ci.onBaja();
			// }

		} else {
			ci.showNotFound();
		}
	}

	public void altaMovimiento() throws DBException {

		Movimiento movimiento = ci.getNuevoMovimiento();

		if (cDB.insert(movimiento)) {

			ci.insertOk();
			this.verMovimientos();
		} else {
			ci.insertError();
		}
	}

	public void showBaja() {
		ci.onBaja();
	}

//	public void showMod() {
//		ci.onMod();
//	}


	public void showCaja() {

		ci.showMenuCaja(this, pc.getView(), pc.getUser());
		this.conectar();
	}

	public void verOtrosMovimientos() {
		
		ci.verOtrosMovimientos();
		
		
	}



	public void veoFecha(Date fecha) {
		
		String format = new String("dd/MM/yy");
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(fecha);
		
		System.out.println(stringDate);

		List<Movimiento> lista = cDB.findByDay(stringDate);
		
		if(lista.size() == 0){
			
			Mensajes.mensajeInfo(StringMsj.MSG_CJA_NOT_MOV);
			
		} else{
			
			ci.onVerOtro(lista, stringDate);
		}
		
		
	}



	public void cleanCaja() {
		ci.cleanPanelCaja();
		
	}
	
	
	// LOG . NO TOCAR.
	
	
//	public class archivoLog () {
//	     FileWriter archivo //nuestro archivo log
//
//	     public void crearLog(String Operacion) {
//
//	        //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
//	        if (new File("log.txt").exists()==false){archivo=new FileWriter(new File("log.txt"),false);}
//	             archivo = new FileWriter(new File("log.txt"), true);
//	             Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar     
//	             //Empieza a escribir en el archivo
//	             archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
//	                  +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
//	                  +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
//	                  +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
//	                  +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
//	                  +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";"+operacion+"\r\n");
//	             archivo.close(); //Se cierra el archivo
//	     }//Fin del metodo crearLog
	    
	

}
