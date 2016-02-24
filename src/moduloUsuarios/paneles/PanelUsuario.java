package moduloUsuarios.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.List;

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
import utilitarios.PantallaUtil;

public class PanelUsuario extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25);
	private JButton btnVolver;
	private JTextField userText;
	private JTextField permisosText;
	private JPasswordField passwordText;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JButton btnAceptar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnResetear;
	private Usuario user;
	private JButton btnAceptarMod;
	
	public PanelUsuario(){
		
		
		System.out.println("Creo nuevo panel Usuario");
		
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
		
		
	}
	
	public void onAlta(){
		
		this.removeAll();
		System.out.println("ONALTA");
		
		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setBounds(150, 30, 80, 25);
		this.add(userLabel);

		userText = new JTextField(9);
		userText.setBounds(300, 30, 160, 25);
		this.add(userText);
		
		JLabel passLabel = new JLabel("Contrasena");
		passLabel.setBounds(150, 60, 80, 25);
		this.add(passLabel);

		passwordText = new JPasswordField(8);
		passwordText.setBounds(300, 60, 160, 25);
		this.add(passwordText);
		
		JLabel patenteLabel = new JLabel("Permisos: ");
		patenteLabel.setBounds(150, 90, 160, 25);
		this.add(patenteLabel);
		
		permisosText = new JTextField(3);
		permisosText.setBounds(300, 90, 160, 25);
		this.add(permisosText);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(150, 120, 160, 25);
		this.add(nombreLabel);
		
		nombreText = new JTextField(6);
		nombreText.setBounds(300, 120, 160, 25);
		this.add(nombreText);
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(150, 150, 160, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(6);
		apellidoText.setBounds(300, 150, 160, 25);
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

	
	public void onBaja() {
		
		this.removeAll();
		
		System.out.println("ONBAJA");
		
		JLabel userLabel = new JLabel("Usuario a dar de baja: ");
		userLabel.setBounds(150, 0, 160, 25);
		this.add(userLabel);

		userText = new JTextField(9);
		userText.setBounds(300, 0, 160, 25);
		this.add(userText);


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
		
		
		System.out.println("ONMOD");
		
		
		//Aca solo el permiso 0 puede modificar el campo user.
		userText.setEditable(true);
		passwordText.setEditable(true);
		permisosText.setEditable(true);
		nombreText.setEditable(true);
		apellidoText.setEditable(true);
		
		btnAceptarMod = new JButton("Modificar Usuario");
		btnAceptarMod.setBounds(500, 180, 160, 25);
		this.add(btnAceptarMod);
		
		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);		
		btnResetear.setVisible(false);	
		btnVolver.setBounds(500, 210, 160, 25);
		
		
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

	public void onBuscar() {
		
		this.removeAll();
		System.out.println("ONBuscar");
		
		JLabel buscarLabel = new JLabel("Ingrese el usuario a consultar: ");
		buscarLabel.setBounds(100, 0, 280, 25);
		this.add(buscarLabel);

		userText = new JTextField(9);
		userText.setBounds(300, 30, 160, 25);
		this.add(userText);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(500, 180, 100, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 210, 100, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();
		
	}


	public void verUnUsuario(Usuario u) {
		
		this.removeAll();
		
		user = u;
		
		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setBounds(150, 30, 80, 25);
		this.add(userLabel);
		
		userText = new JTextField(u.getUsername());
		userText.setBounds(300, 30, 160, 25);
		userText.setEditable(false);
		this.add(userText);
		
		JLabel passLabel = new JLabel("Contrasena");
		passLabel.setBounds(150, 60, 160, 25);
		this.add(passLabel);

		passwordText = new JPasswordField(u.getPassword());
		passwordText.setBounds(300, 60, 160, 25);
		passwordText.setEditable(false);
		this.add(passwordText);
		
		JLabel patenteLabel = new JLabel("Permisos: ");
		patenteLabel.setBounds(150, 90, 160, 25);
		this.add(patenteLabel);
		
		permisosText = new JTextField(String.valueOf(u.getPermisos()));
		permisosText.setBounds(300, 90, 160, 25);
		permisosText.setEditable(false);
		this.add(permisosText);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(150, 120, 160, 25);
		this.add(nombreLabel);
		
		nombreText = new JTextField(u.getNombre());
		nombreText.setBounds(300, 120, 160, 25);
		nombreText.setEditable(false);
		this.add(nombreText);
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(150, 150, 160, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(u.getApellido());
		apellidoText.setEditable(false);
		apellidoText.setBounds(300, 150, 160, 25);
		this.add(apellidoText);
		
		btnModificar = new JButton("Modificar Usuario");
		btnModificar.setBounds(500, 180, 160, 25);
		this.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar Usuario");
		btnEliminar.setBounds(500, 210, 160, 25);
		this.add(btnEliminar);
		
		btnResetear = new JButton("Resetear Usuario");
		btnResetear.setBounds(500, 240, 160, 25);
		this.add(btnResetear);
		

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 270, 160, 25);
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

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnResetear() {
		return btnResetear;
	}

	public void setBtnResetear(JButton btnResetear) {
		this.btnResetear = btnResetear;
	}

	public Usuario getUsuarioAModificar() {
		// TODO Auto-generated method stub
		return user;
	}

	public void mostrarListaUsuario(List<Usuario> lista) {
		// TODO Auto-generated method stub
		
	}
	

	public Usuario getModUsuario() {
		String s = new String(passwordText.getPassword());
		
		Usuario u = new Usuario(userText.getText(), s, Integer.parseInt(permisosText.getText()), nombreText.getText(), apellidoText.getText());
		
		return u;
	}

	public JButton getBtnAceptarMod() {
		return btnAceptarMod;
	}

	public void setBtnAceptarMod(JButton btnAceptarMod) {
		this.btnAceptarMod = btnAceptarMod;
	}

	
	

}
