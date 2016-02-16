package vehiculo.ABM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Vehiculo;
import listeners.ListenerBuscarVehiculo;
import listeners.ListenerNuevoVehiculo;
import listeners.ListenerSalirVehiculo;
import listeners.ListenerStock;


public class VehiculoView implements VehiculoInterface {
	
	private JPanel panel;
	private JFrame frmStock;
	private VehiculoController vehiculoController;

	// LISTENERS
	
	private ListenerSalirVehiculo listenerSalir;
	private ListenerNuevoVehiculo listenerNuevo;
	private ListenerBuscarVehiculo listenerBuscar;
	private ListenerStock listenerStock;
	
	private JButton btnSalir;
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JButton btnStock;
	
	private JTextField txtPatente;

	
	
	private DefaultTableModel model;
	private JTable table;
	private JLabel ventaLabel;
//	private FormularioAlta panelF;
//	private ListenerVolverV listenerVolver;
//	private ListenerAltaV listenerAlta;
//	private FormularioNuevaCompra panelC;
//	private FormularioNuevoCliente panelNC;
//	private ListenerNuevoCliente listenerAltaCliente;

	public VehiculoView() {
		
		//FRAME
		frmStock = new JFrame("Menú Vehiculo");
		frmStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// PANEL
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmStock.add(panel);
		panel.setLayout(null);

		// BOTONES
		panel.setLayout(null);
	
		JLabel lblPatente = new JLabel("Ingrese patente: ");
		lblPatente.setBounds(100, 50, 160, 25);
		panel.add(lblPatente);

		txtPatente = new JTextField(6);
		txtPatente.setBounds(100, 80, 160, 25);
		panel.add(txtPatente);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(100, 120, 80, 25);
		panel.add(btnBuscar);
		
		btnStock = new JButton("Consultar stock");
		btnStock.setBounds(100, 150, 80, 25);
		panel.add(btnStock);
		
		btnNuevo = new JButton("Nuevo vehículo");
		btnNuevo.setBounds(100, 180, 80, 25);
		panel.add(btnNuevo);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(100, 210, 80, 25);
		panel.add(btnSalir);
		
	}

	@Override
	public void showVehiculo(VehiculoController vc) {

		vehiculoController = vc;
				
		listenerSalir = new ListenerSalirVehiculo(vehiculoController);
		listenerNuevo = new ListenerNuevoVehiculo(vehiculoController);
		listenerBuscar = new ListenerBuscarVehiculo(vehiculoController);
		
		btnSalir.addActionListener(listenerSalir);
		btnNuevo.addActionListener(listenerNuevo);
		btnBuscar.addActionListener(listenerBuscar);
//		frmVentas.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		frmVentas.setVisible(true);
		
		

	}

	@Override
	public void closeVehiculo() {
		//Formulario vehiculo dispose
	}

	@Override
	public Vehiculo getNuevoVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo getVehiculoPorPatente(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

}
