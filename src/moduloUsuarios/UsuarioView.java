package moduloUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptions.DBException;
import objetos.Usuario;
import moduloClientes.paneles.PanelClientes;
import moduloClientes.paneles.ClientesMenu;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.PanelAux;
import moduloPrincipal.paneles.PanelMenu;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioInterface;
import moduloUsuarios.listener.*;
import moduloUsuarios.paneles.PanelUsuario;
import moduloUsuarios.paneles.UsuarioMenu;
import moduloPrincipal.paneles.PanelGeneral;

public class UsuarioView implements UsuarioInterface {
	
	private JFrame frame;
	private PanelUsuario panelUsuario;
	private ListenerUsuarioVolver listenerVolver;
	private ListenerUsuarioVer listenerVer;
	private UsuarioMenu panelUsuarioMenu;
	private ListenerUsuarioAlta listenerAlta;
	private ListenerAltaAceptar listenerAltaAceptar;
	private ListenerMenuUsuarioVolver listenerAltaVolver;
	private UsuarioController userController;
	private ListenerMenuUsuarioVolver listenerBajaVolver;
	private ListenerBajaAceptar listenerBajaAceptar;
	private ListenerUsuarioBaja listenerBaja;
	private ListenerModAceptar listenerModAceptar;
	private ListenerMenuUsuarioVolver listenerModVolver;
	private ListenerMenuUsuarioVolver listenerVerVolver;
	private ListenerUsuarioMod listenerMod;

	public UsuarioView(){
		
		
	
		panelUsuarioMenu= new UsuarioMenu();
		panelUsuario = new PanelUsuario();
	
	}

	

	

	@Override
	public List<Usuario> findAll() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMenuUsuario(UsuarioController uc,
			JFrame f, Usuario u) {
		userController = uc;
		frame = f;
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		listenerVolver = new ListenerUsuarioVolver(uc);
		listenerVer = new ListenerUsuarioVer(uc);
		listenerAlta = new ListenerUsuarioAlta(uc);
		listenerBaja = new ListenerUsuarioBaja(uc);
		listenerMod = new ListenerUsuarioMod(uc);
		listenerVer= new ListenerUsuarioVer(uc);
		
		panelUsuarioMenu.getBtnVolver().addActionListener(listenerVolver);
		panelUsuarioMenu.getBtnVerU().addActionListener(listenerVer);
		panelUsuarioMenu.getBtnAltaU().addActionListener(listenerAlta);
		panelUsuarioMenu.getBtnBajaU().addActionListener(listenerBaja);
		panelUsuarioMenu.getBtnModU().addActionListener(listenerMod);
		panelUsuarioMenu.getBtnVerU().addActionListener(listenerVer);
		
		
		//frame.setVisible(false);
		frame.setTitle("Menu Usuarios");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
		frame.getContentPane().add(panelUsuarioMenu, BorderLayout.WEST);
		frame.getContentPane().add(panelUsuario, BorderLayout.LINE_END);
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
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
		panelUsuario.onAlta();
		
		listenerAltaAceptar = new ListenerAltaAceptar(userController);
		listenerAltaVolver = new ListenerMenuUsuarioVolver(userController);
		
		panelUsuario.getBtnAceptar().addActionListener(listenerAltaAceptar);
		panelUsuario.getBtnVolver().addActionListener(listenerAltaVolver);
		
		
		frame.validate();
		frame.repaint();
		
	
		
	}

	@Override
	public void onVer(List<Usuario> lista) {
		
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
		panelUsuario.onVer();
		
		
		listenerVerVolver = new ListenerMenuUsuarioVolver(userController);
		
		
		panelUsuario.getBtnVolver().addActionListener(listenerVerVolver);
		
		
		frame.validate();
		frame.repaint();
		
		
		
	}
	
	@Override
	public void onBaja() {
		
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
		panelUsuario.onBaja();
		
		listenerBajaAceptar = new ListenerBajaAceptar(userController);
		listenerBajaVolver = new ListenerMenuUsuarioVolver(userController);
		
		panelUsuario.getBtnAceptar().addActionListener(listenerBajaAceptar);
		panelUsuario.getBtnVolver().addActionListener(listenerBajaVolver);
		
		
		frame.validate();
		frame.repaint();
		
		
		
	}
	
	public Usuario getNuevoUsuario(){
		
		String s = new String(panelUsuario.getPasswordText().getPassword());
		
		Usuario u = new Usuario(panelUsuario.getUserText().getText(), s,
				Integer.parseInt(panelUsuario.getPermisosText().getText()), 
				panelUsuario.getNombreText().getText(),
				panelUsuario.getApellidoText().getText());
		
		return u;

	}





	@Override
	public void insertOk() {
		
		JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
		
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
		
		
	}





	@Override
	public void insertBad() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar el usuario. Por favor reintente");
		
	}





	@Override
	public String getBajaUsuario() {

		return panelUsuario.getUserText().getText();
		
		
	}





	@Override
	public void cleanPanelUsuario() {
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
	}





	@Override
	public void onMod() {
		
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
		panelUsuario.onMod();
		
		listenerModAceptar = new ListenerModAceptar(userController);
		listenerModVolver = new ListenerMenuUsuarioVolver(userController);
		
		panelUsuario.getBtnAceptar().addActionListener(listenerModAceptar);
		panelUsuario.getBtnVolver().addActionListener(listenerModVolver);
		
		
		frame.validate();
		frame.repaint();
		
	}





	@Override
	public void showNotFound() {
		
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar borrar el usuario. Por favor reintente");
			
		
		
	}





	@Override
	public int showToDelete(Usuario user) {
		
		String s = new String("¿Esta seguro que desea eliminar el usuario: " + user.getUsername() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
		
		
	}





	@Override
	public void deleteOk() {
		JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
		
		panelUsuario.removeAll();
		panelUsuario.validate();
		panelUsuario.repaint();
		
	}





	@Override
	public void deleteBad() {
		// TODO Auto-generated method stub
		
	}
	

}
