package moduloCaja.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CajaMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;

	private JButton btnVolver;
	private JButton btnVerMovs;
	private JButton btnVerLog;

	private JButton btnVerUnDia;


public CajaMenu() {
		

		this.setPreferredSize(new Dimension(250, 500));
		
		btnVerMovs = new JButton("Ver Caja del Dia");
		btnVerMovs.setPreferredSize(preferredSize);
		this.add(btnVerMovs);
		
		btnVerUnDia = new JButton("Ver Caja de Otro día");
		btnVerUnDia.setPreferredSize(preferredSize);
		this.add(btnVerUnDia);
		
		btnVerLog = new JButton("Ver Log");
		btnVerLog.setPreferredSize(preferredSize);
		this.add(btnVerLog);
		
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

	public JButton getBtnVerLog() {
		return btnVerLog;
	}

	public void setBtnVerLog(JButton btnVerLog) {
		this.btnVerLog = btnVerLog;
	}

}
