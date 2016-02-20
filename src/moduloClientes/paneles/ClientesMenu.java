package moduloClientes.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClientesMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnVolver;
	private JButton btnVerC;
	private JButton btnAltaC;


public ClientesMenu() {
		

		this.setPreferredSize(new Dimension(250, 500));
		
		btnAltaC = new JButton("Alta Cliente");
		btnAltaC.setPreferredSize(preferredSize);
		this.add(btnAltaC);
		
		btnVerC = new JButton("Ver Cliente");
		btnVerC.setPreferredSize(preferredSize);
		this.add(btnVerC);
		
		btnVolver = new JButton("Volver");
		btnVolver.setPreferredSize(preferredSize);
		this.add(btnVolver);
		
		

	}

	
	public JButton getBtnAltaC() {
		return btnAltaC;
	}

	public void setBtnAltaC(JButton btnAltaC) {
		this.btnAltaC = btnAltaC;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}


	public JButton getBtnVerC() {
		return btnVerC;
	}


	public void setBtnVerC(JButton btnVerC) {
		this.btnVerC = btnVerC;
	}
	

}
