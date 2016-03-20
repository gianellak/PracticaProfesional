package moduloVehiculos;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;
import utilitarios.PantallaUtil;
import moduloPrincipal.paneles.PanelGeneral;
import moduloVehiculos.listener.*;
import moduloVehiculos.paneles.PanelVehiculos;
import moduloVehiculos.paneles.VehiculosMenu;
import moduloVenta.VentasController;
import moduloVenta.listener.ListenerCombo;
import moduloVenta.listener.ListenerVolverVentaStock;


public class VehiculosView implements VehiculosInterface {

	private JFrame frmVehiculo;
	private VehiculosController vc;
	private JButton btnSalir, btnBuscar, btnNuevo, btnStock;
	private VehiculosMenu panelVehiculosMenu;
	private PanelVehiculos panelVehiculos;
	private VehiculosController cc;
	private JFrame frame;

	// LISTENERS

	private ListenerNuevoVehiculo listenerNuevo;
	private ListenerBuscarVehiculo listenerBuscar;
	private ListenerStock listenerStock;
	private ListenerVehiculoVolver listenerVolver;
	private ListenerBuscarPatente listenerBuscarPatente;
	private ListenerSeleccionar listenerSeleccionar;
	private ListenerDetalleVehiculo listenerDetalle;
	private ListenerAceptarAltaVehiculo listenerAceptarAlta;
	private ListenerVolverAVehiculo listenerVolverAlta;
	private ListenerFiltroStock listenerFiltroStock;
	private ListenerCombo listenerMarca;
	private ListenerCombo listenerYear;
	private ListenerCopiar listenerCopiar;
	private ListenerVenderVehiculo listenerVender;
	private ListenerVolverAVehiculo listenerVolverVehiculo;
	private ListenerVolverVentaStock listenerVolverVenta;
	private ListenerVenderVehiculoDetalle listenerVenderDetalle;
	private ListenerAceptarAltaVenta listenerAceptarAltaVenta;
	private ListenerVehiculoVolverVenta listenerVolverVehiculoVenta;

	

	public VehiculosView() {
		
		panelVehiculosMenu= new VehiculosMenu();
		panelVehiculos = new PanelVehiculos();

		
	}
	public VehiculosView(JFrame f) {
		
		panelVehiculosMenu= new VehiculosMenu();
		panelVehiculos = new PanelVehiculos();
		frame = f;
		
		
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
		
		listenerVolver = new ListenerVehiculoVolver(vc);
		listenerNuevo = new ListenerNuevoVehiculo(vc);
		listenerBuscar = new ListenerBuscarVehiculo(vc);
		listenerStock = new ListenerStock(vc);

		panelVehiculosMenu.getBtnVolver().addActionListener(listenerVolver);
		panelVehiculosMenu.getBtnNuevo().addActionListener(listenerNuevo);
		panelVehiculosMenu.getBtnStock().addActionListener(listenerStock);
		panelVehiculosMenu.getBtnBuscar().addActionListener(listenerBuscar);
		

	}

	
	@Override
	public void closeVehiculo() {
		frame.dispose();
	}

	@Override
	public void showFormNuevoVehiculo() {

		PantallaUtil.remove(panelVehiculos);
		
		panelVehiculos.onNuevoVehiculo();
		
		listenerAceptarAlta =new ListenerAceptarAltaVehiculo(vc);
		listenerVolver =new ListenerVehiculoVolver(vc);
		
		panelVehiculos.getBtnAceptar().addActionListener(listenerAceptarAlta);
		panelVehiculos.getBtnCancelar().addActionListener(listenerVolver);
		
		
		PantallaUtil.refresh(frame);
		

	}
	
	
	public void showFormModificarVehiculo(){
		
		panelVehiculos.onModificarVehiculo();


		listenerVolverVehiculo = new ListenerVolverAVehiculo(vc);
		//listenerModificar = new ListenerModificarVehiculo(vc);

		panelVehiculos.getBtnCancelar().addActionListener(listenerVolverVehiculo);
		//panelModificarVehiculo.getBtnAceptar().addActionListener(listenerModificar);
	}

	@Override
	public Vehiculo getVehiculoPorPatente(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showStock(List<Stock> listaStockVehiculos, ArrayList<String> comboMarca,
			ArrayList<String> comboModelo, ArrayList<String> comboYear) {
		
		PantallaUtil.remove(panelVehiculos);
		
		panelVehiculos.muestroStock(listaStockVehiculos);		
		panelVehiculos.menuVerStock();
		panelVehiculos.preparoFiltros(comboMarca, comboModelo, comboYear);
		
		
		listenerVender = new ListenerVenderVehiculo(vc);			
		panelVehiculos.getBtnVender().addActionListener(listenerVender);
		listenerMarca = new ListenerCombo(vc);
		panelVehiculos.getComboListMarca().addItemListener(listenerMarca);
		listenerYear = new ListenerCombo(vc);
		panelVehiculos.getComboListYear().addItemListener(listenerYear);
		listenerDetalle = new ListenerDetalleVehiculo(vc);
		panelVehiculos.getBtnDetalle().addActionListener(listenerDetalle);
		listenerFiltroStock = new ListenerFiltroStock(vc);
		panelVehiculos.getBtnFiltrar().addActionListener(listenerFiltroStock);
		listenerCopiar = new ListenerCopiar(vc);
		panelVehiculos.getBtnCopiar().addActionListener(listenerCopiar);
		listenerVolverVehiculo = new ListenerVolverAVehiculo(vc);
		panelVehiculos.getBtnVolverVenta().addActionListener(listenerVolverVehiculo);
		
		
		frame.add(panelVehiculos);
		
		PantallaUtil.refresh(frame);
	}

	@Override
	public void refresh() {

		frmVehiculo.invalidate();
		frmVehiculo.validate();
		frmVehiculo.repaint();

	}

	public Vehiculo getDatosNuevoVehiculo() {
		
		
		
		int km, pvc, pro, cli;
		
		try {
			km = Integer.parseInt(panelVehiculos.getTxtKm().getText());
		} catch (NumberFormatException e) {
			km = 0;
		}
		
		try {
			pvc = Integer.parseInt(panelVehiculos.getTxtPvc().getText());
		} catch (NumberFormatException e) {
			pvc = 0;
		}
		try {
			pro = Integer.parseInt(panelVehiculos.getTxtProveedor().getText());
		} catch (NumberFormatException e) {
			pro = 0;
		}
		try {
			cli = Integer.parseInt(panelVehiculos.getTxtCliente().getText());
		} catch (NumberFormatException e) {
			cli = 0;
		}
		
		Vehiculo v = new Vehiculo(
				
				panelVehiculos.getTxtPatente().getText().toUpperCase(),
				panelVehiculos.getTxtMarca().getText(),
				panelVehiculos.getTxtModelo().getText(),
				panelVehiculos.getTxtYear().getText(),
				panelVehiculos.getTxtColor().getText(),
				km,
				panelVehiculos.getTxtMotor().getText().toUpperCase(),
				panelVehiculos.getTxtDominio().getText().toUpperCase(),
				pvc,
				panelVehiculos.getTxtFechaIngreso().getText(),
				panelVehiculos.getTxtFechaVenta().getText(), 
				panelVehiculos.getTxtCondicion().getText().toUpperCase(), 
				pro,
				cli,
				panelVehiculos.getTxtComentarios().getText());

		return v;
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

	

	@Override
	public void cleanPanelVehiculo() {
		panelVehiculos.removeAll();
		panelVehiculos.validate();
		panelVehiculos.repaint();
		
	}
	


	@Override
	public void onBuscarVehiculo() {
		
		panelVehiculos.onBuscarVehiculo();
		listenerBuscarPatente = new ListenerBuscarPatente(vc);
		panelVehiculos.getBtnBuscar().addActionListener(listenerBuscarPatente);
	
		listenerVolverVehiculo = new ListenerVolverAVehiculo(vc);
		panelVehiculos.getBtnVolver().addActionListener(listenerVolverVehiculo);
		PantallaUtil.refresh(frame);
		
	}


	@Override
	public String getPatenteABuscar() {
		// TODO Auto-generated method stub
		return panelVehiculos.getPatenteText().getText();
	}


	@Override
	public void muestroStock(List<Stock> stockAMostrar,
			ArrayList<String> comboMarca, ArrayList<String> comboModelo,
			ArrayList<String> comboYear) {
	
			panelVehiculos = new PanelVehiculos();
			
			panelVehiculos.muestroStock(stockAMostrar);
			panelVehiculos.menuVentaStock();

			panelVehiculos.preparoFiltros(comboMarca, comboModelo, comboYear);

			
			frame.add(panelVehiculos);
			
			listenerMarca = new ListenerCombo(vc);
			panelVehiculos.getComboListMarca().addItemListener(listenerMarca);
			listenerYear = new ListenerCombo(vc);
			panelVehiculos.getComboListYear().addItemListener(listenerYear);
			
		
			listenerSeleccionar = new ListenerSeleccionar(vc);			
			panelVehiculos.getBtnSeleccionar().addActionListener(listenerSeleccionar);
			
			listenerDetalle = new ListenerDetalleVehiculo(vc);
			panelVehiculos.getBtnDetalle().addActionListener(listenerDetalle);
			listenerFiltroStock = new ListenerFiltroStock(vc);
			panelVehiculos.getBtnFiltrar().addActionListener(listenerFiltroStock);
		
			PantallaUtil.refresh(frame);
					
		}


	@Override
	public String getVehiculoTabla() {
		return panelVehiculos.getVehiculoTabla();
	}


	@Override
	public void mostrarDetalleVehiculo(Vehiculo vehiculo) {

		panelVehiculos.mostrarDetalleVehiculo(vehiculo);
		listenerVenderDetalle = new ListenerVenderVehiculoDetalle(vc);			
		panelVehiculos.getBtnVender().addActionListener(listenerVenderDetalle);
		listenerVolverVehiculo = new ListenerVolverAVehiculo(vc);
		panelVehiculos.getBtnVolverAStock().addActionListener(listenerVolverVehiculo);
		
		PantallaUtil.refresh(frame);
	}


	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return panelVehiculos.getComboListMarca().getSelectedItem().toString();
				
	}


	@Override
	public String getYear() {
		// TODO Auto-generated method stub
		return panelVehiculos.getComboListYear().getSelectedItem().toString();
	}


	@Override
	public void actualizoStock(List<Stock> stockAMostrar) {
		panelVehiculos.getPanelStock().actualizoStock(stockAMostrar);
		
	}


	@Override
	public void copioVehiculo(Vehiculo vehiculo) {
			
		panelVehiculos.copioVehiculo(vehiculo);
		
		listenerAceptarAlta =new ListenerAceptarAltaVehiculo(vc);
		listenerVolverAlta =new ListenerVolverAVehiculo(vc);
		
		panelVehiculos.getBtnAceptar().addActionListener(listenerAceptarAlta);
		panelVehiculos.getBtnCancelar().addActionListener(listenerVolver);
		
		PantallaUtil.refresh(frame);
		
	}


	@Override
	public String vehiculoVenta() {
		
		return panelVehiculos.getPatenteText().getText();
		
	}


	@Override
	public JPanel getPanel() {
		return panelVehiculos;
	}


	@Override
	public void nuevoVehiculoVenta(String patente, VentasController vc) {

		System.out.println(patente);
		
		
		panelVehiculos.onNuevoVehiculoVenta(patente);
		
		listenerAceptarAltaVenta =new ListenerAceptarAltaVenta(vc);
		listenerVolverVehiculoVenta =new ListenerVehiculoVolverVenta(vc);
		
		panelVehiculos.getBtnAceptar().addActionListener(listenerAceptarAltaVenta);
		panelVehiculos.getBtnCancelar().addActionListener(listenerVolver);
		
		PantallaUtil.refresh(frame);

	}


	@Override
	public void removePanelVehiculos() {
		
		PantallaUtil.remove(panelVehiculos);
	}



}