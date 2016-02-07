package moduloPrincipal;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;

public class PanelGeneral extends JPanel {
	
	PanelGeneral(Usuario user){
		
		
		System.out.println("Creo nuevo panel");
		
		this.setBackground(Color.red);
		this.setLayout(null);

		this.setSize(500, 100);
		
		this.setLocation(1, 1);
		
		JLabel usuarioLabel = new JLabel("Usuario: " + user.getNombre() + " " + user.getApellido());
		usuarioLabel.setBounds(10, 10, 300, 20);
	
		JLabel editarLabel = new JLabel("Editar Perfil");
		editarLabel.setBounds(10, 35, 300, 20);
		
		this.add(usuarioLabel);
		this.add(editarLabel);
		
		
	}

}
