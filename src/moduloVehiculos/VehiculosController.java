package moduloVehiculos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Stock;
import objetos.Vehiculo;
import utilitarios.*;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import moduloVenta.VentasController;
import moduloVenta.VentasView;

public class VehiculosController {

	private VehiculosInterface vi;
	private PrincipalController pc;
	private VehiculosDB vDB;
	private Vehiculo vehiculo;
	private String marca;
	private String year;
	private VentasView vtai;

	public VehiculosController(VehiculosView ci, PrincipalController pc) {
		this.vi = ci;
		this.pc = pc;
	}

	public void conectar() {

		ConnectionProvider pro = new DBConnection();

		try {
			pro.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		vDB = new VehiculosDB(pro);
	}

	public void onCancel() {
		vi.closeVehiculo();
	}

	public void onCreateVehiculo() throws DBException {

		vi.showFormNuevoVehiculo();
	}

	public void onUpdateVehiculo(Vehiculo vehiculoAModificar)
			throws DBException {

		Vehiculo vehiculoModificado = vi
				.getDatosModificarVehiculo(vehiculoAModificar);
		if (vDB.updateVehiculo(vehiculoModificado))
			;
	}

	public void onStock() throws DBException {

		List<Vehiculo> stockActual = vDB.getAllVehiculos();
		List<Stock> stockAMostrar = new ArrayList<Stock>();

		for (int i = 0; i < stockActual.size(); i++) {

			if (!(stockActual.get(i).getCondicion().toUpperCase()
					.equals("VENDIDO"))
					&& !(stockActual.get(i).getCondicion().toUpperCase()
							.equals("NO DISPONIBLE"))) {

				Stock s = new Stock();

				String patenteActual = stockActual.get(i).getPatente();

				if (patenteActual == "000000") {
					s.setPatente(stockActual.get(i).getMotor());
				}

				s.setPatente(patenteActual);
				s.setMarca(stockActual.get(i).getMarca());
				s.setModelo(stockActual.get(i).getModelo());
				s.setColor(stockActual.get(i).getColor());
				s.setCondicion(stockActual.get(i).getCondicion());
				s.setYear(stockActual.get(i).getYear());
				s.setPvc(stockActual.get(i).getPvc());

				stockAMostrar.add(s);
			}
		}

		ArrayList<String> comboMarca = vDB.getComboMarca();
		ArrayList<String> comboModelo = vDB.getComboModelo();
		ArrayList<String> comboYear = vDB.getComboYear();

		vi.showStock(stockAMostrar, comboMarca, comboModelo, comboYear);
	}

	public void onBuscarPorPatente() throws DBException {

		String patente = vi.getPatenteABuscar().toUpperCase();
		
	
		Vehiculo vehiculo = vDB.getVehiculo(patente);

		if (vehiculo != null) {
			vi.mostrarDetalleVehiculo(vehiculo);
		} else {
			int codigo = Mensajes.msjSinPatente();

			if (codigo == JOptionPane.YES_OPTION) {
				onStock();
				
			} else {
				if (codigo == JOptionPane.NO_OPTION) {

				}
			}
		}
	}

	public void getBack() {
		pc.getBack();
	}

	public void onVolver() {
		vi.refresh();
	}

	public void onAceptarNuevoVehiculo() throws DBException {

		Vehiculo newVehiculoAInsertar = vi.getDatosNuevoVehiculo();

		if ((newVehiculoAInsertar.getPatente().isEmpty())
				|| (newVehiculoAInsertar.getMarca().isEmpty())
				|| (newVehiculoAInsertar.getModelo().isEmpty())
				|| (newVehiculoAInsertar.getColor().isEmpty())
				|| (newVehiculoAInsertar.getYear().isEmpty())
				|| (newVehiculoAInsertar.getPvc() == 0)
				|| (newVehiculoAInsertar.getMotor().isEmpty())) {
			
			System.out.println("NOT_OBLI");
		
			Mensajes.mensajeWarning(StringMsj.MSG_NOT_OBLI);
			

		} else {

			if ((newVehiculoAInsertar.getCondicion() == "")
					|| (newVehiculoAInsertar.getCondicion().isEmpty())) {
				newVehiculoAInsertar.setCondicion("STOCK");
			}
			
			Vehiculo v = vDB.getVehiculo(newVehiculoAInsertar.getPatente());

			if(v == null){
				if (vDB.createVehiculo(newVehiculoAInsertar)) {
					Mensajes.mensajeInfo(StringMsj.MSG_VEH_INS_OK);
				} else {
					Mensajes.mensajeWarning(StringMsj.MSG_VEH_INS_BAD);
				}
			}else{
				Mensajes.mensajeWarning(StringMsj.MSG_VEH_DUP);				
			}
		}
	}

	public void onMenuVehiculo() {

		vi.showVehiculo(this, pc.getView(), pc.getUser());
		this.conectar();
	}

	public void cleanVehiculo() {
		vi.cleanPanelVehiculo();
	}

	public void onBuscarVehiculo() {
		vi.onBuscarVehiculo();

	}

	private void muestroStock(List<Vehiculo> lista) throws DBException {

		List<Stock> stockAMostrar = new ArrayList<Stock>();

		for (int i = 0; i < lista.size(); i++) {

			if (!(lista.get(i).getCondicion().toUpperCase().equals("VENDIDO"))
					&& !(lista.get(i).getCondicion().toUpperCase()
							.equals("NO DISPONIBLE"))) {

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

		ArrayList<String> comboMarca = vDB.getComboMarca();
		ArrayList<String> comboModelo = vDB.getComboModelo();
		ArrayList<String> comboYear = vDB.getComboYear();

		vi.muestroStock(stockAMostrar, comboMarca, comboModelo, comboYear);

	}

	
	public void mostrarDetalle() {

		
		String p = vi.getVehiculoTabla();
		
		if(p != null){
		
			vehiculo = vDB.getVehiculo(p);
		
			vi.mostrarDetalleVehiculo(vehiculo);}
		
		else{
			Mensajes.mensajeInfo(StringMsj.MSG_BAD_ROW);
		}

	}
	
	public void copiarVechiulo(){
		
		String p = vi.getVehiculoTabla();
		
		if(p != null){
		
			System.out.println("COPIO");
			vehiculo = vDB.getVehiculo(p);
		
			vi.copioVehiculo(vehiculo);
			
		}else{
			Mensajes.mensajeInfo(StringMsj.MSG_BAD_ROW);
		}
		
	}

	public void getCombos() {
		marca = vi.getMarca();
		year = vi.getYear();
		
		System.out.println(marca + " " + year);
		
	}

	public void aplicoFiltros() throws DBException {

		List<Vehiculo> lista;
		
		try {
			if(marca.equals("-") || year.equals("-"))
			{
				lista = vDB.getFilterVehiculos(marca, year);
			}else{
				lista = vDB.getBothFilters(marca, year);
			}
			List<Stock> stockAMostrar = new ArrayList<Stock>();

			for (int i = 0; i < lista.size(); i++) {

				if (!(lista.get(i).getCondicion().toUpperCase().equals("VENDIDO"))
						&& !(lista.get(i).getCondicion().toUpperCase()
								.equals("NO DISPONIBLE"))) {

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

			vi.actualizoStock(stockAMostrar);

		} catch (NullPointerException e) {
			
		}
		
		
		
		
	}

	public void seleccionaVehiculo() {

		vtai = new VentasView();
		
		VentasController vc = new VentasController(vtai, pc);
		
		String p = vi.getVehiculoTabla();

		vc.ventaDesdeVehiculo(p);


		
	}


}
