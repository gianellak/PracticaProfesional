package moduloPrincipal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listeners.ListenerC;
import listeners.ListenerL;
import moduloCobranzas.ventas.VentasInterface;
import moduloPrincipal.listenerPrincipal.ListenerCaja;
import moduloPrincipal.listenerPrincipal.ListenerCliente;
import moduloPrincipal.listenerPrincipal.ListenerSalirPrincipal;
import moduloPrincipal.listenerPrincipal.ListenerUsuario;
import moduloPrincipal.listenerPrincipal.ListenerVehiculo;
import moduloPrincipal.listenerPrincipal.ListenerVenta;
import moduloPrincipal.paneles.PanelGeneral;
import moduloPrincipal.paneles.PanelMenu;

public class PrincipalView implements PrincipalInterface {
	
	private JFrame frmPrin;
	private ListenerSalirPrincipal listenerCV;
	private ListenerVehiculo listenerVehiculo;
	private ListenerVenta listenerVenta;
	private ListenerCliente listenerCliente;
	private ListenerCaja listenerCaja;
	private PanelGeneral panelGeneral;
	private JPanel contentPanel;
	private PanelMenu contentPane;
	private PrincipalController pc;
	private ListenerUsuario listenerUsuario;
	

	public PrincipalView(){
	
		//FRAME
		frmPrin = new JFrame("Menu Principal");
		frmPrin.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frmPrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		//PANELES
		
		contentPane =new PanelMenu();
		contentPanel =new JPanel();

		
		}


	@Override
	public void showPrincipal(PrincipalController principalController) {
		
		pc = principalController;
		
		
		panelGeneral = new PanelGeneral(pc.getUser());
		
		listenerCV = new ListenerSalirPrincipal(pc);
		listenerVenta = new ListenerVenta(pc);
		listenerVehiculo = new ListenerVehiculo(pc);
		listenerCaja= new ListenerCaja(pc);
		listenerCliente= new ListenerCliente(pc);
		listenerUsuario= new ListenerUsuario(pc);
		
		
		contentPane.getBtnVehiculo().addActionListener(listenerVehiculo);
		contentPane.getBtnVenta().addActionListener(listenerVenta);
		contentPane.getBtnSalir().addActionListener(listenerCV);
		contentPane.getBtnCliente().addActionListener(listenerCliente);
		contentPane.getBtnUsuario().addActionListener(listenerUsuario);
		contentPane.getBtnCaja().addActionListener(listenerCaja);
		
		
		frmPrin.add(panelGeneral);
		
		frmPrin.add(contentPane);
		
		
		frmPrin.setVisible(true);
		
	}


	@Override
	public void closePrincipal() {

		frmPrin.dispose();
		
	}


	@Override
	public void showVenta(VentasInterface sc) {
		// TODO Auto-generated method stub
		
	}




}
















