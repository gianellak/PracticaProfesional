package moduloClientes.paneles;

import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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
	
	public void onAlta() {
		
		this.removeAll();
		System.out.println("ONALTA");
		
		JLabel datosLabel = new JLabel("Por favor, ingrese los datos del cliente a dar de alta.");
		datosLabel.setBounds(0, 0, 360, 25);
		this.add(datosLabel);
		
		JLabel dniCompradorLabel = new JLabel("DNI(*): ");
		dniCompradorLabel.setBounds(0, 50, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(150, 50, 160, 25);
		this.add(dniCompradorText);
		
		JLabel nombreCompradorLabel = new JLabel("Nombre(*): ");
		nombreCompradorLabel.setBounds(0, 80, 80, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(9);
		nombreCompradorText.setBounds(150, 80, 160, 25);
		this.add(nombreCompradorText);
	
		JLabel apellidoCompradorLabel = new JLabel("Apellido(*): ");
		apellidoCompradorLabel.setBounds(0, 110, 80, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(9);
		apellidoCompradorText.setBounds(150, 110, 160, 25);
		this.add(apellidoCompradorText);
		
		
		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(0, 140, 160, 25);
		this.add(domicilioPartLabel);
		
		domicilioPartText = new JTextField(25);
		domicilioPartText.setBounds(150, 140, 160, 25);
		this.add(domicilioPartText);
		
		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(0, 170, 160, 25);
		this.add(ciudadLabel);
		
		ciudadText = new JTextField(25);
		ciudadText.setBounds(150, 170, 160, 25);
		this.add(ciudadText);
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(0, 200, 160, 25);
		this.add(provinciaLabel);
		
		provinciaText = new JTextField(25);
		provinciaText.setBounds(150, 200, 160, 25);
		this.add(provinciaText);
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(0, 230, 160, 25);
		this.add(domicilioLabLabel);
		
		domicilioLabText = new JTextField(25);
		domicilioLabText.setBounds(150, 230, 160, 25);
		this.add(domicilioLabText);
		
		JLabel telPartLabel = new JLabel("Tel. Particular(*): ");
		telPartLabel.setBounds(0, 260, 160, 25);
		this.add(telPartLabel);
		     
		telPartText = new JTextField(25);
		telPartText.setBounds(150, 260, 160, 25);
		this.add(telPartText);
		
		JLabel telCelLabel = new JLabel("Email: ");
		telCelLabel.setBounds(0, 290, 160, 25);
		this.add(telCelLabel);
		
		telCelText = new JTextField(25);
		telCelText.setBounds(150, 290, 160, 25);
		this.add(telCelText);
		
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(0, 320, 160, 25);
		this.add(telLabLabel);
		
		telLabText = new JTextField(25);
		telLabText.setBounds(150, 320, 160, 25);
		this.add(telLabText);
		
		JLabel empresaLabel = new JLabel("Empresa: ");
		empresaLabel.setBounds(0, 350, 160, 25);
		this.add(empresaLabel);
		
		empresaText = new JTextField();
		empresaText.setBounds(150, 350, 160, 25);
		this.add(empresaText);

		JLabel obLabel = new JLabel("Los campos marcados con (*) son obligatorios.");
		obLabel.setBounds(0, 380, 360, 25);
		this.add(obLabel);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(50, 430, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(160, 430, 100, 25);
		this.add(btnVolver);
		
		
	
		
		this.validate();
		this.repaint();
		
		
	}

	
	
	public void onMod(){
		
		this.removeAll();
		System.out.println("ONMOD");
		
		
		JLabel datosLabel = new JLabel("Por favor, ingrese el DNI del cliente a buscar.");
		datosLabel.setBounds(0, 0, 360, 25);
		this.add(datosLabel);
		
		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(0, 50, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(150, 50, 160, 25);
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

		
		JLabel dniCompradorLabel = new JLabel("DNI(*): ");
		dniCompradorLabel.setBounds(0, 50, 160, 25);
		this.add(dniCompradorLabel);
	
		JLabel nombreCompradorLabel = new JLabel("Nombre(*): ");
		nombreCompradorLabel.setBounds(0, 80, 80, 25);
		this.add(nombreCompradorLabel);

		JLabel apellidoCompradorLabel = new JLabel("Apellido(*): ");
		apellidoCompradorLabel.setBounds(0, 110, 80, 25);
		this.add(apellidoCompradorLabel);
		
		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(0, 140, 160, 25);
		this.add(domicilioPartLabel);
		
		JLabel ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(0, 170, 160, 25);
		this.add(ciudadLabel);
		
		JLabel provinciaLabel = new JLabel("Provincia: ");
		provinciaLabel.setBounds(0, 200, 160, 25);
		this.add(provinciaLabel);
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(0, 230, 160, 25);
		this.add(domicilioLabLabel);
				
		JLabel telPartLabel = new JLabel("Tel. Particular(*): ");
		telPartLabel.setBounds(0, 260, 160, 25);
		this.add(telPartLabel);
				
		JLabel telCelLabel = new JLabel("Email: ");
		telCelLabel.setBounds(0, 290, 160, 25);
		this.add(telCelLabel);
				
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(0, 320, 160, 25);
		this.add(telLabLabel);		
		
		JLabel empresaLabel = new JLabel("Empresa: ");
		empresaLabel.setBounds(0, 350, 160, 25);
		this.add(empresaLabel);				
				
		dniCompradorText= new JTextField(String.valueOf(p.getDni()));
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
		
		telCelText = new JTextField(p.getTelefonoC());
		telCelText.setEditable(false);
		
		telLabText = new JTextField(p.getTelefonoL());
		telLabText.setEditable(false);
		
		empresaText = new JTextField(p.getTelefonoL());
		empresaText.setEditable(false);

		
		dniCompradorText.setBounds(150, 50, 160, 25);
		nombreCompradorText.setBounds(150, 80, 160, 25);
		apellidoCompradorText.setBounds(150, 110, 160, 25);
		domicilioPartText.setBounds(150, 140, 160, 25);
		ciudadText.setBounds(150, 170, 160, 25);
		provinciaText.setBounds(150, 200, 160, 25);
		domicilioLabText.setBounds(150, 230, 160, 25);
		telPartText.setBounds(150, 260, 160, 25);
		telCelText.setBounds(150, 290, 160, 25);
		telLabText.setBounds(150, 320, 160, 25);
		empresaText.setBounds(150, 350, 160, 25);
		
		
		this.add(dniCompradorText);
		this.add(nombreCompradorText);
		this.add(apellidoCompradorText);
		this.add(domicilioPartText);
		this.add(ciudadText);
		this.add(provinciaText);
		this.add(domicilioLabText);
		this.add(telPartText);
		this.add(telCelText);
		this.add(telLabText);
		this.add(empresaText);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(350, 300, 160, 25);
		this.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(350, 330, 160, 25);
		this.add(btnEliminar);

		btnVender = new JButton("Iniciar Venta");
		btnVender.setBounds(350, 360, 160, 25);
		this.add(btnVender);

		btnComprar = new JButton("Comprar Vehiculo");
		btnComprar.setBounds(350, 390, 160, 25);
		this.add(btnComprar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 420, 160, 25);
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

		JLabel datosLabel = new JLabel("Por favor, ingrese los datos del clientea modificar.");
		datosLabel.setBounds(0, 0, 360, 25);
		this.add(datosLabel);
		
		JLabel obLabel = new JLabel("Los campos marcados con (*) son obligatorios.");
		obLabel.setBounds(0, 380, 360, 25);
		this.add(obLabel);

		
		dniCompradorText.setEditable(false);
		nombreCompradorText.setEditable(true);
		apellidoCompradorText.setEditable(true);
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
		btnAceptar.setBounds(350, 270, 160, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 300, 100, 25);
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
		int dni;
		
		try {
			 dni = Integer.parseInt(dniCompradorText.getText());
		    }
		    catch (NumberFormatException e) {
		     dni = 0;;
		    }
		
		Persona cliente = new Persona(
				dni,
				telPartText.getText(),
				telCelText.getText(),
				telLabText.getText(),
				nombreCompradorText.getText(),
				apellidoCompradorText.getText(),
				domicilioPartText.getText(),
				ciudadText.getText(),
				provinciaText.getText(),
				domicilioLabText.getText(),
				empresaText.getText());
		
		return cliente;
		
	}

	public void onAltaFromVenta(int dni){
		
		this.removeAll();
		
		System.out.println("ONALTAFROMVENTA");
		
		onAlta();
		
		dniCompradorText.setText(String.valueOf(dni));
		
		this.validate();
		this.repaint();
	
	
	}


}
