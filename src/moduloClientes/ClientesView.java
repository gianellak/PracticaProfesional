package moduloClientes;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exceptions.DBException;
import objetos.Persona;
import objetos.Usuario;
import moduloClientes.paneles.ClientesMenu;
import moduloClientes.paneles.PanelClientes;
import moduloClientes.listener.*;
import moduloPrincipal.paneles.PanelGeneral;
import moduloClientes.paneles.*;

public class ClientesView implements ClientesInterface {
	
	private JFrame frame;
	private PanelClientes panelClientes;
	private ListenerClientesVolver listenerVolver;
	private ListenerClientesVer listenerVer;
	private ClientesMenu panelClientesMenu;
	private ListenerClientesAlta listenerAlta;
	private ListenerAltaAceptar listenerAltaAceptar;
	private ListenerMenuClientesVolver listenerMenuClientesVolver;
	private ListenerMenuClientesVolver listenerBajaVolver;
	private ListenerModAceptar listenerModAceptar;
	private ClientesController clientesController;
	private ListenerBuscarCliente listenerBuscarCliente;
	private ListenerClientesMod listenerClientesMod;
	private ListenerClientesBaja listenerClientesBaja;
	private ListenerClientesVenta listenerClientesVenta;
	private ListenerClientesCompra listenerClientesCompra;

	public ClientesView(){
		
		
	
		panelClientesMenu= new ClientesMenu();
		panelClientes = new PanelClientes();
	
	}

	

	

	@Override
	public List<Usuario> findAll() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMenuClientes(ClientesController cc,
			JFrame f, Usuario u) {
		
		System.out.println("SHO");
		
		clientesController = cc;
		frame = f;
		
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		listenerVolver = new ListenerClientesVolver(cc);
		listenerAlta = new ListenerClientesAlta(cc);
		listenerVer= new ListenerClientesVer(cc);
		
		panelClientesMenu.getBtnVolver().addActionListener(listenerVolver);
		panelClientesMenu.getBtnVerC().addActionListener(listenerVer);
		panelClientesMenu.getBtnAltaC().addActionListener(listenerAlta);
		
		
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
		
		listenerAltaAceptar = new ListenerAltaAceptar(clientesController);
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
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
		
		//panelClientes.onVer();
		
		
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		
		
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
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
		
		listenerBuscarCliente= new ListenerBuscarCliente(clientesController);
		panelClientes.getBtnBuscar().addActionListener(listenerBuscarCliente);
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
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





	@Override
	public void verCliente(Persona p) {
		
		panelClientes.verCliente(p);
		
		//NEW LISTENERS
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		listenerClientesMod =new ListenerClientesMod(clientesController);
		listenerClientesBaja =new ListenerClientesBaja(clientesController);
		listenerClientesVenta =new ListenerClientesVenta(clientesController);
		listenerClientesCompra =new ListenerClientesCompra(clientesController);
	
		//ADD LISTENERS
		panelClientes.getBtnModificar().addActionListener(listenerClientesMod);
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		panelClientes.getBtnVender().addActionListener(listenerClientesVenta);
		panelClientes.getBtnComprar().addActionListener(listenerClientesCompra);
		panelClientes.getBtnEliminar().addActionListener(listenerClientesBaja);
	
	}
	

	@Override
	public void verMod() {
		
		panelClientes.verMod();
		
		//LISTENERS
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		listenerModAceptar = new ListenerModAceptar(clientesController);
		
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		panelClientes.getBtnAceptar().addActionListener(listenerModAceptar);
		
		
		
	}





	@Override
	public int getModPersona() {
		return Integer.parseInt(panelClientes.getDniCompradorText().getText());
	}






}
