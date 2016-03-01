package moduloVehiculos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import exceptions.DBException;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;
import moduloVehiculos.VehiculosController;

public class ListenerMenuVehiculoVolver implements ActionListener {


	private VehiculosController vc;


	public ListenerMenuVehiculoVolver(VehiculosController vc){
		this.vc = vc;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		vc.cleanVehiculo();
		
		
	}
	
}
