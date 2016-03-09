package moduloVehiculos.paneles;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FormModificarVehiculo extends JPanel {

//
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JTextField txtPatente, txtKm, txtPvc, txtFechaVenta, txtCondicion, txtCliente, txtComentarios;
	

	public FormModificarVehiculo() {

		this.setLayout(null);

		JLabel lblPatente = new JLabel("Patente(*): ");
		lblPatente.setBounds(100, 10, 160, 25);
		this.add(lblPatente);

		txtPatente = new JTextField(9);
		txtPatente.setBounds(100, 30, 160, 25);
		this.add(txtPatente);

		JLabel lblMarca = new JLabel("Marca(*): ");
		lblMarca.setBounds(100, 50, 160, 25);
		this.add(lblMarca);

		JLabel lblMarca2 = new JLabel(); 
		lblMarca2.setBounds(100, 70, 160, 25);
		this.add(lblMarca2);

		JLabel lblModelo = new JLabel("Modelo(*): ");
		lblModelo.setBounds(100, 90, 160, 25);
		this.add(lblModelo);

		JLabel lblModelo2 = new JLabel();
		lblModelo2.setBounds(100, 110, 160, 25);
		this.add(lblModelo2);

		JLabel lblYear = new JLabel("Año(*): ");
		lblYear.setBounds(100, 130, 160, 25);
		this.add(lblYear);

		JLabel lblYear2 = new JLabel();
		lblYear2.setBounds(100, 150, 260, 25);
		this.add(lblYear2);

		JLabel lblColor = new JLabel("Color(*): ");
		lblColor.setBounds(100, 170, 160, 25);
		this.add(lblColor);

		JLabel lblColor2 = new JLabel();
		lblColor.setBounds(100, 190, 260, 25);
		this.add(lblColor2);

		JLabel lblKm = new JLabel("Km(*): ");
		lblKm.setBounds(100, 210, 160, 25);
		this.add(lblKm);

		txtKm = new JTextField(25);
		txtKm.setBounds(100, 230, 260, 25);
		this.add(txtKm);
		
		JLabel lblMotor = new JLabel("Motor(*): ");
		lblMotor.setBounds(100, 250, 160, 25);
		this.add(lblMotor);

		JLabel lblMotor2 = new JLabel();
		lblMotor2.setBounds(100, 270, 260, 25);
		this.add(lblMotor2);
		
		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(100, 290, 160, 25);
		this.add(lblDominio);

		JLabel lblDominio2 = new JLabel();
		lblDominio2.setBounds(100, 310, 260, 25);
		this.add(lblDominio2);
		
		JLabel lblPvc = new JLabel("PVC(*): ");
		lblPvc.setBounds(100, 330, 160, 25);
		this.add(lblPvc);

		txtPvc = new JTextField(25);
		txtPvc.setBounds(100, 350, 260, 25);
		this.add(txtPvc);
		
		JLabel lblfechaIngreso = new JLabel("Fecha de ingreso: ");
		lblfechaIngreso.setBounds(100, 370, 160, 25);
		this.add(lblfechaIngreso);

		JLabel lblfechaIngreso2 = new JLabel();
		lblfechaIngreso2.setBounds(100, 390, 260, 25);
		this.add(lblfechaIngreso2);
		
		JLabel lblFechaVenta = new JLabel("Fecha de venta: ");
		lblFechaVenta.setBounds(100, 410, 160, 25);
		this.add(lblFechaVenta);

		txtFechaVenta = new JTextField(25);
		txtFechaVenta.setBounds(100, 430, 260, 25);
		this.add(txtFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(100, 450, 160, 25);
		this.add(lblCondicion);

		txtCondicion = new JTextField(25);
		txtCondicion.setBounds(100, 470, 260, 25);
		this.add(txtCondicion);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(100, 490, 160, 25);
		this.add(lblProveedor);

		JLabel lblProveedor2 = new JLabel();
		lblProveedor2.setBounds(100, 510, 260, 25);
		this.add(lblProveedor2);
		
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(100, 530, 160, 25);
		this.add(lblCliente);

		txtCliente = new JTextField(25);
		txtCliente.setBounds(100, 550, 260, 25);
		this.add(txtCliente);
		
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(100, 570, 160, 25);
		this.add(lblComentarios);

		txtComentarios = new JTextField(25);
		txtComentarios.setBounds(100, 590, 260, 25);
		this.add(txtComentarios);
		
		

		btnAceptar = new JButton("Guardar");
		btnAceptar.setBounds(500, 220, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(500, 250, 100, 25);
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

	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public void setTxtPatente(JTextField txtPatente) {
		this.txtPatente = txtPatente;
	}

	public JTextField getTxtKm() {
		return txtKm;
	}

	public void setTxtKm(JTextField txtKm) {
		this.txtKm = txtKm;
	}

	public JTextField getTxtPvc() {
		return txtPvc;
	}

	public void setTxtPvc(JTextField txtPvc) {
		this.txtPvc = txtPvc;
	}

	public JTextField getTxtFechaVenta() {
		return txtFechaVenta;
	}

	public void setTxtFechaVenta(JTextField txtFechaVenta) {
		this.txtFechaVenta = txtFechaVenta;
	}

	public JTextField getTxtCondicion() {
		return txtCondicion;
	}

	public void setTxtCondicion(JTextField txtCondicion) {
		this.txtCondicion = txtCondicion;
	}

	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(JTextField txtCliente) {
		this.txtCliente = txtCliente;
	}

	public JTextField getTxtComentarios() {
		return txtComentarios;
	}

	public void setTxtComentarios(JTextField txtComentarios) {
		this.txtComentarios = txtComentarios;
	}



}
