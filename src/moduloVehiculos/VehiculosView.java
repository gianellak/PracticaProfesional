package moduloVehiculos;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;

import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;
import utilitarios.PantallaUtil;
import moduloClientes.listener.ListenerAltaAceptar;
import moduloClientes.listener.ListenerMenuClientesVolver;
import moduloPrincipal.paneles.PanelGeneral;
import moduloVehiculo.paneles.FormStock;
import moduloVehiculos.listener.*;
import moduloVehiculos.paneles.PanelVehiculos;
import moduloVehiculos.paneles.VehiculosMenu;

public class VehiculosView implements VehiculosInterface {

	private JPanel panel;
	private JFrame frmVehiculo;
	private VehiculosController vc;

	// LISTENERS

	private ListenerSalirVehiculo listenerSalir;
	private ListenerNuevoVehiculo listenerNuevo;
	private ListenerBuscarVehiculo listenerBuscar;
	private ListenerStock listenerStock;
	private JButton btnSalir;
	private JButton btnBuscar;
	private JButton btnNuevo;
	private JButton btnStock;
	private VehiculosMenu panelVehiculosMenu;
	private PanelVehiculos panelVehiculos;
	private VehiculosController cc;
	private JFrame frame;
	private JTable tablaStock;
	private JScrollPane jp;
	private FormStock panelStock;
	private JButton btnVolver;
	private ListenerVolverAVehiculo listenerVolver;

	

	public VehiculosView() {
		
		panelVehiculosMenu= new VehiculosMenu();
		panelVehiculos = new PanelVehiculos();

		System.out.println("DESDE VEHICULOS CON S");
		
	}

	
	@Override
	public void showVehiculo(VehiculosController vehiculoController, JFrame f, Usuario u) {

		vc = vehiculoController;

		vehiculoController = cc;
		frame = f;
		
		
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		
		frame.setTitle("Menu Vehiculos");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
		frame.getContentPane().add(panelVehiculosMenu, BorderLayout.WEST);
		frame.getContentPane().add(panelVehiculos, BorderLayout.LINE_END);
		frame.validate();
		frame.repaint();
		
		listenerSalir = new ListenerSalirVehiculo(vc);
		listenerNuevo = new ListenerNuevoVehiculo(vc);
		listenerBuscar = new ListenerBuscarVehiculo(vc);
		listenerStock = new ListenerStock(vc);

		panelVehiculosMenu.getBtnSalir().addActionListener(listenerSalir);
		panelVehiculosMenu.getBtnNuevo().addActionListener(listenerNuevo);
		panelVehiculosMenu.getBtnBuscar().addActionListener(listenerBuscar);
		panelVehiculosMenu.getBtnStock().addActionListener(listenerStock);


	}

	
	@Override
	public void closeVehiculo() {
		frame.dispose();
	}

	@Override
	public void showFormNuevoVehiculo() {

		panelVehiculos.removeAll();
		panelVehiculos.validate();
		panelVehiculos.repaint();
		
		panelVehiculos.onNuevoVehiculo();
		
		
		
		frame.validate();
		frame.repaint();

		

	}
	
	
	public void showFormModificarVehiculo(){
		
		panelVehiculos.onModificarVehiculo();


	//	listenerVolver = new ListenerVolverAVehiculo(vc);
		//listenerModificar = new ListenerModificarVehiculo(vc);

	//	panelModificarVehiculo.getBtnCancelar().addActionListener(listenerVolver);
		//panelModificarVehiculo.getBtnAceptar().addActionListener(listenerModificar);
	}

	@Override
	public Vehiculo getVehiculoPorPatente(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showStock(List<Stock> listaStockVehiculos) {
		
		
		JFrame stock = new JFrame("Stock actual");
		
		stock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stock.getContentPane().setLayout(new BorderLayout());
		stock.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		panelStock = new FormStock(listaStockVehiculos);
		
		jp= new JScrollPane(tablaStock);
		
		stock.getContentPane().add(panelStock.getJp());

		
		
		stock.validate();
		stock.repaint();
		stock.setVisible(true);
		
		
	}

	@Override
	public void refresh() {
	//	frmVehiculo.remove(panelNuevoVehiculo);
		// frmVehiculo.remove(panelStock);
	//	panelNuevoVehiculo = null;
	//	panelStock = null;
	//	panel.setVisible(true);

		frmVehiculo.invalidate();
		frmVehiculo.validate();
		frmVehiculo.repaint();

	}

	public Vehiculo getDatosNuevoVehiculo() {
		return null;

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

	}
	
	@Override
	public Vehiculo getDatosModificarVehiculo(Vehiculo vehiculo) {
		return vehiculo;
		
//		Vehiculo vehiculoModificado = new Vehiculo(
//				panelModificarVehiculo.getTxtPatente().getText(),
//				vehiculo.getMarca(),
//				vehiculo.getModelo(),
//				vehiculo.getYear(),
//				vehiculo.getColor(),
//				Integer.parseInt(panelModificarVehiculo.getTxtKm().getText()),
//				vehiculo.getMotor(),
//				vehiculo.getDominio(),
//				Integer.parseInt(panelModificarVehiculo.getTxtPvc().getText()),
//				vehiculo.getFechaIngreso(),
//				panelModificarVehiculo.getTxtFechaVenta().getText(), 
//				panelModificarVehiculo.getTxtCondicion().getText(), // combo box u option button
//				vehiculo.getIdProveedor(),
//				Integer.parseInt(panelModificarVehiculo.getTxtCliente().getText()),
//				panelModificarVehiculo.getTxtComentarios().getText());
//
//		return vehiculoModificado;

	}


	@Override
	public void insertOk() {

		JOptionPane.showMessageDialog(null,
				"El vehículo fue registrado correctamente");

		// PANEL ACTUAL

		// removeAll();
		// validate();
		// repaint();

	}

	@Override
	public void insertError() {
		JOptionPane.showMessageDialog(null,
						"Error. El vehículo no ha sido registrado. Intente nuevamente.");

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