package moduloCaja;

import java.awt.BorderLayout;
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
		
		//new listeners -> HAY QUE CREAR LAS CLASES LISTENERS
		listenerCajaVolver= new ListenerCajaVolver(cc);
		listenerVerMovimientos =new ListenerVerMovimientos(cc);
		listenerVerOtrosMovimientos =new ListenerVerOtrosMovimientos(cc);
		//listenerVerLog =new ListenerVerLog(cc); [ADMIN]
		
		
		//ESTO VA A ANDAR CUANDO CREES LO LISTENER,NO HAY QUE TOCAR NADA ACA
		//OK TIA
		panelCajaMenu.getBtnVolver().addActionListener(listenerCajaVolver);
		panelCajaMenu.getBtnVerMovs().addActionListener(listenerVerMovimientos);
		panelCajaMenu.getBtnVerUnDia().addActionListener(listenerVerOtrosMovimientos);
		//panelClientesMenu.getBtnVerLog().addActionListener(listenerVerLog);
			
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
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAlta() {

		//PantallaUtil.remove(panelCaja);
		
		panelCaja.onAlta(usuario);
		
	//	listenerAltaAceptar = new ListenerAltaAceptar(clientesController);
		//listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
	//	panelClientes.getBtnAceptar().addActionListener(listenerAltaAceptar);
		//panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		//PantallaUtil.refresh(frame);	
	}

	@Override
	public void onVer(List<Movimiento> lista) {
		
		PantallaUtil.remove(panelCaja);
		
		panelCaja.onVer(usuario, lista);
		
		
//		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
		listenerAltaMovimiento = new ListenerAltaMovimiento(cajaController);
		
		panelCaja.getBtnAlta().addActionListener(listenerAltaMovimiento);
		
		
//		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
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
		
		panelCaja.removeAll();
		panelCaja.validate();
		panelCaja.repaint();
		
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
		
		
		
		PantallaUtil.refresh(frame);
		
	}




}
