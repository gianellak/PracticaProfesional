package moduloClientes;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objetos.Persona;
import objetos.Usuario;
import utilitarios.PantallaUtil;
import moduloClientes.listener.*;
import moduloClientes.paneles.*;
import moduloPrincipal.paneles.PanelGeneral;

public class ClientesView implements ClientesInterface {
	
	private JFrame frame;
	private PanelClientes panelClientes;
	private ListenerClientesVolver listenerVolver;
	private ListenerClientesVer listenerVer;
	private ClientesMenu panelClientesMenu;
	private ListenerClientesAlta listenerAlta;
	private ListenerAltaAceptar listenerAltaAceptar;
	private ListenerMenuClientesVolver listenerMenuClientesVolver;
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
		frame.setTitle("Menu Clientes");
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
	public void onAlta() {
		
		PantallaUtil.remove(panelClientes);
		
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
		
		PantallaUtil.remove(panelClientes);
		
		//panelClientes.onVer();
		
		
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);
		
		
		PantallaUtil.refresh(frame);
		
		
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

		PantallaUtil.remove(panelClientes);
		
		panelClientes.onMod();
		
		listenerBuscarCliente= new ListenerBuscarCliente(clientesController);
		panelClientes.getBtnBuscar().addActionListener(listenerBuscarCliente);
		listenerMenuClientesVolver = new ListenerMenuClientesVolver(clientesController);
		panelClientes.getBtnVolver().addActionListener(listenerMenuClientesVolver);

		PantallaUtil.refresh(frame);
		
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


	@Override
	public Persona getUpdatePersona() {
		
		return panelClientes.getUpdatePersona();
		
	}





	@Override
	public PanelClientes getPanelClientes() {
		return panelClientes;
	}

	
	



}
