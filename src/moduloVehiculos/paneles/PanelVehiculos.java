package moduloVehiculos.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.NullCipher;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import moduloVenta.listener.ListenerComboModelo;
import objetos.Stock;
import objetos.Vehiculo;

public class PanelVehiculos extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JButton btnAceptar;

	private JTextField txtPatente;
	private JTextField txtKm;
	private JTextField txtPvc;
	private JTextField txtFechaVenta;
	private JTextField txtCondicion;
	private JTextField txtCliente;
	private JTextField txtComentarios;
	private JButton btnCancelar;
	private JTextField txtProveedor;
	private JTextField txtFechaIngreso;
	private JTextField txtDominio;
	private JTextField txtMotor;
	private JTextField txtYear;
	private JTextField txtColor;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private FormStock panelStock;
	private int w, h;
	private JButton btnVender;
	private JButton btnDetalle;
	private JButton btnSeleccionar;
	private JButton btnVolverVenta;
	private JButton btnElegir;
	private JButton btnVolverAStock;
	private JComboBox<String> comboList;
	private JComboBox<String> comboListModelo;
	private JComboBox<String> comboListYear;
	private ListenerComboModelo listenerComboModelo;
	private Component btnCopiar;
	private JTextField patenteText;
	private JButton btnBuscar;
	
	
	public PanelVehiculos(){
		
		
		
		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int w = width.intValue() - 250;
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int h = height.intValue() - 150;
		
		this.setPreferredSize(new Dimension(w, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		this.setLayout(null);
		
		
		
		
	}
	
	public void onNuevoVehiculo() {

		this.removeAll();
		System.out.println("onNuevoVehiculo()");

		JLabel lblPatente = new JLabel("Patente: ");
		lblPatente.setBounds(150, 30, 160, 25);
		this.add(lblPatente);

		txtPatente = new JTextField(9);
		txtPatente.setBounds(300, 30, 160, 25);
		this.add(txtPatente);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(150, 60, 160, 25);
		this.add(lblMarca);

		txtMarca = new JTextField(9);
		txtMarca.setBounds(300, 60, 160, 25);
		this.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(150, 90, 160, 25);
		this.add(lblModelo);

		txtModelo = new JTextField(6);
		txtModelo.setBounds(300, 90, 160, 25);
		this.add(txtModelo);

		JLabel lblYear = new JLabel("A�o: ");
		lblYear.setBounds(150, 120, 160, 25);
		this.add(lblYear);

		txtYear = new JTextField(25);
		txtYear.setBounds(300, 120, 260, 25);
		this.add(txtYear);

		JLabel lblColor = new JLabel("Color: ");
		lblColor.setBounds(150, 150, 160, 25);
		this.add(lblColor);

		txtColor = new JTextField(25);
		txtColor.setBounds(300, 150, 260, 25);
		this.add(txtColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(150, 180, 160, 25);
		this.add(lblKm);

		txtKm = new JTextField(25);
		txtKm.setBounds(300, 180, 260, 25);
		this.add(txtKm);
		
		JLabel lblMotor = new JLabel("Motor: ");
		lblMotor.setBounds(150, 210, 160, 25);
		this.add(lblMotor);

		txtMotor = new JTextField(25);
		txtMotor.setBounds(300, 210, 260, 25);
		this.add(txtMotor);
		
		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(150, 240, 160, 25);
		this.add(lblDominio);

		txtDominio = new JTextField(25);
		txtDominio.setBounds(300, 240, 260, 25);
		this.add(txtDominio);
		
		JLabel lblPvc = new JLabel("PVC: ");
		lblPvc.setBounds(150, 270, 160, 25);
		this.add(lblPvc);

		txtPvc = new JTextField(25);
		txtPvc.setBounds(300, 270, 260, 25);
		this.add(txtPvc);
		
		JLabel lblfechaIngreso = new JLabel("Fecha de ingreso: ");
		lblfechaIngreso.setBounds(150, 300, 160, 25);
		this.add(lblfechaIngreso);

		txtFechaIngreso = new JTextField(25);
		txtFechaIngreso.setBounds(300, 300, 260, 25);
		this.add(txtFechaIngreso);
		
		JLabel lblFechaVenta = new JLabel("Fecha de venta: ");
		lblFechaVenta.setBounds(150, 330, 160, 25);
		this.add(lblFechaVenta);

		txtFechaVenta = new JTextField(25);
		txtFechaVenta.setBounds(300, 330, 260, 25);
		this.add(txtFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(150, 360, 160, 25);
		this.add(lblCondicion);

		txtCondicion = new JTextField(25);
		txtCondicion.setBounds(300, 360, 260, 25);
		this.add(txtCondicion);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(150, 390, 160, 25);
		this.add(lblProveedor);

		txtProveedor = new JTextField(25);
		txtProveedor.setBounds(300, 390, 260, 25);
		this.add(txtProveedor);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(150, 420, 160, 25);
		this.add(lblCliente);

		txtCliente = new JTextField(25);
		txtCliente.setBounds(300, 420, 260, 25);
		this.add(txtCliente);
		
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(150, 450, 160, 25);
		this.add(lblComentarios);

		txtComentarios = new JTextField(25);
		txtComentarios.setBounds(300, 450, 260, 25);
		this.add(txtComentarios);
		
		

		btnAceptar = new JButton("Guardar");
		btnAceptar.setBounds(700, 220, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(700, 250, 100, 25);
		this.add(btnCancelar);
		
		
		this.validate();
		this.repaint();

	}
	
	public void onModificarVehiculo() {

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

		JLabel lblMarca2 = new JLabel(); 
		lblMarca2.setBounds(100, 70, 160, 25);
		this.add(lblMarca2);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(100, 90, 160, 25);
		this.add(lblModelo);

		JLabel lblModelo2 = new JLabel();
		lblModelo2.setBounds(100, 110, 160, 25);
		this.add(lblModelo2);

		JLabel lblYear = new JLabel("A�o: ");
		lblYear.setBounds(100, 130, 160, 25);
		this.add(lblYear);

		JLabel lblYear2 = new JLabel();
		lblYear2.setBounds(100, 150, 260, 25);
		this.add(lblYear2);

		JLabel lblColor = new JLabel("Color: ");
		lblColor.setBounds(100, 170, 160, 25);
		this.add(lblColor);

		JLabel lblColor2 = new JLabel();
		lblColor.setBounds(100, 190, 260, 25);
		this.add(lblColor2);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(100, 210, 160, 25);
		this.add(lblKm);

		txtKm = new JTextField(25);
		txtKm.setBounds(100, 230, 260, 25);
		this.add(txtKm);
		
		JLabel lblMotor = new JLabel("Motor: ");
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
		
		JLabel lblPvc = new JLabel("PVC: ");
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

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public void muestroStock(List<Stock> lista) {
	
		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(50, 0, 50, 25);
		this.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(50, 30, 50, 25);
		this.add(lblModelo);

		JLabel lblYear = new JLabel("A�o: ");
		lblYear.setBounds(280, 0, 50, 25);
		this.add(lblYear);
				
		panelStock = new FormStock(lista);
		
		this.add(panelStock.getJp());
	}
	
	public void menuVentaStock(){
		
		btnDetalle = new JButton("Ver Detalle");
		btnDetalle.setBounds(150, 400, 150, 25);
		this.add(btnDetalle);

		btnSeleccionar = new JButton("Elegir vehiculo");
		btnSeleccionar.setBounds(320, 400, 150, 25);
		this.add(btnSeleccionar);
		
		btnVolverVenta = new JButton("Volver");
		btnVolverVenta.setBounds(490, 400, 150, 25);
		this.add(btnVolverVenta);
		
		
		this.validate();
		this.repaint();
		
	}
	
	public void menuVerStock(){
		
		btnDetalle = new JButton("Ver Detalle");
		btnDetalle.setBounds(150, 400, 150, 25);
		this.add(btnDetalle);
		

		btnVender = new JButton("Vender vehiculo");
		btnVender.setBounds(320, 500, 150, 25);
		this.add(btnVender);
		
		btnCopiar = new JButton("Copiar Vehiculo");
		btnCopiar.setBounds(490, 400, 150, 25);
		this.add(btnCopiar);
		
		btnVolverVenta = new JButton("Volver");
		btnVolverVenta.setBounds(650, 400, 150, 25);
		this.add(btnVolverVenta);
		
		
		this.validate();
		this.repaint();
		
	}

	public JComboBox<String> getComboListModelo() {
		return comboListModelo;
	}

	public void setComboListModelo(JComboBox<String> comboListModelo) {
		this.comboListModelo = comboListModelo;
	}

	public JComboBox<String> getComboListYear() {
		return comboListYear;
	}

	public void setComboListYear(JComboBox<String> comboListYear) {
		this.comboListYear = comboListYear;
	}

	public ListenerComboModelo getListenerComboModelo() {
		return listenerComboModelo;
	}

	public void setListenerComboModelo(ListenerComboModelo listenerComboModelo) {
		this.listenerComboModelo = listenerComboModelo;
	}

	public JButton getBtnDetalle() {
		return btnDetalle;
	}

	public void setBtnDetalle(JButton btnDetalle) {
		this.btnDetalle = btnDetalle;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

	public JButton getBtnVolverVenta() {
		return btnVolverVenta;
	}

	public void setBtnVolverVenta(JButton btnVolverVenta) {
		this.btnVolverVenta = btnVolverVenta;
	}

	public String getVehiculoTabla() {
		int a = panelStock.getTablaStock().getSelectedRow();

		String patente = null;
		
		try {
			patente = String.valueOf(panelStock.getTablaStock().getModel().getValueAt(a,0));
		} catch (Exception e) {
			return null;
		}

				
		System.out.println(patente);
		return patente;
		
	}

	public void mostrarDetalleVehiculo(Vehiculo v) {
		
		this.removeAll();
		
		System.out.println("ON Detalle VEHICULO");

		JLabel lblPatente = new JLabel("Patente: ");
		lblPatente.setBounds(150, 30, 160, 25);
		this.add(lblPatente);

		txtPatente = new JTextField(v.getPatente());
		txtPatente.setBounds(300, 30, 160, 25);
		this.add(txtPatente);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(150, 60, 160, 25);
		this.add(lblMarca);

		txtMarca = new JTextField(v.getMarca());
		txtMarca.setBounds(300, 60, 160, 25);
		this.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(150, 90, 160, 25);
		this.add(lblModelo);

		txtModelo = new JTextField(v.getModelo());
		txtModelo.setBounds(300, 90, 160, 25);
		this.add(txtModelo);

		JLabel lblYear = new JLabel("A�o: ");
		lblYear.setBounds(150, 120, 160, 25);
		this.add(lblYear);

		txtYear = new JTextField(v.getYear());
		txtYear.setBounds(300, 120, 260, 25);
		this.add(txtYear);

		JLabel lblColor = new JLabel("Color: ");
		lblColor.setBounds(150, 150, 160, 25);
		this.add(lblColor);

		txtColor = new JTextField(v.getColor());
		txtColor.setBounds(300, 150, 260, 25);
		this.add(txtColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(150, 180, 160, 25);
		this.add(lblKm);

		txtKm = new JTextField(v.getKm());
		txtKm.setBounds(300, 180, 260, 25);
		this.add(txtKm);
		
		JLabel lblMotor = new JLabel("Motor: ");
		lblMotor.setBounds(150, 210, 160, 25);
		this.add(lblMotor);

		txtMotor = new JTextField(v.getMotor());
		txtMotor.setBounds(300, 210, 260, 25);
		this.add(txtMotor);
		
		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(150, 240, 160, 25);
		this.add(lblDominio);

		txtDominio = new JTextField(v.getDominio());
		txtDominio.setBounds(300, 240, 260, 25);
		this.add(txtDominio);
		
		JLabel lblPvc = new JLabel("PVC: ");
		lblPvc.setBounds(150, 270, 160, 25);
		this.add(lblPvc);

		txtPvc = new JTextField(v.getPvc());
		txtPvc.setBounds(300, 270, 260, 25);
		this.add(txtPvc);
		
		JLabel lblfechaIngreso = new JLabel("Fecha de ingreso: ");
		lblfechaIngreso.setBounds(150, 300, 160, 25);
		this.add(lblfechaIngreso);

		txtFechaIngreso = new JTextField(v.getFechaIngreso());
		txtFechaIngreso.setBounds(300, 300, 260, 25);
		this.add(txtFechaIngreso);
		
		JLabel lblFechaVenta = new JLabel("Fecha de venta: ");
		lblFechaVenta.setBounds(150, 330, 160, 25);
		this.add(lblFechaVenta);

		txtFechaVenta = new JTextField(v.getFechaVenta());
		txtFechaVenta.setBounds(300, 330, 260, 25);
		this.add(txtFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(150, 360, 160, 25);
		this.add(lblCondicion);

		txtCondicion = new JTextField(v.getCondicion());
		txtCondicion.setBounds(300, 360, 260, 25);
		this.add(txtCondicion);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(150, 390, 160, 25);
		this.add(lblProveedor);

		txtProveedor = new JTextField(v.getIdProveedor());
		txtProveedor.setBounds(300, 390, 260, 25);
		this.add(txtProveedor);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(150, 420, 160, 25);
		this.add(lblCliente);

		txtCliente = new JTextField(v.getIdCliente());
		txtCliente.setBounds(300, 420, 260, 25);
		this.add(txtCliente);
		
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(150, 450, 160, 25);
		this.add(lblComentarios);

		txtComentarios = new JTextField(25);
		txtComentarios.setBounds(300, 450, 260, 25);
		this.add(txtComentarios);
		
		

		btnElegir = new JButton("Seleccionar Vehiculo");
		btnElegir.setBounds(700, 220, 160, 25);
		this.add(btnElegir);

		btnVolverAStock = new JButton("Volver a Stock");
		btnVolverAStock.setBounds(700, 250, 160, 25);
		this.add(btnVolverAStock);

		this.validate();
		this.repaint();
		
	}


private void notEditableTextFields() {
	
		txtPatente.setEditable(false);
		txtMarca.setEditable(false);
		txtModelo.setEditable(false);
		txtYear.setEditable(false);
		txtColor.setEditable(false);
		txtKm.setEditable(false);
		txtMotor.setEditable(false);
		txtDominio.setEditable(false);
		txtPvc.setEditable(false);
		txtFechaIngreso.setEditable(false);
		txtFechaVenta.setEditable(false);
		txtCondicion.setEditable(false);
		txtProveedor.setEditable(false);
		txtCliente.setEditable(false);
		txtComentarios.setEditable(false);
		
	}

private void editableTextFields() {
	
	txtPatente.setEditable(true);
	txtYear.setEditable(true);
	txtKm.setEditable(true);
	txtPvc.setEditable(true);
	txtFechaIngreso.setEditable(true);
	txtFechaVenta.setEditable(true);
	txtCondicion.setEditable(true);
	txtCliente.setEditable(true);
	txtComentarios.setEditable(true);
	
}

private void allEditableTextFields() {
	
	txtPatente.setEditable(true); 
	txtMarca.setEditable(true);
	txtModelo.setEditable(true);
	txtYear.setEditable(true);
	txtColor.setEditable(true);
	txtKm.setEditable(true);
	txtMotor.setEditable(true);
	txtDominio.setEditable(true);
	txtPvc.setEditable(true);
	txtFechaIngreso.setEditable(true);
	txtFechaVenta.setEditable(true);
	txtCondicion.setEditable(true);
	txtProveedor.setEditable(true);
	txtCliente.setEditable(true);
	txtComentarios.setEditable(true);
	
}

private void cargarTextFields(Vehiculo v) {
	
	
		try {
			txtPatente.setText(v.getPatente());
			txtMarca.setText(v.getMarca());
			txtModelo.setText(v.getModelo());
			txtYear.setText(v.getYear());
			txtColor.setText(v.getColor());
			txtKm.setText(String.valueOf(v.getKm()));
			txtMotor.setText(v.getMotor());
			txtDominio.setText(v.getDominio());
			txtPvc.setText(String.valueOf(v.getPvc()));
			txtFechaIngreso.setText(v.getFechaIngreso());
			txtFechaVenta.setText(v.getFechaVenta());
			txtCondicion.setText(v.getCondicion());
			txtProveedor.setText(String.valueOf(v.getIdProveedor()));
			txtCliente.setText(String.valueOf(v.getIdCliente()));
			txtComentarios.setText(v.getComentarios());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage().toString());
		}
		
		
	}

public void muestroStock(List<Stock> lista) {
		
		JLabel datosLabel = new JLabel("A continuaci�n de muestra el stock actual. ");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel filtroLabel = new JLabel("Si lo desea, puede filtrar su b�squeda en base a alguno de los siguientes conceptos: ");
		filtroLabel.setBounds(50, 75, 560, 25);
		this.add(filtroLabel);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(50, 100, 50, 25);
		this.add(lblMarca);
		
		JLabel lblYear = new JLabel("A�o: ");
		lblYear.setBounds(260, 100, 50, 25);
		this.add(lblYear);
				
		panelStock = new FormStock(lista);
		
		panelStock.getJp().setBounds(50, 170, w - 100, 300);
		
		this.add(panelStock.getJp());
		
		this.revalidate();
		this.repaint();
	}
	
	@SuppressWarnings("unchecked")
	public void preparoFiltros(ArrayList<String> comboMarca, ArrayList<String> comboModelo, ArrayList<String> comboYear) {
		
		comboListModelo = extracted(comboModelo);
		comboListModelo.setBounds(120, 0, 150, 25);
		this.add(comboListModelo);
		
		comboListMarca = extracted(comboMarca);
		comboListMarca.setBounds(120, 30, 250, 25);
		this.add(comboListMarca);
		
		comboListYear = extracted(comboYear);
		comboListYear.setBounds(340, 0, 250, 25);
		this.add(comboListYear);

		
	}

	private JComboBox extracted(ArrayList<String> comboModelo) {
		return new JComboBox(comboModelo.toArray());
	}

	public void onBuscarVehiculo() {
		this.removeAll();
		System.out.println("ONMOD");
		
		JLabel dniCompradorLabel = new JLabel("Ingrese patente o motor a buscar: ");
		dniCompradorLabel.setBounds(150, 0, 260, 25);
		this.add(dniCompradorLabel);

		patenteText = new JTextField(9);
		patenteText.setBounds(380, 0, 160, 25);
		this.add(patenteText);
		

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(700, 270, 160, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(700, 300, 160, 25);
		this.add(btnVolver);
		
		
		this.validate();
		this.repaint();
		
	}

	public JButton getBtnElegir() {
		return btnElegir;
	}

	public void setBtnElegir(JButton btnElegir) {
		this.btnElegir = btnElegir;
	}

	public JButton getBtnVolverAStock() {
		return btnVolverAStock;
	}

	public void setBtnVolverAStock(JButton btnVolverAStock) {
		this.btnVolverAStock = btnVolverAStock;
	}

	public Component getBtnCopiar() {
		return btnCopiar;
	}

	public void setBtnCopiar(Component btnCopiar) {
		this.btnCopiar = btnCopiar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getPatenteText() {
		return patenteText;
	}

	public void setPatenteText(JTextField patenteText) {
		this.patenteText = patenteText;
	}

	public JTextField getTxtProveedor() {
		return txtProveedor;
	}

	public void setTxtProveedor(JTextField txtProveedor) {
		this.txtProveedor = txtProveedor;
	}

	public JTextField getTxtFechaIngreso() {
		return txtFechaIngreso;
	}

	public void setTxtFechaIngreso(JTextField txtFechaIngreso) {
		this.txtFechaIngreso = txtFechaIngreso;
	}

	public JTextField getTxtDominio() {
		return txtDominio;
	}

	public void setTxtDominio(JTextField txtDominio) {
		this.txtDominio = txtDominio;
	}

	public JTextField getTxtMotor() {
		return txtMotor;
	}

	public void setTxtMotor(JTextField txtMotor) {
		this.txtMotor = txtMotor;
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

	public FormStock getPanelStock() {
		return panelStock;
	}

	public void setPanelStock(FormStock panelStock) {
		this.panelStock = panelStock;
	}

	public JComboBox<String> getComboList() {
		return comboList;
	}

	public void setComboList(JComboBox<String> comboList) {
		this.comboList = comboList;
	}

	public JComboBox getComboListMarca() {
		return comboListMarca;
	}

	public void setComboListMarca(JComboBox comboListMarca) {
		this.comboListMarca = comboListMarca;
	}


	public JButton getBtnCopiar() {
		return btnCopiar;
	}

	public void setBtnCopiar(JButton btnCopiar) {
		this.btnCopiar = btnCopiar;
	}

	public JTextField getPatenteText() {
		return patenteText;
	}

	public void setPatenteText(JTextField patenteText) {
		this.patenteText = patenteText;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
	}

	public void copioVehiculo(Vehiculo vehiculo) {

		this.removeAll();

		JLabel datosLabel = new JLabel("Por favor, ingrese los datos de la nueva unidad.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		labels();
		
		textFields();
		
		cargarTextFields(vehiculo);
		
		txtPatente.setText("");
		txtMotor.setText("");
		
		btnAceptar = new JButton("Guardar");
		btnAceptar.setBounds(100, 440, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(210, 440, 100, 25);
		this.add(btnCancelar);
		
		this.validate();
		this.repaint();


		
	}

	public JButton getBtnVender() {
		return btnVender;
	}

	public void setBtnVender(JButton btnVender) {
		this.btnVender = btnVender;
	}


}
