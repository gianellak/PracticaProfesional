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
import moduloClientes.paneles.ClientesMenu;
import moduloClientes.paneles.PanelClientes;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.*;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioInterface;
import moduloClientes.listener.*;
import moduloPrincipal.paneles.PanelGeneral;
import moduloClientes.paneles.*;

public class CajaView implements CajaInterface {
	
	private JFrame frame;
	private PanelClientes panelClientes;
	private ListenerClientesVolver listenerVolver;
	private ListenerClientesVer listenerVer;
	private ClientesMenu panelClientesMenu;
	private ListenerClientesAlta listenerAlta;
	private ListenerAltaAceptar listenerAltaAceptar;
	private ListenerMenuClientesVolver listenerMenuClientesVolver;
	private ListenerMenuClientesVolver listenerBajaVolver;
	private ListenerBajaAceptar listenerBajaAceptar;
	private ListenerClientesBaja listenerBaja;
	private ListenerModAceptar listenerModAceptar;
	private ListenerClientesMod listenerMod;
	private CajaController clientesController;

	public CajaView(){
		
		
	
		panelClientesMenu= new ClientesMenu();
		panelClientes = new PanelClientes();
	
	}

	

	

	@Override
	public List<Usuario> findAll() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMenuClientes(CajaController cc,
			JFrame f, Usuario u) {
		
		System.out.println("SHO");
		
		clientesController = cc;
		frame = f;
		
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		//new listeners
		
		panelClientesMenu.getBtnVolver().addActionListener(listenerVolver);
		panelClientesMenu.getBtnVerU().addActionListener(listenerVer);
		panelClientesMenu.getBtnAltaU().addActionListener(listenerAlta);
		panelClientesMenu.getBtnBajaU().addActionListener(listenerBaja);
		panelClientesMenu.getBtnModU().addActionListener(listenerMod);
		panelClientesMenu.getBtnVerU().addActionListener(listenerVer);
		
		
		//frame.setVisible(false);
		frame.setTitle("Menu Usuarios");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
		frame.getContentPane().add(panelClientesMenu, BorderLayout.WEST);
		frame.getContentPane().add(panelClientes, BorderLayout.LINE_END);
		frame.validate();
		frame.repaint();
		//frame.setVisible(true);
		
		
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
		
		panelClientes.getBtnAceptar().addActionListener(listenerAltaAceptar);
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		frame.validate();
		frame.repaint();
		
	
		
	}

	@Override
	public void onVer(List<Usuario> lista) {
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
		panelClientes.onVer();
		
		
//		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
		
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		frame.validate();
		frame.repaint();
		
		
		
	}
	
	@Override
	public void onBaja() {
		
		panelClientes.removeAll();
		panelClientes.validate();
		panelClientes.repaint();
		
		panelClientes.onBaja();
		
		//listenerBajaAceptar = new ListenerBajaAceptar(clientesController);
		//listenerBajaVolver = new ListenerMenuClientesVolver(clientesController);
		
		panelClientes.getBtnAceptar().addActionListener(listenerBajaAceptar);
		panelClientes.getBtnVolver().addActionListener(listenerBajaVolver);
		
		
		frame.validate();
		frame.repaint();
		
		
		
	}
	
	public Usuario getNuevoUsuario(){
		
		String s = new String(panelClientes.getPasswordText().getPassword());
		
		Usuario u = new Usuario(panelClientes.getUserText().getText(), s,
				Integer.parseInt(panelClientes.getPermisosText().getText()), 
				panelClientes.getNombreText().getText(),
				panelClientes.getApellidoText().getText());
		
		return u;

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

		return Integer.parseInt(panelClientes.getDniText().getText());
		
		
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
		
		panelClientes.getBtnAceptar().addActionListener(listenerModAceptar);
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
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
