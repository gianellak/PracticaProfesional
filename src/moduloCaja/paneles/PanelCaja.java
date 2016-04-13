package moduloCaja.paneles;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import objetos.Cuota;
import objetos.Movimiento;
import objetos.Usuario;

public class PanelCaja extends JPanel {

	private JButton btnVolver, btnAceptar, btnAlta, btnAbrir, btnMod, btnEliminar, btnLog;
	private JTextField descripcionText, dniText, montoText;
	private JLabel usuarioText, dateField, idText, idLabel;
	private JTable tabla;
	private JRadioButton ingresoButton, egresoButton;
	private JDateChooser dateChooser;
	private JButton btnCierre;
	private JTextField saldoText;
	
	public PanelCaja() {

		System.out.println("Creo nuevo panel Caja");

		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int w = width.intValue() - 250;
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		int h = height.intValue() - 150;
		
		this.setPreferredSize(new Dimension(w, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		this.setLayout(null);

	}

	public void onAlta(int i, Usuario usuario) {


		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(0, 350, 30, 25);
		this.add(idLabel);

		idText = new JLabel(String.valueOf(i+1));
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
	
	public void abroCaja(Usuario usuario) {
		
		this.removeAll();
		System.out.println("abroCaja()");
		
		
		String format = new String("dd/MM/yy");
		String format2 = new String("dd/MM/yy - HH:mm"  );
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		SimpleDateFormat df2 = new SimpleDateFormat(format2);
		String stringDate = df.format(d);
		String stringDate2 = df2.format(d);
		
		
		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(0, 350, 30, 25);
		this.add(idLabel);
		
		idText = new JLabel(String.valueOf(1));
		idText.setBounds(30, 350, 40, 25);
		this.add(idText);
		
		JLabel passLabel = new JLabel("Descripcion: ");
		passLabel.setBounds(0, 390, 80, 25);
		this.add(passLabel);
		
		String openText = new String("Apertura de caja - "+ stringDate2 );
		descripcionText = new JTextField(openText);
		descripcionText.setBounds(100, 390, 700, 25);
		this.add(descripcionText);
		
		JLabel nombreLabel = new JLabel("Fecha: ");
		nombreLabel.setBounds(100, 350, 50, 25);
		this.add(nombreLabel);
		
		
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
		ingresoButton.setSelected(true);
		ingresoButton.setBounds(270, 430, 80, 25);
		
		egresoButton = new JRadioButton("Egreso");
		egresoButton.setEnabled(false);
		egresoButton.setBounds(360, 430, 80, 25);
		
		
		this.add(ingresoButton);
		this.add(egresoButton);
		
		btnAbrir = new JButton("Abrir Caja");
		btnAbrir.setBounds(460, 430, 200, 25);
		this.add(btnAbrir);
		
		this.validate();
		this.repaint();
		
	}
	public void cierroCaja(int i, Usuario usuario) {
		
		System.out.println("cierroCaja()");
		
		
		String format = new String("dd/MM/yy");
		String format2 = new String("dd/MM/yy - HH:mm"  );
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		SimpleDateFormat df2 = new SimpleDateFormat(format2);
		String stringDate = df.format(d);
		String stringDate2 = df2.format(d);
		
		
		idText.setText(String.valueOf(i+1) );
		String closeText = new String("Cierre de caja - "+ stringDate2 );
		descripcionText.setText(closeText);
		descripcionText.setEditable(false);
		
		dateField.setText(stringDate);
	
		usuarioText.setText(usuario.getUsername());
		
		Double montoTotal = new Double(calculoTotal());
		
		montoText.setText(String.valueOf(montoTotal));
		montoText.setEditable(false);
	
		if(Double.valueOf(montoText.getText()) > 0){
			ingresoButton.setSelected(true);
		}else{
			egresoButton.setSelected(true);
		}
		
		egresoButton.setEnabled(false);
		ingresoButton.setEnabled(false);
		
		btnAlta.setText("Cerrar Caja");
		
		this.validate();
		this.repaint();
		
	}

	

	private double calculoTotal() {
		
		System.out.println("CalculoTotal()");		
		
		int rows = tabla.getRowCount();
		
		System.out.println("Filas: " + rows);
		
		Double total = new Double(0);
		
		
		for(int i = 0; i < rows; i++){
	 
			String in = String.valueOf(tabla.getModel().getValueAt(i, 2));
			String eg = String.valueOf(tabla.getModel().getValueAt(i, 3));
			
			if(in.equals("0.0")){
				total = total - (Double.valueOf(eg));
			}else{
				total = total + (Double.valueOf(in));
				
			}
			
			System.out.println(i+ "-" + rows + " - Total: " + total);
		
		}
		
		return total;
	
	}

	public void onVer(Usuario usuario, List<Movimiento> lista) {

		this.removeAll();
		System.out.println("OnVer()");

		JLabel idLabel = new JLabel("Movimientos de hoy: " );
		idLabel.setBounds(10, 60, 280, 25);
		this.add(idLabel);

		tabla = this.createTablaMovimientos();
		
		
		this.cargarTabla(lista);
		
		JScrollPane jp= new JScrollPane(tabla);
		
		jp.setBounds(10, 90, 800, 200);
		
		this.add(jp);
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(720, 300, 80, 25);
		this.add(btnVolver);
		

		btnMod = new JButton("Modificar");
		btnMod.setBounds(600, 300, 100, 25);
		this.add(btnMod);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(500, 300, 80, 25);
		this.add(btnEliminar);
		
		btnCierre= new JButton("Cerrar caja");
		btnCierre.setBounds(350,300,130,25);
		this.add(btnCierre);
		

		this.validate();
		this.repaint();

	}
	
	public void calendar(){
		
		JLabel calendario = new JLabel("Seleccione la fecha que desea ver: ");
		calendario.setBounds(10,0,200,20);
		
		this.add(calendario);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 20, 200, 20);
	
		this.add(dateChooser);
	}
	
	public void onVerOtro(Usuario usuario) {
		
		this.removeAll();
		System.out.println("OnVerOtro()");
		
		calendar();
		
		idLabel = new JLabel("Movimientos del día: --/--/-- " );
		idLabel.setBounds(10, 60, 280, 25);
		this.add(idLabel);
			
		tabla = this.createTablaMovimientos();
			
		JScrollPane jp= new JScrollPane(tabla);
		
		jp.setBounds(10, 90, 800, 200);
		
		this.add(jp);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(730, 300, 80, 25);
		this.add(btnVolver);
		
		btnLog = new JButton("Descargar log");
		btnLog.setBounds(590,300,130,25);
		this.add(btnLog);
		
		this.validate();
		this.repaint();
		
	}
	
	public void verDia(List<Movimiento> lista, String date){
		
		
		idLabel.setText("Movimientos del día: " + date);
		
		((DefaultTableModel) tabla.getModel()).setRowCount(0);
		
		this.cargarTabla(lista);
		
		this.validate();
		this.repaint();
	}

	
	private void cargarTabla(List<Movimiento> lista) {
		
		int i = 0;

		for (Movimiento m : lista) {
			
			i++;
			
			String id = String.valueOf(m.getId());
			String f = m.getFecha();
			String[] partes = f.split("/");			
			String fecha = String.valueOf(partes[0]+partes[1]+partes[2]);
			id = id.replace(fecha, "");
			
			Object[] o = new Object[6];
			o[0] = id;
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
		
		tabla.getTableHeader().setReorderingAllowed(false);
	
		tabla.setModel(modelo);
			
		modelo.setColumnIdentifiers(columnNames);
		
		tabla.getColumn("ID").setPreferredWidth(100);
		tabla.getColumn("Descripcion").setPreferredWidth(200);
		tabla.getColumn("Ingreso").setPreferredWidth(100);
		tabla.getColumn("Egreso").setPreferredWidth(100);
		tabla.getColumn("Fecha").setPreferredWidth(100);
		tabla.getColumn("Usuario").setPreferredWidth(100);
			
		return tabla;
	}


	public Movimiento getNuevoMovimiento() {
		Double i ;
		Double e;
		if(ingresoButton.isSelected()){
			System.out.println("ingreso");
			i = new Double(montoText.getText());
			e = new Double(0);
		
		} else{
			System.out.println("egreso");
			e = new Double(montoText.getText());
			i = new Double(0);
		}
	
		String format = new String("ddMMYY");
	
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date d = new Date();
		String stringDate = df.format(d);
		    
		
		String s = idText.getText() + stringDate;
	
		System.out.println(s);
		
		Movimiento m = new Movimiento(Integer.parseInt(s), descripcionText.getText(), i, e, dateField.getText(), usuarioText.getText(), true);
		
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

	public JButton getBtnAbrir() {
		return btnAbrir;
	}

	public void setBtnAbrir(JButton btnAbrir) {
		this.btnAbrir = btnAbrir;
	}

	public JButton getBtnMod() {
		return btnMod;
	}

	public void setBtnMod(JButton btnMod) {
		this.btnMod = btnMod;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public JButton getBtnLog() {
		return btnLog;
	}

	public void setBtnLog(JButton btnLog) {
		this.btnLog = btnLog;
	}

	public String getMovimientoTabla() {

		int a = this.tabla.getSelectedRow();
		
		String d = String.valueOf(tabla.getModel().getValueAt(a, 4));
		
		String[] partes = d.split("/");
		
		String fecha = String.valueOf(partes[0]+partes[1]+partes[2]);
		
		String idMov = String.valueOf(tabla.getModel().getValueAt(a,0)) + fecha;
	
		
				
		return idMov;
	}

	public void mostrarMovimientoMod(Movimiento m) {
		
		descripcionText.setText(m.getDescripcion());

		Double monto;
		
		btnAlta.setText("Aceptar cambios");
		
		if(m.getIngreso() == 0){
			monto = m.getEgreso();
			egresoButton.setSelected(true);
			
		}else{
			monto=m.getIngreso();
			ingresoButton.setSelected(true);
		}
		
		montoText.setText(String.valueOf(monto));
		
	
		this.validate();
		this.repaint();
		
	}

	public JButton getBtnCierre() {
		return btnCierre;
	}

	public void setBtnCierre(JButton btnCierre) {
		this.btnCierre = btnCierre;
	}

	public void onCierre() {
		btnMod.setVisible(false);
		
		btnEliminar.setVisible(false);
		
		btnCierre.setVisible(false);
		
		
	}

	public void onVerCuota(Usuario usuario, List<Movimiento> lista, Cuota c) {
		this.removeAll();
		System.out.println("OnVer()");

		JLabel hoyLabel = new JLabel("Movimientos de hoy: " );
		hoyLabel.setBounds(10, 60, 280, 25);
		this.add(hoyLabel);

		tabla = this.createTablaMovimientos();
		
		
		this.cargarTabla(lista);
		
		JScrollPane jp= new JScrollPane(tabla);
		
		jp.setBounds(10, 90, 800, 200);
		
		this.add(jp);
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(720, 300, 80, 25);
		this.add(btnVolver);
		

		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(0, 350, 30, 25);
		this.add(idLabel);

		idText = new JLabel(String.valueOf(lista.size()+ 1));
		idText.setBounds(30, 350, 40, 25);
		this.add(idText);

		JLabel passLabel = new JLabel("Descripcion");
		passLabel.setBounds(0, 390, 80, 25);
		this.add(passLabel);

		descripcionText = new JTextField("Pago de Cuota N° " + c.getCuota());
		
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

		montoText = new JTextField(String.valueOf(c.getValor()));
		montoText.setBounds(100, 430, 160, 25);
		this.add(montoText);

		ingresoButton = new JRadioButton("Ingreso");
		ingresoButton.setMnemonic(KeyEvent.VK_C); 
		ingresoButton.setSelected(true);
		ingresoButton.setBounds(270, 430, 80, 25);

	    egresoButton = new JRadioButton("Egreso");
	    egresoButton.setMnemonic(KeyEvent.VK_G); 
	    egresoButton.setSelected(false);
	    egresoButton.setEnabled(false);
	    egresoButton.setBounds(360, 430, 80, 25);
	    
	    
	    ButtonGroup buttonGroup = new ButtonGroup();
	    buttonGroup.add(ingresoButton);
	    buttonGroup.add(egresoButton);

	    JLabel saldoLabel = new JLabel("Saldo anterior: ");
		saldoLabel.setBounds(0, 460, 100, 25);
		this.add(saldoLabel);
		
		saldoText = new JTextField(c.getCuota());
		saldoText.setBounds(110, 460, 160, 25);
		this.add(saldoText);

	

	   
	    
	    this.add(ingresoButton);
	    this.add(egresoButton);
	    
	    btnAlta = new JButton("Cobrar Cuota");
		btnAlta.setBounds(460, 430, 200, 25);
		this.add(btnAlta);

		this.validate();
		this.repaint();

	}


}
