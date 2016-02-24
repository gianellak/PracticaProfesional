package moduloUsuarios.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UsuarioMenu extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25) ;
	private JButton btnAltaU;
	private JButton btnVerU;
	private JButton btnVolver;
	private JButton btnListaU;


public UsuarioMenu() {
		

		this.setPreferredSize(new Dimension(250, 500));
		
		btnAltaU = new JButton("Alta Usuario");
		btnAltaU.setPreferredSize(preferredSize);
		this.add(btnAltaU);
		
		btnListaU = new JButton("Listar Usuarios");
		btnListaU.setPreferredSize(preferredSize);
		this.add(btnListaU);
		
		btnVerU = new JButton("Buscar Usuario");
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

	public JButton getBtnListaU() {
		return btnListaU;
	}

	public void setBtnListaU(JButton btnListaU) {
		this.btnListaU = btnListaU;
	}



}
