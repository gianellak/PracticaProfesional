package moduloPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import moduloCobranzas.ventas.VentasInterface;
import moduloPrincipal.listenerPrincipal.*;
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
		
		
		}


	@Override
	public void showPrincipal(PrincipalController principalController) {
		
		pc = principalController;
		
		
		panelGeneral = new PanelGeneral(pc.getUser());
		
		//CREATE LISTENERS
		listenerCV = new ListenerSalirPrincipal(pc);
		listenerVenta = new ListenerVenta(pc);
		listenerVehiculo = new ListenerVehiculo(pc);
		listenerCaja= new ListenerCaja(pc);
		listenerCliente= new ListenerCliente(pc);
		listenerUsuario= new ListenerUsuario(pc);
		
		//ADD LISTENER TO BUTTONS
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
















