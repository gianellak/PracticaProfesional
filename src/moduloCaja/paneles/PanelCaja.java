package moduloCaja.paneles;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import objetos.Movimiento;
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
	
	public PanelCaja() {

		System.out.println("Creo nuevo panel Caja");

		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

	}

	public void onAlta(Usuario usuario) {


		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(0, 420, 30, 25);
		this.add(idLabel);

		idText = new JLabel(String.valueOf(tabla.getRowCount() + 1));
		idText.setBounds(40, 420, 40, 25);
		this.add(idText);

		JLabel passLabel = new JLabel("Descripcion");
		passLabel.setBounds(0, 450, 80, 25);
		this.add(passLabel);

		descripcionText = new JTextField();
		
		descripcionText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (descripcionText.getText().length() >= 140 )
	                e.consume();
	        }
	    });


		descripcionText.setBounds(100, 450, 700, 30);
	    this.add(descripcionText);

		JLabel montoLabel = new JLabel("Monto: ");
		montoLabel.setBounds(0, 490, 80, 25);
		this.add(montoLabel);

		montoText = new JTextField(10);
		montoText.setBounds(100, 490, 160, 25);
		this.add(montoText);

		JLabel nombreLabel = new JLabel("Fecha: ");
		nombreLabel.setBounds(100, 420, 50, 25);
		this.add(nombreLabel);


		// VER!!!! PORQUE LO HABIA PUESTO STRING
		String format = new String("dd/MM/yyyy");
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(d);

		    
		JLabel dateField = new JLabel(stringDate);
		dateField.setBounds(160, 420, 80, 25);
		this.add(dateField);

		JLabel usuarioLabel = new JLabel("Usuario: ");
		usuarioLabel.setBounds(280, 420, 50, 25);
		this.add(usuarioLabel);

		usuarioText = new JLabel(usuario.getUsername());
		usuarioText.setBounds(330, 420, 80, 25);
		this.add(usuarioText);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 200, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 230, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	
	
	
	
	public void onVer(Usuario usuario, List<Movimiento> lista) {

		this.removeAll();
		System.out.println("ONVER");

		JLabel idLabel = new JLabel(
				"Movimientos del día: ");
		idLabel.setBounds(150, 0, 280, 25);
		this.add(idLabel);

		
		tabla = this.createTablaMovimientos();
		
		JScrollPane jp= new JScrollPane(tabla);
		
		jp.setBounds(200, 30, 400, 200);
		
		this.add(jp);
		
		this.onAlta(usuario);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	private JTable createTablaMovimientos() {
		// Create columns names
		String columnNames[] = { "ID", "Descripcion", "Ingreso", "Egreso", "Fecha", "Usuario"}; // Marca no se muestra

		// Create some data
		String dataValues[][] =
		{
			{ "12", "234", "67", "0", "24/02/16", "Gianella"},
			{ "-123", "43", "0", "853", "12/01/16", "Rachel" },
		};
		
		JTable tabla = new JTable(dataValues, columnNames);
		
		return tabla;
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

	public void setJLabel(JLabel idText) {
		this.idText = idText;
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

	public JTextField getDescripcionText() {
		return descripcionText;
	}

	public void setDescripcionText(JTextField descripcionText) {
		this.descripcionText = descripcionText;
	}



}
