package moduloPrincipal.paneles;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	
	private JButton btnSalir;
	private JButton btnVehiculo;
	private JButton btnVenta;
	private JButton btnCliente;
	private JButton btnCaja;
	private JButton btnUsuario;


	public PanelMenu(){
		
		this.setBackground(Color.green);
		
		btnUsuario= new JButton("Menu Usuario ");
		btnUsuario.setBounds(50, 130, 200, 25);
		this.add(btnUsuario);
		
		btnCliente= new JButton("Menu Cliente");
		btnCliente.setBounds(50, 160, 200, 25);
		this.add(btnCliente);
	
		btnVenta= new JButton("Menu Ventas");
		btnVenta.setBounds(50, 190, 200, 25);
		this.add(btnVenta);

		btnVehiculo= new JButton("Menu Vehículo");
		btnVehiculo.setBounds(50, 220, 200, 25);
		this.add(btnVehiculo);

		btnCaja= new JButton("Menu Caja ");
		btnCaja.setBounds(50, 250, 200, 25);
		this.add(btnCaja);
		
		btnSalir= new JButton("Salir ");
		btnSalir.setBounds(50, 280, 100, 25);
		this.add(btnSalir);

		this.setLayout(null);
		
		this.setSize(500, 500);
		
		this.setLocation(1, 101);
		

	}


	public JButton getBtnUsuario() {
		return btnUsuario;
	}


	public void setBtnUsuario(JButton btnUsuario) {
		this.btnUsuario = btnUsuario;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}


	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


	public JButton getBtnVehiculo() {
		return btnVehiculo;
	}


	public void setBtnVehiculo(JButton btnVehiculo) {
		this.btnVehiculo = btnVehiculo;
	}


	public JButton getBtnVenta() {
		return btnVenta;
	}


	public void setBtnVenta(JButton btnVenta) {
		this.btnVenta = btnVenta;
	}



	public JButton getBtnCliente() {
		return btnCliente;
	}


	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
	}


	public JButton getBtnCaja() {
		return btnCaja;
	}


	public void setBtnCaja(JButton btnCaja) {
		this.btnCaja = btnCaja;
	}
	

}
