package moduloCaja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import exceptions.DBException;
import objetos.*;
import utilitarios.PantallaUtil;
import moduloClientes.listener.ListenerClientesVolver;
import moduloClientes.paneles.*;
import moduloPrincipal.*;
import moduloPrincipal.paneles.PanelGeneral;
import moduloUsuarios.*;
import moduloCaja.listener.*;
import moduloCaja.paneles.*;


public class CajaView implements CajaInterface {
	
	private JFrame frame;
	private PanelClientes panelClientes;
	private CajaController cajaController;
	private PanelCaja panelCaja;
	private CajaMenu panelCajaMenu;
	private ListenerCajaVolver listenerCajaVolver;
	private Usuario usuario;
	private ListenerVerMovimientos listenerVerMovimientos;

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
		//listenerVerLog =new ListenerVerLog(cc); [ADMIN]
		
		
		//ESTO VA A ANDAR CUANDO CREES LO LISTENER,NO HAY QUE TOCAR NADA ACA
		//OK TIA
		panelCajaMenu.getBtnVolver().addActionListener(listenerCajaVolver);
		panelCajaMenu.getBtnVerMovs().addActionListener(listenerVerMovimientos);
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
		
		
//		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		PantallaUtil.refresh(frame);
	
	}
	
	@Override
	public void onBaja() {
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
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
		
		JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();		
	}

	@Override
	public void insertError() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar el movimiento. Por favor reintente");
	}


	@Override
	public int getBajaMovimiento() {

		return Integer.parseInt(panelClientes.getDniCompradorText().getText());
	}


	@Override
	public void cleanPanelClientes() {
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
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
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
	}

	public void deleteError() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar eliminar el movimiento. Por favor reintente");
	}


	@Override
	public Movimiento getNuevoMovimiento() {
		// TODO Auto-generated method stub
		return null;
	}


}
