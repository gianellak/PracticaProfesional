package moduloPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import moduloCobranzas.ventas.VentasInterface;
import moduloPrincipal.listener.*;
import moduloPrincipal.paneles.PanelAux;
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
	private PanelMenu panelMenu;
	private PrincipalController pc;
	private ListenerUsuario listenerUsuario;
	private PanelAux panelAux;
	

	public PanelGeneral getPanelGeneral() {
		return panelGeneral;
	}


	public void setPanelGeneral(PanelGeneral panelGeneral) {
		this.panelGeneral = panelGeneral;
	}


	public PanelMenu getPanelMenu() {
		return panelMenu;
	}


	public void setPanelMenu(PanelMenu panelMenu) {
		this.panelMenu = panelMenu;
	}


	public PanelAux getPanelAux() {
		return panelAux;
	}


	public void setPanelAux(PanelAux panelAux) {
		this.panelAux = panelAux;
	}


	public PrincipalView(){
	
		//FRAME
		frmPrin = new JFrame("Menu Principal");
		frmPrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrin.getContentPane().setLayout(new BorderLayout());
		frmPrin.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		}


	@Override
	public void showPrincipal(PrincipalController principalController) {
		
		pc = principalController;
		
		//PANELES
		panelMenu =new PanelMenu();
		panelAux = new PanelAux();
		panelGeneral = new PanelGeneral(pc.getUser());
		
		if (pc.getUser().getPermisos() != 0){
			panelMenu.getBtnUsuario().setVisible(false);
		}
		
		frmPrin.setTitle("Menu Principal");
		
		
		//CREATE LISTENERS
		listenerCV = new ListenerSalirPrincipal(pc);
		listenerVenta = new ListenerVenta(pc);
		listenerVehiculo = new ListenerVehiculo(pc);
		listenerCaja= new ListenerCaja(pc);
		listenerCliente= new ListenerCliente(pc);
		listenerUsuario= new ListenerUsuario(pc);
		
		//ADD LISTENER TO BUTTONS
		panelMenu.getBtnVehiculo().addActionListener(listenerVehiculo);
		panelMenu.getBtnVenta().addActionListener(listenerVenta);
		panelMenu.getBtnSalir().addActionListener(listenerCV);
		panelMenu.getBtnCliente().addActionListener(listenerCliente);
		panelMenu.getBtnUsuario().addActionListener(listenerUsuario);
		panelMenu.getBtnCaja().addActionListener(listenerCaja);
		
		//ADD PANELS TO FRAME
		frmPrin.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
        frmPrin.getContentPane().add(panelMenu, BorderLayout.WEST);
        frmPrin.getContentPane().add(panelAux, BorderLayout.LINE_END);

        //frmPrin.pack();
        frmPrin.validate();
		frmPrin.repaint();
		frmPrin.setVisible(true);
		
	}


	@Override
	public void closePrincipal() {

		frmPrin.dispose();
		
	}


	@Override
	public JFrame getPView() {
		// TODO Auto-generated method stub
		return frmPrin;
	}
	
	@Override
	public PanelGeneral getGeneral() {
		// TODO Auto-generated method stub
		return panelGeneral;
	}


	@Override
	public void getBack() {
	
		frmPrin.getContentPane().removeAll();
		this.showPrincipal(pc);
		
	}


	



}
















