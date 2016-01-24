package moduloPrincipal;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listeners.ListenerC;
import listeners.ListenerL;
import listeners.ListenerS;
import listeners.ListenerV;
import listeners.ListenerCV;
import moduloCobranzas.ventas.VentasInterface;

public class PrincipalView implements PrincipalInterface {
	
	private JFrame frmPrin;
	private Container contentPane;
	private JButton btnSalir;
	private JButton btnStock;
	private JButton btnVenta;
	private PrincipalController pc;
	private ListenerCV listenerCV;
	private ListenerS listenerStock;
	private ListenerV listenerVenta;


	public PrincipalView(){
	
		//FRAME
		frmPrin = new JFrame("Menu Principal"); 
		frmPrin.setBounds(500, 100, 400, 600);
		frmPrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//PANEL
		contentPane = new JPanel();
		((JComponent) contentPane).setBorder(new EmptyBorder(5, 5, 5, 5));
		
		frmPrin.setContentPane(contentPane);
	
		
		//BOTONES	
		
		btnStock= new JButton("Consultar Stock ");
		contentPane.add(btnStock);
	
		btnVenta= new JButton("Consultar Venta");
		contentPane.add(btnVenta);
	
		btnSalir= new JButton("Salir ");
		contentPane.add(btnSalir);
	

		}


	@Override
	public void showPrincipal(PrincipalController principalController) {
		pc = principalController;
		
		listenerCV = new ListenerCV(pc);
		listenerStock = new ListenerS();
		listenerVenta = new ListenerV(pc);
		
		btnStock.addActionListener(listenerStock);
		btnVenta.addActionListener(listenerVenta);
		btnSalir.addActionListener(listenerCV);
		
		frmPrin.setVisible(true);
		
	}


	@Override
	public void closePrincipal() {

		frmPrin.dispose();
		
	}


	@Override
	public void showVenta(VentasInterface sc) {
		// TODO Auto-generated method stub
		
	}


	


	
	
}
