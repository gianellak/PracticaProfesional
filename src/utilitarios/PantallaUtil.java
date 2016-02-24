package utilitarios;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PantallaUtil {
	
	public static void remove(JPanel p){
		
		p.removeAll();
		p.validate();
		p.repaint();
		
	}
	
	public static void refresh(JFrame f){
		
		f.validate();
		f.repaint();
		
	}

}
