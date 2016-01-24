package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import moduloCobranzas.ventas.VentasController;
import moduloCobranzas.ventas.VentasInterface;
import moduloCobranzas.ventas.VentasView;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.login.LoginController;

public class ListenerV implements ActionListener {

	private VentasInterface vi;
	
	private PrincipalController pc;
	

	public ListenerV(PrincipalController pc) {
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
