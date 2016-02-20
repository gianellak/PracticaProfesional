package moduloClientes.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClientesMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnAltaU;
	private JButton btnBajaU;
	private JButton btnModU;
	private JButton btnVerU;
	private JButton btnVolver;


public ClientesMenu() {
		

		this.setPreferredSize(new Dimension(250, 500));
		
		btnAltaU = new JButton("Alta Usuario");
		btnAltaU.setPreferredSize(preferredSize);
		this.add(btnAltaU);
		
		btnBajaU = new JButton("Baja Usuario");
		btnBajaU.setPreferredSize(preferredSize);
		this.add(btnBajaU);
		
		btnModU = new JButton("Modificacion Usuario");
		btnModU.setPreferredSize(preferredSize);
		this.add(btnModU);
		
		btnVerU = new JButton("Ver Usuario");
		btnVerU.setPreferredSize(preferredSize);
		this.add(btnVerU);
		
		btnVolver = new JButton("Volver");
		btnVolver.setPreferredSize(preferredSize);
		this.add(btnVolver);
		
		

	}

	
	public JButton getBtnAltaU() {
		return btnAltaU;
	}

	public void setBtnAltaU(JButton btnAltaU) {
		this.btnAltaU = btnAltaU;
	}

	public JButton getBtnBajaU() {
		return btnBajaU;
	}

	public void setBtnBajaU(JButton btnBajaU) {
		this.btnBajaU = btnBajaU;
	}

	public JButton getBtnModU() {
		return btnModU;
	}

	public void setBtnModU(JButton btnModU) {
		this.btnModU = btnModU;
	}

	public JButton getBtnVerU() {
		return btnVerU;
	}

	public void setBtnVerU(JButton btnVerU) {
		this.btnVerU = btnVerU;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	

}
