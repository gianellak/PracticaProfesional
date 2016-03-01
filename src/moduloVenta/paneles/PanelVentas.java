package moduloVenta.paneles;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import objetos.Persona;
import objetos.Vehiculo;

public class PanelVentas extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension preferredSize =new Dimension(200,25);
	private JTextField dniCompradorText;
	private JTextField patenteText;
	private JTextField dniGaranteText;
	private JButton btnValidarDniC;
	private JButton btnValidarDniG;
	private JButton btnBuscarVehiculo;
	private JButton btnAceptarNuevaV;
	private JButton btnVolverNuevaV;
	private FocusListener l;

	public PanelVentas(){
		
		
		System.out.println("Creo nuevo panel Venta");
		
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		
	}

// Muestra los tres campos iniciales para crear una venta.
	
	public void showNuevaVenta() {
		
		this.removeAll();
		
		System.out.println("En Nueva Venta");
		
		JLabel compradorLabel = new JLabel("Ingrese DNI del Comprador: ");
		compradorLabel.setBounds(50, 60, 200, 25);
		this.add(compradorLabel);
		
		dniCompradorText = new JTextField(9);
		dniCompradorText.setBounds(300, 60, 160, 25);
		this.add(dniCompradorText);
		
		btnValidarDniC = new JButton("Validar Dni");
		btnValidarDniC.setPreferredSize(preferredSize);
		btnValidarDniC.setBounds(480, 60, 160, 25);
		this.add(btnValidarDniC);
		
		JLabel vehiculoLabel = new JLabel("Ingrese Patente: ");
		vehiculoLabel.setBounds(50, 90, 200, 25);
		this.add(vehiculoLabel);

		patenteText = new JTextField(9);
		patenteText.setBounds(300, 90, 160, 25);
		this.add(patenteText);
		
		btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.setPreferredSize(preferredSize);
		btnBuscarVehiculo.setBounds(480, 90, 160, 25);
		this.add(btnBuscarVehiculo);
		
		JLabel garanteLabel = new JLabel("Usuario: ");
		garanteLabel.setBounds(50, 120, 200, 25);
		this.add(garanteLabel);
		
		dniGaranteText = new JTextField(9);
		dniGaranteText.setBounds(300, 120, 160, 25);
		this.add(dniGaranteText);
		
		btnValidarDniG = new JButton("Validar Dni");
		btnValidarDniG.setPreferredSize(preferredSize);
		btnValidarDniG.setBounds(480, 120, 160, 25);
		this.add(btnValidarDniG);
		
		btnAceptarNuevaV = new JButton("Aceptar");
		btnAceptarNuevaV.requestFocus(true);
		btnAceptarNuevaV.setPreferredSize(preferredSize);
		btnAceptarNuevaV.setBounds(480, 200, 160, 25);
		this.add(btnAceptarNuevaV);
		
		btnVolverNuevaV = new JButton("Volver");
		btnVolverNuevaV.setPreferredSize(preferredSize);
		btnVolverNuevaV.setBounds(650, 200, 160, 25);
		this.add(btnVolverNuevaV);
		
		
		this.validate();
		this.repaint();
		
		
		
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

	public JButton getBtnAceptarNuevaV() {
		return btnAceptarNuevaV;
	}

	public void setBtnAceptarNuevaV(JButton btnAceptarNuevaV) {
		this.btnAceptarNuevaV = btnAceptarNuevaV;
	}

	public JButton getBtnVolverNuevaV() {
		return btnVolverNuevaV;
	}

	public void setBtnVolverNuevaV(JButton btnVolverNuevaV) {
		this.btnVolverNuevaV = btnVolverNuevaV;
	}

	public void mostrarCliente(Persona cliente) {
		
		JLabel compradorLabel = new JLabel(cliente.getApellido()+ " " + cliente.getNombre());
		compradorLabel.setBounds(650, 60, 200, 25);
		this.add(compradorLabel);
		
		dniCompradorText.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        btnValidarDniC.setEnabled(true);
		        compradorLabel.setText("");		
		    }

		    public void focusLost(FocusEvent e) {
		    	btnAceptarNuevaV.requestFocus(true);
		    }
		});
		
		btnValidarDniC.setEnabled(false);
		
	}

	public void mostrarGarante(Persona cliente) {
		
		JLabel garanteLabel = new JLabel(cliente.getApellido()+ " " + cliente.getNombre());
		garanteLabel.setBounds(650, 120, 200, 25);
		this.add(garanteLabel);
		
		dniGaranteText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				btnValidarDniG.setEnabled(true);
				garanteLabel.setText("");	
			}
			
			public void focusLost(FocusEvent e) {
				btnAceptarNuevaV.requestFocus(true);
			}
		});
		
		btnValidarDniG.setEnabled(false);
		
	}

	public void mostrarPatente(Vehiculo vehiculo) {
		
		JLabel vehiculoLabel = new JLabel(vehiculo.getMarca()+ " " + vehiculo.getModelo());
		vehiculoLabel.setBounds(650, 90, 250, 25);
		this.add(vehiculoLabel);
		
		patenteText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				btnBuscarVehiculo.setEnabled(true);
				vehiculoLabel.setText("");				
			}
			

			public void focusLost(FocusEvent e) {
				btnAceptarNuevaV.requestFocus(true);
			}
		});
		
		btnBuscarVehiculo.setEnabled(false);
		
	}

	public Boolean getButtonState() {
		
		if(btnValidarDniG.isEnabled() ||
		btnValidarDniC.isEnabled() ||
		btnBuscarVehiculo.isEnabled()){
			return false;			
		}else{
			return true;
		}
	}

	public void mostrarDatosPago() {
		System.out.println("mostrar datos de pago");
		
	}

	
	
	
}

