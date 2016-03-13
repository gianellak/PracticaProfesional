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


public class VehiculosView implements VehiculosInterface {
//
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
	private ListenerVehiculoVolver listenerVolverAlta;
	private ListenerFiltroStock listenerFiltroStock;
	private ListenerCombo listenerMarca;
	private ListenerCombo listenerYear;
	private ListenerCopiar listenerCopiar;
	private ListenerVenderVehiculo listenerVender;

	

	public VehiculosView() {
		
		panelVehiculosMenu= new VehiculosMenu();
		panelVehiculos = new PanelVehiculos();

		
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
		listenerVolverAlta =new ListenerVehiculoVolver(vc);
		
		panelVehiculos.getBtnAceptar().addActionListener(listenerAceptarAlta);
		panelVehiculos.getBtnCancelar().addActionListener(listenerVolver);
		
		
		PantallaUtil.refresh(frame);
		

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
		
		
		
		frame.add(panelVehiculos);
		
		PantallaUtil.refresh(frame);
	}

	@Override
	public void refresh() {
	//	frmVehiculo.remove(panelVehiculo);
		// frmVehiculo.remove(panelStock);
	//	panelVehiculo = null;
	//	panelStock = null;
	//	panel.setVisible(true);

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
		listenerVolverAlta =new ListenerVehiculoVolver(vc);
		
		panelVehiculos.getBtnAceptar().addActionListener(listenerAceptarAlta);
		panelVehiculos.getBtnCancelar().addActionListener(listenerVolver);
		
		PantallaUtil.refresh(frame);
		
	}


	@Override
	public String vehiculoVenta() {
		
		return panelVehiculos.getPatenteText().getText();
		
	}


	
	

}