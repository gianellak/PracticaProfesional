package moduloClientes.paneles;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import objetos.Persona;

public class PanelClientes extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnAceptar;
	private JTextField nombreCompradorText;
	private JTextField apellidoCompradorText;
	private JTextField dniCompradorText;
	private JTextField fechaNacText;
	private JTextField domicilioPartText;
	private JTextField domicilioLabText;
	private JTextField telPartText;
	private JTextField telCelText;
	private JTextField telLabText;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVender;
	private JButton btnComprar;
	private JTextField ciudadText;
	private JTextField provinciaText;
	private JTextField empresaText;
	
	
	public PanelClientes(){
		
		
		System.out.println("Creo nuevo panel Cliente");
		
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
		
		
	}
	
	public void onAlta(){
		
		this.removeAll();
		System.out.println("ONALTA");
		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(150, 0, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(300, 0, 160, 25);
		this.add(dniCompradorText);
		
		JLabel nombreCompradorLabel = new JLabel("Nombre: ");
		nombreCompradorLabel.setBounds(150, 30, 80, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(9);
		nombreCompradorText.setBounds(300, 30, 160, 25);
		this.add(nombreCompradorText);
	
		JLabel apellidoCompradorLabel = new JLabel("Apellido: ");
		apellidoCompradorLabel.setBounds(150, 60, 80, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(9);
		apellidoCompradorText.setBounds(300, 60, 160, 25);
		this.add(apellidoCompradorText);
		
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
		
		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(150, 150, 160, 25);
		this.add(ciudadLabel);
		
		ciudadText = new JTextField(25);
		ciudadText.setBounds(300, 150, 160, 25);
		this.add(ciudadText);
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(150, 180, 160, 25);
		this.add(provinciaLabel);
		
		provinciaText = new JTextField(25);
		provinciaText.setBounds(300, 180, 160, 25);
		this.add(provinciaText);
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(150, 210, 160, 25);
		this.add(domicilioLabLabel);
		
		domicilioLabText = new JTextField(25);
		domicilioLabText.setBounds(300, 210, 260, 25);
		this.add(domicilioLabText);
		
		JLabel telPartLabel = new JLabel("Tel. Particular: ");
		telPartLabel.setBounds(150, 240, 160, 25);
		this.add(telPartLabel);
		
		telPartText = new JTextField(25);
		telPartText.setBounds(300,240, 260, 25);
		this.add(telPartText);
		
		JLabel telCelLabel = new JLabel("Tel. Celular: ");
		telCelLabel.setBounds(150, 270, 160, 25);
		this.add(telCelLabel);
		
		telCelText = new JTextField(25);
		telCelText.setBounds(300, 270, 260, 25);
		this.add(telCelText);
		
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(150, 300, 160, 25);
		this.add(telLabLabel);
		
		telLabText = new JTextField(25);
		telLabText.setBounds(300, 300, 260, 25);
		this.add(telLabText);
		
		JLabel empresaLabel = new JLabel("Tel. Laboral: ");
		empresaLabel.setBounds(150, 330, 160, 25);
		this.add(empresaLabel);
		
		empresaText = new JTextField();
		empresaText.setBounds(300, 330, 260, 25);
		this.add(empresaText);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(700, 300, 160, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 330, 160, 25);
		this.add(btnVolver);
		
		
	
		
		this.validate();
		this.repaint();
		
		
	}

	
	
	public void onMod(){
		
		this.removeAll();
		System.out.println("ONMOD");
		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(150, 0, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(300, 0, 160, 25);
		this.add(dniCompradorText);
		

		btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.setBounds(700, 270, 160, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 300, 160, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();
	}

	public void verCliente(Persona p) {
		
		this.removeAll();
		System.out.println("ONVERMOD");

		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(150, 0, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText= new JTextField();
		dniCompradorText.setText(String.valueOf(p.getDni()));
		dniCompradorText.setEditable(false);
		dniCompradorText.setBounds(300, 0, 160, 25);
		this.add(dniCompradorText);
		
		JLabel nombreCompradorLabel = new JLabel("Nombre: ");
		nombreCompradorLabel.setBounds(150, 30, 80, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(p.getNombre());
		nombreCompradorText.setBounds(300, 30, 160, 25);
		nombreCompradorText.setEditable(false);
		this.add(nombreCompradorText);
	
		JLabel apellidoCompradorLabel = new JLabel("Apellido: ");
		apellidoCompradorLabel.setBounds(150, 60, 80, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(p.getApellido());
		apellidoCompradorText.setBounds(300, 60, 160, 25);
		apellidoCompradorText.setEditable(false);
		this.add(apellidoCompradorText);
		
		JLabel fechaNacLabel = new JLabel("Fecha nacimiento: ");
		fechaNacLabel.setBounds(150, 90, 160, 25);
		this.add(fechaNacLabel);
		
		fechaNacText = new JTextField(6);
		fechaNacText.setBounds(300, 90, 160, 25);
		fechaNacText.setEditable(false);
		this.add(fechaNacText);
		
		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(150, 120, 160, 25);
		this.add(domicilioPartLabel);
		
		domicilioPartText = new JTextField(p.getDomicilio());
		domicilioPartText.setBounds(300, 120, 160, 25);
		domicilioPartText.setEditable(false);
		this.add(domicilioPartText);
		
		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(150, 150, 160, 25);
		this.add(ciudadLabel);
		
		ciudadText = new JTextField(25);
		ciudadText.setBounds(300, 150, 160, 25);
		ciudadText.setEditable(false);
		this.add(ciudadText);
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(150, 180, 160, 25);
		this.add(provinciaLabel);
		
		provinciaText = new JTextField(25);
		provinciaText.setBounds(300, 180, 160, 25);
		provinciaText.setEditable(false);
		this.add(provinciaText);
		
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(150, 210, 160, 25);
		this.add(domicilioLabLabel);
		
		domicilioLabText = new JTextField(p.getDomicilioL());
		domicilioLabText.setBounds(300, 210, 260, 25);
		domicilioLabText.setEditable(false);
		this.add(domicilioLabText);
		
		JLabel telPartLabel = new JLabel("Tel. Particular: ");
		telPartLabel.setBounds(150, 240, 160, 25);
		this.add(telPartLabel);
		
		telPartText = new JTextField(p.getTelefonoP());
		telPartText.setBounds(300, 240, 260, 25);
		telPartText.setEditable(false);
		this.add(telPartText);
		
		JLabel telCelLabel = new JLabel("Tel. Celular: ");
		telCelLabel.setBounds(150, 270, 160, 25);
		this.add(telCelLabel);
		
		telCelText = new JTextField(p.getTelefonoC());
		telCelText.setBounds(300, 270, 260, 25);
		telCelText.setEditable(false);
		this.add(telCelText);
		
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(150, 300, 160, 25);
		this.add(telLabLabel);
		
		telLabText = new JTextField(p.getTelefonoL());
		telLabText.setBounds(300, 300, 260, 25);
		telLabText.setEditable(false);
		this.add(telLabText);
		
		JLabel empresaLabel = new JLabel("Tel. Laboral: ");
		empresaLabel.setBounds(150, 330, 160, 25);
		this.add(empresaLabel);
		
		empresaText = new JTextField(p.getTelefonoL());
		empresaText.setBounds(300, 330, 260, 25);
		empresaText.setEditable(false);
		this.add(empresaText);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(700, 300, 160, 25);
		this.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(700, 330, 160, 25);
		this.add(btnEliminar);

		btnVender = new JButton("Iniciar Venta");
		btnVender.setBounds(700, 360, 160, 25);
		this.add(btnVender);

		btnComprar = new JButton("Comprar Vehiculo");
		btnComprar.setBounds(700, 390, 160, 25);
		this.add(btnComprar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 420, 160, 25);
		this.add(btnVolver);
		
	
		
		this.validate();
		this.repaint();
	

	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getCiudadText() {
		return ciudadText;
	}

	public void setCiudadText(JTextField ciudadText) {
		this.ciudadText = ciudadText;
	}

	public JTextField getProvinciaText() {
		return provinciaText;
	}

	public void setProvinciaText(JTextField provinciaText) {
		this.provinciaText = provinciaText;
	}

	public void verMod() {
		
		
		System.out.println("ONVERMOD");

		
		dniCompradorText.setEditable(false);
		nombreCompradorText.setEditable(true);
		apellidoCompradorText.setEditable(true);
		fechaNacText.setEditable(true);
		domicilioPartText.setEditable(true);
		ciudadText.setEditable(true);
		provinciaText.setEditable(true);
		domicilioLabText.setEditable(true);
		telPartText.setEditable(true);
		telCelText.setEditable(true);
		telLabText.setEditable(true);
		empresaText.setEditable(true);
		
		
		this.remove(btnModificar);
		this.remove(btnVender);
		this.remove(btnComprar);
		this.remove(btnEliminar);
		this.remove(btnVolver);
			
		
		

		btnAceptar = new JButton("Aceptar Cambios");
		btnAceptar.setBounds(700, 270, 160, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 300, 100, 25);
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

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JTextField getNombreCompradorText() {
		return nombreCompradorText;
	}

	public void setNombreCompradorText(JTextField nombreCompradorText) {
		this.nombreCompradorText = nombreCompradorText;
	}

	public JTextField getApellidoCompradorText() {
		return apellidoCompradorText;
	}

	public void setApellidoCompradorText(JTextField apellidoCompradorText) {
		this.apellidoCompradorText = apellidoCompradorText;
	}

	public JTextField getDniCompradorText() {
		return dniCompradorText;
	}

	public void setDniCompradorText(JTextField dniCompradorText) {
		this.dniCompradorText = dniCompradorText;
	}

	public JTextField getFechaNacText() {
		return fechaNacText;
	}

	public void setFechaNacText(JTextField fechaNacText) {
		this.fechaNacText = fechaNacText;
	}

	public JTextField getDomicilioPartText() {
		return domicilioPartText;
	}

	public void setDomicilioPartText(JTextField domicilioPartText) {
		this.domicilioPartText = domicilioPartText;
	}

	public JTextField getDomicilioLabText() {
		return domicilioLabText;
	}

	public void setDomicilioLabText(JTextField domicilioLabText) {
		this.domicilioLabText = domicilioLabText;
	}

	public JTextField getTelPartText() {
		return telPartText;
	}

	public void setTelPartText(JTextField telPartText) {
		this.telPartText = telPartText;
	}

	public JTextField getTelCelText() {
		return telCelText;
	}

	public void setTelCelText(JTextField telCelText) {
		this.telCelText = telCelText;
	}

	public JTextField getTelLabText() {
		return telLabText;
	}

	public void setTelLabText(JTextField telLabText) {
		this.telLabText = telLabText;
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

	public JButton getBtnVender() {
		return btnVender;
	}

	public void setBtnVender(JButton btnVender) {
		this.btnVender = btnVender;
	}

	public JButton getBtnComprar() {
		return btnComprar;
	}

	public void setBtnComprar(JButton btnComprar) {
		this.btnComprar = btnComprar;
	}

	public Persona getUpdatePersona() {

		
		Persona cliente = new Persona(
				Integer.parseInt(dniCompradorText.getText()),
				Integer.parseInt(telPartText.getText()),
				Integer.parseInt(telCelText.getText()),
				Integer.parseInt(telLabText.getText()),
				nombreCompradorText.getText(),
				apellidoCompradorText.getText(),
				domicilioPartText.getText(),
				ciudadText.getText(),
				provinciaText.getText(),
				domicilioLabText.getText(),
				empresaText.getText());
		
		return cliente;
		
	}

	public void onAltaFromVenta(String dni) {
		
		this.removeAll();
		
		System.out.println("ONALTAFROMVENTA");
		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(150, 0, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(String.valueOf(dni));
		dniCompradorText.setBounds(300, 0, 160, 25);
		this.add(dniCompradorText);
		
		JLabel nombreCompradorLabel = new JLabel("Nombre: ");
		nombreCompradorLabel.setBounds(150, 30, 80, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(9);
		nombreCompradorText.setBounds(300, 30, 160, 25);
		this.add(nombreCompradorText);
	
		JLabel apellidoCompradorLabel = new JLabel("Apellido: ");
		apellidoCompradorLabel.setBounds(150, 60, 80, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(9);
		apellidoCompradorText.setBounds(300, 60, 160, 25);
		this.add(apellidoCompradorText);
		
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
		
		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(150, 150, 160, 25);
		this.add(ciudadLabel);
		
		ciudadText = new JTextField(25);
		ciudadText.setBounds(300, 150, 160, 25);
		this.add(ciudadText);
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(150, 180, 160, 25);
		this.add(provinciaLabel);
		
		provinciaText = new JTextField(25);
		provinciaText.setBounds(300, 180, 160, 25);
		this.add(provinciaText);
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(150, 210, 160, 25);
		this.add(domicilioLabLabel);
		
		domicilioLabText = new JTextField(25);
		domicilioLabText.setBounds(300, 210, 260, 25);
		this.add(domicilioLabText);
		
		JLabel telPartLabel = new JLabel("Tel. Particular: ");
		telPartLabel.setBounds(150, 240, 160, 25);
		this.add(telPartLabel);
		
		telPartText = new JTextField(25);
		telPartText.setBounds(300,240, 260, 25);
		this.add(telPartText);
		
		JLabel telCelLabel = new JLabel("Tel. Celular: ");
		telCelLabel.setBounds(150, 270, 160, 25);
		this.add(telCelLabel);
		
		telCelText = new JTextField(25);
		telCelText.setBounds(300, 270, 260, 25);
		this.add(telCelText);
		
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(150, 300, 160, 25);
		this.add(telLabLabel);
		
		telLabText = new JTextField(25);
		telLabText.setBounds(300, 300, 260, 25);
		this.add(telLabText);
		
		JLabel empresaLabel = new JLabel("Tel. Laboral: ");
		empresaLabel.setBounds(150, 330, 160, 25);
		this.add(empresaLabel);
		
		empresaText = new JTextField();
		empresaText.setBounds(300, 330, 260, 25);
		this.add(empresaText);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(700, 300, 160, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 330, 160, 25);
		this.add(btnVolver);
		
		
	
		
		this.validate();
		this.repaint();
	
	
	}


}
