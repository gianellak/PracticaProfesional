package moduloVenta;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objetos.Persona;
import objetos.Usuario;
import objetos.Vehiculo;
import utilitarios.PantallaUtil;
import moduloClientes.paneles.*;
import moduloPrincipal.paneles.PanelGeneral;
import moduloVenta.listener.ListenerAltaClienteV;
import moduloVenta.listener.ListenerAltaGaranteV;
import moduloVenta.listener.ListenerBuscarVehiculoV;
import moduloVenta.listener.ListenerNuevaCompra;
import moduloVenta.listener.ListenerNuevaVenta;
import moduloVenta.listener.ListenerValidarC;
import moduloVenta.listener.ListenerValidarG;
import moduloVenta.listener.ListenerValidarVenta;
import moduloVenta.listener.ListenerVentasVolver;
import moduloVenta.listener.ListenerVolverVentas;
import moduloVenta.paneles.PanelVentas;
import moduloVenta.paneles.VentasMenu;

public class VentasView implements VentasInterface {
	
	private JFrame frame;
	private PanelVentas panelVentas;
	private VentasMenu panelVentasMenu;
	private VentasController ventasController;
	private ListenerVentasVolver listenerVolver;
	private ListenerNuevaVenta listenerNuevaVenta;
	private ListenerNuevaCompra listenerNuevaCompra;
	private ListenerValidarC listenerValidarC;
	private ListenerAltaClienteV listenerAltaAceptar;
	private PanelClientes panelClientes;
	private ListenerValidarG listenerValidarG;
	private ListenerAltaGaranteV listenerAltaAceptarG;
	private ListenerBuscarVehiculoV listenerBuscarV;
	private ListenerVolverVentas listenerVolverAVentas;
	private ListenerValidarVenta listenerAceptarV;

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
		
		panelVentas.getBtnValidarDniC().addActionListener(listenerValidarC);
		panelVentas.getBtnBuscarVehiculo().addActionListener(listenerBuscarV);
		panelVentas.getBtnValidarDniG().addActionListener(listenerValidarG);
		panelVentas.getBtnVolverNuevaV().addActionListener(listenerVolverAVentas);
		panelVentas.getBtnAceptarNuevaV().addActionListener(listenerAceptarV);
		
	}

//Busco DNI Comprador. Viene de Botón "Validar DNI" del Comprador en Nueva Venta.
	@Override
	public int getDniBuscarC() {
		try {
		return Integer.parseInt(panelVentas.getDniCompradorText().getText());
	    }
	    catch (NumberFormatException e) {
	        return 0;
	    }
	}
	
//Busco DNI Garante. Viene de Botón "Validar DNI" del garante en Nueva Venta.
	@Override
	public int getDniBuscarG() {
		try {
			return Integer.parseInt(panelVentas.getDniGaranteText().getText());
		}
		catch (NumberFormatException e) {
			return 0;
		}
	}

	@Override
	public void msjErrorDNI() {
		JOptionPane.showMessageDialog(null, "No ha ingresado un valor valido para el DNI . Por favor reintente");
		
	}

	@Override
	public int msjClienteNotFound() {
		
		String s = new String("Dni no registrado en el Sistema. Debera ingresar los datos para continuar con la venta.");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Not Found", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
		
	}

//Muestro Alta Cliente. Viene de Validar cliente -> Cliente no encontrado -> Acepto registrarlo.
	@Override
	public void altaCliente() {
		
		panelClientes = new PanelClientes();
		
		panelVentas.setVisible(false);
		
		PantallaUtil.refresh(frame);
		
		panelClientes.onAltaFromVenta(panelVentas.getDniCompradorText().getText());
		
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
	public void altaGarante() {
		
		panelClientes = new PanelClientes();
		
		panelVentas.setVisible(false);
		
		PantallaUtil.refresh(frame);
		
		panelClientes.onAltaFromVenta(panelVentas.getDniGaranteText().getText());
		
		frame.add(panelClientes);
		
		PantallaUtil.refresh(frame);
		
		listenerAltaAceptarG = new ListenerAltaGaranteV(ventasController);
		
		panelClientes.getBtnAceptar().addActionListener(listenerAltaAceptarG);
		
	}
	
	
	




	@Override
	public void insertOk() {
		
		JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
		
		panelClientes.setVisible(false);
		
		panelVentas.setVisible(true);
		
		PantallaUtil.refresh(frame);
		
	}
	
	@Override
	public void insertGaranteOk() {
		
		JOptionPane.showMessageDialog(null, "Garante agregado correctamente");
		
		panelClientes.setVisible(false);
		
		panelVentas.setVisible(true);
		
		PantallaUtil.refresh(frame);
		
	}


	@Override
	public void insertBad() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al dar de alta a la persona. Por favor reintente");
		
	}



//Muestro Cliente encontrado. Viene de Validar cliente -> Garante Encontrado.
	@Override
	public void mostrarCliente(Persona cliente) {
		
		panelVentas.mostrarCliente(cliente);
		
		PantallaUtil.refresh(frame);
		
	}
	
//Muestro Garante encontrado. Viene de Validar Garante -> Garante encontrado.
	@Override
	public void mostrarPatente(Vehiculo vehiculo) {
		
		panelVentas.mostrarPatente(vehiculo);
		
		PantallaUtil.refresh(frame);
		
	}

//Muestro Garante encontrado. Viene de Validar Garante -> Garante encontrado.
	@Override
	public void mostrarGarante(Persona garante) {
		
		panelVentas.mostrarGarante(garante);
		
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




	@Override
	public Boolean getButtonState() {
		return panelVentas.getButtonState();
	}


	@Override
	public void msjVentaIncompleta() {
		JOptionPane.showMessageDialog(null, "Alguno de los datos no ha ido validado correctamente. Por favor revise y reintente nuevamente.");
		
	}
}