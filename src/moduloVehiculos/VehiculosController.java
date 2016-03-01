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
import exceptions.DBException;
import moduloPrincipal.PrincipalController;

public class VehiculosController {

	private VehiculosInterface vi;
	private PrincipalController pc;
	private VehiculosDB vDB;
	
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
		
//		TABLAVEHICULO
//		SchemaGenerator v = new SchemaGenerator(conn);
//		
//		try {
//			v.generateSchemaVehiculo();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		
	}

	

	public void onCancel() {
		vi.closeVehiculo();
	}

	public void onCreateVehiculo() throws DBException {
		
		vi.showFormNuevoVehiculo();

		Vehiculo newVehiculoAInsertar = vi.getDatosNuevoVehiculo();

		if (vDB.createVehiculo(newVehiculoAInsertar)) {

			vi.insertOk();
//hh
		} else {
			vi.insertError();
		}

	}
	
	public void onUpdateVehiculo(Vehiculo vehiculoAModificar) throws DBException{
		
		Vehiculo vehiculoModificado = vi.getDatosModificarVehiculo(vehiculoAModificar);
		
		if (vDB.updateVehiculo(vehiculoModificado));
		
		
	}

	public void onStock() throws DBException {

		
		List<Vehiculo> stockActual = vDB.getAllVehiculos();
		
		List<Stock> stockAMostrar = new ArrayList<Stock>();

		for (int i = 0; i < stockActual.size(); i++) {

			if (! ( (stockActual.get(i).getCondicion() == "Vendido") || (stockActual.get(i).getCondicion() == "No disponible"))) {

				Stock s = new Stock();
				
				String patenteActual = stockActual.get(i).getPatente();

				if (patenteActual == "000000"){
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

	public void onBuscarPorPatente() {
		String patente = null;
		vi.getVehiculoPorPatente(patente);
	}
	

	public void getBack() {
		
		pc.getBack();
		
		
	}

	public void onVolver() {
		vi.refresh();
	}

	public void onAceptarNuevoVehiculo() {
		
	}



	public void onMenuVehiculo() {

		vi.showVehiculo(this, pc.getView(), pc.getUser());
		
		this.conectar();
		
	}



	public void cleanVehiculo() {
		vi.cleanPanelVehiculo();
		
	}

	

}
