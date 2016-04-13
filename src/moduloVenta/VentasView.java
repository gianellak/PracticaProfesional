package moduloVenta;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.DBException;
import objetos.Cuota;
import objetos.DetalleVenta;
import objetos.MuestroVenta;
import objetos.Persona;
import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;
import objetos.Venta;
import utilitarios.PantallaUtil;
import moduloClientes.paneles.*;
import moduloPrincipal.paneles.PanelGeneral;
import moduloVehiculos.listener.ListenerFiltroStock;
import moduloVehiculos.paneles.PanelVehiculos;
import moduloVenta.listener.*;
import moduloVenta.paneles.PanelVentas;
import moduloVenta.paneles.VentasMenu;

public class VentasView implements VentasInterface {
	
	private JFrame frame;
	
	private PanelVentas panelVentas;
	private PanelClientes panelClientes;
	private PanelVehiculos panelVehiculos;


	private VentasMenu panelVentasMenu;
	private VentasController ventasController;
	
	private ListenerVentasVolver listenerVolver;
	private ListenerNuevaVenta listenerNuevaVenta;
	private ListenerNuevaCompra listenerNuevaCompra;
	private ListenerValidarC listenerValidarC;
	private ListenerAltaClienteV listenerAltaAceptar;
	private ListenerValidarG listenerValidarG;
	private ListenerAltaGaranteV listenerAltaAceptarG;
	private ListenerBuscarVehiculoV listenerBuscarV;
	private ListenerVolverVentas listenerVolverAVentas;
	private ListenerValidarVenta listenerAceptarV;
	private ListenerSeleccionar listenerSeleccionar;
	private ListenerVolverVentaStock listenerVolverVenta;
	private ListenerDetalleVehiculo listenerDetalle;
	private ListenerReiniciarVenta listenerReiniciar;
	private ListenerDate listenerDate;

	private ListenerAceptarDetalle listenerAceptarDetalle;

	private ListenerFiltroStock listenerFiltroStock;

	private ListenerCombo listenerMarca;

	private ListenerCombo listenerYear;

	private ListenerAdqUnidad listenerAdqUnidad;

	private ListenerBuscarClienteVentas listenerBuscarClienteVentas;

	private ListenerUnaVenta listenerUnaVenta;

	private ListenerPagarCuota listenerPagarCuota;

	public VentasView(){
		
		panelVentasMenu= new VentasMenu();
		panelVentas = new PanelVentas();
	
	}
	
	//


//Muestra el Menu de Ventas. Viene del Menu Principal.
	@Override
	public void showMenuVentas(VentasController vc,
			JFrame f, Usuario u) {
		
		ventasController = vc;
		frame = f;
		
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		listenerVolver = new ListenerVentasVolver(vc);
		listenerNuevaVenta = new ListenerNuevaVenta(vc);
		listenerNuevaCompra= new ListenerNuevaCompra(vc);

		
		panelVentasMenu.getBtnNuevaVenta().addActionListener(listenerNuevaVenta);
		panelVentasMenu.getBtnBuscarVenta().addActionListener(listenerNuevaCompra);
		panelVentasMenu.getBtnVolver().addActionListener(listenerVolver);

		frame.setTitle("Menu Ventas");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
		frame.getContentPane().add(panelVentasMenu, BorderLayout.WEST);
		frame.getContentPane().add(panelVentas, BorderLayout.LINE_END);
		
		PantallaUtil.refresh(frame);
		
	}



//Muestro Pantalla Nueva Venta. Viene de Menu Ventas, Botón Nueva Venta. 
	@Override
	public void showNuevaVenta() {
		
		panelVentas.showNuevaVenta();
		
		listenerValidarC = new ListenerValidarC(ventasController);
		listenerBuscarV = new ListenerBuscarVehiculoV(ventasController);
		listenerValidarG = new ListenerValidarG(ventasController);
		listenerVolverAVentas = new ListenerVolverVentas(ventasController);
		listenerAceptarV = new ListenerValidarVenta(ventasController);
		listenerReiniciar = new ListenerReiniciarVenta(ventasController);
		
		panelVentas.getBtnValidarDniC().addActionListener(listenerValidarC);
		panelVentas.getBtnBuscarVehiculo().addActionListener(listenerBuscarV);
		panelVentas.getBtnValidarDniG().addActionListener(listenerValidarG);
		panelVentas.getBtnVolverNewVenta().addActionListener(listenerVolverAVentas);
		panelVentas.getBtnAceptarNewVenta().addActionListener(listenerAceptarV);
		panelVentas.getBtnReset().addActionListener(listenerReiniciar);
		
		PantallaUtil.refresh(frame);
	}

//Busco DNI Comprador. Viene de Botón "Validar DNI" del Comprador en Nueva Venta.
	@Override
	public int getDniBuscarC() {
		int dni;
		try {
			 dni = Integer.parseInt(panelVentas.getDniCompradorText().getText());
		    }
		    catch (NumberFormatException e) {
		     dni = 0;
		    }
		return dni;
	}
	
//Busco DNI Garante. Viene de Botón "Validar DNI" del garante en Nueva Venta.
	
	@Override
	public int getDniBuscarG() {
		int dni;
		try {
			 dni = Integer.parseInt(panelVentas.getDniGaranteText().getText());
		    }
		    catch (NumberFormatException e) {
		     dni = 0;
		    }
		return dni;
	}


//Muestro Alta Cliente. Viene de Validar cliente -> Cliente no encontrado -> Acepto registrarlo.
	@Override
	public void altaCliente(int dni) {
		
		panelClientes = new PanelClientes();
		
		panelVentas.setVisible(false);
		
		PantallaUtil.refresh(frame);
		
		panelClientes.onAltaFromVenta(dni);
		
		frame.add(panelClientes);
		
		PantallaUtil.refresh(frame);
		
		listenerAltaAceptar = new ListenerAltaClienteV(ventasController);
		
		panelClientes.getBtnAceptar().addActionListener(listenerAltaAceptar);
		
	}



//	Traigo Persona a dar de alta desde el Panel Alta Cliente.
	@Override
	public Persona getPersonaAlta() {
		return panelClientes.getUpdatePersona();
	}

//Muestro Alta Garante. Viene de Validar Garante -> Garante no encontrado -> Acepto registrarlo.
	@Override
	public void altaGarante(int dni){
		
		panelClientes = new PanelClientes();
		
		panelVentas.setVisible(false);
		
		PantallaUtil.refresh(frame);
		
		panelClientes.onAltaFromVenta(dni);
		
		frame.add(panelClientes);
		
		PantallaUtil.refresh(frame);
		
		listenerAltaAceptarG = new ListenerAltaGaranteV(ventasController);
		
		panelClientes.getBtnAceptar().addActionListener(listenerAltaAceptarG);
		
	}
	
	
	
	


//Muestro Cliente encontrado. Viene de Validar cliente -> Garante Encontrado.
	@Override
	public void mostrarCliente(Persona cliente) {

		if (panelClientes != null){
		panelClientes.setVisible(false);}
	
		panelVentas.mostrarCliente(cliente);
		panelVentas.setVisible(true);
		
		PantallaUtil.refresh(frame);
		
	}
	
//Muestro Garante encontrado. Viene de Validar Garante -> Garante encontrado.
	@Override
	public void mostrarPatente(Vehiculo vehiculo) {
		
		if(panelVehiculos!= null){
			frame.remove(panelVehiculos);
			panelVentas.getPatenteText().setText(vehiculo.getPatente());
			panelVentas.setVisible(true);
		}
		
		panelVentas.mostrarPatente(vehiculo);
		
		PantallaUtil.refresh(frame);
		
	}

//Muestro Garante encontrado. Viene de Validar Garante -> Garante encontrado.
	@Override
	public void mostrarGarante(Persona garante) {

		if (panelClientes != null){
			panelClientes.setVisible(false);}
			
		panelVentas.mostrarGarante(garante);
		panelVentas.setVisible(true);
		
		PantallaUtil.refresh(frame);
		
	}



//  Envia la patente ingresada en Nueva Venta.
	@Override
	public String getPatenteBuscar() {
		return panelVentas.getPatenteText().getText();
	}

	
	@Override
	public void cleanPanelVentas() {
		panelVentas.removeAll();
		panelVentas.validate();
		panelVentas.repaint();
		
	}



//	Devuelve true si todos los botones estan not enabled. [Ya tuvieron validación]
	@Override
	public Boolean getButtonState() {
		return panelVentas.getButtonState();
	}


	@Override
	public void msjVentaIncompleta() {
		JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados no ha sido validado correctamente. Por favor revise y reintente nuevamente.");
		
	}




	@Override
	public void muestroStock(List<Stock> lista, ArrayList<String> comboMarca, ArrayList<String> comboModelo, ArrayList<String>comboYear) {
		
		panelVehiculos = new PanelVehiculos();
		panelVehiculos.muestroStock(lista);
		panelVehiculos.menuVentaStock();
		panelVehiculos.preparoFiltros(comboMarca, comboModelo, comboYear);
		
		frame.add(panelVehiculos);
		
		panelVentas.setVisible(false);
		
		listenerSeleccionar = new ListenerSeleccionar(ventasController);
		listenerDetalle = new ListenerDetalleVehiculo(ventasController);
		listenerVolverVenta = new ListenerVolverVentaStock(ventasController);
		listenerFiltroStock = new ListenerFiltroStock(ventasController);
		listenerYear = new ListenerCombo(ventasController);
		listenerMarca = new ListenerCombo(ventasController);
		

		panelVehiculos.getComboListMarca().addItemListener(listenerMarca);
		panelVehiculos.getComboListYear().addItemListener(listenerYear);
		
		panelVehiculos.getBtnFiltrar().addActionListener(listenerFiltroStock);
		panelVehiculos.getBtnVolverVenta().addActionListener(listenerVolverVenta);
		panelVehiculos.getBtnSeleccionar().addActionListener(listenerSeleccionar);
		panelVehiculos.getBtnDetalle().addActionListener(listenerDetalle);
		
		PantallaUtil.refresh(frame);
				
	}

	@Override
	public String getVehiculoTabla() {
		return panelVehiculos.getVehiculoTabla();
	}

	@Override
	public int msjSinPatente() {
		
		String s = new String("No se ha registrado el ingreso de una patente válida. ¿Desea ver los autos en stock?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Not Found", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);  
		return codigo;
		
	}

	@Override
	public void cleanStock() {
		
		frame.remove(panelVehiculos);
		panelVentas.setVisible(true);		
		PantallaUtil.refresh(frame);
	}


	@Override
	public void mostrarDetalleVehiculo(Vehiculo vehiculo){
		
		panelVehiculos.mostrarDetalleVehiculo(vehiculo);
		PantallaUtil.refresh(frame);	
	}


	@Override
	public void ingresarDetalleVenta(int idVenta, Persona cliente, Persona garante, Vehiculo vehiculo, int precio){
		
		PantallaUtil.remove(panelVentas);
		PantallaUtil.refresh(frame);
		
		panelVentas.ingresarDetalleVenta(idVenta, cliente, garante, vehiculo,precio);
		
		listenerDate= new ListenerDate(ventasController);
		
		panelVentas.getCuotasText().addKeyListener(new ListenerCuotas(ventasController));
		
		panelVentas.getDateChooser().getDateEditor().addPropertyChangeListener(listenerDate);
		
		listenerAceptarDetalle = new ListenerAceptarDetalle(ventasController);		
		panelVentas.getBtnAceptarDetalle().addActionListener(listenerAceptarDetalle);
		
		listenerAdqUnidad = new ListenerAdqUnidad(ventasController);
		panelVentas.getBtnAdqUnidad().addActionListener(listenerAdqUnidad);
	}

	@Override
	public void msjVentaError() {
		
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el vehiculo. Por favor, realice la baja de stock manualmente.");
		
	}
	
	@Override
	public int getCuotas() {
		int cuota;
		
		try {
			cuota = Integer.valueOf(panelVentas.getCuotasText().getText());
		} catch (NumberFormatException e) {
			cuota = 0;
		}
		return cuota;
	}

	@Override
	public void cargarTabla(List<Cuota> lista) {
		panelVentas.cargarTabla(lista);		
	}

	@Override
	public Double getSaldo() {
		return Double.valueOf(panelVentas.getSaldoText().getText());
	}


	@Override
	public DetalleVenta getNewDetalle() {
		return panelVentas.getNewDetalle();
	}

	@Override
	public void mostrarBuscarVenta() {
		panelVentas.buscarVenta();
		
		listenerBuscarClienteVentas = new ListenerBuscarClienteVentas(ventasController);
		listenerVolverAVentas = new ListenerVolverVentas(ventasController);
		
		panelVentas.getBtnBuscar().addActionListener(listenerBuscarClienteVentas);
		panelVentas.getBtnVolver().addActionListener(listenerVolverAVentas);
		
		
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
	public void ventaDesdeCliente(String dni) {

		panelVentas.showNuevaVenta();
		
		listenerValidarC = new ListenerValidarC(ventasController);
		listenerBuscarV = new ListenerBuscarVehiculoV(ventasController);
		listenerValidarG = new ListenerValidarG(ventasController);
		listenerVolverAVentas = new ListenerVolverVentas(ventasController);
		listenerAceptarV = new ListenerValidarVenta(ventasController);
		listenerReiniciar = new ListenerReiniciarVenta(ventasController);
		
		panelVentas.getBtnValidarDniC().addActionListener(listenerValidarC);
		panelVentas.getBtnBuscarVehiculo().addActionListener(listenerBuscarV);
		panelVentas.getBtnValidarDniG().addActionListener(listenerValidarG);
		panelVentas.getBtnVolverNewVenta().addActionListener(listenerVolverAVentas);
		panelVentas.getBtnAceptarNewVenta().addActionListener(listenerAceptarV);
		panelVentas.getBtnReset().addActionListener(listenerReiniciar);

		panelVentas.getDniCompradorText().setText(dni);
		
		try {
			ventasController.validarCliente();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		PantallaUtil.refresh(frame);
		
	
	}

	@Override
	public void ventaDesdeVehiculo(String dominio) {

		panelVentas.showNuevaVenta();
		
		listenerValidarC = new ListenerValidarC(ventasController);
		listenerBuscarV = new ListenerBuscarVehiculoV(ventasController);
		listenerValidarG = new ListenerValidarG(ventasController);
		listenerVolverAVentas = new ListenerVolverVentas(ventasController);
		listenerAceptarV = new ListenerValidarVenta(ventasController);
		listenerReiniciar = new ListenerReiniciarVenta(ventasController);
		
		panelVentas.getBtnValidarDniC().addActionListener(listenerValidarC);
		panelVentas.getBtnBuscarVehiculo().addActionListener(listenerBuscarV);
		panelVentas.getBtnValidarDniG().addActionListener(listenerValidarG);
		panelVentas.getBtnVolverNewVenta().addActionListener(listenerVolverAVentas);
		panelVentas.getBtnAceptarNewVenta().addActionListener(listenerAceptarV);
		panelVentas.getBtnReset().addActionListener(listenerReiniciar);

		panelVentas.getPatenteText().setText(dominio);
		
		try {
			ventasController.buscarVehiculo();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		PantallaUtil.refresh(frame);
		
		
	}

	@Override
	public String getVehiculoAdq() {
		return panelVentas.getNuevaPatenteText().getText();
		
	}


	@Override
	public PanelVentas getPanelVentas() {
		return panelVentas;
		
	}

	@Override
	public void prosigoVenta(String patente,Integer precio, String texto) {
	
		System.out.println("prosigoVenta");
		panelVentas.actualizoNuevaUnidad(patente, precio, texto);
		PantallaUtil.refresh(frame);
		
	}

	@Override
	public Date getDateCuotas() {
		try {
			return panelVentas.getDateChooser().getDate();
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public void muestroVentas(List<Venta> lista) {
		
		panelVentas.preparoComboVentas(lista);
		

		listenerUnaVenta = new ListenerUnaVenta(ventasController);
		

		panelVentas.getBtnBuscar().addActionListener(listenerUnaVenta);
		
		
	}

	
	@Override
	public String getVenta() {
		// TODO Auto-generated method stub
		return panelVentas.getComboVentas().getSelectedItem().toString();
				
	}

	@Override
	public void mostrarVenta(MuestroVenta v,  List<Cuota> c) {
		panelVentas.mostrarVenta(v, c);
		
		listenerPagarCuota = new ListenerPagarCuota(ventasController); 
		
		panelVentas.getBtnPagarCuota().addActionListener(listenerPagarCuota);
		
	}

	@Override
	public Cuota getCuotaTabla() {
		return panelVentas.getCuotaTabla();
	}

	
}