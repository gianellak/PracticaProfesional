package moduloCaja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;
import moduloClientes.listener.ListenerClientesVolver;
import moduloClientes.paneles.ClientesMenu;
import moduloClientes.paneles.PanelClientes;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.*;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioInterface;
import moduloCaja.listener.*;
import moduloCaja.paneles.CajaMenu;
import moduloCaja.paneles.PanelCaja;
import moduloPrincipal.paneles.PanelGeneral;
import moduloClientes.paneles.*;

public class CajaView implements CajaInterface {
	
	private JFrame frame;
	private PanelClientes panelClientes;
	private CajaController cajaController;
	private PanelCaja panelCaja;
	private CajaMenu panelCajaMenu;
	private ListenerCajaVolver listenerCajaVolver;

	public CajaView(){
		
		
	
		panelCajaMenu= new CajaMenu();
		panelCaja = new PanelCaja();
	
	}

	

	

	@Override
	public List<Usuario> findAll() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMenuCaja(CajaController cc,
			JFrame f, Usuario u) {
		
		System.out.println("SHOW CAJA");
		
		cajaController = cc;
		frame = f;
		
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		//new listeners -> HAY QUE CREAR LAS CLASES LISTENERS
		listenerCajaVolver= new ListenerCajaVolver(cc);
		//listenerVerMovimientos =new ListenerVerMovimientos(cc);
		//listenerAltaMovimientos =new ListenerAltaMovimientos(cc);
		//listenerVerLog =new ListenerVerLog(cc); [ADMIN]
		
		
		//ESTO VA A ANDAR CUANDO CREES LO LISTENER,NO HAY QUE TOCAR NADA ACA
		panelCajaMenu.getBtnVolver().addActionListener(listenerCajaVolver);
		//panelClientesMenu.getBtnVerMovs().addActionListener(listenerVerMovimientos);
		//panelClientesMenu.getBtnAltaMov().addActionListener(listenerAltaMovimientos);
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
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
		panelClientes.onAlta();
		
	//	listenerAltaAceptar = new ListenerAltaAceptar(clientesController);
		//listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
	//	panelClientes.getBtnAceptar().addActionListener(listenerAltaAceptar);
		//panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		frame.validate();
		frame.repaint();
		
	
		
	}

	@Override
	public void onVer(List<Usuario> lista) {
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
		//panelClientes.onVer();
		
		
//		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
		
//		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		frame.validate();
		frame.repaint();
		
		
		
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
	public void insertBad() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar el usuario. Por favor reintente");
		
	}





	@Override
	public int getBajaPersona() {

		return Integer.parseInt(panelClientes.getDniCompradorText().getText());
		
		
	}





	@Override
	public void cleanPanelClientes() {
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
	}





	@Override
	public void onMod() {
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
		panelClientes.onMod();
		
	//	listenerModAceptar = new ListenerModAceptar(clientesController);
	//  listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
		//panelClientes.getBtnAceptar().addActionListener(listenerModAceptar);
		//panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		frame.validate();
		frame.repaint();
		
	}





	@Override
	public void showNotFound() {
		
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar borrar el usuario. Por favor reintente");
			
		
		
	}





	@Override
	public int showToDelete(Persona p) {
		
		String s = new String("¿Esta seguro que desea eliminar el usuario: " + p.getApellido() + " " + p.getNombre() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar Persona", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
		
		
	}





	@Override
	public void deleteOk() {
		JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
	}





	@Override
	public void deleteBad() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Persona getNuevoCliente() {
		// TODO Auto-generated method stub
		return null;
	}






}
