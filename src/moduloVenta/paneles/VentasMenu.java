package moduloVenta.paneles;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentasMenu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnVolver;
	private JButton btnNuevaVenta;
	private JButton btnNuevaCompra;



public VentasMenu() {		

		this.setPreferredSize(new Dimension(250, 500));
		
		btnNuevaVenta = new JButton("Nueva Venta");
		btnNuevaVenta.setPreferredSize(preferredSize);
		this.add(btnNuevaVenta);
		
		btnNuevaCompra = new JButton("Nueva Compra");
		btnNuevaCompra.setPreferredSize(preferredSize);
		this.add(btnNuevaCompra);
		
		btnVolver = new JButton("Volver");
		btnVolver.setPreferredSize(preferredSize);
		this.add(btnVolver);
		
	}



public JButton getBtnVolver() {
	return btnVolver;
}

public void setBtnVolver(JButton btnVolver) {
	this.btnVolver = btnVolver;
}

public JButton getBtnNuevaVenta() {
	return btnNuevaVenta;
}

public void setBtnNuevaVenta(JButton btnNuevaVenta) {
	this.btnNuevaVenta = btnNuevaVenta;
}

public JButton getBtnNuevaCompra() {
	return btnNuevaCompra;
}

public void setBtnNuevaCompra(JButton btnNuevaCompra) {
	this.btnNuevaCompra = btnNuevaCompra;
}	

}
