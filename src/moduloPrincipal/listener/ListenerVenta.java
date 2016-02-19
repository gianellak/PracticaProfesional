package moduloPrincipal.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasInterface;
import moduloCobranzas.ventas.VentasView;
import moduloLogin.LoginController;
import moduloPrincipal.PrincipalController;

public class ListenerVenta implements ActionListener {

	private VentasInterface vi;
	
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
		
		try {
			vc.showVenta();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pc.onCancel();
		
	}

}
