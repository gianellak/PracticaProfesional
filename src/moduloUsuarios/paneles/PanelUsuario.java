package moduloUsuarios.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;

public class PanelUsuario extends JPanel {
	
	private Dimension preferredSize =new Dimension(200,25);
	private JButton btnVolver;

	public PanelUsuario(){
		
		
		System.out.println("Creo nuevo panel Usuario");
		
		this.setPreferredSize(new Dimension(1500, 500));
		
		
		
		
	}
	
	public void onAlta(){
		
		this.removeAll();
		System.out.println("ONALTA");
		btnVolver = new JButton("Volver");
		btnVolver.setPreferredSize(preferredSize);
		this.add(btnVolver, BorderLayout.CENTER);
		this.validate();
		this.repaint();
		
	}
	

}
