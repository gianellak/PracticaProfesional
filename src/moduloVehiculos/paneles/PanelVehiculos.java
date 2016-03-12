package moduloVehiculos.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import objetos.Stock;
import objetos.Vehiculo;
import utilitarios.Mensajes;
import utilitarios.StringMsj;

public class PanelVehiculos extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver, btnAceptar, btnFiltrar, btnCancelar, btnDetalle, btnSeleccionar, 
					btnVolverVenta, btnElegir, btnVolverAStock, btnCopiar, btnBuscar;
	private JTextField txtPatente, txtKm, txtPvc, txtFechaVenta, txtCondicion, txtCliente, txtComentarios, txtProveedor, 
					   txtFechaIngreso, txtDominio, txtMotor, txtYear, txtColor, txtMarca, txtModelo, patenteText;
	private FormStock panelStock;
	private JComboBox<String> comboListYear, comboListMarca;
	private int w, h;
	
	
	public PanelVehiculos(){
		
		
		
		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		w = width.intValue() - 250;
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		h = height.intValue() - 150;
		
		this.setPreferredSize(new Dimension(w, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		this.setLayout(null);
	}
	
	public void onNuevoVehiculo() {

		this.removeAll();

		JLabel datosLabel = new JLabel("Por favor, ingrese los datos de la nueva unidad.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		labels();
		
		textFields();
		
		btnAceptar = new JButton("Guardar");
		btnAceptar.setBounds(100, 440, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(210, 440, 100, 25);
		this.add(btnCancelar);
		
		this.validate();
		this.repaint();

	}
	
	private void textFields() {
		
		txtPatente = new JTextField(9);
		txtPatente.setBounds(170, 90, 160, 25);
		this.add(txtPatente);

		txtMarca = new JTextField(9);
		txtMarca.setBounds(480, 90, 160, 25);
		this.add(txtMarca);

		txtModelo = new JTextField(6);
		txtModelo.setBounds(170, 130, 160, 25);
		this.add(txtModelo);
		
		txtYear = new JTextField(25);
		txtYear.setBounds(480, 130, 160, 25);
		this.add(txtYear);

		txtColor = new JTextField(25);
		txtColor.setBounds(170, 170, 160, 25);
		this.add(txtColor);

		txtKm = new JTextField(25);
		txtKm.setBounds(480, 170, 160, 25);
		this.add(txtKm);

		txtDominio = new JTextField(25);
		txtDominio.setBounds(170, 210, 160, 25);
		this.add(txtDominio);
		
		txtPvc = new JTextField(25);
		txtPvc.setBounds(480, 210, 160, 25);
		this.add(txtPvc);
		
		txtFechaIngreso = new JTextField(25);
		txtFechaIngreso.setBounds(170, 250, 160, 25);
		this.add(txtFechaIngreso);
		
		txtProveedor = new JTextField(25);
		txtProveedor.setBounds(480, 250, 160, 25);
		this.add(txtProveedor);

		txtFechaVenta = new JTextField(25);
		txtFechaVenta.setBounds(170, 290, 160, 25);
		this.add(txtFechaVenta);
		
		txtCondicion = new JTextField(25);
		txtCondicion.setBounds(480, 290, 160, 25);
		this.add(txtCondicion);
		
		txtCliente = new JTextField(25);
		txtCliente.setBounds(170, 330, 160, 25);
		this.add(txtCliente);
		
		txtMotor = new JTextField(25);
		txtMotor.setBounds(480, 330, 160, 25);
		this.add(txtMotor);
		
		txtComentarios = new JTextField(25);
		txtComentarios.setBounds(170, 370, 500, 25);
		this.add(txtComentarios);

		
	}

	public void onModificarVehiculo() {

		this.setLayout(null);
		
		System.out.println("ACA EN MODIFICAR VEHICULO");
		
		editableTextFields();
		
		btnAceptar = new JButton("Guardar");
		btnAceptar.setBounds(500, 220, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(500, 250, 100, 25);
		this.add(btnCancelar);
		
		
		
	}


	
	public void menuVentaStock(){
		
		btnDetalle = new JButton("Ver Detalle");
		btnDetalle.setBounds(150, 500, 150, 25);
		this.add(btnDetalle);

		btnSeleccionar = new JButton("Elegir vehiculo");
		btnSeleccionar.setBounds(320, 500, 150, 25);
		this.add(btnSeleccionar);
		
		btnVolverVenta = new JButton("Volver");
		btnVolverVenta.setBounds(490, 500, 150, 25);
		this.add(btnVolverVenta);
		
		
		this.validate();
		this.repaint();
		
	}
	
	public void menuVerStock(){
		
		btnDetalle = new JButton("Ver Detalle");
		btnDetalle.setBounds(150, 500, 150, 25);
		this.add(btnDetalle);
		
		btnSeleccionar = new JButton("Vender vehiculo");
		btnSeleccionar.setBounds(320, 500, 150, 25);
		this.add(btnSeleccionar);
		
		btnCopiar = new JButton("Copiar Vehiculo");
		btnCopiar.setBounds(490, 500, 150, 25);
		this.add(btnCopiar);
		
		btnVolverVenta = new JButton("Volver");
		btnVolverVenta.setBounds(650, 500, 150, 25);
		this.add(btnVolverVenta);
		
		
		this.validate();
		this.repaint();
		
	}

	

	public String getVehiculoTabla() {
		
		int a = panelStock.getTablaStock().getSelectedRow();
		
		String patente = null;
		try {
			patente = String.valueOf(panelStock.getTablaStock().getModel().getValueAt(a,0));
		} catch (Exception e) {
			return null;
		}
				
		return patente;
		
	}
	
	public void labels(){
		
		JLabel lblPatente = new JLabel("Patente(*): ");
		lblPatente.setBounds(50, 90, 70, 25);
		this.add(lblPatente);

		JLabel lblMarca = new JLabel("Marca(*): ");
		lblMarca.setBounds(360, 90, 70, 25);
		this.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo(*): ");
		lblModelo.setBounds(50, 130, 70, 25);
		this.add(lblModelo);

		JLabel lblYear = new JLabel("Año(*): ");
		lblYear.setBounds(360, 130, 70, 25);
		this.add(lblYear);

		JLabel lblColor = new JLabel("Color(*): ");
		lblColor.setBounds(50, 170, 70, 25);
		this.add(lblColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(360, 170, 70, 25);
		this.add(lblKm);

		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(50, 210, 70, 25);
		this.add(lblDominio);
		
		JLabel lblPvc = new JLabel("PVC(*): ");
		lblPvc.setBounds(360, 210, 100, 25);
		this.add(lblPvc);
		
		JLabel lblfechaIngreso = new JLabel("Fecha ingreso: ");
		lblfechaIngreso.setBounds(50, 250, 90, 25);
		this.add(lblfechaIngreso);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(360, 250, 70, 25);
		this.add(lblProveedor);

		JLabel lblFechaVenta = new JLabel("Fecha condicion: ");
		lblFechaVenta.setBounds(50, 290, 90, 25);
		this.add(lblFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(360, 290, 70, 25);
		this.add(lblCondicion);		
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(50, 330, 70, 25);
		this.add(lblCliente);
		
		JLabel lblMotor = new JLabel("Motor(*): ");
		lblMotor.setBounds(360, 330, 70, 25);
		this.add(lblMotor);
				
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(50, 370, 90, 25);
		this.add(lblComentarios);
	}

	public void mostrarDetalleVehiculo(Vehiculo v) {
		
		this.removeAll();
		
			JLabel datosLabel = new JLabel("A continuación de muestra el detalle de la unidad consultada. ");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		labels();

		textFields();
		
		cargarTextFields(v);
		
		notEditableTextFields();
		
		

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
		
		
	}

public void muestroStock(List<Stock> lista) {
		
		JLabel datosLabel = new JLabel("A continuación de muestra el stock actual. ");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel filtroLabel = new JLabel("Si lo desea, puede filtrar su búsqueda en base a alguno de los siguientes conceptos: ");
		filtroLabel.setBounds(50, 75, 560, 25);
		this.add(filtroLabel);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(50, 100, 50, 25);
		this.add(lblMarca);
		
		JLabel lblYear = new JLabel("Año: ");
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
		
		comboListMarca = extracted(comboMarca);
		comboListMarca.setBounds(50, 120, 200, 25);
		this.add(comboListMarca);		
		
		comboListYear = extracted(comboYear);
		comboListYear.setBounds(260, 120, 200, 25);
		this.add(comboListYear);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(680, 120,100,25);
		this.add(btnFiltrar);

		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox extracted(ArrayList<String> comboModelo) {
		return new JComboBox(comboModelo.toArray());
	}

	public void onBuscarVehiculo() {
		
		this.removeAll();
		
		JLabel dniCompradorLabel = new JLabel("Ingrese patente o motor a buscar: ");
		dniCompradorLabel.setBounds(50, 50, 200, 25);
		this.add(dniCompradorLabel);

		patenteText = new JTextField(9);
		patenteText.setBounds(260, 50, 160, 25);
		this.add(patenteText);
		

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(70, 120, 160, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(240, 120, 160, 25);
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
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

	public JComboBox<String> getComboListYear() {
		return comboListYear;
	}

	public void setComboListYear(JComboBox<String> comboListYear) {
		this.comboListYear = comboListYear;
	}

	public JComboBox<String> getComboListMarca() {
		return comboListMarca;
	}

	public void setComboListMarca(JComboBox<String> comboListMarca) {
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

	


	
	
	
	

}
