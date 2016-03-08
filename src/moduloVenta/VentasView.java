package moduloVenta;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objetos.Cuota;
import objetos.Persona;
import objetos.Stock;
import objetos.Usuario;
import objetos.Vehiculo;
import utilitarios.PantallaUtil;
import moduloClientes.paneles.*;
import moduloPrincipal.paneles.PanelGeneral;
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
	private ListenerComboModelo listenerComboModelo;
	private ListenerReiniciarVenta listenerReiniciar;
	private ListenerDate listenerDate;

	public VentasView(){
		panelVentasMenu= new VentasMenu();
		panelVentas = new PanelVentas();
	
	}


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
		panelVentasMenu.getBtnNuevaCompra().addActionListener(listenerNuevaCompra);
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
		listenerComboModelo = new ListenerComboModelo(ventasController);

		panelVehiculos.getComboListModelo().addActionListener(listenerComboModelo);
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
	public void ingresarDetalleVenta(int idVenta, String cliente, String garante, String vehiculo, int precio){
		
		PantallaUtil.remove(panelVentas);
		PantallaUtil.refresh(frame);
		
		panelVentas.ingresarDetalleVenta(idVenta, cliente, garante, vehiculo,precio);
		listenerDate= new ListenerDate(ventasController);
		panelVentas.getDateChooser().getDateEditor().addPropertyChangeListener(listenerDate);
	}

	@Override
	public void msjVentaError() {
		
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el vehiculo. Por favor, realice la baja de stock manualmente.");
		
	}
	
	//
	
	@Override
	public int getCuotas() {
		
		return Integer.valueOf(panelVentas.getCuotasText().getText());
	}

	@Override
	public void cargarTabla(List<Cuota> lista) {
		panelVentas.cargarTabla(lista);		
	}

	@Override
	public Double getSaldo() {
		return Double.valueOf(panelVentas.getSaldoText().getText());
	}

}