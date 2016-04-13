package moduloVenta.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import utilitarios.Mensajes;


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
	private JTable tablaVenta;
	private int idV;
	private String idVehiculo;
	private Double p,comision,descuento,adelanto;
	private JPanel miniVentaPanel;
	private int h;
	private int w;
	private JPanel detallePanel;
	private JPanel pagoPanel;
	private JButton btnAdqUnidad;
	private JButton btnBuscarVenta;
	private String nuevoVehiculoText;
	private JTextField nuevaPatenteText;
	private JLabel vehiculoALabel;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JTextField ventasText;
	private JComboBox<String> comboVentas;
	DecimalFormat dfD = new DecimalFormat("#.00");
	private JButton btnPagarCuota; 
	

	public PanelVentas() {

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
		textLabel.setBounds(50, 40, 480, 25);
		this.add(textLabel);

		JLabel compradorLabel = new JLabel("DNI del comprador: ");
		compradorLabel.setBounds(50, 90, 120, 25);
		this.add(compradorLabel);

		dniCompradorText = new JTextField(10);
		dniCompradorText.setBounds(170, 90, 150, 25);
		this.add(dniCompradorText);

		btnValidarDniC = new JButton("Validar DNI");
		btnValidarDniC.setPreferredSize(preferredSize);
		btnValidarDniC.setBounds(330, 90, 140, 25);
		this.add(btnValidarDniC);

		JLabel vehiculoLabel = new JLabel("Ingrese dominio: ");
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

		btnValidarDniG = new JButton("Validar DNI");
		btnValidarDniG.setPreferredSize(preferredSize);
		btnValidarDniG.setBounds(330, 170, 140, 25);
		this.add(btnValidarDniG);

		
		miniVentaPanel = new JPanel();
		miniVentaPanel.setLayout(null);
	    miniVentaPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Detalle de la venta "));
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

		if (btnValidarDniC.isEnabled()
				|| btnBuscarVehiculo.isEnabled()) {
			return false;
		} 
		return true;
	}

	public void mostrarDetalleVenta(int idVenta, Persona cliente,
			Persona garante, Vehiculo vehiculo) {

		this.removeAll();
		
	
		detallePanel = new JPanel();
		detallePanel.setLayout(null);
	    detallePanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Detalle de Venta N°: " + idVenta + "  " ));
	    detallePanel.setBounds(20, 20, w - 290, 150);
	   
	      this.add(detallePanel);

		
	    JLabel clienteLabel = new JLabel("Cliente: " + cliente.getApellido() + " " + cliente.getNombre());
	    clienteLabel.setBounds(20, 20, 260, 20);
	    detallePanel.add(clienteLabel);

	    JLabel dniCompradorLabel = new JLabel("DNI: " + cliente.getDni());
		dniCompradorLabel.setBounds(280, 20, 260, 20);
		detallePanel.add(dniCompradorLabel);

		try {
			if(!garante.equals(null)){
			
				JLabel garanteLabel = new JLabel("Garante: "
						+ garante.getApellido() + " " + garante.getNombre());
				garanteLabel.setBounds(20, 50, 260, 20);
				detallePanel.add(garanteLabel);

				JLabel dniGaranteLabel = new JLabel("DNI: " + garante.getDni());
				dniGaranteLabel.setBounds(280, 50, 260, 20);
				detallePanel.add(dniGaranteLabel);

			}
		} catch (Exception e) {
			
			JLabel garanteLabel = new JLabel("Garante: - ");
			garanteLabel.setBounds(20, 50, 260, 20);
			detallePanel.add(garanteLabel);
			
			JLabel dniGaranteLabel = new JLabel("DNI: - ");
			dniGaranteLabel.setBounds(280, 50, 260, 20);
			detallePanel.add(dniGaranteLabel);

		}
		
		JLabel vehiculoLabel = new JLabel("Unidad vendida: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
		vehiculoLabel.setBounds(20, 80, 260, 20);
		detallePanel.add(vehiculoLabel);

		JLabel patenteLabel = new JLabel("Dominio: " + vehiculo.getPatente());
		patenteLabel.setBounds(280, 80, 150, 20);
		detallePanel.add(patenteLabel);
		
		nuevoVehiculoText = new String("-");

		vehiculoALabel = new JLabel("Unidad adquirida: " + nuevoVehiculoText);
		vehiculoALabel.setBounds(20, 110, 260, 20);
		detallePanel.add(vehiculoALabel);		
		
		JLabel patenteALabel = new JLabel("Dominio: ");
		patenteALabel.setBounds(280, 110, 90, 20);
		detallePanel.add(patenteALabel);
		
		nuevaPatenteText = new JTextField();
		nuevaPatenteText.setBounds(380, 110, 100, 20);
		detallePanel.add(nuevaPatenteText);

		btnAdqUnidad = new JButton("Ingresar Unidad");
		btnAdqUnidad.setBounds(490, 110, 150, 20);
		detallePanel.add(btnAdqUnidad);

		JLabel yearLabel = new JLabel("Año: " + vehiculo.getYear());
		yearLabel.setBounds(440, 80, 260, 20);
		detallePanel.add(yearLabel);


		this.revalidate();
		this.repaint();
	}

	public void ingresarDetalleVenta(int idVenta, Persona cliente,
			Persona garante, Vehiculo vehiculo, int precio) {

		mostrarDetalleVenta(idVenta, cliente, garante, vehiculo);
		
		
		pagoPanel = new JPanel();
		pagoPanel.setLayout(null);
	    pagoPanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Detalle de financiación  " ));
	    pagoPanel.setBounds(20, 175, w - 290, h - 400);
	   
	     this.add(pagoPanel);

		idV = idVenta;
		idVehiculo = vehiculo.getMotor();
		p = new Double(precio);

		JLabel precioLabel = new JLabel("Precio Lista: $" + String.valueOf(precio));
		precioLabel.setBounds(20, 20, 160, 20);
		pagoPanel.add(precioLabel);

		JLabel precioTLabel = new JLabel("Precio Final: ");
		precioTLabel.setBounds(170, 20, 100, 20);
		pagoPanel.add(precioTLabel);
		
		precioFText = new JTextField(String.valueOf(precio));
		precioFText.setEditable(false);
		precioFText.setBounds(280, 20, 100, 20);
		pagoPanel.add(precioFText);

		JLabel adelantoLabel = new JLabel("Adelanto Efvo.: ");
		adelantoLabel.setBounds(20, 50, 100, 20);
		pagoPanel.add(adelantoLabel);

		adelantoText = new JTextField("0");
		adelantoText.setBounds(110, 50, 100, 20);
		adelantoText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           recalcularSaldo();
	           recalcularFinal();
	        }
	    });
		adelantoText.getDocument().addDocumentListener(new ListenerDetalleTotal(this));
		pagoPanel.add(adelantoText);

		JLabel comisionLabel = new JLabel("Comision: ");
		comisionLabel.setBounds(220, 50, 100, 20);
		pagoPanel.add(comisionLabel);

		JLabel descuentoLabel = new JLabel("Descuento: ");
		descuentoLabel.setBounds(440, 50, 100, 20);
		pagoPanel.add(descuentoLabel);
		
		descuentoText = new JTextField("0");
		descuentoText.setBounds(550, 50, 100, 20);
		descuentoText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           recalcularSaldo();
	           recalcularFinal();
	        }
	    });
		descuentoText.getDocument().addDocumentListener(new ListenerDetalleTotal(this));
		pagoPanel.add(descuentoText);
			
		comisionText = new JTextField("0");
		comisionText.setBounds(330, 50, 100, 20);
		comisionText.getDocument().addDocumentListener(new ListenerDetalleTotal(this));
		comisionText.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	           recalcularSaldo();
	           recalcularFinal();
	        }
	    });
		pagoPanel.add(comisionText);

		JLabel comentarioLabel = new JLabel("Comentarios: ");
		comentarioLabel.setBounds(20, 80, 100, 20);
		pagoPanel.add(comentarioLabel);

		comentarioText = new JTextField();
		comentarioText.setBounds(110, 80, 600, 20);
		pagoPanel.add(comentarioText);

		JLabel saldoLabel = new JLabel("Saldo: ");
		saldoLabel.setBounds(20, 110, 100, 20);
		pagoPanel.add(saldoLabel);

		saldoText = new JTextField(String.valueOf(precio));
		saldoText.setBounds(110, 110, 160, 20);
		pagoPanel.add(saldoText);

		JLabel cuotasLabel = new JLabel("Cantidad de cuotas: ");
		cuotasLabel.setBounds(20, 140, 160, 20);
		pagoPanel.add(cuotasLabel);

		cuotasText = new JTextField();
		cuotasText.setBounds(165, 140, 50, 20);
		pagoPanel.add(cuotasText);

		calendar();

		tabla = tablaCuotas();

		JScrollPane jp = new JScrollPane(tabla);

		jp.setBounds(60, 180, 600, 150);

		pagoPanel.add(jp);

		btnAceptarDetalle = new JButton("Aceptar");
		btnAceptarDetalle.setPreferredSize(preferredSize);
		btnAceptarDetalle.setBounds(650, 300, 150, 25);
		pagoPanel.add(btnAceptarDetalle);

		this.validate();
		this.repaint();

	}

	public void cargarTabla(List<Cuota> lista) {

		((DefaultTableModel) tabla.getModel()).setRowCount(0);

		for (Cuota c : lista) {
			
			String day = c.getVencimiento();
			
			String format = new String("dd-MM-yy");

			SimpleDateFormat df = new SimpleDateFormat(format);

			String[] partes = day.split("-");

			String date = new String(partes[2] + "/" + partes[1] + "/" + partes[0]);
			
			

			Object[] o = new Object[6];
			o[0] = c.getCuota();
			o[1] = date;
			o[2] = dfD.format(c.getValor());
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
		calendario.setBounds(225, 140, 300, 20);

		pagoPanel.add(calendario);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(535, 140, 200, 20);

		pagoPanel.add(dateChooser);

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

        btnBuscarVenta = new JButton("Ver ventas");
        btnBuscarVenta.setBounds(480, 60, 160, 25);
        this.add(btnBuscarVenta);

        this.validate();
        this.repaint();

}


	public DetalleVenta getNewDetalle() {
		
		int c; 
		Double a, s, co, d;
		
		try {
			d = Double.valueOf(descuentoText.getText());
		} catch (NumberFormatException e) {
			d = Double.valueOf(0);
		}
		try {
			c = Integer.valueOf(cuotasText.getText());
		} catch (NumberFormatException e) {
			c = 0;
		}
		
		try {
			a = Double.valueOf(adelantoText.getText());
		} catch (NumberFormatException e) {
			a =  Double.valueOf(0);
		}
		
		try {
			co = Double.valueOf(comisionText.getText());
		} catch (NumberFormatException e) {
			co =  Double.valueOf(0);
		}
		try {
			s = Double.valueOf(saldoText.getText());
		} catch (NumberFormatException e) {
			s =  Double.valueOf(0);
		}
		
		
		DetalleVenta v  = new DetalleVenta(idV, idVehiculo, p , c, 
				s, a, co, d, comentarioText.getText());
		
		return v;
	}

	public void recalcularFinal() {
		
		try {
			comision = new Double(comisionText.getText());
		    }
		    catch (NumberFormatException e) {
		        comision = Double.valueOf(0);
		    }
		try {
			descuento = new Double(descuentoText.getText());
		}
		catch (NumberFormatException e) {
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
		    }
		    catch (NumberFormatException | NullPointerException e ) {
		        comision = Double.valueOf(0);
		    }
		try {
			descuento = new Double(descuentoText.getText());			
		}
		catch (NumberFormatException | NullPointerException e ) {
			descuento = Double.valueOf(0);
		}
		try {
			adelanto = new Double(adelantoText.getText());			
		}
		catch (NumberFormatException | NullPointerException e ) {
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


	public JButton getBtnAdqUnidad() {
		return btnAdqUnidad;
	}


	public void setBtnAdqUnidad(JButton btnAdqUnidad) {
		this.btnAdqUnidad = btnAdqUnidad;
	}


	public JButton getBtnBuscarVenta() {
		return btnBuscarVenta;
	}


	public void setBtnBuscarVenta(JButton btnBuscarVenta) {
		this.btnBuscarVenta = btnBuscarVenta;
	}




	public JTextField getNuevaPatenteText() {
		return nuevaPatenteText;
	}


	public void setNuevaPatenteText(JTextField nuevaPatenteText) {
		this.nuevaPatenteText = nuevaPatenteText;
	}


	public JTextField getComisionText() {
		return comisionText;
	}


	public void setComisionText(JTextField comisionText) {
		this.comisionText = comisionText;
	}


	public JTextField getDescuentoText() {
		return descuentoText;
	}


	public void setDescuentoText(JTextField descuentoText) {
		this.descuentoText = descuentoText;
	}


	public JTextField getPrecioFText() {
		return precioFText;
	}


	public void setPrecioFText(JTextField precioFText) {
		this.precioFText = precioFText;
	}


	public String getNuevoVehiculoText() {
		return nuevoVehiculoText;
	}


	public void setNuevoVehiculoText(String nuevoVehiculoText) {
		this.nuevoVehiculoText = nuevoVehiculoText;
	}
	
	public void actualizoNuevaUnidad(String patente, Integer precio, String texto){
		
		nuevaPatenteText.setText(patente);
		descuentoText.setText(String.valueOf(precio));
		nuevaPatenteText.setEditable(false);
		descuentoText.setEditable(false);
		btnAdqUnidad.setEnabled(false);
		setNuevoVehiculoText(texto);
		
		vehiculoALabel.setText("Unidad adquirida: " + nuevoVehiculoText);
		
	}


	public void buscarVenta() {
		this.removeAll();
		
		JLabel datosLabel = new JLabel(
				"Por favor, ingrese DNI del cliente a consultar.");
		datosLabel.setBounds(50	, 40, 360, 25);
		this.add(datosLabel);

		JLabel dniCompradorLabel = new JLabel("DNI(*): ");
		dniCompradorLabel.setBounds(50, 90, 70, 25);
		this.add(dniCompradorLabel);

		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(130, 90, 100, 25);
		this.add(dniCompradorText);
		
		JLabel ventasLabel = new JLabel("Ventas: ");
		ventasLabel.setBounds(240, 90, 70, 25);
		this.add(ventasLabel);
		
		comboVentas = new JComboBox();
		comboVentas.setBounds(320, 90, 160, 25);
		comboVentas.setEnabled(false);
		this.add(comboVentas);
		
		btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.setBounds(70, 160, 160, 25);
		this.add(btnBuscar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(240, 160, 160, 25);
		this.add(btnVolver);

		this.validate();
		this.repaint();
		
	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}


	public void preparoComboVentas(List<Venta> lista) {
		
		List<String> listaV = new ArrayList<String>();
		
		for(Venta v : lista){
			
			String s = "Venta: " + v.getIdVenta() + " - " + v.getFecha();
			
			listaV.add(s);
			
		}
		
		comboVentas.setModel(new DefaultComboBoxModel((listaV.toArray())));
		comboVentas.setEnabled(true);
		
		btnBuscar.setText("Seleccionar");
		
		
		this.revalidate();
		this.repaint();
	}


	public JComboBox<String> getComboVentas() {
		return comboVentas;
	}


	public void setComboVentas(JComboBox<String> comboVentas) {
		this.comboVentas = comboVentas;
	}


	public void mostrarVenta(MuestroVenta v, List<Cuota> c) {
		
		
		this.removeAll();
		
		detallePanel = new JPanel();
		detallePanel.setLayout(null);
	    detallePanel.setBorder(new TitledBorder(new LineBorder(Color.black, 1),
	            "Detalle de Venta N°: " + v.getIdVenta() + "  " ));
	    detallePanel.setBounds(20, 20, w - 290, 200);
	    this.add(detallePanel);

		
	    JLabel clienteLabel = new JLabel(v.getNombreComprador());
	    clienteLabel.setBounds(20, 20, 260, 20);
	    detallePanel.add(clienteLabel);

	    JLabel garanteLabel = new JLabel(v.getNombreGarante());
	    garanteLabel.setBounds(20, 50, 260, 20);
	    detallePanel.add(garanteLabel);
		
		JLabel vehiculoLabel = new JLabel(v.getIdVehiculo());
		vehiculoLabel.setBounds(20, 80, 260, 20);
		detallePanel.add(vehiculoLabel);
		
		JLabel precioLabel = new JLabel("Precio: $" + v.getPrecio());
		precioLabel.setBounds(20, 110, 100, 20);
		detallePanel.add(precioLabel);
		
		JLabel adelantoLabel = new JLabel("Adelanto Efvo.: " + v.getAdelanto());
		adelantoLabel.setBounds(180, 110, 150, 20);
		detallePanel.add(adelantoLabel);

		JLabel comisionLabel = new JLabel("Comision: " + v.getComision());
		comisionLabel.setBounds(360, 110, 100, 20);
		detallePanel.add(comisionLabel);

		JLabel descuentoLabel = new JLabel("Descuento: " + v.getDescuento());
		descuentoLabel.setBounds(480, 110, 100, 20);
		detallePanel.add(descuentoLabel);
		
		JLabel comentarioLabel = new JLabel("Comentarios: " + v.getDetalle());
		comentarioLabel.setBounds(20, 140, 250, 20);
		detallePanel.add(comentarioLabel);

		JLabel saldoLabel = new JLabel("Saldo: " + v.getDeuda());
		saldoLabel.setBounds(20, 170, 100, 20);
		detallePanel.add(saldoLabel);

		

		

		tablaVenta = tablaVenta();

		JScrollPane jp = new JScrollPane(tablaVenta);

		jp.setBounds(20, 230, w - 290, 250);

		this.add(jp);
		
		cargarTablaVenta(c);

		

		btnPagarCuota = new JButton("Pagar Cuota");
		btnPagarCuota.setPreferredSize(preferredSize);
		btnPagarCuota.setBounds(800, 490, 150, 25);
		this.add(btnPagarCuota);
		
		
		this.revalidate();
		this.repaint();
	}


	private JTable tablaVenta() {
		
	
		String columnNames[] = { "Cuota", "Vencimiento", "Valor", "Adelanto", "Recibo", "Intereses", "Pago", "Saldo"};

		JTable tabla = new JTable();
		
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		tabla.getTableHeader().setReorderingAllowed(false);

		tabla.setModel(modelo);

		modelo.setColumnIdentifiers(columnNames);


		
		return tabla;
	}


	public JButton getBtnPagarCuota() {
		return btnPagarCuota;
	}


	public void setBtnPagarCuota(JButton btnPagarCuota) {
		this.btnPagarCuota = btnPagarCuota;
	}


	public Cuota getCuotaTabla() {

		int a = tablaVenta.getSelectedRow();
		
		
		
		Cuota c = null;
			
			try {
				String valor = String.valueOf(tablaVenta.getModel().getValueAt(a,2));			
				String adelanto = String.valueOf(tablaVenta.getModel().getValueAt(a,3));
				String intereses = String.valueOf(tablaVenta.getModel().getValueAt(a,5));
				String pago = String.valueOf(tablaVenta.getModel().getValueAt(a,6));
				String saldo = String.valueOf(tablaVenta.getModel().getValueAt(a,7));
				
				c = new Cuota(String.valueOf(tablaVenta.getModel().getValueAt(a,0)),
						String.valueOf(tablaVenta.getModel().getValueAt(a,1)),
						Double.parseDouble(valor.replace(",", ".")),
						Double.parseDouble(adelanto.replace(",", ".")),
						String.valueOf(tablaVenta.getModel().getValueAt(a,4)),
						Double.parseDouble(intereses.replace(",", ".")),
						Double.parseDouble(pago.replace(",", ".")),
						Double.parseDouble(saldo.replace(",", ".")));
			} catch (Exception e) {
				return null;
			}
					
		return c;
		
	}
	
	public void cargarTablaVenta(List<Cuota> lista) {

		((DefaultTableModel) tablaVenta.getModel()).setRowCount(0);

		for (Cuota c : lista) {
			
			

			Object[] o = new Object[8];
			o[0] = c.getCuota();
			o[1] = c.getVencimiento();
			o[2] = dfD.format(c.getValor());
			o[3] = c.getAdelanto();
			o[4] = c.getRecibo();
			o[5] = c.getIntereses();
			o[6] = c.getPago();
			o[7] = c.getSaldo();

			((DefaultTableModel) tablaVenta.getModel()).addRow(o);

			this.validate();
			this.repaint();
		}

	}


	

}