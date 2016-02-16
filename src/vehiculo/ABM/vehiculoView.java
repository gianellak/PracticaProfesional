package vehiculo.ABM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Vehiculo;
import listeners.ListenerAltaV;
import listeners.ListenerVolverV;
import listenersVehiculo.ListenerBuscarVehiculo;
import listenersVehiculo.ListenerNuevoVehiculo;
import listenersVehiculo.ListenerSalirVehiculo;
import listenersVehiculo.ListenerStock;
import listenersVehiculo.ListenerVolverAVehiculo;
import moduloCobranzas.altaVenta.FormularioAlta;

public class VehiculoView implements VehiculoInterface {

	private JPanel panel;
	private JFrame frmVehiculo;
	private VehiculoController vc;

	// LISTENERS

	private ListenerSalirVehiculo listenerSalir;
	private ListenerNuevoVehiculo listenerNuevo;
	private ListenerBuscarVehiculo listenerBuscar;
	private ListenerStock listenerStock;
	private ListenerVolverAVehiculo listenerVolver;

	private JButton btnSalir;
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JButton btnStock;

	private JTextField txtPatente;

	private FormNuevoVehiculo panelNuevoVehiculo;

	public VehiculoView() {

		// FRAME
		frmVehiculo = new JFrame("Menú Vehiculo");
		frmVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// PANEL
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmVehiculo.add(panel);
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
	public void showVehiculo(VehiculoController vehiculoController) {

		vc = vehiculoController;

		listenerSalir = new ListenerSalirVehiculo(vc);
		listenerNuevo = new ListenerNuevoVehiculo(vc);
		listenerBuscar = new ListenerBuscarVehiculo(vc);
		listenerStock = new ListenerStock();

		btnSalir.addActionListener(listenerSalir);
		btnNuevo.addActionListener(listenerNuevo);
		btnBuscar.addActionListener(listenerBuscar);
		btnStock.addActionListener(listenerStock);

		frmVehiculo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmVehiculo.setVisible(true);

	}

	@Override
	public void closeVehiculo() {
		frmVehiculo.dispose();
	}

	@Override
	public Vehiculo getNuevoVehiculo() {

		panelNuevoVehiculo = new FormNuevoVehiculo();
		panel.setVisible(false);

		frmVehiculo.setTitle("Nuevo Vehículo");
		frmVehiculo.invalidate();
		frmVehiculo.validate();
		frmVehiculo.repaint();

		frmVehiculo.add(panelNuevoVehiculo);
		frmVehiculo.invalidate();
		frmVehiculo.validate();
		frmVehiculo.repaint();

		listenerVolver = new ListenerVolverAVehiculo(vc);
		listenerNuevo = new ListenerNuevoVehiculo(vc);

		panelNuevoVehiculo.getBtnCancelar().addActionListener(listenerVolver);
		panelNuevoVehiculo.getBtnAceptar().addActionListener(listenerNuevo);

		Vehiculo v = new Vehiculo(
				panelNuevoVehiculo.getTxtPatente().getText(),
				panelNuevoVehiculo.getTxtMarca().getText(),
				panelNuevoVehiculo.getTxtModelo().getText(),
				Integer.parseInt(panelNuevoVehiculo.getTxtYear().getText()),
				panelNuevoVehiculo.getTxtColor().getText(),
				Integer.parseInt(panelNuevoVehiculo.getTxtKm().getText()),
				panelNuevoVehiculo.getTxtMotor().getText(),
				panelNuevoVehiculo.getTxtDominio().getText(),
				panelNuevoVehiculo.getTxtPvc().getText(),
				panelNuevoVehiculo.getTxtFechaIngreso().getText(), // En un futuro ver
				panelNuevoVehiculo.getTxtFechaVenta().getText(), // que sea tipo DATE CALENDAR
				panelNuevoVehiculo.getTxtCondicion().getText(), // Ver que sea combo box.
				panelNuevoVehiculo.getTxtProveedor().getText(),
				panelNuevoVehiculo.getTxtComentarios());
		
				
				
		return v;

	}

	@Override
	public Vehiculo getVehiculoPorPatente(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showStock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() {
		frmVehiculo.remove(panelNuevoVehiculo);
		panelNuevoVehiculo = null;
		panel.setVisible(true);

		frmVehiculo.invalidate();
		frmVehiculo.validate();
		frmVehiculo.repaint();

	}

	// GETTERS Y SETTERS

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JButton getBtnStock() {
		return btnStock;
	}

	public void setBtnStock(JButton btnStock) {
		this.btnStock = btnStock;
	}

}
