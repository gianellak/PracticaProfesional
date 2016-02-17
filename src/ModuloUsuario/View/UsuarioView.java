package ModuloUsuario.View;

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
import ModuloUsuario.UsuarioController;
import ModuloUsuario.UsuarioInterface;
import ModuloUsuario.Listener.ListenerUsuarioVer;
import ModuloUsuario.Listener.ListenerUsuarioVolver;

public class UsuarioView implements UsuarioInterface {
	
	private UsuarioMenu panelUsuario;
	private JFrame frmUsuario;
	private JButton btnAltaU;
	private JButton btnBajaU;
	private JButton btnModU;
	private JButton btnVerU;
	private JButton btnVolver;
	private JPanel panelAux;
	private ListenerUsuarioVolver ListenerVolver;
	private ListenerUsuarioVolver listenerVolver;
	private ListenerUsuarioVer listenerVer;

	public UsuarioView(){
		
		frmUsuario = new JFrame("Menu Usuario");
		frmUsuario.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frmUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		panelUsuario = new UsuarioMenu();
		frmUsuario.add(panelUsuario);
		
		panelAux = new JPanel();
		frmUsuario.add(panelAux);
		
		btnAltaU = new JButton("Alta Usuario");
		btnAltaU.setBounds(100, 120, 150, 25);
		panelUsuario.add(btnAltaU);
		
		btnBajaU = new JButton("Baja Usuario");
		btnBajaU.setBounds(100, 150, 150, 25);
		panelUsuario.add(btnBajaU);
		
		btnModU = new JButton("Modificacion Usuario");
		btnModU.setBounds(100, 180, 150, 25);
		panelUsuario.add(btnModU);
		
		btnVerU = new JButton("Ver Usuario");
		btnVerU.setBounds(100, 210, 150, 25);
		panelUsuario.add(btnVerU);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(100, 240, 150, 25);
		panelUsuario.add(btnVolver);
		
		
		
		frmUsuario.pack();
		
		
		
	
	}

	public void showMenuUsuario(UsuarioController uc) {
		
		listenerVolver = new ListenerUsuarioVolver(uc);
		btnVolver.addActionListener(listenerVolver);
		listenerVer = new ListenerUsuarioVer(uc);
		btnVerU.addActionListener(listenerVer);
		frmUsuario.setVisible(true);
		
		
	}

	public void dispose() {
		frmUsuario.dispose();
		
	}

	@Override
	public List<Usuario> findAll() throws DBException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
