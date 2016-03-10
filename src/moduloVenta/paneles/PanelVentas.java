package moduloVenta.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;




import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import moduloVenta.listener.ListenerDetalleTotal;

import com.toedter.calendar.JDateChooser;

import objetos.*;


public class PanelVentas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension preferredSize = new Dimension(200, 25);
	private JTextField dniCompradorText,patenteText, dniGaranteText, cuotasText, adelantoText,comentarioText, saldoText, comisionText,descuentoText, precioFText;
	private JButton btnValidarVenta, btnValidarDniC, btnValidarDniG, btnBuscarVehiculo, btnAceptarNewVenta, btnVolverNewVenta,btnReset,btnAceptarDetalle;
	private FocusListener l;
	private JDateChooser dateChooser;
	private JTable tabla;
	private int idV;
	private String idVehiculo;
	private Double p,comision,descuento,adelanto;
	private JPanel miniVentaPanel;
	private int h;
	private int w;
	private JPanel detallePanel;

	public PanelVentas() {

		System.out.println("Creo nuevo panel Venta");

		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		w = width.intValue();
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		h = height.intValue() ;
		
		this.setPreferredSize(new Dimension(w -250, h-150));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		this.setLayout(null);

	}
	

	// Muestra los tres campos iniciales para crear una venta.

	public void showNuevaVenta() {

		this.removeAll();

		JLabel textLabel = new JLabel("Por favor, complete los siguientes datos para comenzar el proceso de venta.");
		textLabel.setBounds(50, 40, 380, 25);
		this.add(textLabel);

		JLabel compradorLabel = new JLabel("DNI del comprador: ");
		compradorLabel.setBounds(50, 90, 120, 25);
		this.add(compradorLabel);

		dniCompradorText = new JTextField(10);
		dniCompradorText.setBounds(170, 90, 150, 25);
		this.add(dniCompradorText);

		btnValidarDniC = new JButton("Validar Dni");
		btnValidarDniC.setPreferredSize(preferredSize);
		btnValidarDniC.setBounds(330, 90, 140, 25);
		this.add(btnValidarDniC);

		JLabel vehiculoLabel = new JLabel("Ingrese Patente: ");
		vehiculoLabel.setBounds(50, 130, 120, 25);
		this.add(vehiculoLabel);

		patenteText = new JTextField(9);
		patenteText.setBounds(170, 130, 150, 25);
		this.add(patenteText);

		btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.setPreferredSize(preferredSize);
		btnBuscarVehiculo.setBounds(330, 130, 140, 25);
		this.add(btnBuscarVehiculo);

		JLabel garanteLabel = new JLabel("DNI del garante: ");
		garanteLabel.setBounds(50, 170, 120, 25);
		this.add(garanteLabel);

		dniGaranteText = new JTextField(9);
		dniGaranteText.setBounds(170, 170, 150, 25);
		this.add(dniGaranteText);

		btnValidarDniG = new JButton("Validar Dni");
		btnValidarDniG.setPreferredSize(preferredSize);
		btnValidarDniG.setBounds(330, 170, 140, 25);
		this.add(btnValidarDniG);

		
		miniVentaPanel = new JPanel();
		miniVentaPanel.setLayout(null);
	    miniVentaPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Detalle de la venta."));
	    miniVentaPanel.setBounds(490, 80, 260, 130);
	   
	        this.add(miniVentaPanel);
	        
	        
		btnAceptarNewVenta = new JButton("Aceptar");
		btnAceptarNewVenta.requestFocus(true);
		btnAceptarNewVenta.setPreferredSize(preferredSize);
		btnAceptarNewVenta.setBounds(70, 240, 120, 25);
		this.add(btnAceptarNewVenta);

		btnVolverNewVenta = new JButton("Volver");
		btnVolverNewVenta.setPreferredSize(preferredSize);
		btnVolverNewVenta.setBounds(200, 240, 120, 25);
		this.add(btnVolverNewVenta);

		btnReset = new JButton("Reiniciar");
		btnReset.setPreferredSize(preferredSize);
		btnReset.setBounds(330, 240, 120, 25);
		this.add(btnReset);

		this.validate();
		this.repaint();

	}

	public void mostrarCliente(Persona cliente) {

		JLabel compradorLabel = new JLabel("Cliente: " + cliente.getApellido() + " " + cliente.getNombre());
		compradorLabel.setBounds(10, 20, 200, 25);
		miniVentaPanel.add(compradorLabel);

		dniCompradorText.setEditable(false);
		btnValidarDniC.setEnabled(false);

	}

	public void mostrarGarante(Persona cliente) {

		JLabel garanteLabel = new JLabel("Garante " +cliente.getApellido() + " " + cliente.getNombre());
		garanteLabel.setBounds(10, 80, 200, 25);
		miniVentaPanel.add(garanteLabel);

		dniGaranteText.setEditable(false);
		btnValidarDniG.setEnabled(false);

	}

	public void mostrarPatente(Vehiculo vehiculo) {

		JLabel vehiculoLabel = new JLabel("Vehiculo: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
		vehiculoLabel.setBounds(10, 50, 250, 25);
		miniVentaPanel.add(vehiculoLabel);

		patenteText.setEditable(false);
		btnBuscarVehiculo.setEnabled(false);

	}

	public Boolean getButtonState() {

		if (btnValidarDniG.isEnabled() || btnValidarDniC.isEnabled()
				|| btnBuscarVehiculo.isEnabled()) {
			return false;
		} else {
			return true;
		}
	}

	public void mostrarDetalleVenta(int idVenta, String cliente,
			String garante, String vehiculo) {

		this.removeAll();
		
	
		detallePanel = new JPanel();
		detallePanel.setLayout(null);
	    detallePanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Detalle de Venta N�: " + idVenta));
	    detallePanel.setBounds(20, 40, w - 290, 150);
	   
	      this.add(detallePanel);

		
		JLabel dniCompradorLabel = new JLabel("Cliente: " + cliente);
		dniCompradorLabel.setBounds(20, 20, 260, 20);
		detallePanel.add(dniCompradorLabel);

		JLabel nombreCompradorLabel = new JLabel("Garante: " + garante);
		nombreCompradorLabel.setBounds(20, 50, 260, 20);
		detallePanel.add(nombreCompradorLabel);

		JLabel vehiculoLabel = new JLabel("Vehiculo: " + vehiculo);
		vehiculoLabel.setBounds(20, 80, 260, 20);
		detallePanel.add(vehiculoLabel);

		this.revalidate();
		this.repaint();
	}

	public void ingresarDetalleVenta(int idVenta, String cliente,
			String garante, String vehiculo, int precio) {

		mostrarDetalleVenta(idVenta, cliente, garante, vehiculo);
		
		idV = idVenta;
		idVehiculo = vehiculo;
		p = new Double(precio);

		JLabel precioLabel = new JLabel("Precio Lista: $" + String.valueOf(precio));
		precioLabel.setBounds(0, 120, 160, 20);
		this.add(precioLabel);

		JLabel precioTLabel = new JLabel("Precio Final: ");
		precioTLabel.setBounds(170, 120, 100, 20);
		this.add(precioTLabel);
		
		precioFText = new JTextField("0");
		precioFText.setEditable(false);
		precioFText.setBounds(280, 120, 100, 20);
		this.add(precioFText);

		JLabel adelantoLabel = new JLabel("Adelanto: ");
		adelantoLabel.setBounds(0, 145, 100, 20);
		this.add(adelantoLabel);

		adelantoText = new JTextField("0");
		adelantoText.setBounds(110, 145, 100, 20);
		adelantoText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           recalcularSaldo();
	           recalcularFinal();
	        }
	    });
		adelantoText.getDocument().addDocumentListener(new ListenerDetalleTotal(this));
		this.add(adelantoText);

		JLabel comisionLabel = new JLabel("Comision: ");
		comisionLabel.setBounds(220, 145, 100, 20);
		this.add(comisionLabel);

		JLabel descuentoLabel = new JLabel("Descuento: ");
		descuentoLabel.setBounds(440, 145, 100, 20);
		this.add(descuentoLabel);
		
		descuentoText = new JTextField("0");
		descuentoText.setBounds(550, 145, 100, 20);
		descuentoText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           recalcularSaldo();
	           recalcularFinal();
	        }
	    });
		descuentoText.getDocument().addDocumentListener(new ListenerDetalleTotal(this));
		this.add(descuentoText);
			
		comisionText = new JTextField("0");
		comisionText.setBounds(330, 145, 100, 20);
		comisionText.getDocument().addDocumentListener(new ListenerDetalleTotal(this));
		comisionText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           recalcularSaldo();
	           recalcularFinal();
	        }
	    });
		this.add(comisionText);

		JLabel comentarioLabel = new JLabel("Comentarios: ");
		comentarioLabel.setBounds(0, 170, 100, 20);
		this.add(comentarioLabel);

		comentarioText = new JTextField();
		comentarioText.setBounds(110, 170, 600, 20);
		this.add(comentarioText);

		JLabel saldoLabel = new JLabel("Saldo: ");
		saldoLabel.setBounds(0, 195, 100, 20);
		this.add(saldoLabel);

		saldoText = new JTextField("0");
		saldoText.setBounds(110, 195, 160, 20);
		this.add(saldoText);

		JLabel cuotasLabel = new JLabel("Cantidad de cuotas: ");
		cuotasLabel.setBounds(0, 220, 160, 20);
		this.add(cuotasLabel);

		cuotasText = new JTextField();
		cuotasText.setBounds(165, 220, 50, 20);
		this.add(cuotasText);

		calendar();

		tabla = tablaCuotas();

		JScrollPane jp = new JScrollPane(tabla);

		jp.setBounds(0, 265, 600, 200);

		this.add(jp);

		btnAceptarDetalle = new JButton("Aceptar");
		btnAceptarDetalle.setPreferredSize(preferredSize);
		btnAceptarDetalle.setBounds(650, 300, 150, 25);
		this.add(btnAceptarDetalle);

		this.validate();
		this.repaint();

	}

	public void cargarTabla(List<Cuota> lista) {

		((DefaultTableModel) tabla.getModel()).setRowCount(0);

		for (Cuota c : lista) {

			Object[] o = new Object[6];
			o[0] = c.getCuota();
			o[1] = c.getVencimiento();
			o[2] = c.getValor();
			o[3] = c.getAdelanto();

			((DefaultTableModel) tabla.getModel()).addRow(o);

			this.validate();
			this.repaint();
		}

	}

	private JTable tablaCuotas() {
		// Create columns names
		String columnNames[] = { "Cuota", "Vencimiento", "Valor", "Adelanto" };

		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		tabla.getTableHeader().setReorderingAllowed(false);

		tabla.setModel(modelo);

		modelo.setColumnIdentifiers(columnNames);

		tabla.getColumn("Cuota").setPreferredWidth(100);
		tabla.getColumn("Vencimiento").setPreferredWidth(200);
		tabla.getColumn("Valor").setPreferredWidth(100);
		tabla.getColumn("Adelanto").setPreferredWidth(100);

		return tabla;
	}

	public void calendar() {

		JLabel calendario = new JLabel(
				"Seleccione vencimiento de la primera cuota: ");
		calendario.setBounds(0, 245, 300, 20);

		this.add(calendario);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(310, 245, 200, 20);

		this.add(dateChooser);

	}
	
	public void showBuscarVenta() {
		 
        this.removeAll();

        System.out.println("En BuscarVenta");

        JLabel compradorLabel = new JLabel("Ingrese DNI del Comprador: ");
        compradorLabel.setBounds(50, 60, 200, 25);
        this.add(compradorLabel);

        dniCompradorText = new JTextField(9);
        dniCompradorText.setBounds(300, 60, 160, 25);
        this.add(dniCompradorText);

        btnValidarVenta = new JButton("Ver ventas");
        btnValidarVenta.setBounds(480, 60, 160, 25);
        this.add(btnValidarVenta);

        this.validate();
        this.repaint();

}


	public DetalleVenta getNewDetalle() {
		
		DetalleVenta v  = new DetalleVenta(idV, idVehiculo, p , Integer.valueOf(cuotasText.getText()), 
				Double.valueOf(saldoText.getText()), Double.valueOf(adelantoText.getText()), Double.valueOf(comisionText.getText()), 
				comentarioText.getText());
		
		return v;
	}

	public void recalcularFinal() {
		
		try {
			comision = new Double(comisionText.getText());
			descuento = new Double(descuentoText.getText());
		    }
		    catch (NumberFormatException e) {
		        comision = Double.valueOf(0);
		        descuento = Double.valueOf(0);
		    }
		
		Double f = (double) (p + comision - descuento);
		
		precioFText.setText(String.valueOf(f));
		
		this.revalidate();
		this.repaint();
	
		
	}

	public void recalcularSaldo() {
		
		try {
			comision = new Double(comisionText.getText());
			descuento = new Double(descuentoText.getText());
			adelanto = new Double(adelantoText.getText());
		    }
		    catch (NumberFormatException | NullPointerException e ) {
		        comision = Double.valueOf(0);
		        descuento = Double.valueOf(0);
		        adelanto = Double.valueOf(0);
		        		    }
		Double s = (double) (p - descuento + comision - adelanto);
		
		saldoText.setText(String.valueOf(s));
		
		this.revalidate();
		this.repaint();
		
	}
	
	
	
	
	

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JTextField getCuotasText() {
		return cuotasText;
	}

	public void setCuotasText(JTextField cuotasText) {
		this.cuotasText = cuotasText;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public JTextField getAdelantoText() {
		return adelantoText;
	}

	public void setAdelantoText(JTextField adelantoText) {
		this.adelantoText = adelantoText;
	}

	public JTextField getComentarioText() {
		return comentarioText;
	}

	public void setComentarioText(JTextField comentarioText) {
		this.comentarioText = comentarioText;
	}

	public JTextField getSaldoText() {
		return saldoText;
	}

	public void setSaldoText(JTextField saldoText) {
		this.saldoText = saldoText;
	}

	public JButton getBtnAceptarNewVenta() {
		return btnAceptarNewVenta;
	}

	public void setBtnAceptarNewVenta(JButton btnAceptarNewVenta) {
		this.btnAceptarNewVenta = btnAceptarNewVenta;
	}

	public JButton getBtnVolverNewVenta() {
		return btnVolverNewVenta;
	}

	public void setBtnVolverNewVenta(JButton btnVolverNewVenta) {
		this.btnVolverNewVenta = btnVolverNewVenta;
	}

	public JTextField getDniCompradorText() {
		return dniCompradorText;
	}

	public void setDniCompradorText(JTextField dniCompradorText) {
		this.dniCompradorText = dniCompradorText;
	}

	public JTextField getPatenteText() {
		return patenteText;
	}

	public void setPatenteText(JTextField patenteText) {
		this.patenteText = patenteText;
	}

	public JTextField getDniGaranteText() {
		return dniGaranteText;
	}

	public void setDniGaranteText(JTextField dniGaranteText) {
		this.dniGaranteText = dniGaranteText;
	}

	public JButton getBtnValidarDniC() {
		return btnValidarDniC;
	}

	public void setBtnValidarDniC(JButton btnValidarDniC) {
		this.btnValidarDniC = btnValidarDniC;
	}

	public JButton getBtnValidarDniG() {
		return btnValidarDniG;
	}

	public void setBtnValidarDniG(JButton btnValidarDniG) {
		this.btnValidarDniG = btnValidarDniG;
	}

	public JButton getBtnBuscarVehiculo() {
		return btnBuscarVehiculo;
	}

	public void setBtnBuscarVehiculo(JButton btnBuscarVehiculo) {
		this.btnBuscarVehiculo = btnBuscarVehiculo;
	}

	public JButton getBtnAceptarDetalle() {
		return btnAceptarDetalle;
	}

	public void setBtnAceptarDetalle(JButton btnAceptarDetalle) {
		this.btnAceptarDetalle = btnAceptarDetalle;
	}
	public JButton getBtnValidarVenta() {
		return btnValidarVenta;
	}
	
	
	public void setBtnValidarVenta(JButton btnValidarVenta) {
		this.btnValidarVenta = btnValidarVenta;
	}



}