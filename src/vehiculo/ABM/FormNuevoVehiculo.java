package vehiculo.ABM;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormNuevoVehiculo extends JPanel {

	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JTextField txtPatente;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtYear;
	private JTextField txtColor;
	private JTextField txtKm;

	public FormNuevoVehiculo() {

		this.setLayout(null);

		JLabel lblPatente = new JLabel("Patente: ");
		lblPatente.setBounds(100, 10, 160, 25);
		this.add(lblPatente);

		txtPatente = new JTextField(9);
		txtPatente.setBounds(100, 30, 160, 25);
		this.add(txtPatente);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(100, 50, 160, 25);
		this.add(lblMarca);

		txtMarca = new JTextField(9);
		txtMarca.setBounds(100, 70, 160, 25);
		this.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(100, 90, 160, 25);
		this.add(lblModelo);

		txtModelo = new JTextField(6);
		txtModelo.setBounds(100, 110, 160, 25);
		this.add(txtModelo);

		JLabel lblYear = new JLabel("Año: ");
		lblYear.setBounds(100, 130, 160, 25);
		this.add(lblYear);

		txtYear = new JTextField(25);
		txtYear.setBounds(100, 150, 260, 25);
		this.add(txtYear);

		JLabel lblColor = new JLabel("Color: ");
		lblColor.setBounds(100, 170, 160, 25);
		this.add(lblYear);

		txtColor = new JTextField(25);
		txtColor.setBounds(100, 190, 260, 25);
		this.add(txtColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(100, 210, 160, 25);
		this.add(lblKm);

		txtKm = new JTextField(25);
		txtKm.setBounds(100, 230, 260, 25);
		this.add(txtKm);
		
		

		btnAceptar = new JButton("Ingresar Vehículo");
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


}
