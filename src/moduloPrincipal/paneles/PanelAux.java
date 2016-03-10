package moduloPrincipal.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PanelAux extends JPanel {
	
	public PanelAux(){
		
		//this.setBackground(Color.green);
		
		Double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int w = width.intValue() - 250;
		
		Double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int h = height.intValue() - 150;
		
		this.setPreferredSize(new Dimension(w, h));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
	   
	}
	
	

}
