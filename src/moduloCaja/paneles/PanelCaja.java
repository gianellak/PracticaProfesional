package moduloCaja.paneles;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import objetos.Movimiento;
import objetos.Stock;
import objetos.Usuario;

public class PanelCaja extends JPanel {

	private JButton btnVolver;
	private JLabel idText;
	private JTextField descripcionText;
	private JButton btnAceptar;
	private JTextField dniText;
	private JLabel usuarioText;
	private JTextField montoText;
	private JTable tabla;
	private JRadioButton ingresoButton;
	private JRadioButton egresoButton;
	private JButton btnAlta;
	private JLabel dateField;
	
	public PanelCaja() {

		System.out.println("Creo nuevo panel Caja");

		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

	}

	public void onAlta(Usuario usuario) {


		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(0, 350, 30, 25);
		this.add(idLabel);

		idText = new JLabel(String.valueOf(tabla.getRowCount() + 1));
		idText.setBounds(30, 350, 40, 25);
		this.add(idText);

		JLabel passLabel = new JLabel("Descripcion");
		passLabel.setBounds(0, 390, 80, 25);
		this.add(passLabel);

		descripcionText = new JTextField();
		
		descripcionText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (descripcionText.getText().length() >= 140 )
	                e.consume();
	        }
	    });


		descripcionText.setBounds(100, 390, 700, 30);
	    this.add(descripcionText);

		JLabel nombreLabel = new JLabel("Fecha: ");
		nombreLabel.setBounds(100, 350, 50, 25);
		this.add(nombreLabel);

		String format = new String("dd/MM/yy");
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(d);
		    
		dateField = new JLabel(stringDate);
		dateField.setBounds(160, 350, 80, 25);
		this.add(dateField);

		JLabel usuarioLabel = new JLabel("Usuario: ");
		usuarioLabel.setBounds(280, 350, 50, 25);
		this.add(usuarioLabel);

		usuarioText = new JLabel(usuario.getUsername());
		usuarioText.setBounds(340, 350, 80, 25);
		this.add(usuarioText);
		
		JLabel montoLabel = new JLabel("Monto: ");
		montoLabel.setBounds(0, 430, 80, 25);
		this.add(montoLabel);

		montoText = new JTextField(10);
		montoText.setBounds(100, 430, 160, 25);
		this.add(montoText);

		ingresoButton = new JRadioButton("Ingreso");
		ingresoButton.setMnemonic(KeyEvent.VK_C); 
		ingresoButton.setSelected(false);
		ingresoButton.setBounds(270, 430, 80, 25);

	    egresoButton = new JRadioButton("Egreso");
	    egresoButton.setMnemonic(KeyEvent.VK_G); 
	    egresoButton.setSelected(false);
	    egresoButton.setBounds(360, 430, 80, 25);
	    
	    
	    ButtonGroup buttonGroup = new ButtonGroup();
	    buttonGroup.add(ingresoButton);
	    buttonGroup.add(egresoButton);

	   
	    
	    this.add(ingresoButton);
	    this.add(egresoButton);
	    
	    btnAlta = new JButton("Ingresar Nuevo Movimiento.");
		btnAlta.setBounds(460, 430, 200, 25);
		this.add(btnAlta);

		this.validate();
		this.repaint();

	}

	
	
	
	
	public void onVer(Usuario usuario, List<Movimiento> lista) {

		this.removeAll();
		System.out.println("ONVER");

		JLabel idLabel = new JLabel("Movimientos del día: ");
		idLabel.setBounds(150, 0, 280, 25);
		this.add(idLabel);

		
		tabla = this.createTablaMovimientos();
		
		this.cargarTabla(lista);
		
		JScrollPane jp= new JScrollPane(tabla);
		
		jp.setBounds(10, 30, 800, 200);
		
		this.add(jp);
		
		this.onAlta(usuario);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(720, 250, 80, 25);
		this.add(btnVolver);
		
		btnVolver = new JButton("Modificar");
		btnVolver.setBounds(600, 250, 100, 25);
		this.add(btnVolver);
		
		btnVolver = new JButton("Eliminar");
		btnVolver.setBounds(500, 250, 80, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	private void cargarTabla(List<Movimiento> lista) {

		for (Movimiento m : lista) {
			
			Object[] o = new Object[6];
			o[0] = m.getId();
			o[1] = m.getDescripcion();
			o[2] = m.getIngreso();
			o[3] = m.getEgreso();
			o[4] = m.getFecha();
			o[5] = m.getUsuario();
			
			
			((DefaultTableModel) tabla.getModel()).addRow(o);
		}
		

		
	}

	private JTable createTablaMovimientos() {
		// Create columns names
		String columnNames[] = { "ID", "Descripcion", "Ingreso", "Egreso", "Fecha", "Usuario"}; // Marca no se muestra

		
		
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(){ 
			public boolean isCellEditable(int row, int column){
		      return false;
		    }
		
		};
		
		modelo.setColumnIdentifiers(columnNames);
		
		tabla.setModel(modelo);
			
		
		return tabla;
	}


	public Movimiento getNuevoMovimiento() {
		Double i ;
		Double e;
		if(ingresoButton.isSelected()){
			i = new Double(montoText.getText());
			e = new Double(0);
		
		} else{
			
			e = new Double(montoText.getText());
			i = new Double(0);
		}
		
		Movimiento m = new Movimiento(Integer.parseInt(idText.getText()), descripcionText.getText(), i, e, dateField.getText(), usuarioText.getText(),
				true);
		
		return m;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JLabel getIdText() {
		return idText;
	}

	public void setIdText(JLabel idText) {
		this.idText = idText;
	}

	public JTextField getDescripcionText() {
		return descripcionText;
	}

	public void setDescripcionText(JTextField descripcionText) {
		this.descripcionText = descripcionText;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JTextField getDniText() {
		return dniText;
	}

	public void setDniText(JTextField dniText) {
		this.dniText = dniText;
	}

	public JLabel getUsuarioText() {
		return usuarioText;
	}

	public void setUsuarioText(JLabel usuarioText) {
		this.usuarioText = usuarioText;
	}

	public JTextField getMontoText() {
		return montoText;
	}

	public void setMontoText(JTextField montoText) {
		this.montoText = montoText;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JRadioButton getIngresoButton() {
		return ingresoButton;
	}

	public void setIngresoButton(JRadioButton ingresoButton) {
		this.ingresoButton = ingresoButton;
	}

	public JRadioButton getEgresoButton() {
		return egresoButton;
	}

	public void setEgresoButton(JRadioButton egresoButton) {
		this.egresoButton = egresoButton;
	}

	public JButton getBtnAlta() {
		return btnAlta;
	}

	public void setBtnAlta(JButton btnAlta) {
		this.btnAlta = btnAlta;
	}

	public JLabel getDateField() {
		return dateField;
	}

	public void setDateField(JLabel dateField) {
		this.dateField = dateField;
	}

	public void refreshTable() {
		// TODO Auto-generated method stub
		
	}



}
