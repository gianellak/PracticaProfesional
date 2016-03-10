package moduloVenta.paneles;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class VentasMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension preferredSize = new Dimension(200, 25);
	private JButton btnVolver, btnNuevaVenta, btnBuscarVenta;

	public VentasMenu() {

		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int h = height.intValue() - 150;
		this.setPreferredSize(new Dimension(250, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		btnNuevaVenta = new JButton("Nueva Venta");
		btnNuevaVenta.setPreferredSize(preferredSize);
		this.add(btnNuevaVenta);

		btnBuscarVenta = new JButton("Buscar Venta");
		btnBuscarVenta.setPreferredSize(preferredSize);
		this.add(btnBuscarVenta);

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

	public JButton getBtnBuscarVenta() {
		return btnBuscarVenta;
	}

	public void setBtnBuscarVenta(JButton btnBuscarVenta) {
		this.btnBuscarVenta = btnBuscarVenta;
	}

	

}
