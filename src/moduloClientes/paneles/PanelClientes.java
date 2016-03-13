package moduloClientes.paneles;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import objetos.Persona;

public class PanelClientes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver, btnAceptar, btnBuscar, btnModificar,	btnEliminar, btnVender;
	
	private JTextField nombreCompradorText, apellidoCompradorText, dniCompradorText, domicilioPartText, domicilioLabText, telPartText, emailText, telLabText, ciudadText, provinciaText, empresaText;
	private JButton btnAceptarCambios;

	public PanelClientes() {

		System.out.println("Creo nuevo panel Cliente");

		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int w = width.intValue() - 250;
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int h = height.intValue() - 150;
		
		this.setPreferredSize(new Dimension(w, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		
		this.setLayout(null);

	}

	public void onAlta() {

		this.removeAll();
		
		JLabel datosLabel = new JLabel(
				"Por favor, ingrese los datos del cliente a dar de alta.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel dniCompradorLabel = new JLabel("DNI(*): ");
		dniCompradorLabel.setBounds(50, 90, 70, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(150, 90, 160, 25);
		this.add(dniCompradorText);

		JLabel nombreCompradorLabel = new JLabel("Nombre(*): ");
		nombreCompradorLabel.setBounds(50, 130, 70, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(9);
		nombreCompradorText.setBounds(150, 130, 160, 25);
		this.add(nombreCompradorText);

		JLabel apellidoCompradorLabel = new JLabel("Apellido(*): ");
		apellidoCompradorLabel.setBounds(50, 170, 70, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(9);
		apellidoCompradorText.setBounds(150, 170, 160, 25);
		this.add(apellidoCompradorText);

		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(50, 210, 100, 25);
		this.add(domicilioPartLabel);

		domicilioPartText = new JTextField(25);
		domicilioPartText.setBounds(150, 210, 160, 25);
		this.add(domicilioPartText);

		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(50, 250, 70, 25);
		this.add(ciudadLabel);

		ciudadText = new JTextField(25);
		ciudadText.setBounds(150, 250, 160, 25);
		this.add(ciudadText);

		/// DERECHA ---------
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(340, 90, 70, 25);
		this.add(provinciaLabel);

		provinciaText = new JTextField(25);
		provinciaText.setBounds(460, 90, 160, 25);
		this.add(provinciaText);

		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(340, 130, 90, 25);
		this.add(domicilioLabLabel);

		domicilioLabText = new JTextField(25);
		domicilioLabText.setBounds(460, 130, 160, 25);
		this.add(domicilioLabText);

		JLabel telPartLabel = new JLabel("Tel. Particular(*): ");
		telPartLabel.setBounds(340, 170, 100, 25);
		this.add(telPartLabel);

		telPartText = new JTextField(25);
		telPartText.setBounds(460, 170, 160, 25);
		this.add(telPartText);

		JLabel telCelLabel = new JLabel("Email: ");
		telCelLabel.setBounds(340, 210, 70, 25);
		this.add(telCelLabel);

		emailText = new JTextField(25);
		emailText.setBounds(460, 210, 160, 25);
		this.add(emailText);

		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(340, 250, 100, 25);
		this.add(telLabLabel);

		telLabText = new JTextField(25);
		telLabText.setBounds(460, 250, 160, 25);
		this.add(telLabText);

		JLabel empresaLabel = new JLabel("Empresa: ");
		empresaLabel.setBounds(340, 290, 80, 25);
		this.add(empresaLabel);

		empresaText = new JTextField();
		empresaText.setBounds(460, 290, 160, 25);
		this.add(empresaText);

		JLabel obLabel = new JLabel(
				"Los campos marcados con (*) son obligatorios.");
		obLabel.setBounds(70, 350, 360, 25);
		this.add(obLabel);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(70, 320, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(180, 320, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	public void onMod() {

		this.removeAll();

		JLabel datosLabel = new JLabel(
				"Por favor, ingrese el DNI del cliente a buscar.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel dniCompradorLabel = new JLabel("DNI(*): ");
		dniCompradorLabel.setBounds(50, 90, 70, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(150, 90, 160, 25);
		this.add(dniCompradorText);

		btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.setBounds(70, 160, 160, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(240, 160, 160, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();
	}

	public void verCliente(Persona p) {

		this.removeAll();
		System.out.println("ONVERMOD");

		JLabel datosLabel = new JLabel(
				"A continuación se muestran los datos del cliente consultado.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);
		
		dniCompradorText = new JTextField(String.valueOf(p.getDni()));
		dniCompradorText.setEditable(false);

		nombreCompradorText = new JTextField(p.getNombre());
		nombreCompradorText.setEditable(false);

		apellidoCompradorText = new JTextField(p.getApellido());
		apellidoCompradorText.setEditable(false);

		domicilioPartText = new JTextField(p.getDomicilio());
		domicilioPartText.setEditable(false);

		ciudadText = new JTextField(p.getCiudad());
		ciudadText.setEditable(false);

		provinciaText = new JTextField(p.getProvincia());
		provinciaText.setEditable(false);

		domicilioLabText = new JTextField(p.getDomicilioL());
		domicilioLabText.setEditable(false);

		telPartText = new JTextField(p.getTelefonoP());
		telPartText.setEditable(false);

		emailText = new JTextField(p.getEmail());
		emailText.setEditable(false);

		telLabText = new JTextField(p.getTelefonoL());
		telLabText.setEditable(false);

		empresaText = new JTextField(p.getTelefonoL());
		empresaText.setEditable(false);
		
		//LABELS + SIZE

		JLabel dniCompradorLabel = new JLabel("DNI(*): ");
		dniCompradorLabel.setBounds(50, 90, 70, 25);
		this.add(dniCompradorLabel);

		dniCompradorText.setBounds(150, 90, 160, 25);
		this.add(dniCompradorText);

		JLabel nombreCompradorLabel = new JLabel("Nombre(*): ");
		nombreCompradorLabel.setBounds(50, 130, 70, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText.setBounds(150, 130, 160, 25);
		this.add(nombreCompradorText);

		JLabel apellidoCompradorLabel = new JLabel("Apellido(*): ");
		apellidoCompradorLabel.setBounds(50, 170, 70, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText.setBounds(150, 170, 160, 25);
		this.add(apellidoCompradorText);

		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(50, 210, 100, 25);
		this.add(domicilioPartLabel);

		domicilioPartText.setBounds(150, 210, 160, 25);
		this.add(domicilioPartText);

		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(50, 250, 70, 25);
		this.add(ciudadLabel);

		ciudadText.setBounds(150, 250, 160, 25);
		this.add(ciudadText);

		/// DERECHA ---------
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(340, 90, 70, 25);
		this.add(provinciaLabel);

		provinciaText.setBounds(460, 90, 160, 25);
		this.add(provinciaText);

		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(340, 130, 90, 25);
		this.add(domicilioLabLabel);

		domicilioLabText.setBounds(460, 130, 160, 25);
		this.add(domicilioLabText);

		JLabel telPartLabel = new JLabel("Tel. Particular(*): ");
		telPartLabel.setBounds(340, 170, 100, 25);
		this.add(telPartLabel);

		telPartText.setBounds(460, 170, 160, 25);
		this.add(telPartText);

		JLabel telCelLabel = new JLabel("Email: ");
		telCelLabel.setBounds(340, 210, 70, 25);
		this.add(telCelLabel);

		emailText.setBounds(460, 210, 160, 25);
		this.add(emailText);

		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(340, 250, 100, 25);
		this.add(telLabLabel);

		telLabText.setBounds(460, 250, 160, 25);
		this.add(telLabText);

		JLabel empresaLabel = new JLabel("Empresa: ");
		empresaLabel.setBounds(340, 290, 80, 25);
		this.add(empresaLabel);

		empresaText.setBounds(460, 290, 160, 25);
		this.add(empresaText);

		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(70, 330, 100, 25);
		this.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(180, 330, 100, 25);
		this.add(btnEliminar);

		btnVender = new JButton("Iniciar Venta");
		btnVender.setBounds(600, 330, 160, 25);
		this.add(btnVender);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(600, 370, 160, 25);
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

		JLabel datosLabel = new JLabel(
				"Por favor, ingrese los datos del cliente a modificar.");
		datosLabel.setBounds(0, 0, 360, 25);
		this.add(datosLabel);

		JLabel obLabel = new JLabel(
				"Los campos marcados con (*) son obligatorios.");
		obLabel.setBounds(70, 350, 360, 25);
		this.add(obLabel);

		dniCompradorText.setEditable(false);
		nombreCompradorText.setEditable(true);
		apellidoCompradorText.setEditable(true);
		domicilioPartText.setEditable(true);
		ciudadText.setEditable(true);
		provinciaText.setEditable(true);
		domicilioLabText.setEditable(true);
		telPartText.setEditable(true);
		emailText.setEditable(true);
		telLabText.setEditable(true);
		empresaText.setEditable(true);

		this.remove(btnModificar);
		this.remove(btnVender);
		this.remove(btnEliminar);
		this.remove(btnVolver);

		btnAceptarCambios = new JButton("Aceptar Cambios");
		btnAceptarCambios.setBounds(600, 330, 160, 25);
		this.add(btnAceptarCambios);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(600, 370, 160, 25);
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
		return emailText;
	}

	public void setTelCelText(JTextField telCelText) {
		this.emailText = telCelText;
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

	

	public Persona getUpdatePersona() {
		int dni;

		try {
			dni = Integer.parseInt(dniCompradorText.getText());
		} catch (NumberFormatException e) {
			dni = 0;
			;
		}

		Persona cliente = new Persona(dni, telPartText.getText(),
				emailText.getText(), telLabText.getText(),
				nombreCompradorText.getText(), apellidoCompradorText.getText(),
				domicilioPartText.getText(), ciudadText.getText(),
				provinciaText.getText(), domicilioLabText.getText(),
				empresaText.getText());

		return cliente;

	}

	public void onAltaFromVenta(int dni) {

		this.removeAll();

		System.out.println("ONALTAFROMVENTA");

		onAlta();

		dniCompradorText.setText(String.valueOf(dni));

		this.validate();
		this.repaint();

	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}

	public JTextField getEmpresaText() {
		return empresaText;
	}

	public void setEmpresaText(JTextField empresaText) {
		this.empresaText = empresaText;
	}

	public JButton getBtnAceptarCambios() {
		return btnAceptarCambios;
	}

	public void setBtnAceptarCambios(JButton btnAceptarCambios) {
		this.btnAceptarCambios = btnAceptarCambios;
	}

}
