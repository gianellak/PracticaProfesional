package moduloCaja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connections.*;
import objetos.*;
import utilitarios.Mensajes;
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
	
	public static String globalSelectedDate  ="";
    public static String globalPath = "C:\\Tias\\";

	
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
		
		List<Movimiento> listaMov = cDB.findByDay(stringDate);
		globalSelectedDate = stringDate;
		
		if(listaMov.size() == 0){
			
			Mensajes.mensajeInfo("No hay movimientos registrados para el día seleccionado. Intente con otra fecha.");
		} else{
			
			ci.onVerOtro(listaMov, stringDate);		
		}
	}
	
	
	
	public void cleanCaja() {
		ci.cleanPanelCaja();
		
	}

	
	public void generarArchivoLog(){
	
		Date fechaActual = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	    DateFormat formatoHora = new SimpleDateFormat("HH.mm.ss");	    
	 
	    String nameOfFile = "log_"+formatoFecha.format(fechaActual)+"_"+formatoHora.format(fechaActual)+".txt";
	    
	    File f = new File(globalPath+nameOfFile);
		
	    try {
			FileWriter w;
			w = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(w);
					
			PrintWriter wr = new PrintWriter(bw);  
			
		//	wr.write("Hola");
		
			List<Movimiento> listaMov = cDB.findByDay(globalSelectedDate);
			
			if(listaMov.size() == 0){
				
				Mensajes.mensajeInfo("No hay movimientos registrados para el día seleccionado. Intente con otra fecha.");
				wr.write("No hay movimientos registrados");
			} else{
				
				int i = 0;

				for (Movimiento m : listaMov) {
					i++;	
					String linea = "";
					linea = linea + i+","+ m.getDescripcion()+","+m.getIngreso()+","+m.getEgreso()+","+
					m.getFecha()+","+m.getUsuario();
					wr.println(linea);
				}
			}

			
			wr.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
