package moduloVehiculos.paneles;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VehiculosMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnSalir;
	private JButton btnNuevo;
	private JTextField txtPatente;
	private JButton btnBuscar;
	private JButton btnStock;


public VehiculosMenu() {
		

		this.setPreferredSize(new Dimension(250, 500));
		
		// BOTONES
		JLabel lblPatente = new JLabel("Ingrese patente: ");
		lblPatente.setPreferredSize(preferredSize);
		this.add(lblPatente);

		txtPatente = new JTextField(6);
		txtPatente.setPreferredSize(preferredSize);
		this.add(txtPatente);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setPreferredSize(preferredSize);
		this.add(btnBuscar);

		btnStock = new JButton("Stock");
		btnStock.setPreferredSize(preferredSize);
		this.add(btnStock);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setPreferredSize(preferredSize);
		this.add(btnNuevo);

		btnSalir = new JButton("Salir");
		btnSalir.setPreferredSize(preferredSize);
		this.add(btnSalir);

	}


	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public void setTxtPatente(JTextField txtPatente) {
		this.txtPatente = txtPatente;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnStock() {
		return btnStock;
	}

	public void setBtnStock(JButton btnStock) {
		this.btnStock = btnStock;
	}

}
