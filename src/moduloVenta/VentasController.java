package moduloVenta;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import connections.*;
import objetos.*;
import utilitarios.*;
import exceptions.DBException;
import exceptions.LexicalException;
import moduloClientes.*;
import moduloPrincipal.PrincipalController;
import moduloVehiculos.*;

public class VentasController {

	private VentasInterface vi;
	private PrincipalController pc;
	private VentasDB vDB;
	private ClientesDB cDB;
	private VehiculosDB vhDB;
	private Persona cliente;
	private Persona garante;
	private Vehiculo vehiculo;

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

		SchemaGenerator s = new SchemaGenerator(pro);

		try {
			s.generateSchemaVenta();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		vDB = new VentasDB(pro);
		cDB = new ClientesDB(pro);
		vhDB = new VehiculosDB(pro);

	}

	// Muestra el menu principal
	public void getBack() {

		pc.getBack();

	}

	// Viene de Menu Principal "Venta".
	// Muestra la pantalla Venta
	public void showVentas() {

		vi.showMenuVentas(this, pc.getView(), pc.getUser());

		this.conectar();

		System.out.println(vDB.countAll());

	}

	public void showNuevaVenta() {

		vi.showNuevaVenta();

	}

	public void validarCliente() throws DBException {

		int dni = vi.getDniBuscarC();

		try {
			if (Sintaxis.analizoDNI(String.valueOf(dni))) {
				Persona p = cDB.findId(dni);

				if (p != null) {

					vi.mostrarCliente(p);
					cliente = p;

				} else {

					int codigo = Mensajes.msjOkCancel(StringMsj.MSG_NEW_CLIENT,
							"Not Found");

					if (codigo == JOptionPane.YES_OPTION) {

						vi.altaCliente(dni);

					}
				}
			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_DNI_NOT_VALID);
			}
		} catch (LexicalException e) {
			e.printStackTrace();
		}

	}

	public void validarGarante() throws DBException, NumberFormatException,
			ParseException {

		int dni = vi.getDniBuscarG();

		try {
			if (Sintaxis.analizoDNI(String.valueOf(dni))) {
				Persona p = cDB.findId(dni);

				if (p != null) {

					vi.mostrarGarante(p);
					garante = p;

				} else {

					int codigo = Mensajes.msjOkCancel(StringMsj.MSG_NEW_CLIENT,
							"Not Found");

					if (codigo == JOptionPane.YES_OPTION) {

						vi.altaGarante(dni);

					}
				}
			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_DNI_NOT_VALID);
			}
		} catch (LexicalException e) {
			e.printStackTrace();
		}
	}

	// Doy de alta en un cliente. Vengo de la pantalla de Venta -> Nueva Venta
	// -> Validar Cliente -> Cliente no encontrado -> Alta
	public void altaClienteV() throws DBException {

		Persona persona = vi.getPersonaAlta();

		try {
			if (persona.getDni() != 0
					&& Sintaxis.analizoDNI(String.valueOf(persona.getDni()))
					&& Sintaxis.analizoTexto(persona.getNombre())
					&& Sintaxis.analizoTexto(persona.getApellido())
					&& Sintaxis.analizoTelefono(persona.getTelefonoP())) {

				if (cDB.insert(persona)) {

					Mensajes.mensajeInfo(StringMsj.MSG_CLI_INS_OK);

					vi.mostrarCliente(persona);
					cliente = persona;

				} else {
					Mensajes.mensajeWarning(StringMsj.MSG_CLI_INS_BAD);
				}
			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_CLI_NOT_OBLI);
			}
		} catch (LexicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Doy de alta en un Garante. Vengo de la pantalla de Venta -> Nueva Venta
	// -> Validar Garante -> Garante no encontrado -> Alta
	public void altaGaranteV() throws DBException {

		Persona persona = vi.getPersonaAlta();

		try {
			if (persona.getDni() != 0
					&& Sintaxis.analizoDNI(String.valueOf(persona.getDni()))
					&& Sintaxis.analizoTexto(persona.getNombre())
					&& Sintaxis.analizoTexto(persona.getApellido())
					&& Sintaxis.analizoTelefono(persona.getTelefonoP())) {

				if (cDB.insert(persona)) {

					Mensajes.mensajeInfo(StringMsj.MSG_GTE_INS_OK);
					garante = persona;
					vi.mostrarGarante(persona);

				} else {
					Mensajes.mensajeWarning(StringMsj.MSG_GTE_INS_BAD);
				}
			} else {
				Mensajes.mensajeInfo(StringMsj.MSG_CLI_NOT_OBLI);
			}
		} catch (LexicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buscarVehiculo() throws DBException {

		String p = vi.getPatenteBuscar().toUpperCase();
		
		System.out.println("patente ingresada: " + p);

		if (p.isEmpty()) {

			System.out.println("patente nula");
			int codigo = vi.msjSinPatente();

			if (codigo == JOptionPane.YES_OPTION) {

				List<Vehiculo> lista = vhDB.getAllVehiculos();
				muestroStock(lista);
			}
		} else {

			vehiculo = vhDB.getVehiculo(p);

			if (vehiculo != null) {
				vi.mostrarPatente(vehiculo);
			} else {

				int codigo = Mensajes.msjSinPatente();

				if (codigo == JOptionPane.YES_OPTION) {
					
					List<Vehiculo> lista = vhDB.getAllVehiculos();
					muestroStock(lista);
				} else {
					
					if (codigo == JOptionPane.NO_OPTION) {
					}
				}
			}
		}
	}

	// Muestro el stock actual.

	private void muestroStock(List<Vehiculo> lista) throws DBException {

		List<Stock> stockAMostrar = new ArrayList<Stock>();

		for (int i = 0; i < lista.size(); i++) {

			if ((lista.get(i).getCondicion().toUpperCase() != "VENDIDO")
					&& (lista.get(i).getCondicion().toUpperCase() != "NO DISPONIBLE")) {

				Stock s = new Stock();

				String patenteActual = lista.get(i).getPatente();

				if (patenteActual == "000000") {
					s.setPatente(lista.get(i).getMotor());
				} else {

					s.setPatente(patenteActual);
				}
				s.setCondicion(lista.get(i).getCondicion());
				s.setColor(lista.get(i).getColor());
				s.setMarca(lista.get(i).getMarca());
				s.setModelo(lista.get(i).getModelo());
				s.setYear(lista.get(i).getYear());
				s.setPvc(lista.get(i).getPvc());

				stockAMostrar.add(s);
			}

		}

		ArrayList<String> comboMarca = vhDB.getComboMarca();
		ArrayList<String> comboModelo = vhDB.getComboModelo();
		ArrayList<String> comboYear = vhDB.getComboYear();

		vi.muestroStock(stockAMostrar, comboMarca, comboModelo, comboYear);

	}

	public void cleanVentas() {
		System.out.println("clean");
		vi.cleanPanelVentas();

	}

	public void validarVenta() throws DBException {

		Boolean botones = vi.getButtonState();

		if (botones == true) {

			String format = new String("dd/MM/yy");
			Date d = new Date();
			SimpleDateFormat df = new SimpleDateFormat(format);
			String stringDate = df.format(d);

			int idVenta = vDB.countAll();
			System.out.println(idVenta);
			// falta idEmpleado

			Venta v = new Venta(idVenta, stringDate, cliente.getDni(),
					garante.getDni(), 1);

			if (vDB.insertVenta(v)) {

				vehiculo.setCondicion("Vendido");
				vehiculo.setFechaVenta(stringDate);
				vehiculo.setIdCliente(cliente.getDni());

				if (vhDB.updateVehiculo(vehiculo)) {

					Mensajes.mensajeInfo(StringMsj.MSG_VTA_OK);

					String c = new String(cliente.getNombre() + " "
							+ cliente.getApellido());
					String g = new String(garante.getNombre() + " "
							+ garante.getApellido());
					String vh = new String(vehiculo.getMarca() + " - "
							+ vehiculo.getModelo());

					vi.ingresarDetalleVenta(idVenta, c, g, vh,
							vehiculo.getPvc());

				} else {

					vi.msjVentaError();
				}

			}
			System.out.println(vDB.countAll());

		} else {
			vi.msjVentaIncompleta();
		}

	}

	public void seleccionaVehiculo() {

		String p = vi.getVehiculoTabla();

		vehiculo = vhDB.getVehiculo(p);
		vi.mostrarPatente(vehiculo);

	}

	public void cleanStock() {
		vi.cleanStock();

	}

	public void mostrarDetalle() {

		String p = vi.getVehiculoTabla();

		vehiculo = vhDB.getVehiculo(p);

		vi.mostrarDetalleVehiculo(vehiculo);

	}

	public void filtrarModelo() {

		System.out.println("FILTRO");

	}

	public void veoFecha(Date fecha) {

		int cant = vi.getCuotas();

		Double saldo = new Double(vi.getSaldo());

		List<Cuota> lista = cargarLista(fecha, cant, saldo);

		vi.cargarTabla(lista);

	}

	private List<Cuota> cargarLista(Date fecha, int cant, Double saldo) {

		List<Cuota> lista = new ArrayList<Cuota>();

		Calendar c1 = GregorianCalendar.getInstance();

		String format = new String("yyyy-MM-dd");

		SimpleDateFormat df = new SimpleDateFormat(format);

		String stringDate = df.format(fecha);

		System.out.println(stringDate);

		String[] partes = stringDate.split("-");

		c1.set(Integer.valueOf(partes[0]), Integer.valueOf(partes[1]),
				Integer.valueOf(partes[2]));

		Double valorCuota = new Double(saldo / cant);

		Cuota c = new Cuota(1, stringDate, valorCuota, new Double(0));

		lista.add(c);

		for (int i = 0; i < cant - 1; i++) {

			c = new Cuota(i + 2, df.format(c1.getTime()), valorCuota,
					new Double(0));
			c1.add(Calendar.MONTH, 1);
			lista.add(c);
		}

		return lista;
	}
	
	public void insertarDetalleVenta(){
		
		
	}

}
