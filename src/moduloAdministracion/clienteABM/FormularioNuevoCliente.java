package moduloAdministracion.clienteABM;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioNuevoCliente extends JPanel {
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField nombreCompradorText;
	private JTextField apellidoCompradorText;
	private JTextField dniCompradorText;
	private JTextField fechaNacText;
	private JTextField domicilioPartText;
	private JTextField domicilioLabText;
	private JTextField telPartText;
	private JTextField telCelText;
	private JTextField telLabText;

	

	public FormularioNuevoCliente(){
	
		this.setLayout(null);

		JLabel nombreCompradorLabel = new JLabel("Nombre: ");
		nombreCompradorLabel.setBounds(100, 10, 160, 25);
		this.add(nombreCompradorLabel);

		nombreCompradorText = new JTextField(9);
		nombreCompradorText.setBounds(100, 30, 160, 25);
		this.add(nombreCompradorText);
	
		JLabel apellidoCompradorLabel = new JLabel("Apellido: ");
		apellidoCompradorLabel.setBounds(100, 50, 160, 25);
		this.add(apellidoCompradorLabel);

		apellidoCompradorText = new JTextField(9);
		apellidoCompradorText.setBounds(100, 70, 160, 25);
		this.add(apellidoCompradorText);
		
		JLabel dniCompradorLabel = new JLabel("DNI: ");
		dniCompradorLabel.setBounds(100, 90, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(100, 110, 160, 25);
		this.add(dniCompradorText);
		
		JLabel fechaNacLabel = new JLabel("Fecha nacimiento: ");
		fechaNacLabel.setBounds(100, 130, 160, 25);
<<<<<<< HEAD
		this.add(fechaNacLabel);
=======
		this.add(patenteLabel);
>>>>>>> 55ca4cd6e85cf554b762872c4c39690ddd529990
		
		fechaNacText = new JTextField(6);
		fechaNacText.setBounds(100, 150, 160, 25);
		this.add(fechaNacText);
		
		JLabel domicilioPartLabel = new JLabel("Dom.Particular: ");
		domicilioPartLabel.setBounds(100, 190, 160, 25);
		this.add(domicilioPartLabel);
		
		domicilioPartText = new JTextField(25);
		domicilioPartText.setBounds(100, 230, 260, 25);
		this.add(domicilioPartText);
		
		JLabel domicilioLabLabel = new JLabel("Dom.Laboral: ");
		domicilioLabLabel.setBounds(100, 270, 160, 25);
		this.add(domicilioLabLabel);
		
		domicilioLabText = new JTextField(25);
		domicilioLabText.setBounds(100, 310, 260, 25);
		this.add(domicilioLabText);
		
		JLabel telPartLabel = new JLabel("Tel. Particular: ");
		telPartLabel.setBounds(100, 350, 160, 25);
		this.add(telPartLabel);
		
		telPartText = new JTextField(25);
		telPartText.setBounds(100, 390, 260, 25);
		this.add(telPartText);
		
		JLabel telCelLabel = new JLabel("Tel. Celular: ");
		telCelLabel.setBounds(100, 430, 160, 25);
		this.add(telCelLabel);
		
		telCelText = new JTextField(25);
		telCelText.setBounds(100, 470, 260, 25);
		this.add(telCelText);
		
		JLabel telLabLabel = new JLabel("Tel. Laboral: ");
		telLabLabel.setBounds(100, 510, 160, 25);
		this.add(telLabLabel);
		
		telLabText = new JTextField(25);
		telLabText.setBounds(100, 550, 260, 25);
		this.add(telLabText);

		btnAceptar = new JButton("Ingresar Cliente");
		btnAceptar.setBounds(300, 120, 100, 25);
		this.add(btnAceptar);
	
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(300, 150, 100, 25);
		this.add(btnCancelar);
	
	}
<<<<<<< HEAD



	public JButton getBtnAceptar() {
		return btnAceptar;
	}



	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}



	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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
=======
	
	//generar get-set

	

>>>>>>> 55ca4cd6e85cf554b762872c4c39690ddd529990



	public JTextField getTelLabText() {
		return telLabText;
	}



	public void setTelLabText(JTextField telLabText) {
		this.telLabText = telLabText;
	}
	
	
	


}
