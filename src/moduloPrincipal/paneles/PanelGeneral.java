package moduloPrincipal.paneles;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import objetos.Usuario;

public class PanelGeneral extends JPanel {
	
	
	public PanelGeneral(Usuario user){
		

		
		//this.setBackground(Color.red);
		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int w = width.intValue();
		
		this.setPreferredSize(new Dimension(w, 150));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setLayout(null);
		
		JLabel logoLabel = new JLabel("Gitanes Automotores S.R.L");
		logoLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		logoLabel.setBounds(30, 0, 450, 90);

		JLabel usuarioLabel = new JLabel("Usuario: " + user.getNombre() + " " + user.getApellido());
		usuarioLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		usuarioLabel.setBounds(30, 90, 250, 20);
		
		
		String format = new String("dd/MM/yyyy");
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String stringDate = df.format(d);
		
		
		JLabel fechaLabel = new JLabel("Fecha: " + stringDate);
		fechaLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		fechaLabel.setBounds(1200, 30, 300, 20);;
		
		
		
		
		this.add(usuarioLabel);
		this.add(logoLabel);
		this.add(fechaLabel);
		
		this.revalidate();
		this.repaint();
		
		
	}

}
