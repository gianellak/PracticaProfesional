package moduloCaja.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import moduloUsuarios.listener.ListenerAltaAceptar;
import moduloUsuarios.listener.ListenerMenuUsuarioVolver;
import moduloUsuarios.listener.ListenerUsuarioVolver;
import objetos.Usuario;

public class PanelCaja extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25);
	private JButton btnVolver;
	private JTextField userText;
	private JTextField permisosText;
	private JPasswordField passwordText;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JButton btnAceptar;
	private JTextField dniText;
	
	public PanelCaja(){
		
		
		System.out.println("Creo nuevo panel Usuario");
		
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
		
		
	}
	
	public void onAlta(){
		
		this.removeAll();
		System.out.println("ONALTA");
		
		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setBounds(150, 0, 80, 25);
		this.add(userLabel);

		userText = new JTextField(9);
		userText.setBounds(300, 0, 160, 25);
		this.add(userText);
		
		JLabel passLabel = new JLabel("Contrasena");
		passLabel.setBounds(150, 30, 80, 25);
		this.add(passLabel);

		passwordText = new JPasswordField(8);
		passwordText.setBounds(300, 30, 160, 25);
		this.add(passwordText);
		
		JLabel patenteLabel = new JLabel("Permisos: ");
		patenteLabel.setBounds(150, 60, 160, 25);
		this.add(patenteLabel);
		
		permisosText = new JTextField(3);
		permisosText.setBounds(300, 60, 160, 25);
		this.add(permisosText);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(150, 90, 160, 25);
		this.add(nombreLabel);
		
		nombreText = new JTextField(6);
		nombreText.setBounds(300, 90, 160, 25);
		this.add(nombreText);
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(150, 120, 160, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(6);
		apellidoText.setBounds(300, 120, 160, 25);
		this.add(apellidoText);
		

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 150, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);
		
		
	
		
		this.validate();
		this.repaint();
		
		
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JTextField getUserText() {
		return userText;
	}

	public void setUserText(JTextField userText) {
		this.userText = userText;
	}

	public JTextField getPermisosText() {
		return permisosText;
	}

	public void setPermisosText(JTextField permisosText) {
		this.permisosText = permisosText;
	}

	public JPasswordField getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(JPasswordField passwordText) {
		this.passwordText = passwordText;
	}

	public JTextField getNombreText() {
		return nombreText;
	}

	public void setNombreText(JTextField nombreText) {
		this.nombreText = nombreText;
	}

	public JTextField getApellidoText() {
		return apellidoText;
	}

	public void setApellidoText(JTextField apellidoText) {
		this.apellidoText = apellidoText;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public void onBaja() {
		
		this.removeAll();
		
		System.out.println("ONBAJA");
		
		JLabel dniLabel = new JLabel("Cliente a dar de baja: ");
		dniLabel.setBounds(150, 0, 160, 25);
		this.add(dniLabel);

		dniText = new JTextField(9);
		dniText.setBounds(300, 0, 160, 25);
		this.add(dniText);


		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 150, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);
		
		
	
		
		this.validate();
		this.repaint();
		
		
	}
	
	
	public void onMod(){
		
		this.removeAll();
		System.out.println("ONMOD");
		
		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setBounds(150, 0, 80, 25);
		this.add(userLabel);

		userText = new JTextField(9);
		userText.setBounds(300, 0, 160, 25);
		this.add(userText);
		
		JLabel passLabel = new JLabel("Contrasena");
		passLabel.setBounds(150, 30, 80, 25);
		this.add(passLabel);

		passwordText = new JPasswordField(8);
		passwordText.setBounds(300, 30, 160, 25);
		this.add(passwordText);
		
		JLabel patenteLabel = new JLabel("Permisos: ");
		patenteLabel.setBounds(150, 60, 160, 25);
		this.add(patenteLabel);
		
		permisosText = new JTextField(3);
		permisosText.setBounds(300, 60, 160, 25);
		this.add(permisosText);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(150, 90, 160, 25);
		this.add(nombreLabel);
		
		nombreText = new JTextField(6);
		nombreText.setBounds(300, 90, 160, 25);
		this.add(nombreText);
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(150, 120, 160, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(6);
		apellidoText.setBounds(300, 120, 160, 25);
		this.add(apellidoText);
		

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 150, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);
		
		
	
		
		this.validate();
		this.repaint();
	}

	public void onVer() {
		
		this.removeAll();
		System.out.println("ONVER");

		JLabel userLabel = new JLabel("Usuarios habilitados a usar el sistema: ");
		userLabel.setBounds(150, 0, 280, 25);
		this.add(userLabel);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();

	}

	public JTextField getDniText() {
		return dniText;
	}

	public void setDniText(JTextField dniText) {
		this.dniText = dniText;
	}

	
	

}
