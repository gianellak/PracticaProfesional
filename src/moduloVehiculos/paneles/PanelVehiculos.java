package moduloVehiculos.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import moduloVehiculo.paneles.FormStock;
import moduloVenta.listener.ListenerComboModelo;
import objetos.Persona;
import objetos.Stock;
import objetos.Vehiculo;

public class PanelVehiculos extends JPanel {
	
	
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
	private JButton btnDetalle;
	private JButton btnSeleccionar;
	private JButton btnVolverVenta;
	private JButton btnElegir;
	private JButton btnVolverAStock;
	private JComboBox<String> comboList;
	private JComboBox<String> comboListModelo;
	private JComboBox<String> comboListYear;
	private ListenerComboModelo listenerComboModelo;
	private JComboBox comboListMarca;
	private Component btnCopiar;
	
	
	public PanelVehiculos(){
		
		
		System.out.println("Creo nuevo panel Cliente");
		
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
		
		
	}
	
	public void onNuevoVehiculo() {

		this.removeAll();
		System.out.println("ONALTAVEHICULO");

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

		JLabel lblYear = new JLabel("Año: ");
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

		JLabel lblYear = new JLabel("Año: ");
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

		JLabel lblYear = new JLabel("Modelo: ");
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
		
		btnSeleccionar = new JButton("Vender vehiculo");
		btnSeleccionar.setBounds(320, 400, 150, 25);
		this.add(btnSeleccionar);
		
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
		
		String patente = String.valueOf(panelStock.getTablaStock().getModel().getValueAt(a,0));
				
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

		JLabel lblYear = new JLabel("Año: ");
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

	public void preparoFiltros(ArrayList<String> comboMarca, ArrayList<String> comboModelo, ArrayList<String> comboYear) {
		
		comboListModelo = new JComboBox(comboModelo.toArray());
		comboListModelo.setBounds(120, 0, 150, 25);
		this.add(comboListModelo);
		
		comboListMarca = new JComboBox(comboMarca.toArray());
		comboListMarca.setBounds(120, 30, 250, 25);
		this.add(comboListMarca);
		
		comboListYear = new JComboBox(comboYear.toArray());
		comboListYear.setBounds(340, 0, 250, 25);
		this.add(comboListYear);

		
	}


}
