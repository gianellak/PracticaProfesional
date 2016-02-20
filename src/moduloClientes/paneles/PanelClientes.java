package moduloClientes.paneles;

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

public class PanelClientes extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25);
	private JButton btnVolver;
	private JTextField userText;
	private JTextField permisosText;
	private JPasswordField passwordText;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JButton btnAceptar;
	private JTextField dniText;
	private JTextField nombreCompradorText;
	private JTextField apellidoCompradorText;
	private JTextField dniCompradorText;
	private JTextField fechaNacText;
	private JTextField domicilioPartText;
	private JTextField domicilioLabText;
	private JTextField telPartText;
	private JTextField telCelText;
	private JTextField telLabText;
	
	public PanelClientes(){
		
		
		System.out.println("Creo nuevo panel Cliente");
		
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
		
		
	}
	
	public void onAlta(){
		
		this.removeAll();
		System.out.println("ONALTA");
		
		
		JLabel nombreCompradorLabel = new JLabel("Nombre: ");
		nombreCompradorLabel.setBounds(150, 0, 80, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(9);
		nombreCompradorText.setBounds(300, 0, 160, 25);
		this.add(nombreCompradorText);
	
		JLabel apellidoCompradorLabel = new JLabel("Apellido: ");
		apellidoCompradorLabel.setBounds(150, 30, 80, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(9);
		apellidoCompradorText.setBounds(300, 30, 160, 25);
		this.add(apellidoCompradorText);
		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(150, 60, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(300, 60, 160, 25);
		this.add(dniCompradorText);
		
		JLabel fechaNacLabel = new JLabel("Fecha nacimiento: ");
		fechaNacLabel.setBounds(150, 90, 160, 25);
		this.add(fechaNacLabel);
		
		fechaNacText = new JTextField(6);
		fechaNacText.setBounds(300, 90, 160, 25);
		this.add(fechaNacText);
		
		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(150, 120, 160, 25);
		this.add(domicilioPartLabel);
		
		domicilioPartText = new JTextField(25);
		domicilioPartText.setBounds(300, 120, 160, 25);
		this.add(domicilioPartText);
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(150, 150, 160, 25);
		this.add(domicilioLabLabel);
		
		domicilioLabText = new JTextField(25);
		domicilioLabText.setBounds(300, 150, 260, 25);
		this.add(domicilioLabText);
		
		JLabel telPartLabel = new JLabel("Tel. Particular: ");
		telPartLabel.setBounds(150, 180, 160, 25);
		this.add(telPartLabel);
		
		telPartText = new JTextField(25);
		telPartText.setBounds(300, 180, 260, 25);
		this.add(telPartText);
		
		JLabel telCelLabel = new JLabel("Tel. Celular: ");
		telCelLabel.setBounds(150, 210, 160, 25);
		this.add(telCelLabel);
		
		telCelText = new JTextField(25);
		telCelText.setBounds(300, 210, 260, 25);
		this.add(telCelText);
		
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(150, 240, 160, 25);
		this.add(telLabLabel);
		
		telLabText = new JTextField(25);
		telLabText.setBounds(300, 240, 260, 25);
		this.add(telLabText);
		
		
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
