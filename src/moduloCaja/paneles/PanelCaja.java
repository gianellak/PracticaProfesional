package moduloCaja.paneles;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import objetos.Usuario;

public class PanelCaja extends JPanel {

	private JButton btnVolver;
	private JTextField idText;
	private JTextField descripcionText;
	private JButton btnAceptar;
	private JTextField dniText;
	private JTextField usuarioText;
	private JTextField montoText;
	
	public PanelCaja() {

		System.out.println("Creo nuevo panel Caja");

		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

	}

	public void onAlta(Usuario usuario) {

		this.removeAll();
		System.out.println("ONCAJAALTA");

		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(150, 0, 80, 25);
		this.add(idLabel);

		idText = new JTextField(9);
		idText.setBounds(300, 0, 160, 25);
		this.add(idText);

		JLabel passLabel = new JLabel("Descripcion");
		passLabel.setBounds(150, 30, 80, 25);
		this.add(passLabel);

		descripcionText = new JTextField();
		
		descripcionText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (descripcionText.getText().length() >= 140 )
	                e.consume();
	        }
	    });


		JScrollPane jp= new JScrollPane(descripcionText);
		jp.setBounds(300, 30, 300, 60);
	    this.add(jp);

		JLabel montoLabel = new JLabel("Monto: ");
		montoLabel.setBounds(150, 110, 160, 25);
		this.add(montoLabel);

		montoText = new JTextField(10);
		montoText.setBounds(300, 110, 160, 25);
		this.add(montoText);

		JLabel nombreLabel = new JLabel("Fecha: ");
		nombreLabel.setBounds(150, 140, 160, 25);
		this.add(nombreLabel);


		// VER!!!! PORQUE LO HABIA PUESTO STRING
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter df = new DateFormatter(format);
		JFormattedTextField dateField = new JFormattedTextField(df);
		dateField.setPreferredSize(new Dimension(100, 20));
		dateField.setValue(new Date());
		dateField.setEditable(false);
		dateField.setBounds(300, 140, 160, 25);
		this.add(dateField);

		JLabel usuarioLabel = new JLabel("Usuario: ");
		usuarioLabel.setBounds(150, 170, 160, 25);
		this.add(usuarioLabel);

		usuarioText = new JTextField(usuario.getUsername());
		usuarioText.setEditable(false);
		usuarioText.setBounds(300, 170, 160, 25);
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

	
	
	public void onBaja() {

		this.removeAll();

		System.out.println("ONBAJA");

		JLabel dniLabel = new JLabel("Cliente a dar de baja: ");
		dniLabel.setBounds(150, 0, 160, 25);
		this.add(dniLabel);

		dniText = new JTextField(9);
		dniText.setBounds(300, 0, 160, 25);
		this.add(dniText);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 150, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	public void onMod() {

		this.removeAll();
		System.out.println("ONMOD");

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(500, 150, 100, 25);
		this.add(btnAceptar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();
	}

	public void onVer() {

		this.removeAll();
		System.out.println("ONVER");

		JLabel idLabel = new JLabel(
				"Movimientos del día: ");
		idLabel.setBounds(150, 0, 280, 25);
		this.add(idLabel);

		
		JTable tabla = this.createTablaMovimientos();
		
		JScrollPane jp= new JScrollPane(tabla);
		
		jp.setBounds(200, 30, 400, 200);
		this.add(jp);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 180, 100, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();

	}

	private JTable createTablaMovimientos() {
		// Create columns names
		String columnNames[] = { "ID", "Descripcion", "Monto", "Fecha", "Usuario"}; // Marca no se muestra

		// Create some data
		String dataValues[][] =
		{
			{ "12", "234", "67", "24/02/16", "Gianella"},
			{ "-123", "43", "853","12/01/16", "admin" },
			{ "93", "89.2", "109","04/06/15", "Rachel"},
			{ "279", "9033", "3092","14/03/15", "Gianella" }
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

	public JTextField getIdText() {
		return idText;
	}

	public void setIdText(JTextField idText) {
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

	public JTextField getUsuarioText() {
		return usuarioText;
	}

	public void setUsuarioText(JTextField usuarioText) {
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
