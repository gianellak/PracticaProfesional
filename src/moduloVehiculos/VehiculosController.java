package moduloVehiculos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connections.ConnectionProvider;
import connections.DBConnection;
import objetos.Persona;
import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;
import utilitarios.Mensajes;
import exceptions.DBException;
import moduloPrincipal.PrincipalController;

public class VehiculosController {

	private VehiculosInterface vi;
	private PrincipalController pc;
	private VehiculosDB vDB;
	private Vehiculo vehiculo;

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
				List<Vehiculo> lista = vDB.getAllVehiculos();
				muestroStock(lista);
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

		if ((newVehiculoAInsertar.getPatente() == null)
				|| (newVehiculoAInsertar.getMarca() == null)
				|| (newVehiculoAInsertar.getModelo() == null)
				|| (newVehiculoAInsertar.getColor() == null)
				|| (newVehiculoAInsertar.getYear() == null)
				|| (newVehiculoAInsertar.getPvc() == null)
				|| (newVehiculoAInsertar.getMotor() == null)) {
			
			vi.insertError(); //ACA MOSTRAR UN MENSAJE DICIENDO QUE LLENE LOS CAMPOS OBLIGATORIOS.
								// no puse condición porque crea EN STOCK por default.

		} else {

			if ((newVehiculoAInsertar.getCondicion() == "")
					|| (newVehiculoAInsertar.getCondicion() == null)) {
				newVehiculoAInsertar.setCondicion("EN STOCK");
			}

			newVehiculoAInsertar.setCondicion(newVehiculoAInsertar
					.getCondicion().toUpperCase());

			if (vDB.createVehiculo(newVehiculoAInsertar)) {
				vi.insertOk();
			} else {
				vi.insertError();
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

	public void seleccionaVehiculo() {
		// TODO Auto-generated method stub

	}

	public void filtrarModelo() {
		// TODO Auto-generated method stub

	}

	public void mostrarDetalle() {

		String p = vi.getVehiculoTabla();
		vehiculo = vDB.getVehiculo(p);
		vi.mostrarDetalleVehiculo(vehiculo);

	}
}
