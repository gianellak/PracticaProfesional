package moduloPrincipal.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;

public class PanelGeneral extends JPanel {
	
	private Dimension preferredSize =new Dimension(300,25) ;
	
	public PanelGeneral(Usuario user){
		
		
		System.out.println("Creo nuevo panel");
		
		//this.setBackground(Color.red);
		
		this.setPreferredSize(new Dimension(100, 100));
		
		this.setLayout(new BorderLayout());
	   
		
		JLabel usuarioLabel = new JLabel("Usuario: " + user.getNombre() + " " + user.getApellido());
		usuarioLabel.setPreferredSize(preferredSize);
	
		JLabel editarLabel = new JLabel("Editar Perfil");
		editarLabel.setPreferredSize(preferredSize);
		
		this.add(usuarioLabel, BorderLayout.LINE_START);
		this.add(editarLabel);
		
		this.revalidate();
		
		
	}

}
