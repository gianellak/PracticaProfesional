package moduloAdministracion.clienteABM;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioNuevaCompra extends JPanel {
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField dniCompradorText;
	private JTextField dniGaranteText;
	private JTextField patenteText;
	private JTextField descripcionText;

	

	public FormularioNuevaCompra(){
	
		this.setLayout(null);

		JLabel dniCompradorLabel = new JLabel("DNI Comprador: ");
		dniCompradorLabel.setBounds(100, 10, 160, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(100, 30, 160, 25);
		this.add(dniCompradorText);
		
		JLabel dniGaranteLabel = new JLabel("DNI Garante: ");
		dniGaranteLabel.setBounds(100, 50, 160, 25);
		this.add(dniGaranteLabel);

		dniGaranteText = new JTextField(9);
		dniGaranteText.setBounds(100, 80, 160, 25);
		this.add(dniGaranteText);
		
		JLabel patenteLabel = new JLabel("Pantente/Chasis: ");
		patenteLabel.setBounds(100, 110, 160, 25);
		this.add(patenteLabel);
		
		patenteText = new JTextField(6);
		patenteText.setBounds(100, 140, 160, 25);
		this.add(patenteText);
		
		JLabel descripcionLabel = new JLabel("Descripcion: ");
		descripcionLabel.setBounds(100, 170, 160, 25);
		this.add(descripcionLabel);
		
		descripcionText = new JTextField(25);
		descripcionText.setBounds(100, 200, 260, 25);
		this.add(descripcionText);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(300, 120, 100, 25);
		this.add(btnAceptar);
	
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(300, 150, 100, 25);
		this.add(btnCancelar);
	
	}

	

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

	public JTextField getDniCompradorText() {
		return dniCompradorText;
	}
	
	public void setDniCompradorText(JTextField dniCompradorText) {
		this.dniCompradorText = dniCompradorText;
	}
	
	public JTextField getDniGaranteText() {
		return dniGaranteText;
	}
	
	public void setDniGaranteText(JTextField dniGaranteText) {
		this.dniGaranteText = dniGaranteText;
	}
	
	public JTextField getPatenteText() {
		return patenteText;
	}
	
	public void setPatenteText(JTextField patenteText) {
		this.patenteText = patenteText;
	}
	
	public JTextField getDescripcionText() {
		return descripcionText;
	}
	
	public void setDescripcionText(JTextField descripcionText) {
		this.descripcionText = descripcionText;
	}
}
