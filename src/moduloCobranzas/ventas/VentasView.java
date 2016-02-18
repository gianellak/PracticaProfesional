package moduloCobranzas.ventas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Persona;
import objetos.Venta;
import listeners.*;
import moduloAdministracion.clienteABM.FormularioNuevaCompra;
import moduloAdministracion.clienteABM.FormularioNuevoCliente;
import moduloCobranzas.altaVenta.FormularioAlta;


public class VentasView implements VentasInterface {

	private JPanel panel;
	private JButton btnSalir;
	private JButton btnBuscar;
	private JFrame frmVentas;
	private JTextField userText;
	private JTextField autoText;
	private VentasController ventasController;
	private ListenerBuscar listenerBuscar;
	private ListenerSalirV listenerSalir;
	private DefaultTableModel model;
	private JTable table;
	private JLabel ventaLabel;
	private JButton btnNuevo;
	private ListenerNuevaV listenerNuevo;
	private FormularioAlta panelF;
	private ListenerVolverV listenerVolver;
	private ListenerAltaV listenerAlta;
	private FormularioNuevaCompra panelC;
	private FormularioNuevoCliente panelNC;
	private ListenerNuevoCliente listenerAltaCliente;
	
	public VentasView(){
		//FRAME
			frmVentas = new JFrame("Menu Ventas"); 
			//frmVentas.setSize(1000, 500);
			frmVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			//PANEL
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			frmVentas.add(panel);
		
			panel.setLayout(null);
		
			
			//BOTONES	
			
			panel.setLayout(null);

			JLabel userLabel = new JLabel("Buscar por DNI: ");
			userLabel.setBounds(100, 10, 160, 25);
			panel.add(userLabel);

			userText = new JTextField(9);
			userText.setBounds(100, 30, 160, 25);
			panel.add(userText);
			
			
			JLabel autoLabel = new JLabel("Buscar por Patente: ");
			autoLabel.setBounds(100, 50, 160, 25);
			panel.add(autoLabel);

			autoText = new JTextField(6);
			autoText.setBounds(100, 80, 160, 25);
			panel.add(autoText);

			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(100, 120, 80, 25);
			panel.add(btnBuscar);
			
			btnNuevo = new JButton("Ingresar nueva venta.");
			btnNuevo.setBounds(400, 120, 200, 25);
			panel.add(btnNuevo);

			btnSalir = new JButton("Salir");
			btnSalir.setBounds(100, 150, 80, 25);
			panel.add(btnSalir);
		
	}

	@Override
	public void showVenta(VentasController vc) {
		
		ventasController = vc;
		
		listenerBuscar = new ListenerBuscar(ventasController);
		listenerSalir = new ListenerSalirV(ventasController);
		listenerNuevo = new ListenerNuevaV(ventasController);
		
		btnBuscar.addActionListener(listenerBuscar);
		btnSalir.addActionListener(listenerSalir);
		btnNuevo.addActionListener(listenerNuevo);
		frmVentas.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frmVentas.setVisible(true);
		
	}

	@Override
	public int getDNI() {
		
		return Integer.parseInt(userText.getText());
	}

	@Override
	public String getPatente() {
		return new String(autoText.getText());
	}

	@Override
	public void closeVentas() {
		frmVentas.dispose();
		
	}

	@Override
	public void mostrarCompras(List<Venta> lista) {
		
		Venta a = lista.get(0);
		
		ventaLabel = new JLabel();
		
		ventaLabel.setText(a.getIdVenta() + "- Comprador: " + a.getDniComprador() +
				" Vehículo: " + a.getDesc() + "Patente: " + a.getPatente());
		
		ventaLabel.setBounds(100, 180, 500, 25);
		
		panel.add(ventaLabel);
		
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
			
		
		
	}

	@Override
	public void mostrarAltA() {
		
		panelF = new FormularioAlta();
		panel.setVisible(false);
		frmVentas.setTitle("Nueva Venta");
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
		
		frmVentas.add(panelF);
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
		
		listenerVolver = new ListenerVolverV(ventasController);
		listenerAlta= new ListenerAltaV(ventasController);
		
		panelF.getBtnCancelar().addActionListener(listenerVolver);
		panelF.getBtnAceptar().addActionListener(listenerAlta);
	}

	@Override
	public void refreshVenta() {
		
		frmVentas.remove(panelF);
		panelF = null;
		panel.setVisible(true);
		
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
		
		
	}

	@Override
	public Venta getNuevaVenta() {
		Venta v = new Venta(1, 
				Integer.parseInt(panelF.getDniCompradorText().getText()), 
				panelF.getPatenteText().getText(),
				Integer.parseInt(panelF.getDniGaranteText().getText()), 
				panelF.getDescripcionText().getText());
		
		return v;
	}
	@Override
	public Persona getNuevaPersona() {
		Persona p = new Persona(Integer.parseInt(panelNC.getDniCompradorText().getText()), 0, 0, 0, "Rachel", "Bronstein", "dom", "ciu", "pro", "domL", "Carrefour");
		
		return p;
	}

	@Override
	public void altaCliente(int dniCliente) {
		// TODO Auto-generated method stub
		
		panelNC = new FormularioNuevoCliente();
		panelF.setVisible(false);
		frmVentas.setTitle("Nuevo Cliente");
		frmVentas.add(panelNC);
		panelNC.getDniCompradorText().setText(String.valueOf(dniCliente));	
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
		
		listenerVolver = new ListenerVolverV(ventasController);
		
		
		listenerAltaCliente= new ListenerNuevoCliente(ventasController);
		
		panelNC.getBtnCancelar().addActionListener(listenerVolver);
		panelNC.getBtnAceptar().addActionListener(listenerAltaCliente);
		
	}
	
	@Override
	public void mostrarCliente(Persona p) {
		
		panelC = new FormularioNuevaCompra();
		panelF.setVisible(false);
		frmVentas.setTitle("Nueva Venta");
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
		panelC.getDniCompradorText().setText(String.valueOf(p.getDni()));		
		frmVentas.add(panelC);
		frmVentas.invalidate();
		frmVentas.validate();
		frmVentas.repaint();
		
		listenerVolver = new ListenerVolverV(ventasController);
		listenerAlta= new ListenerAltaV(ventasController);
		
		panelC.getBtnCancelar().addActionListener(listenerVolver);
		panelC.getBtnAceptar().addActionListener(listenerAlta);
		
	}


	

}