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
import moduloVehiculo.VehiculoDB;

public class VehiculosController {

	private VehiculosInterface vi;
	private PrincipalController pc;
	private VehiculosDB vDB;
	
	public VehiculosController(VehiculosView ci, PrincipalController pc) {
		this.vi = ci;
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
		
		vDB = new VehiculosDB(pro);
		
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
		
		if (vDB.updateVehiculo(vehiculoAModificar.getMotor(), vehiculoModificado));
		
		
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
				s.setYear(stockActual.get(i).getYear());
				s.setPvc(stockActual.get(i).getPvc());

				stockAMostrar.add(s);
			}
		}

		vi.showStock(stockAMostrar);
	}

	public void onBuscarPorPatente() {
		String patente = null;
		vi.getVehiculoPorPatente(patente);
	}

	public void onVolver() {
		vi.refresh();
	}

	public void onAceptarNuevoVehiculo() {
		
	}



	public void onMenuVehiculo() {
		vDB = new VehiculosDB(pc.getConn());
		vi.showVehiculo(this, pc.getView(), pc.getUser());
		
	}

	

}
