package moduloVehiculos.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import moduloVehiculos.listener.ListenerCombo;
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
	private JButton btnDetalle;
	private JButton btnSeleccionar;
	private JButton btnVolverVenta;
	private JButton btnElegir;
	private JButton btnVolverAStock;
	private JComboBox<String> comboListModelo;
	private JComboBox<String> comboListYear;
	private JComboBox comboListMarca;
	private Component btnCopiar;
	private JTextField patenteText;
	private JButton btnBuscar;
	private int w;
	private int h;
	private JButton btnFiltrar;
	
	
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

		JLabel datosLabel = new JLabel("Por favor, ingrese los datos del vehiculo a dar de alta.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel lblPatente = new JLabel("Patente: ");
		lblPatente.setBounds(50, 90, 70, 25);
		this.add(lblPatente);

		txtPatente = new JTextField(9);
		txtPatente.setBounds(170, 90, 160, 25);
		this.add(txtPatente);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(360, 90, 70, 25);
		this.add(lblMarca);

		txtMarca = new JTextField(9);
		txtMarca.setBounds(480, 90, 160, 25);
		this.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(50, 130, 70, 25);
		this.add(lblModelo);

		txtModelo = new JTextField(6);
		txtModelo.setBounds(170, 130, 160, 25);
		this.add(txtModelo);

		JLabel lblYear = new JLabel("Año: ");
		lblYear.setBounds(360, 130, 70, 25);
		this.add(lblYear);

		txtYear = new JTextField(25);
		txtYear.setBounds(480, 130, 160, 25);
		this.add(txtYear);

		JLabel lblColor = new JLabel("Color: ");
		lblColor.setBounds(50, 170, 70, 25);
		this.add(lblColor);

		txtColor = new JTextField(25);
		txtColor.setBounds(170, 170, 160, 25);
		this.add(txtColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(360, 170, 70, 25);
		this.add(lblKm);

		txtKm = new JTextField(25);
		txtKm.setBounds(480, 170, 160, 25);
		this.add(txtKm);

		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(50, 210, 70, 25);
		this.add(lblDominio);

		txtDominio = new JTextField(25);
		txtDominio.setBounds(170, 210, 160, 25);
		this.add(txtDominio);
		
		JLabel lblPvc = new JLabel("Precio Lista: ");
		lblPvc.setBounds(360, 210, 100, 25);
		this.add(lblPvc);

		txtPvc = new JTextField(25);
		txtPvc.setBounds(480, 210, 160, 25);
		this.add(txtPvc);
		
		JLabel lblfechaIngreso = new JLabel("Fecha ingreso: ");
		lblfechaIngreso.setBounds(50, 250, 90, 25);
		this.add(lblfechaIngreso);

		txtFechaIngreso = new JTextField(25);
		txtFechaIngreso.setBounds(170, 250, 160, 25);
		this.add(txtFechaIngreso);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(360, 250, 70, 25);
		this.add(lblProveedor);
		
		txtProveedor = new JTextField(25);
		txtProveedor.setBounds(480, 250, 160, 25);
		this.add(txtProveedor);

		JLabel lblFechaVenta = new JLabel("Fecha condicion: ");
		lblFechaVenta.setBounds(50, 290, 90, 25);
		this.add(lblFechaVenta);

		txtFechaVenta = new JTextField(25);
		txtFechaVenta.setBounds(170, 290, 160, 25);
		this.add(txtFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(360, 290, 70, 25);
		this.add(lblCondicion);

		txtCondicion = new JTextField(25);
		txtCondicion.setBounds(480, 290, 160, 25);
		this.add(txtCondicion);
		
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(50, 330, 70, 25);
		this.add(lblCliente);

		txtCliente = new JTextField(25);
		txtCliente.setBounds(170, 330, 160, 25);
		this.add(txtCliente);
		
		JLabel lblMotor = new JLabel("Motor: ");
		lblMotor.setBounds(360, 330, 70, 25);
		this.add(lblMotor);

		txtMotor = new JTextField(25);
		txtMotor.setBounds(480, 330, 160, 25);
		this.add(txtMotor);
		
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(50, 370, 90, 25);
		this.add(lblComentarios);

		txtComentarios = new JTextField(25);
		txtComentarios.setBounds(170, 370, 500, 25);
		this.add(txtComentarios);

		btnAceptar = new JButton("Guardar");
		btnAceptar.setBounds(100, 440, 100, 25);
		this.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(210, 440, 100, 25);
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
		
		String patente = String.valueOf(panelStock.getTablaStock().getModel().getValueAt(a,0));
				
		return patente;
		
	}

	public void mostrarDetalleVehiculo(Vehiculo v) {
		
		this.removeAll();
		
		txtPatente = new JTextField(v.getPatente());
		txtMarca = new JTextField(v.getMarca());
		txtModelo = new JTextField(v.getModelo());
		txtYear = new JTextField(v.getYear());
		txtColor = new JTextField(v.getColor());
		txtKm = new JTextField(v.getKm());
		txtMotor = new JTextField(v.getMotor());
		txtDominio = new JTextField(v.getDominio());
		txtPvc = new JTextField(v.getPvc());
		txtFechaIngreso = new JTextField(v.getFechaIngreso());
		txtFechaVenta = new JTextField(v.getFechaVenta());
		txtCondicion = new JTextField(v.getCondicion());
		txtProveedor = new JTextField(v.getIdProveedor());
		txtCliente = new JTextField(v.getIdCliente());
		txtComentarios = new JTextField(25);
		
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
		
		
		JLabel datosLabel = new JLabel("A continuación de muestra el detalle de la unidad consultada. ");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel lblPatente = new JLabel("Patente(*): ");
		lblPatente.setBounds(50, 90, 70, 25);
		this.add(lblPatente);

		txtPatente.setBounds(170, 90, 160, 25);
		this.add(txtPatente);

		JLabel lblMarca = new JLabel("Marca(*): ");
		lblMarca.setBounds(360, 90, 70, 25);
		this.add(lblMarca);

		txtMarca.setBounds(480, 90, 160, 25);
		this.add(txtMarca);

		JLabel lblModelo = new JLabel("Modelo(*): ");
		lblModelo.setBounds(50, 130, 70, 25);
		this.add(lblModelo);

		txtModelo.setBounds(170, 130, 160, 25);
		this.add(txtModelo);

		JLabel lblYear = new JLabel("Año(*): ");
		lblYear.setBounds(360, 130, 70, 25);
		this.add(lblYear);

		txtYear.setBounds(480, 130, 160, 25);
		this.add(txtYear);

		JLabel lblColor = new JLabel("Color(*): ");
		lblColor.setBounds(50, 170, 70, 25);
		this.add(lblColor);

		txtColor.setBounds(170, 170, 160, 25);
		this.add(txtColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(360, 170, 70, 25);
		this.add(lblKm);

		txtKm.setBounds(480, 170, 160, 25);
		this.add(txtKm);

		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(50, 210, 70, 25);
		this.add(lblDominio);

		txtDominio.setBounds(170, 210, 160, 25);
		this.add(txtDominio);
		
		JLabel lblPvc = new JLabel("PVC(*): ");
		lblPvc.setBounds(360, 210, 100, 25);
		this.add(lblPvc);

		txtPvc.setBounds(480, 210, 160, 25);
		this.add(txtPvc);
		
		JLabel lblfechaIngreso = new JLabel("Fecha ingreso: ");
		lblfechaIngreso.setBounds(50, 250, 90, 25);
		this.add(lblfechaIngreso);

		txtFechaIngreso.setBounds(170, 250, 160, 25);
		this.add(txtFechaIngreso);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(360, 250, 70, 25);
		this.add(lblProveedor);
		
		txtProveedor.setBounds(480, 250, 160, 25);
		this.add(txtProveedor);

		JLabel lblFechaVenta = new JLabel("Fecha condicion: ");
		lblFechaVenta.setBounds(50, 290, 90, 25);
		this.add(lblFechaVenta);

		txtFechaVenta.setBounds(170, 290, 160, 25);
		this.add(txtFechaVenta);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(360, 290, 70, 25);
		this.add(lblCondicion);

		txtCondicion.setBounds(480, 290, 160, 25);
		this.add(txtCondicion);
		
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(50, 330, 70, 25);
		this.add(lblCliente);

		txtCliente.setBounds(170, 330, 160, 25);
		this.add(txtCliente);
		
		JLabel lblMotor = new JLabel("Motor(*): ");
		lblMotor.setBounds(360, 330, 70, 25);
		this.add(lblMotor);

		txtMotor.setBounds(480, 330, 160, 25);
		this.add(txtMotor);
		
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(50, 370, 70, 25);
		this.add(lblComentarios);

		txtComentarios.setBounds(170, 370, 500, 25);
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
	}
	
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

	private JComboBox extracted(ArrayList<String> comboModelo) {
		return new JComboBox(comboModelo.toArray());
	}

	public void onBuscarVehiculo() {
		this.removeAll();
		System.out.println("ONMOD");
		
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

	public JComboBox getComboListMarca() {
		return comboListMarca;
	}

	public void setComboListMarca(JComboBox comboListMarca) {
		this.comboListMarca = comboListMarca;
	}

	public Component getBtnCopiar() {
		return btnCopiar;
	}

	public void setBtnCopiar(Component btnCopiar) {
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

	


	
	
	
	

}
