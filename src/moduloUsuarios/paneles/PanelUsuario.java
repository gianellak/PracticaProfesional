
package moduloUsuarios.paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Empleado;
import objetos.Usuario;

public class PanelUsuario extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25);

	private JButton btnVolver;
	private JTextField userText;
	private JTextField permisosText;
	private JPasswordField passwordText;
	
	//EMPLEADO
	
	private JTextField dniText;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JTextField direccionText;
	private JTextField idCargoText;
	
	private JTextField telefonoText;
	private JTextField emailText;
	private JButton btnAceptarModE;
	
	private JButton btnAceptar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnResetear;
	private JButton btnAceptarMod;
	private Usuario user;
	private JTable tabla;
	private JScrollPane jp;

	private JTextField empText;

	
	private JButton btnValidarE;

	private JButton btnAceptarE;

	private JPanel empleadoPanel;

	private JPanel userPanel;

	private JTextField nombreEText;

	private JTextField apellidoEText;

	private JButton btnModificarE;

	private JButton btnEliminarE;

	private JTextField dniEText;
	
	public PanelUsuario(){

		
		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int w = width.intValue() - 250;
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int h = height.intValue() - 150;
		
		this.setPreferredSize(new Dimension(w, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		this.setLayout(null);
		
		
	}
	
	public void onAlta(){
		
		this.removeAll();


		JLabel textLabel = new JLabel("Por favor, ingrese los datos del nuevo usuario. ");
		textLabel.setBounds(50, 40, 380, 25);
		this.add(textLabel);

		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setBounds(50, 90, 70, 25);
		this.add(userLabel);

		userText = new JTextField(9);
		userText.setBounds(150, 90, 160, 25);
		this.add(userText);
		
		JLabel passLabel = new JLabel("Contraseña: ");
		passLabel.setBounds(50, 130, 80, 25);
		this.add(passLabel);

		passwordText = new JPasswordField(8);
		passwordText.setBounds(150, 130, 160, 25);
		this.add(passwordText);
		
		JLabel patenteLabel = new JLabel("Permisos: ");
		patenteLabel.setBounds(50, 170, 70, 25);
		this.add(patenteLabel);
		
		
		JPanel permisos = new JPanel();
	    permisos.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Permisos"));
	    permisos.setBounds(330, 150, 170, 70);
	    permisos.add(new JLabel("0 = Usuario Administrativo."));
	    permisos.add(new JLabel("1 = Usuario Funcional."));
	        this.add(permisos);
	
		
		permisosText = new JTextField(3);
		permisosText.setBounds(150, 170, 160, 25);
		this.add(permisosText);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(50, 210, 70, 25);
		this.add(nombreLabel);
		
		nombreText = new JTextField(6);
		nombreText.setBounds(150, 210, 160, 25);
		this.add(nombreText);
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(50, 250, 70, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(6);
		apellidoText.setBounds(150, 250, 160, 25);
		this.add(apellidoText);
		

		nombreText.setEditable(false);
		apellidoText.setEditable(false);

		
		JLabel dniLabel = new JLabel("DNI: ");
		dniLabel.setBounds(50, 290, 70, 25);
		this.add(dniLabel);

		dniText = new JTextField();
		dniText.setBounds(150, 290, 160, 25);
		this.add(dniText);
		

		btnValidarE = new JButton("Validar");
		btnValidarE.setBounds(330, 290, 100, 25);
		this.add(btnValidarE);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(100, 360, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(210, 360, 100, 25);
		this.add(btnVolver);

		
		this.validate();
		this.repaint();
		
		
	}

	
	public void onBaja() {
		
		this.removeAll();
		
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
		
	
		//Aca solo el permiso 0 puede modificar el campo user.
		userText.setEditable(true);
		passwordText.setEditable(true);
		permisosText.setEditable(true);
		nombreText.setEditable(false);
		dniText.setEditable(false);
		apellidoText.setEditable(false);
		
		btnAceptarMod = new JButton("Aceptar Cambios");
		btnAceptarMod.setBounds(110, 290, 160, 25);
		userPanel.add(btnAceptarMod);

		
		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);		
		btnResetear.setVisible(false);	
		
		
		this.validate();
		this.repaint();
		
	}


public void createTablaUsuarios(List<Usuario> lista) {
		
		// Create columns names
		String columnNames[] = { "Usuario", "Contrasena", "DNI", "Nombre", "Apellido", "Permisos", "Bloqueo"};

		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columnNames);
		
		tabla = new JTable();
		tabla.setEnabled(false);

		tabla.setModel(model);
		tabla.getTableHeader().setReorderingAllowed(false);
		jp= new JScrollPane(tabla);
		
		
		
		// Create some data
		for (Usuario u : lista) {
			
			
			Object[] o = new Object[7];
			o[0] = u.getUsername();
			o[1] = u.getPassword();
			o[2] = u.getDniUsuario();
			o[3] = u.getNombre();
			o[4] = u.getApellido();
			o[5] = u.getPermisos();
			o[6]  = "NO";
			if (u.getBloqueo())
				o[6]  = "SI";
			model.addRow(o);
		}
		
		jp.setBounds(50, 90, 600, 200);


	
	}
	public void onBuscar() {
		
		this.removeAll();
		System.out.println("ONBuscar");
		
		JLabel textLabel = new JLabel("Por favor, ingrese alguno de los siguientes datos para realizar la búsqueda.");
		textLabel.setBounds(50, 40, 480, 25);
		this.add(textLabel);

		
		JLabel buscarLabel = new JLabel("Nombre de usuario: ");
		buscarLabel.setBounds(50, 90, 150, 25);
		this.add(buscarLabel);

		userText = new JTextField();
		userText.setBounds(210, 90, 160, 25);
		this.add(userText);
		
		JLabel buscarELabel = new JLabel("DNI del empleado: ");
		buscarELabel.setBounds(50, 130, 150, 25);
		this.add(buscarELabel);
		
		empText = new JTextField();
		empText.setBounds(210, 130, 160, 25);
		this.add(empText);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(100, 200, 100, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(210, 200, 100, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();
		
	}


	
	public void onAltaE() {

		this.removeAll();
		
		JLabel textLabel = new JLabel("Por favor, ingrese los datos del nuevo empleado. ");
		textLabel.setBounds(50, 40, 380, 25);
		this.add(textLabel);

		JLabel dniLabel = new JLabel("DNI(*): ");
		dniLabel.setBounds(50, 90, 80, 25);
		this.add(dniLabel);

		dniEText = new JTextField(9);
		dniEText.setBounds(150, 90, 160, 25);
		this.add(dniEText);

		JLabel nombreLabel = new JLabel("Nombre(*): ");
		nombreLabel.setBounds(50, 130, 80, 25);
		this.add(nombreLabel);

		nombreEText = new JTextField(8);
		nombreEText.setBounds(150, 130, 160, 25);
		this.add(nombreEText);

		JLabel apellidoLabel = new JLabel("Apellido(*): ");
		apellidoLabel.setBounds(50, 170, 160, 25);
		this.add(apellidoLabel);

		apellidoEText = new JTextField(3);
		apellidoEText.setBounds(150, 170, 160, 25);
		this.add(apellidoEText);

		JLabel direccionLabel = new JLabel("Direccion: ");
		direccionLabel.setBounds(50, 210, 160, 25);
		this.add(direccionLabel);

		direccionText = new JTextField(6);
		direccionText.setBounds(150, 210, 160, 25);
		this.add(direccionText);

		JLabel idCargoLabel = new JLabel("Cargo: ");
		idCargoLabel.setBounds(50, 250, 160, 25);
		this.add(idCargoLabel);

		idCargoText = new JTextField(6);
		idCargoText.setBounds(150, 250, 160, 25);
		this.add(idCargoText);

		JLabel telefonoLabel = new JLabel("Telefono(*): ");
		telefonoLabel.setBounds(50, 290, 160, 25);
		this.add(telefonoLabel);

		telefonoText = new JTextField();
		telefonoText.setBounds(150, 290, 160, 25);
		this.add(telefonoText);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(50, 330, 160, 25);
		this.add(emailLabel);

		emailText = new JTextField();
		emailText.setBounds(150, 330, 160, 25);
		this.add(emailText);

		btnAceptarE = new JButton("Aceptar");
		btnAceptarE.setBounds(100, 400, 100, 25);
		this.add(btnAceptarE);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(210, 400, 100, 25);
		this.add(btnVolver);
		
		JLabel textObLabel = new JLabel("Los campos marcados con (*) son obligatorios.");
		textObLabel.setBounds(50, 440, 380, 25);
		this.add(textObLabel);

		this.validate();
		this.repaint();

	}

	public void empleadoSinUsuario() {
		
	
		userPanel.removeAll();
		JLabel sinUser = new JLabel("El empleado no posee un usuario en el sistema.");
		sinUser.setBounds(10, 20, 290, 30);
		userPanel.add(sinUser);
		
		this.add(userPanel);

		this.validate();
		this.repaint();
	}
	

	public void verUnUsuario(Usuario u) {
		
		
	    
	    this.add(userPanel);
	        
	    user = u;
		
		userText = new JTextField(u.getUsername());
		userText.setEditable(false);
		passwordText = new JPasswordField(u.getPassword());
		passwordText.setEditable(false);
		permisosText = new JTextField(String.valueOf(u.getPermisos()));
		permisosText.setEditable(false);
		nombreText = new JTextField(u.getNombre());
		nombreText.setEditable(false);
		apellidoText = new JTextField(u.getApellido());
		apellidoText.setEditable(false);
		dniText = new JTextField(String.valueOf(u.getDniUsuario()));
		dniText.setEditable(false);
		
		JLabel userLabel = new JLabel("Usuario: ");
		userLabel.setBounds(10, 20, 70, 25);
		userPanel.add(userLabel);

		userText.setBounds(90, 20, 160, 25);
		userPanel.add(userText);
		
		JLabel passLabel = new JLabel("Contraseña: ");
		passLabel.setBounds(10, 60, 80, 25);
		userPanel.add(passLabel);

		passwordText.setBounds(90, 60, 160, 25);
		userPanel.add(passwordText);
		
		JLabel patenteLabel = new JLabel("Permisos: ");
		patenteLabel.setBounds(10, 100, 70, 25);
		userPanel.add(patenteLabel);
		
		permisosText.setBounds(90, 100, 160, 25);
		userPanel.add(permisosText);
		
		JLabel nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(10, 140, 70, 25);
		userPanel.add(nombreLabel);
		
		nombreText.setBounds(90, 140, 160, 25);
		userPanel.add(nombreText);
		
		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(10, 180, 70, 25);
		userPanel.add(apellidoLabel);

		apellidoText.setBounds(90, 180, 160, 25);
		userPanel.add(apellidoText);

		JLabel dniLabel = new JLabel("DNI: ");
		dniLabel.setBounds(10, 220, 70, 25);
		userPanel.add(dniLabel);

		dniText.setBounds(90, 220, 160, 25);
		userPanel.add(dniText);
		
		
		btnModificar = new JButton("Modificar Usuario");
		btnModificar.setBounds(110, 290, 160, 25);
		userPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar Usuario");
		btnEliminar.setBounds(110, 330, 160, 25);
		userPanel.add(btnEliminar);
		
		btnResetear = new JButton("Resetear Usuario");
		btnResetear.setBounds(110, 370, 160, 25);
		userPanel.add(btnResetear);
		
		this.validate();
		this.repaint();
		
	}
	
	public void verUnEmpleado(Empleado e) {

		userPanel = new JPanel();
		userPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
				"Usuario"));
		userPanel.setBounds(470, 40, 400, 500);
		userPanel.setLayout(null);
		
		empleadoPanel = new JPanel();
		empleadoPanel.setLayout(null);
		empleadoPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1), "Empleado"));
	    empleadoPanel.setBounds(50, 40, 400, 500);
	    
	    this.add(empleadoPanel);
		
		
		//CARGO LOS CAMPOS NO EDITABLES
		dniEText = new JTextField(String.valueOf(e.getIdEmpleado()));
		dniEText.setEditable(false);
		nombreEText = new JTextField(e.getNombre());
		nombreEText.setEditable(false);
		apellidoEText = new JTextField(e.getApellido());
		apellidoEText.setEditable(false);
		direccionText = new JTextField(e.getDireccion());
		direccionText.setEditable(false);
		idCargoText = new JTextField(e.getIdCargo());
		idCargoText.setEditable(false);
		telefonoText = new JTextField(String.valueOf(e.getTelefono()));
		telefonoText.setEditable(false);
		emailText = new JTextField(e.getEmail());
		emailText.setEditable(false);
		
		//LABELS + SIZE + ADD

		JLabel dniLabel = new JLabel("DNI(*): ");
		dniLabel.setBounds(10, 20, 70, 25);
		empleadoPanel.add(dniLabel);

		dniEText.setBounds(90, 20, 160, 25);
		empleadoPanel.add(dniEText);

		JLabel nombreLabel = new JLabel("Nombre(*): ");
		nombreLabel.setBounds(10, 60, 80, 25);
		empleadoPanel.add(nombreLabel);

		nombreEText.setBounds(90, 60, 160, 25);
		empleadoPanel.add(nombreEText);

		JLabel apellidoLabel = new JLabel("Apellido(*): ");
		apellidoLabel.setBounds(10, 100, 160, 25);
		empleadoPanel.add(apellidoLabel);

		apellidoEText.setBounds(90, 100, 160, 25);
		empleadoPanel.add(apellidoEText);

		JLabel direccionLabel = new JLabel("Direccion: ");
		direccionLabel.setBounds(10, 140, 160, 25);
		empleadoPanel.add(direccionLabel);

		direccionText.setBounds(90, 140, 160, 25);
		empleadoPanel.add(direccionText);

		JLabel idCargoLabel = new JLabel("Cargo: ");
		idCargoLabel.setBounds(10, 180, 160, 25);
		empleadoPanel.add(idCargoLabel);

		idCargoText.setBounds(90, 180, 160, 25);
		empleadoPanel.add(idCargoText);

		JLabel telefonoLabel = new JLabel("Telefono(*): ");
		telefonoLabel.setBounds(10, 220, 160, 25);
		empleadoPanel.add(telefonoLabel);

		telefonoText.setBounds(90, 220, 160, 25);
		empleadoPanel.add(telefonoText);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(10, 260, 160, 25);
		empleadoPanel.add(emailLabel);

		emailText.setBounds(90, 260, 160, 25);
		empleadoPanel.add(emailText);
		
		
		btnModificarE = new JButton("Modificar Empleado");
		btnModificarE.setBounds(110, 330, 160, 25);
		empleadoPanel.add(btnModificarE);

		btnEliminarE = new JButton("Eliminar Empleado");
		btnEliminarE.setBounds(110, 370, 160, 25);
		empleadoPanel.add(btnEliminarE);


		btnVolver = new JButton("Volver");
		btnVolver.setBounds(900, 470, 160, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();

	}

	public void onVer(List<Usuario> lista) {
		
		this.removeAll();
		

		JLabel textLabel = new JLabel("Usuarios registrados en el sistema. ");
		textLabel.setBounds(50, 40, 380, 25);
		this.add(textLabel);
		
		createTablaUsuarios(lista);
		
		this.add(jp);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();

	}

	public void onModE() {

		System.out.println("ONMOD");

		nombreEText.setEditable(true);
		apellidoEText.setEditable(true);
		direccionText.setEditable(true);
		idCargoText.setEditable(true);
		telefonoText.setEditable(true);
		emailText.setEditable(true);

		btnAceptarModE = new JButton("Aceptar Cambios");
		btnAceptarModE.setBounds(110, 330, 160, 25);
		empleadoPanel.add(btnAceptarModE);

		btnModificarE.setVisible(false);
		btnEliminarE.setVisible(false);

		empleadoPanel.validate();
		empleadoPanel.repaint();
		
		this.validate();
		this.repaint();

	}

	
	public JTextField getDireccionText() {
		return direccionText;
	}

	public void setDireccionText(JTextField direccionText) {
		this.direccionText = direccionText;
	}

	public JTextField getIdCargoText() {
		return idCargoText;
	}

	public void setIdCargoText(JTextField idCargoText) {
		this.idCargoText = idCargoText;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	

	public JTextField getTelefonoText() {
		return telefonoText;
	}

	public void setTelefonoText(JTextField telefonoText) {
		this.telefonoText = telefonoText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}

	public JButton getBtnAceptarModE() {
		return btnAceptarModE;
	}

	public void setBtnAceptarModE(JButton btnAceptarModE) {
		this.btnAceptarModE = btnAceptarModE;
	}

	public Empleado getModEmpleado() {
		
		int dniE;
		int telE;
		try {
			dniE = Integer.parseInt(dniEText.getText());
		    }
		    catch (NumberFormatException e) {
		        dniE = 0;
		    }
		
		return new Empleado(dniE, nombreEText.getText(),
		apellidoEText.getText(),
		direccionText.getText(), idCargoText.getText(), telefonoText.getText(),
		emailText.getText());
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
	public JTextField getNombreEText() {
		return nombreEText;
	}
	
	public void setNombreEText(JTextField nombreText) {
		this.nombreEText = nombreText;
	}

	public JTextField getApellidoText() {
		return apellidoText;
	}

	public void setApellidoText(JTextField apellidoText) {
		this.apellidoText = apellidoText;
	}
	
	public JTextField getApellidoEText() {
		return apellidoEText;
	}
	
	public void setApellidoEText(JTextField apellidoText) {
		this.apellidoEText = apellidoText;
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
		
		Usuario u = new Usuario(userText.getText(), s, Integer.parseInt(dniText.getText()), Integer.parseInt(permisosText.getText()), nombreText.getText(), apellidoText.getText(),  false);
		
		return u;
	}
	
	public String getResetUsuario(){
		
		String s = new String (passwordText.getPassword());
		Usuario u = new Usuario(userText.getText(), s, Integer.parseInt(dniText.getText()), Integer.parseInt(permisosText.getText()), nombreText.getText(), apellidoText.getText(),  false);
		return "";
	
	}

	public JButton getBtnAceptarMod() {
		return btnAceptarMod;
	}

	public void setBtnAceptarMod(JButton btnAceptarMod) {
		this.btnAceptarMod = btnAceptarMod;
	}

	
	public JTextField getEmpText() {
		return empText;
	}

	public void setEmpText(JTextField empText) {
		this.empText = empText;
	}

	public JTextField getDniText() {
		return dniText;
	}

	public void setDniText(JTextField dniText) {
		this.dniText = dniText;
	}

	public Dimension getPreferredSize() {
		return preferredSize;
	}

	public void setPreferredSize(Dimension preferredSize) {
		this.preferredSize = preferredSize;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JScrollPane getJp() {
		return jp;
	}

	public void setJp(JScrollPane jp) {
		this.jp = jp;
	}

	public JButton getBtnValidarE() {
		return btnValidarE;
	}

	public void setBtnValidarE(JButton btnValidarE) {
		this.btnValidarE = btnValidarE;
	}

	public JButton getBtnAceptarE() {
		return btnAceptarE;
	}

	public void setBtnAceptarE(JButton btnAceptarE) {
		this.btnAceptarE = btnAceptarE;
	}

	public JPanel getEmpleadoPanel() {
		return empleadoPanel;
	}

	public void setEmpleadoPanel(JPanel empleadoPanel) {
		this.empleadoPanel = empleadoPanel;
	}

	public JPanel getUserPanel() {
		return userPanel;
	}

	public void setUserPanel(JPanel userPanel) {
		this.userPanel = userPanel;
	}

	public JButton getBtnModificarE() {
		return btnModificarE;
	}

	public void setBtnModificarE(JButton btnModificarE) {
		this.btnModificarE = btnModificarE;
	}

	public JButton getBtnEliminarE() {
		return btnEliminarE;
	}

	public void setBtnEliminarE(JButton btnEliminarE) {
		this.btnEliminarE = btnEliminarE;
	}

	public JTextField getDniEText() {
		return dniEText;
	}

	public void setDniEText(JTextField dniEText) {
		this.dniEText = dniEText;
	}

	

	
	

}
