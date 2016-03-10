package moduloCaja.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class CajaMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;

	private JButton btnVolver, btnVerMovs,  btnVerUnDia;


public CajaMenu() {
		

	Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	int h = height.intValue() - 150;
	this.setPreferredSize(new Dimension(250, h));
	this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		btnVerMovs = new JButton("Ver Caja del Dia");
		btnVerMovs.setPreferredSize(preferredSize);
		this.add(btnVerMovs);
		
		btnVerUnDia = new JButton("Ver Caja de Otro día");
		btnVerUnDia.setPreferredSize(preferredSize);
		this.add(btnVerUnDia);
				
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

	public JButton getBtnVerMovs() {
		return btnVerMovs;
	}


	public void setBtnVerMovs(JButton btnVerMovs) {
		this.btnVerMovs = btnVerMovs;
	}

	public JButton getBtnVerUnDia() {
		return btnVerUnDia;
	}


	public void setBtnVerUnDia(JButton btnVerUnDia) {
		this.btnVerUnDia = btnVerUnDia;
	}

}
