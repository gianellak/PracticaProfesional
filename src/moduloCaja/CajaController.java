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
import utilitarios.Sintaxis;
import utilitarios.StringMsj;
import exceptions.DBException;
import exceptions.LexicalException;
import moduloPrincipal.PrincipalController;

public class CajaController {
	

	private CajaInterface ci;
	private PrincipalController pc;
	private CajaDB cDB;
	private Movimiento mov;

	public CajaController(CajaView ci, PrincipalController pc) {
		this.ci = ci;
		this.pc = pc;
	}

	public static String globalSelectedDate = "";
	public static String globalPath = "C:\\Tias\\";

	
	public void verMovimientos() throws DBException{

		System.out.println("verMovimientos - Controller");

		String format = new String("dd/MM/yy");
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(d);

		List<Movimiento> lista = cDB.findByDay(stringDate);

		if (lista.size() == 0) {

			Mensajes.mensajeInfo(StringMsj.MSG_FIRST_MOV);
			ci.abroCaja();

		} else {
			int i = cDB.countAll(stringDate);
			
			int size = lista.size();
			
			for(int a = 0; a < size; a++){
				try {
					if(Sintaxis.analizoCierre(lista.get(a).getDescripcion())){
						System.out.println("es cierre");
						String s = lista.get(a).getDescripcion();
						s = s.replace("XXX - ", "");
						
						lista.get(a).setDescripcion(s);
						
						ci.onVerCierre(i, lista);
					}else{
						ci.onVer(i, lista);
					}
				} catch (LexicalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
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
		
		System.out.println("bajaMovimiento - Controller");

		int codigo = Mensajes.msjOkCancel(StringMsj.MSG_DEL_MOV, "Eliminar");

		if (codigo == JOptionPane.YES_OPTION) {

			mov.setMarca(false);
			mov.setDescripcion("Movimiento eliminado por Usuario: "
					+ pc.getUser().getUsername());

			if (cDB.delete(mov)) {
				Mensajes.mensajeInfo(StringMsj.MSG_DEL_MOV_OK);

				verMovimientos();

			} else {
				Mensajes.mensajeWarning(StringMsj.MSG_DEL_MOV_BAD);

			}
		}

	}

	public void movimientoModificado() throws DBException {
		
		System.out.println("movimientoModificado - Controller");

		Movimiento m = ci.getNuevoMovimiento();

		int codigo = Mensajes.msjOkCancel(StringMsj.MSG_MOD_MOV, "Modificar");

		if (codigo == JOptionPane.YES_OPTION) {

			mov.setMarca(false);

			if (cDB.insert(m)) {
				Mensajes.mensajeInfo(StringMsj.MSG_MOD_MOV_OK);

				if (cDB.update(mov)) {
					verMovimientos();
				}
			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_MOD_MOV_BAD);
				verMovimientos();
			}
		} else {
			if (codigo == JOptionPane.CANCEL_OPTION) {
				verMovimientos();

			}
		}

	}

	public void altaMovimiento() throws DBException {
		
		System.out.println("altaMovimiento - Controller");

		Movimiento movimiento = ci.getNuevoMovimiento();

		if (cDB.insert(movimiento)) {

			Mensajes.mensajeInfo(StringMsj.MSG_MOV_INS_OK);
			verMovimientos();

		} else {
			Mensajes.mensajeInfo(StringMsj.MSG_MOV_INS_BAD);

		}
	}

	
	public void aceptoCierre() throws DBException {
		
		System.out.println("aceptoCierre - Controller");

		int codigo = Mensajes.msjOkCancel(StringMsj.MSG_MOV_CLO, "Confirmar");

		if (codigo == JOptionPane.YES_OPTION) {

			Movimiento movimiento = ci.getNuevoMovimiento();
			
			String s = "XXX - " + movimiento.getDescripcion();
			movimiento.setDescripcion(s);

			if (cDB.insert(movimiento)) {

				Mensajes.mensajeInfo(StringMsj.MSG_MOV_INS_OK);
				verMovimientos();

			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_MOV_INS_BAD);

			}
		}
	}

	public void showCaja() {
		
		System.out.println("showCaja - Controller");

		ci.showMenuCaja(this, pc.getView(), pc.getUser());
		this.conectar();
	}

	public void verOtrosMovimientos() {
		
		System.out.println("verOtrosMovimientos - Controller");

		ci.verOtrosMovimientos();
	}

	public void veoFecha(Date fecha) {
		
		System.out.println("VeoFecha - Controller");

		String format = new String("dd/MM/yy");
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(fecha);

		System.out.println(stringDate);

		List<Movimiento> listaMov = cDB.findByDay(stringDate);

		globalSelectedDate = stringDate;

		if (listaMov.size() == 0) {
			Mensajes.mensajeInfo(StringMsj.MSG_CJA_NOT_MOV);
		} else {
			System.out.println("date: " + stringDate);
			ci.onVerOtro(listaMov, stringDate);
		}

	}

	public void cleanCaja() {
		System.out.println("cleanCaja -COntroller");
		ci.cleanPanelCaja();

	}

	public void generarArchivoLog() {

		System.out.println("generarArchivo - Controller");
		Date fechaActual = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat formatoHora = new SimpleDateFormat("HH.mm.ss");

		String nameOfFile = "log_" + formatoFecha.format(fechaActual) + "_"
				+ formatoHora.format(fechaActual) + ".txt";

		File f = new File(globalPath + nameOfFile);

		try {
			FileWriter w;
			w = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(w);

			PrintWriter wr = new PrintWriter(bw);

			// wr.write("Hola");

			System.out.println("Date: " + globalSelectedDate);
			if (globalSelectedDate.isEmpty()) {
				Mensajes.mensajeInfo(StringMsj.MSG_CJA_NOT_SEL);
			} else {

				List<Movimiento> listaMov = cDB
						.findAllByDay(globalSelectedDate);

				if (listaMov.size() == 0) {

					Mensajes.mensajeInfo(StringMsj.MSG_CJA_NOT_MOV);
					wr.write("No hay movimientos registrados.");
				} else {

					int i = 0;

					for (Movimiento m : listaMov) {
						i++;
						String linea = "";
						linea = linea + i + "," + m.getDescripcion() + ","
								+ m.getIngreso() + "," + m.getEgreso() + ","
								+ m.getFecha() + "," + m.getUsuario();
						wr.println(linea);
					}
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

		System.out.println("eliminarMovimiento - Controller");
		String idMov = ci.getMovimientoTabla();

		Movimiento m = cDB.findId(Integer.valueOf(idMov));

		System.out.println(m.getDescripcion());

		bajaMovimiento(m);

	}

	public void modMovimiento() throws NumberFormatException, DBException {
		
		System.out.println("modMovimiento - Controller");

		String idMov = ci.getMovimientoTabla();

		mov = cDB.findId(Integer.valueOf(idMov));

		if (String.valueOf(mov.getId()).matches("[1][0-9]{6}")) {
			Mensajes.mensajeInfo(StringMsj.MSG_MOV_NOT_MOD);
		} else {
			ci.mostrarMovimientoMod(mov);
		}

	}

	public void cerrarCaja() {
		
		System.out.println("cerrarCaja - Controller");
		
		String format = new String("dd/MM/yy");

		Date fecha = new Date();

		SimpleDateFormat df = new SimpleDateFormat(format);

		String stringDate = df.format(fecha);

		int i = cDB.countAll(stringDate);

		ci.cierroCaja(i);

	}
	


	public void mostrarCuota(Cuota c) throws DBException {
		
		showCaja();
		
		String format = new String("dd/MM/yy");
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(d);
		
		List<Movimiento> lista = cDB.findByDay(stringDate);

		int i = cDB.countAll(stringDate);
		
		int size = lista.size();
		
		for(int a = 0; a < size; a++){
			try {
				if(Sintaxis.analizoCierre(lista.get(a).getDescripcion())){
					Mensajes.mensajeWarning(StringMsj.MSG_CUOTA_CLOSE);
				}else{
				
					ci.verCuota(i, lista, c);
				}
			} catch (LexicalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	public void altaMovimientoCuota() throws DBException {
	
		Movimiento movimiento = ci.getNuevoMovimiento();
		
		Cuota c = ci.getNuevaCuota();
		
		if(c.getAdelanto() > 0 ){
			
			
			String[] cuota = c.getCuota().split("-");

			String c1 = String.valueOf(cuota[0]) + "-" + String.valueOf(Integer.valueOf(cuota[2])+1);
			
			cDB.getSiguiente(c1);
			
			//grabo siguiente
		}
		
		//RegraboCuota actual

		if (cDB.insert(movimiento)) {

			Mensajes.mensajeInfo(StringMsj.MSG_MOV_INS_OK);
			verMovimientos();

		} else {
			Mensajes.mensajeInfo(StringMsj.MSG_MOV_INS_BAD);

		}
		
	}
}
