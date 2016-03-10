package moduloPrincipal.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class PanelMenu extends JPanel {
	
	private JButton btnSalir;
	private JButton btnVehiculo;
	private JButton btnVenta;
	private JButton btnCliente;
	private JButton btnCaja;
	private JButton btnUsuario;
	private Dimension preferredSize =new Dimension(200,25) ;


	public PanelMenu(){
		
	
		//this.setBackground(Color.blue);
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int h = height.intValue() - 150;
		this.setPreferredSize(new Dimension(250, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		btnUsuario= new JButton("Menu Usuario ");
		btnUsuario.setPreferredSize(preferredSize);
		this.add(btnUsuario);
		
		btnCliente= new JButton("Menu Cliente");
		btnCliente.setPreferredSize(preferredSize);
		this.add(btnCliente);
	
		btnVenta= new JButton("Menu Ventas");
		btnVenta.setPreferredSize(preferredSize);
		this.add(btnVenta);

		btnVehiculo= new JButton("Menu Vehículo");
		btnVehiculo.setPreferredSize(preferredSize);
		this.add(btnVehiculo);

		btnCaja= new JButton("Menu Caja ");
		btnCaja.setPreferredSize(preferredSize);
		this.add(btnCaja);
		
		btnSalir= new JButton("Salir ");
		btnSalir.setPreferredSize(preferredSize);
		this.add(btnSalir);
		

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
