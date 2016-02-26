package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import moduloVenta.VentasController;
import moduloVenta.VentasInterface;
import moduloVenta.VentasView;
import moduloPrincipal.PrincipalController;

public class ListenerVenta implements ActionListener {

	private VentasView vi;
	private PrincipalController pc;


	public ListenerVenta(PrincipalController pc) {
		super();
		this.pc = pc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("ListenerVentas");
		
		vi = new VentasView();
		
		VentasController vc = new VentasController(vi, pc);
		
		vc.showVentas();
		
	}

}
