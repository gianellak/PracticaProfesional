package moduloUsuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import exceptions.DBException;
import objetos.Usuario;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.PanelAux;
import moduloPrincipal.paneles.PanelMenu;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioInterface;
import moduloUsuarios.listener.ListenerUsuarioAlta;
import moduloUsuarios.listener.ListenerUsuarioVer;
import moduloUsuarios.listener.ListenerUsuarioVolver;
import moduloPrincipal.paneles.PanelGeneral;
import moduloUsuarios.paneles.PanelUsuario;
import moduloUsuarios.paneles.UsuarioMenu;

public class UsuarioView implements UsuarioInterface {
	
	private JFrame frame;
	private PanelUsuario panelUsuario;
	private ListenerUsuarioVolver listenerVolver;
	private ListenerUsuarioVer listenerVer;
	private UsuarioMenu panelUsuarioMenu;
	private ListenerUsuarioAlta listenerAlta;

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
		
		frame = f;
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		listenerVolver = new ListenerUsuarioVolver(uc);
		listenerVer = new ListenerUsuarioVer(uc);
		listenerAlta = new ListenerUsuarioAlta(uc);
		panelUsuarioMenu.getBtnVolver().addActionListener(listenerVolver);
		panelUsuarioMenu.getBtnVerU().addActionListener(listenerVer);
		panelUsuarioMenu.getBtnAltaU().addActionListener(listenerAlta);
		
		
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
		
		System.out.println("O Alta VIEW");
		panelUsuario.onAlta();
		frame.validate();
		frame.repaint();
		
	}
	

}
