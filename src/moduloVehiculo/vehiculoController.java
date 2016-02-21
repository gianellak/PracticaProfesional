package moduloVehiculo;

import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import objetos.Stock;
import objetos.Vehiculo;

public class vehiculoController {

	private vehiculoInterface vehiculo;
	private VehiculoDB vehiculoDB;
	private PrincipalController pc;

	public vehiculoController(vehiculoInterface vehiculo, PrincipalController pc) {
		super();
		this.vehiculo = vehiculo;
		this.pc = pc;

	}

	public void onMenuVehiculo() {
		vehiculoDB = new VehiculoDB(pc.getConn());
		vehiculo.showVehiculo(this);
	}

	public void onCancel() {
		vehiculo.closeVehiculo();
	}

	public void onCreateVehiculo() throws DBException {


		Vehiculo newVehiculoAInsertar = vehiculo.getDatosNuevoVehiculo();

		if (vehiculoDB.createVehiculo(newVehiculoAInsertar)) {

			vehiculo.insertOk();
//hh
		} else {
			vehiculo.insertError();
		}

	}
	
	public void onUpdateVehiculo() throws DBException{
		
		Vehiculo vehiculoAModificar = new Vehiculo(); // ACA REEMPLAZAR POR ELEM. SELECC DE LA TABLA
		
		Vehiculo vehiculoModificado = vehiculo.getDatosModificarVehiculo(vehiculoAModificar);
		
		if (vehiculoDB.updateVehiculo(vehiculoAModificar.getMotor(), vehiculoModificado));
		
		
	}

	public void onStock() throws DBException {

		
		List<Vehiculo> stockActual = vehiculoDB.getAllVehiculos();
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
				s.setYear(stockActual.get(i).getYear());
				s.setPvc(stockActual.get(i).getPvc());

				stockAMostrar.add(s);
			}
		}

		vehiculo.showStock(stockAMostrar);
	}

	public void onBuscarPorPatente() {
		String patente = null;
		vehiculo.getVehiculoPorPatente(patente);
	}

	public void onVolver() {
		vehiculo.refresh();
	}

	

}
