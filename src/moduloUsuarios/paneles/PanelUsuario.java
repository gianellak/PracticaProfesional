
package moduloUsuarios.paneles;

import java.awt.Dimension;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
		
		nombreText.setEditable(false);
		apellidoText.setEditable(false);

		
		JLabel dniLabel = new JLabel("Dni Usuario: ");
		dniLabel.setBounds(150, 180, 160, 25);
		this.add(dniLabel);

		dniText = new JTextField();
		dniText.setBounds(300, 180, 160, 25);
		this.add(dniText);
		

		btnValidarE = new JButton("Validar");
		btnValidarE.setBounds(500, 180, 100, 25);
		this.add(btnValidarE);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 210, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 240, 100, 25);
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
		nombreText.setEditable(false);
		dniText.setEditable(false);
		apellidoText.setEditable(false);
		
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

	public void onVer(List<Usuario> lista) {
		
		this.removeAll();
		System.out.println("ONVER");

		JLabel userLabel = new JLabel("Usuarios habilitados a usar el sistema: ");
		userLabel.setBounds(150, 0, 280, 25);
		this.add(userLabel);
		
		createTablaUsuarios(lista);
		
		this.add(jp);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();

	}

public void createTablaUsuarios(List<Usuario> lista) {
		
		// Create columns names
		String columnNames[] = { "Usuario", "Contrasena", "DNI", "Nombre", "Apellido", "Permisos", "Bloqueo"};

		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columnNames);
		
		tabla = new JTable();

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
		
		jp.setBounds(150, 50, 600, 200);


	
	}
	public void onBuscar() {
		
		this.removeAll();
		System.out.println("ONBuscar");
		
		JLabel buscarLabel = new JLabel("Ingrese el nombre de usuario a consultar: ");
		buscarLabel.setBounds(100, 0, 280, 25);
		this.add(buscarLabel);

		userText = new JTextField();
		userText.setBounds(300, 30, 160, 25);
		this.add(userText);
		
		JLabel buscarELabel = new JLabel("Ingrese el DNI del empleado a consultar: ");
		buscarELabel.setBounds(100, 70, 280, 25);
		this.add(buscarELabel);
		
		empText = new JTextField();
		empText.setBounds(300, 100, 160, 25);
		this.add(empText);
		
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
		
		JLabel dniLabel = new JLabel("Dni Usuario: ");
		dniLabel.setBounds(150, 180, 160, 25);
		this.add(dniLabel);

		dniText = new JTextField(String.valueOf(u.getDniUsuario()));
		dniText.setEditable(false);
		dniText.setBounds(300, 180, 160, 25);
		this.add(dniText);
	
		
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
	
	public void onAltaE() {

		this.removeAll();
		System.out.println("ONALTAE");

		JLabel dniLabel = new JLabel("Dni Empleado: ");
		dniLabel.setBounds(150, 30, 100, 25);
		this.add(dniLabel);

		dniText = new JTextField(9);
		dniText.setBounds(300, 30, 160, 25);
		this.add(dniText);

		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(150, 60, 80, 25);
		this.add(nombreLabel);

		nombreText = new JTextField(8);
		nombreText.setBounds(300, 60, 160, 25);
		this.add(nombreText);

		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(150, 90, 160, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(3);
		apellidoText.setBounds(300, 90, 160, 25);
		this.add(apellidoText);

		JLabel direccionLabel = new JLabel("Direccion: ");
		direccionLabel.setBounds(150, 120, 160, 25);
		this.add(direccionLabel);

		direccionText = new JTextField(6);
		direccionText.setBounds(300, 120, 160, 25);
		this.add(direccionText);

		JLabel idCargoLabel = new JLabel("Cargo: ");
		idCargoLabel.setBounds(150, 150, 160, 25);
		this.add(idCargoLabel);

		idCargoText = new JTextField(6);
		idCargoText.setBounds(300, 150, 160, 25);
		this.add(idCargoText);

		JLabel telefonoLabel = new JLabel("Telefono: ");
		telefonoLabel.setBounds(150, 180, 160, 25);
		this.add(telefonoLabel);

		telefonoText = new JTextField();
		telefonoText.setBounds(300, 180, 160, 25);
		this.add(telefonoText);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(150, 210, 160, 25);
		this.add(emailLabel);

		emailText = new JTextField();
		emailText.setBounds(300, 210, 160, 25);
		this.add(emailText);

		btnAceptarE = new JButton("Aceptar");
		btnAceptarE.setBounds(500, 210, 100, 25);
		this.add(btnAceptarE);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 240, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	public void verUnEmpleado(Empleado e) {

		this.removeAll();

		JLabel dniLabel = new JLabel("Dni Empleado: ");
		dniLabel.setBounds(150, 30, 80, 25);
		this.add(dniLabel);

		dniText = new JTextField(String.valueOf(e.getIdEmpleado()));
		dniText.setBounds(300, 30, 160, 25);
		dniText.setEditable(false);
		this.add(dniText);

		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(150, 60, 80, 25);
		this.add(nombreLabel);

		nombreText = new JTextField(e.getNombre());
		nombreText.setEditable(false);
		nombreText.setBounds(300, 60, 160, 25);
		this.add(nombreText);

		JLabel apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(150, 90, 160, 25);
		this.add(apellidoLabel);

		apellidoText = new JTextField(e.getApellido());
		apellidoText.setEditable(false);
		apellidoText.setBounds(300, 90, 160, 25);
		this.add(apellidoText);

		JLabel direccionLabel = new JLabel("Direccion: ");
		direccionLabel.setBounds(150, 120, 160, 25);
		this.add(direccionLabel);

		direccionText = new JTextField(e.getDireccion());
		direccionText.setEditable(false);
		direccionText.setBounds(300, 120, 160, 25);
		this.add(direccionText);

		JLabel idCargoLabel = new JLabel("Cargo: ");
		idCargoLabel.setBounds(150, 150, 160, 25);
		this.add(idCargoLabel);

		idCargoText = new JTextField(e.getIdCargo());
		idCargoText.setEditable(false);
		idCargoText.setBounds(300, 150, 160, 25);
		this.add(idCargoText);

		JLabel telefonoLabel = new JLabel("Telefono: ");
		telefonoLabel.setBounds(150, 180, 160, 25);
		this.add(telefonoLabel);

		telefonoText = new JTextField(String.valueOf(e.getTelefono()));
		telefonoText.setEditable(false);
		telefonoText.setBounds(300, 180, 160, 25);
		this.add(telefonoText);

		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(150, 210, 160, 25);
		this.add(emailLabel);

		emailText = new JTextField(e.getEmail());
		emailText.setEditable(false);
		emailText.setBounds(300, 210, 160, 25);
		this.add(emailText);

		btnModificar = new JButton("Modificar Empleado");
		btnModificar.setBounds(500, 180, 160, 25);
		this.add(btnModificar);

		btnEliminar = new JButton("Eliminar Empleado");
		btnEliminar.setBounds(500, 210, 160, 25);
		this.add(btnEliminar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 270, 160, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	public void onModE() {

		System.out.println("ONMOD");

		nombreText.setEditable(true);
		apellidoText.setEditable(true);
		direccionText.setEditable(true);
		idCargoText.setEditable(true);
		telefonoText.setEditable(true);
		emailText.setEditable(true);

		btnAceptarModE = new JButton("Modificar Empleado");
		btnAceptarModE.setBounds(500, 180, 160, 25);
		this.add(btnAceptarModE);

		btnModificar.setVisible(false);
		btnEliminar.setVisible(false);
		btnVolver.setBounds(500, 210, 160, 25);

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
		return new Empleado(Integer.parseInt(dniText.getText()), nombreText.getText(),
		apellidoText.getText(),
		direccionText.getText(), idCargoText.getText(), Integer.parseInt(telefonoText.getText()),
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

	public JTextField getApellidoText() {
		return apellidoText;
	}

	public void setApellidoText(JTextField apellidoText) {
		this.apellidoText = apellidoText;
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

	
	

}
