//package moduloVehiculo;
//
//import java.util.List;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//
//import exceptions.DBException;
//import objetos.Stock;
//import objetos.Vehiculo;
//import moduloVehiculo.listener.*;
//import moduloVehiculo.paneles.FormModificarVehiculo;
//import moduloVehiculo.paneles.FormNuevoVehiculo;
//import moduloVehiculo.paneles.FormStock;
//
//public class vehiculoView implements vehiculoInterface {
//
//	private JPanel panel;
//	private JFrame frmVehiculo;
//	private vehiculoController vc;
//
//	// LISTENERS
//
//	private ListenerSalirVehiculo listenerSalir;
//	private ListenerNuevoVehiculo listenerNuevo;
//	private ListenerBuscarVehiculo listenerBuscar;
//	private ListenerStock listenerStock;
//	private ListenerVolverAVehiculo listenerVolver;
//	private ListenerVerStock listenerVerStock;
//	private ListenerModificarVehiculo listenerModificar;
//
//	private JButton btnSalir;
//	private JButton btnBuscar;
//	private JButton btnNuevo;
//	private JButton btnStock;
//
//	private JTextField txtPatente;
//
//	private FormNuevoVehiculo panelNuevoVehiculo;
////	private FormModificarVehiculo panelModificarVehiculo;
//	private FormStock panelStock;
//
//	public vehiculoView() {
//
//		// FRAME
//		frmVehiculo = new JFrame("Menú Vehiculo");
//		frmVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		// PANEL
//		panel = new JPanel();
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		frmVehiculo.add(panel);
//		panel.setLayout(null);
//
//		// BOTONES
//		panel.setLayout(null);
//
//		JLabel lblPatente = new JLabel("Ingrese patente: ");
//		lblPatente.setBounds(100, 50, 160, 25);
//		panel.add(lblPatente);
//
//		txtPatente = new JTextField(6);
//		txtPatente.setBounds(100, 80, 160, 25);
//		panel.add(txtPatente);
//
//		btnBuscar = new JButton("Buscar");
//		btnBuscar.setBounds(100, 120, 80, 25);
//		panel.add(btnBuscar);
//
//		btnStock = new JButton("Stock");
//		btnStock.setBounds(100, 150, 80, 25);
//		panel.add(btnStock);
//
//		btnNuevo = new JButton("Nuevo");
//		btnNuevo.setBounds(100, 180, 80, 25);
//		panel.add(btnNuevo);
//
//		btnSalir = new JButton("Salir");
//		btnSalir.setBounds(100, 210, 80, 25);
//		panel.add(btnSalir);
//
//	}
//
//	@Override
//	public void showVehiculo(vehiculoController vehiculoController) {
//
//		vc = vehiculoController;
//
//		listenerSalir = new ListenerSalirVehiculo(vc);
//		listenerNuevo = new ListenerNuevoVehiculo(vc);
//		listenerBuscar = new ListenerBuscarVehiculo(vc);
//		listenerStock = new ListenerStock(vc);
//
//		btnSalir.addActionListener(listenerSalir);
//		btnNuevo.addActionListener(listenerNuevo);
//		btnBuscar.addActionListener(listenerBuscar);
//		btnStock.addActionListener(listenerStock);
//
//		frmVehiculo.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frmVehiculo.setVisible(true);
//
//	}
//
//	@Override
//	public void closeVehiculo() {
//		frmVehiculo.dispose();
//	}
//
//	@Override
//	public void showFormNuevoVehiculo() {
//
//		panelNuevoVehiculo = new FormNuevoVehiculo();
//		panel.setVisible(false);
//
//		frmVehiculo.setTitle("Nuevo Vehículo");
//		frmVehiculo.invalidate();
//		frmVehiculo.validate();
//		frmVehiculo.repaint();
//
//		frmVehiculo.add(panelNuevoVehiculo);
//		frmVehiculo.invalidate();
//		frmVehiculo.validate();
//		frmVehiculo.repaint();
//
//		listenerVolver = new ListenerVolverAVehiculo(vc);
//		listenerNuevo = new ListenerNuevoVehiculo(vc);
//
//		panelNuevoVehiculo.getBtnCancelar().addActionListener(listenerVolver);
//		panelNuevoVehiculo.getBtnAceptar().addActionListener(listenerNuevo);
//
//	}
//	
//	
//	public void showFormModificarVehiculo(){
////		panelModificarVehiculo = new FormModificarVehiculo();
//		panel.setVisible(false);
//
//		frmVehiculo.setTitle("Modificar Vehículo");
//		frmVehiculo.invalidate();
//		frmVehiculo.validate();
//		frmVehiculo.repaint();
//
//	//	frmVehiculo.add(panelModificarVehiculo);
//		frmVehiculo.invalidate();
//		frmVehiculo.validate();
//		frmVehiculo.repaint();
//
//		listenerVolver = new ListenerVolverAVehiculo(vc);
//		listenerModificar = new ListenerModificarVehiculo(vc);
//
//		//panelModificarVehiculo.getBtnCancelar().addActionListener(listenerVolver);
//		//panelModificarVehiculo.getBtnAceptar().addActionListener(listenerModificar);
//	}
//
//	@Override
//	public Vehiculo getVehiculoPorPatente(String patente) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void showStock(List<Stock> listaStockVehiculos) {
//
//		 panelStock = new FormStock();
//		 panel.setVisible(false);
//		
//		 frmVehiculo.setTitle("Stock");
//		 frmVehiculo.invalidate();
//		 frmVehiculo.validate();
//		 frmVehiculo.repaint();
//		
//		 frmVehiculo.add(panelStock);
//		 frmVehiculo.invalidate();
//		 frmVehiculo.validate();
//		 frmVehiculo.repaint();
//		
//		 listenerVolver = new ListenerVolverAVehiculo(vc);
//		 listenerStock = new ListenerStock(vc);
//		
//		 panelStock.getBtnCancelar().addActionListener(listenerVolver);
//		 panelStock.getBtnVerDetalle().addActionListener(listenerVerStock);
//		 
//	}
//
//	@Override
//	public void refresh() {
//		frmVehiculo.remove(panelNuevoVehiculo);
//		// frmVehiculo.remove(panelStock);
//		panelNuevoVehiculo = null;
//		panelStock = null;
//		panel.setVisible(true);
//
//		frmVehiculo.invalidate();
//		frmVehiculo.validate();
//		frmVehiculo.repaint();
//
//	}
//
//	public Vehiculo getDatosNuevoVehiculo() {
//
//		Vehiculo v = new Vehiculo(
//				panelNuevoVehiculo.getTxtPatente().getText(),
//				panelNuevoVehiculo.getTxtMarca().getText(),
//				panelNuevoVehiculo.getTxtModelo().getText(),
//				Integer.parseInt(panelNuevoVehiculo.getTxtYear().getText()),
//				panelNuevoVehiculo.getTxtColor().getText(),
//				Integer.parseInt(panelNuevoVehiculo.getTxtKm().getText()),
//				panelNuevoVehiculo.getTxtMotor().getText(),
//				panelNuevoVehiculo.getTxtDominio().getText(),
//				Integer.parseInt(panelNuevoVehiculo.getTxtPvc().getText()),
//				panelNuevoVehiculo.getTxtFechaIngreso().getText(),
//				panelNuevoVehiculo.getTxtFechaVenta().getText(), 
//				panelNuevoVehiculo.getTxtCondicion().getText(), // combo box u option button
//				Integer.parseInt(panelNuevoVehiculo.getTxtProveedor().getText()),
//				Integer.parseInt(panelNuevoVehiculo.getTxtCliente().getText()),
//				panelNuevoVehiculo.getTxtComentarios().getText());
//
//		return v;
//
//	}
//	
//	@Override
//	public Vehiculo getDatosModificarVehiculo(Vehiculo vehiculo) {
//		
////		Vehiculo vehiculoModificado = new Vehiculo(
////				panelModificarVehiculo.getTxtPatente().getText(),
////				vehiculo.getMarca(),
////				vehiculo.getModelo(),
////				vehiculo.getYear(),
////				vehiculo.getColor(),
////				Integer.parseInt(panelModificarVehiculo.getTxtKm().getText()),
////				vehiculo.getMotor(),
////				vehiculo.getDominio(),
////				Integer.parseInt(panelModificarVehiculo.getTxtPvc().getText()),
////				vehiculo.getFechaIngreso(),
////				panelModificarVehiculo.getTxtFechaVenta().getText(), 
////				panelModificarVehiculo.getTxtCondicion().getText(), // combo box u option button
////				vehiculo.getIdProveedor(),
////				Integer.parseInt(panelModificarVehiculo.getTxtCliente().getText()),
////				panelModificarVehiculo.getTxtComentarios().getText());
//
//		Vehiculo vehiculoModificado = null;
//		return vehiculoModificado;
//
//	}
//
//
//	@Override
//	public void insertOk() {
//
//		JOptionPane.showMessageDialog(null,
//				"El vehículo fue registrado correctamente");
//
//		// PANEL ACTUAL
//
//		// removeAll();
//		// validate();
//		// repaint();
//
//	}
//
//	@Override
//	public void insertError() {
//		JOptionPane.showMessageDialog(null,
//						"Error. El vehículo no ha sido registrado. Intente nuevamente.");
//
//	}
//
//	// GETTERS Y SETTERS
//
//	public JButton getBtnSalir() {
//		return btnSalir;
//	}
//
//	public void setBtnSalir(JButton btnSalir) {
//		this.btnSalir = btnSalir;
//	}
//
//	public JButton getBtnBuscar() {
//		return btnBuscar;
//	}
//
//	public void setBtnBuscar(JButton btnBuscar) {
//		this.btnBuscar = btnBuscar;
//	}
//
//	public JButton getBtnNuevo() {
//		return btnNuevo;
//	}
//
//	public void setBtnNuevo(JButton btnNuevo) {
//		this.btnNuevo = btnNuevo;
//	}
//
//	public JButton getBtnStock() {
//		return btnStock;
//	}
//
//	public void setBtnStock(JButton btnStock) {
//		this.btnStock = btnStock;
//	}
//
//}