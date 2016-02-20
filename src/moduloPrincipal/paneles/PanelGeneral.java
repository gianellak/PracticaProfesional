package moduloPrincipal.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;

public class PanelGeneral extends JPanel {
	
	
	public PanelGeneral(Usuario user){
		
		
		System.out.println("Creo nuevo panel");
		
		//this.setBackground(Color.red);
		
		this.setPreferredSize(new Dimension(700, 150));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JLabel usuarioLabel = new JLabel("Usuario: " + user.getNombre() + " " + user.getApellido());
		usuarioLabel.setBounds(30, 20, 250, 20);
	
		JLabel editarLabel = new JLabel("Editar Perfil");
		editarLabel.setBounds(30, 40, 250, 20);
		
		this.add(usuarioLabel);
		
		this.add(editarLabel);
		
		this.revalidate();
		this.repaint();
		
		
	}

}
