package moduloCaja;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import objetos.*;
import utilitarios.PantallaUtil;
import moduloPrincipal.paneles.PanelGeneral;
import moduloCaja.listener.*;
import moduloCaja.paneles.*;


public class CajaView implements CajaInterface {
	
	private JFrame frame;
	private CajaController cajaController;
	private PanelCaja panelCaja;
	private CajaMenu panelCajaMenu;
	private ListenerCajaVolver listenerCajaVolver;
	private Usuario usuario;
	private ListenerVerMovimientos listenerVerMovimientos;
	private ListenerAltaMovimiento listenerAltaMovimiento;
	private ListenerVerOtrosMovimientos listenerVerOtrosMovimientos;
	private Object pantallaCaja;
	private ListenerDate listenerDate;
	private ListenerCajaVolver listenerVolver;
	private ListenerLogMovimiento listenerLog;
	private ListenerModMovimiento listenerModMovimiento;
	private ListenerEliminarMovimiento listenerEliminarMovimiento;
	private ListenerAceptarMod listenerAceptarMod;

	public CajaView(){
	
		panelCajaMenu= new CajaMenu();
		panelCaja = new PanelCaja();
	
	}

	@Override
	public void showMenuCaja(CajaController cc, JFrame f, Usuario u) {
		
		usuario = u;
		
		System.out.println("SHOW CAJA");
		
		cajaController = cc;
		frame = f;
		
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		listenerCajaVolver= new ListenerCajaVolver(cc);
		listenerVerMovimientos =new ListenerVerMovimientos(cc);
		listenerVerOtrosMovimientos =new ListenerVerOtrosMovimientos(cc);
		
	
		panelCajaMenu.getBtnVolver().addActionListener(listenerCajaVolver);
		panelCajaMenu.getBtnVerMovs().addActionListener(listenerVerMovimientos);
		panelCajaMenu.getBtnVerUnDia().addActionListener(listenerVerOtrosMovimientos);
		
		
			
		frame.setTitle("Menu Caja");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
		frame.getContentPane().add(panelCajaMenu, BorderLayout.WEST);
		frame.getContentPane().add(panelCaja, BorderLayout.LINE_END);
		frame.validate();
		frame.repaint();
		
		
	}



	
	@Override
	public void onVer(int i, List<Movimiento> lista) {
		
		PantallaUtil.remove(panelCaja);
		
		panelCaja.onVer(usuario, lista);
		
		panelCaja.onAlta(i, usuario);
		
		
		listenerVolver = new ListenerCajaVolver(cajaController);
		listenerAltaMovimiento = new ListenerAltaMovimiento(cajaController);
		listenerModMovimiento = new ListenerModMovimiento(cajaController);
		listenerEliminarMovimiento = new ListenerEliminarMovimiento(cajaController);
		
		
		panelCaja.getBtnMod().addActionListener(listenerModMovimiento);
		panelCaja.getBtnEliminar().addActionListener(listenerEliminarMovimiento);
		
		panelCaja.getBtnAlta().addActionListener(listenerAltaMovimiento);
		
		panelCaja.getBtnVolver().addActionListener(listenerCajaVolver);
		
		
		PantallaUtil.refresh(frame);
	
	}
	
	

	@Override
	public int getBajaMovimiento() {

		return 0;
	}



// NO HAY MODIFICACIÓN DE MOVIMIENTOS
	
//	@Override 
//	public void onMod() {
//		
//		panelClientes.removeAll();
//		panelClientes.validate();
//		panelClientes.repaint();
//		
//		panelClientes.onMod();
//		
//		listenerModAceptar = new ListenerModAceptar(clientesController);
//		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
//		
//		panelClientes.getBtnAceptar().addActionListener(listenerModAceptar);
//		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
//		
//		
//		frame.validate();
//		frame.repaint();
//		
//	}


	@Override
	public Movimiento getNuevoMovimiento() {
		
		return panelCaja.getNuevoMovimiento();
	}

	

	@Override
	public void verOtrosMovimientos() {
	
		PantallaUtil.remove(panelCaja);
		
		panelCaja.onVerOtro(usuario);
		
		listenerDate = new ListenerDate(cajaController); 
		
		panelCaja.getDateChooser().getDateEditor().addPropertyChangeListener(listenerDate);
		
		listenerVolver = new ListenerCajaVolver(cajaController);
		listenerLog = new ListenerLogMovimiento(cajaController);

		
		panelCaja.getBtnVolver().addActionListener(listenerCajaVolver);
		panelCaja.getBtnLog().addActionListener(listenerLog);

		
		
		PantallaUtil.refresh(frame);
		
	}

	
	@Override
	public void abroCaja() {

		PantallaUtil.remove(panelCaja);
		
		panelCaja.abroCaja(usuario);
		

		listenerAltaMovimiento = new ListenerAltaMovimiento(cajaController);
		
		panelCaja.getBtnAbrir().addActionListener(listenerAltaMovimiento);
		
		PantallaUtil.refresh(frame);
		
		
	}

	@Override
	public void onVerOtro(List<Movimiento> lista, String date) {

		panelCaja.verDia(lista, date);
		
	}

	@Override
	public void cleanPanelCaja() {
		PantallaUtil.remove(panelCaja);
		
	}

	@Override
	public String getMovimientoTabla() {
		return panelCaja.getMovimientoTabla();
	}

	@Override
	public void mostrarMovimientoMod(Movimiento m) {
		
		panelCaja.mostrarMovimientoMod(m);
		
		listenerAceptarMod = new ListenerAceptarMod(cajaController);
		panelCaja.getBtnAlta().removeActionListener(listenerAltaMovimiento);
		panelCaja.getBtnAlta().addActionListener(listenerAceptarMod);
		
		
		
	}


}
