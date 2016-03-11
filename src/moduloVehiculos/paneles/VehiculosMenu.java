package moduloVehiculos.paneles;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class VehiculosMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnNuevo;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JButton btnStock;


public VehiculosMenu() {
		

	Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int h = height.intValue() - 150;
	this.setPreferredSize(new Dimension(250, h));
	this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
	btnNuevo = new JButton("Nuevo Vehiculo");
	btnNuevo.setPreferredSize(preferredSize);
	this.add(btnNuevo);
	
	btnBuscar = new JButton("Buscar Vehiculo");
	btnBuscar.setPreferredSize(preferredSize);
	this.add(btnBuscar);
		
	btnStock = new JButton("Ver Stock");
	btnStock.setPreferredSize(preferredSize);
	this.add(btnStock);
	
	btnVolver = new JButton("Volver");
	btnVolver.setPreferredSize(preferredSize);
	this.add(btnVolver);
		
	}


public JButton getBtnNuevo() {
	return btnNuevo;
}


public void setBtnNuevo(JButton btnNuevo) {
	this.btnNuevo = btnNuevo;
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


public JButton getBtnStock() {
	return btnStock;
}


public void setBtnStock(JButton btnStock) {
	this.btnStock = btnStock;
}


	

}
