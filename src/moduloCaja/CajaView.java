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
	public void onVer(List<Movimiento> lista) {
		
		PantallaUtil.remove(panelCaja);
		
		panelCaja.onVer(usuario, lista);
		
		panelCaja.onAlta(usuario);
		
		
		listenerVolver = new ListenerCajaVolver(cajaController);
		listenerAltaMovimiento = new ListenerAltaMovimiento(cajaController);
		
		panelCaja.getBtnAlta().addActionListener(listenerAltaMovimiento);
		
		panelCaja.getBtnVolver().addActionListener(listenerCajaVolver);
		
		
		PantallaUtil.refresh(frame);
	
	}
	
	@Override
	public void onBaja() {
		
		
	//	panelClientes.onBaja();
		
		//listenerBajaAceptar = new ListenerBajaAceptar(clientesController);
		//listenerBajaVolver = new ListenerMenuClientesVolver(clientesController);
		
		//panelClientes.getBtnAceptar().addActionListener(listenerBajaAceptar);
		//panelClientes.getBtnVolver().addActionListener(listenerBajaVolver);
		
		
		frame.validate();
		frame.repaint();
	}
	
	@Override
	public void insertOk() {
		
		JOptionPane.showMessageDialog(null, "Movimiento agregado correctamente");
		
		PantallaUtil.remove(panelCaja);		
	}

	@Override
	public void insertError() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar el movimiento. Por favor reintente");
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
	public void showNotFound() {
		
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar borrar el movimiento. Por favor reintente");	
		
	}

	
	public void showToDelete(Movimiento v) {
		
//		String s = new String("¿Esta seguro que desea eliminar el usuario: " + p.getApellido() + " " + p.getNombre() + "?");
//		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar Persona", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
//       
//		return codigo;
//		
		
	}


	@Override
	public void deleteOk() {
		JOptionPane.showMessageDialog(null, "Movimiento borrado correctamente");
		
		PantallaUtil.remove(panelCaja);
		
	}

	public void deleteError() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar eliminar el movimiento. Por favor reintente");
	}


	@Override
	public Movimiento getNuevoMovimiento() {
		
		return panelCaja.getNuevoMovimiento();
	}

	@Override
	public void primerMovimiento() {
		JOptionPane.showMessageDialog(null, "No hay movimientos registrados al día de la fecha. Deberá realizar la apertura de la caja.");
		
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


}
