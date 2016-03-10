package moduloClientes.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ClientesMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnVolver;
	private JButton btnVerC;
	private JButton btnAltaC;


public ClientesMenu() {
		

	Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int h = height.intValue() - 150;
	this.setPreferredSize(new Dimension(250, h));
	this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		
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
