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
			int i = cDB.countAll(stringDate);
			ci.onVer(i, lista);
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



	
	public void bajaMovimiento(Movimiento mov) throws DBException {

		
		
		int codigo = Mensajes.msjOkCancel(StringMsj.MSG_DEL_MOV, "Eliminar");
		
		if (codigo ==JOptionPane.YES_OPTION){
			
			
			mov.setMarca(false);
			mov.setDescripcion("Movimiento eliminado por Usuario: " + pc.getUser().getUsername());

			if(cDB.delete(mov)){
				Mensajes.mensajeInfo(StringMsj.MSG_DEL_MOV_OK);
				
				verMovimientos();
				
			}else{
				Mensajes.mensajeInfo(StringMsj.MSG_DEL_MOV_BAD);
				
			}
		}
		

	}

	public void altaMovimiento() throws DBException {

		Movimiento movimiento = ci.getNuevoMovimiento();

		if (cDB.insert(movimiento)) {

			ci.insertOk();
			verMovimientos();
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
			
			Mensajes.mensajeInfo(StringMsj.MSG_CJA_NOT_MOV);
			
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

		
			List<Movimiento> listaMov = cDB.findAllByDay(globalSelectedDate);
			
			if(listaMov.size() == 0){
				
				Mensajes.mensajeInfo(StringMsj.MSG_CJA_NOT_MOV);
				wr.write("No hay movimientos registrados.");
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

	public void eliminarMov() throws NumberFormatException, DBException {


		String idMov = ci.getMovimientoTabla();
		
		Movimiento m  = cDB.findId(Integer.valueOf(idMov));
		
		System.out.println(m.getDescripcion());
		bajaMovimiento(m);
		
	}

	public void modMovimiento() throws NumberFormatException, DBException {

		String idMov = ci.getMovimientoTabla();
		
		Movimiento m  = cDB.findId(Integer.valueOf(idMov));
		
		System.out.println(m.getDescripcion());
		
		
	}
}
