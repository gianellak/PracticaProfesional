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
import listeners.ListenerV;
import listeners.ListenerCV;
import listenersVehiculo.ListenerVehiculo;
import moduloCobranzas.ventas.VentasInterface;

public class PrincipalView implements PrincipalInterface {
	
	private JFrame frmPrin;
	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnVehiculo;
	private JButton btnVenta;
	private PrincipalController pc;
	private ListenerCV listenerCV;
	private ListenerVehiculo listenerVehiculo;
	private ListenerV listenerVenta;
	private PanelGeneral panelGeneral;
	private JPanel contentPanel;
	private PanelMenu contentPane1;
	private JButton btnCliente;
	private JButton btnCaja;


	public PrincipalView(){
	
		//FRAME
		frmPrin = new JFrame("Menu Principal");
		frmPrin.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frmPrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		//PANEL
		
		contentPane =new PanelMenu();
		contentPanel =new JPanel();

		
		//BOTONES	
			
		btnVehiculo= new JButton("Menu Usuario ");
		btnVehiculo.setBounds(50, 130, 200, 25);
		contentPane.add(btnVehiculo);
		
		btnCliente= new JButton("Menu Cliente");
		btnCliente.setBounds(50, 160, 200, 25);
		contentPane.add(btnCliente);
	
		btnVenta= new JButton("Menu Ventas");
		btnVenta.setBounds(50, 190, 200, 25);
		contentPane.add(btnVenta);

		btnVehiculo= new JButton("Menu Vehículo");
		btnVehiculo.setBounds(50, 220, 200, 25);
		contentPane.add(btnVehiculo);

		btnCaja= new JButton("Menu Caja ");
		btnCaja.setBounds(50, 250, 200, 25);
		contentPane.add(btnCaja);
		
		btnSalir= new JButton("Salir ");
		btnSalir.setBounds(50, 280, 100, 25);
		contentPane.add(btnSalir);
		
	

		}


	@Override
	public void showPrincipal(PrincipalController principalController) {
		pc = principalController;
		
		
		panelGeneral = new PanelGeneral(pc.getUser());
		
		listenerCV = new ListenerCV(pc);
		listenerVehiculo = new ListenerVehiculo(pc);
		listenerVenta = new ListenerV(pc);
		
		
		btnVehiculo.addActionListener(listenerVehiculo);
		btnVenta.addActionListener(listenerVenta);
		btnSalir.addActionListener(listenerCV);
		
		
		frmPrin.add(panelGeneral);
		
		frmPrin.add(contentPane);
		
		//frmPrin.add(contentPanel);

		
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
