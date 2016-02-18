package vehiculo.ABM;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import moduloVehiculo.listener.ListenerAceptarNuevoVehiculo;

public class FormNuevoVehiculo extends JPanel {

	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JTextField txtPatente, txtMarca, txtModelo, txtYear, txtColor, txtKm, txtMotor, txtDominio, txtPvc, txtFechaIngreso, txtFechaVenta, txtCondicion, txtProveedor, txtCliente, txtComentarios;
	
	
	private ListenerAceptarNuevoVehiculo listenerAceptar;

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
		
		JLabel lblMotor = new JLabel("Motor: ");
		lblMotor.setBounds(100, 250, 160, 25);
		this.add(lblKm);

		txtMotor = new JTextField(25);
		txtMotor.setBounds(100, 270, 260, 25);
		this.add(txtMotor);
		
		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(100, 290, 160, 25);
		this.add(lblKm);

		txtDominio = new JTextField(25);
		txtDominio.setBounds(100, 310, 260, 25);
		this.add(txtDominio);
		
		JLabel lblPvc = new JLabel("Pvc: ");
		lblPvc.setBounds(100, 330, 160, 25);
		this.add(lblKm);

		txtPvc = new JTextField(25);
		txtPvc.setBounds(100, 350, 260, 25);
		this.add(txtPvc);
		
		JLabel lblfechaIngreso = new JLabel("fechaIngreso: ");
		lblfechaIngreso.setBounds(100, 370, 160, 25);
		this.add(lblKm);

		txtFechaIngreso = new JTextField(25);
		txtFechaIngreso.setBounds(100, 390, 260, 25);
		this.add(txtFechaIngreso);
		
		JLabel lblFechaVenta = new JLabel("FechaVenta: ");
		lblFechaVenta.setBounds(100, 410, 160, 25);
		this.add(lblKm);

		txtFechaVenta = new JTextField(25);
		txtFechaVenta.setBounds(100, 430, 260, 25);
		this.add(txtFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(100, 450, 160, 25);
		this.add(lblKm);

		txtCondicion = new JTextField(25);
		txtCondicion.setBounds(100, 470, 260, 25);
		this.add(txtCondicion);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(100, 490, 160, 25);
		this.add(lblKm);

		txtProveedor = new JTextField(25);
		txtProveedor.setBounds(100, 510, 260, 25);
		this.add(txtProveedor);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(100, 530, 160, 25);
		this.add(lblKm);

		txtCliente = new JTextField(25);
		txtCliente.setBounds(100, 550, 260, 25);
		this.add(txtCliente);
		
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(100, 570, 160, 25);
		this.add(lblKm);

		txtComentarios = new JTextField(25);
		txtComentarios.setBounds(100, 590, 260, 25);
		this.add(txtComentarios);
		
		

		btnAceptar = new JButton("Ingresar Vehículo");
		btnAceptar.setBounds(300, 120, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(300, 150, 100, 25);
		this.add(btnCancelar);

	}
	
	
	// GETTERS Y SETTERS

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


	public JTextField getTxtMarca() {
		return txtMarca;
	}


	public void setTxtMarca(JTextField txtMarca) {
		this.txtMarca = txtMarca;
	}


	public JTextField getTxtModelo() {
		return txtModelo;
	}


	public void setTxtModelo(JTextField txtModelo) {
		this.txtModelo = txtModelo;
	}


	public JTextField getTxtYear() {
		return txtYear;
	}


	public void setTxtYear(JTextField txtYear) {
		this.txtYear = txtYear;
	}


	public JTextField getTxtColor() {
		return txtColor;
	}


	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}


	public JTextField getTxtKm() {
		return txtKm;
	}


	public void setTxtKm(JTextField txtKm) {
		this.txtKm = txtKm;
	}


	public JTextField getTxtMotor() {
		return txtMotor;
	}


	public void setTxtMotor(JTextField txtMotor) {
		this.txtMotor = txtMotor;
	}


	public JTextField getTxtDominio() {
		return txtDominio;
	}


	public void setTxtDominio(JTextField txtDominio) {
		this.txtDominio = txtDominio;
	}


	public JTextField getTxtPvc() {
		return txtPvc;
	}


	public void setTxtPvc(JTextField txtPvc) {
		this.txtPvc = txtPvc;
	}


	public JTextField getTxtFechaIngreso() {
		return txtFechaIngreso;
	}


	public void setTxtFechaIngreso(JTextField txtFechaIngreso) {
		this.txtFechaIngreso = txtFechaIngreso;
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


	public JTextField getTxtProveedor() {
		return txtProveedor;
	}


	public void setTxtProveedor(JTextField txtProveedor) {
		this.txtProveedor = txtProveedor;
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
