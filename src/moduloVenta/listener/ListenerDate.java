package moduloVenta.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.Date;

import exceptions.DBException;
import moduloCaja.CajaController;
import moduloClientes.ClientesController;
import moduloPrincipal.PrincipalController;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioView;
import moduloVenta.VentasController;

public class ListenerDate implements PropertyChangeListener {

	private VentasController vc;

	public ListenerDate(VentasController vc) {
		this.vc = vc;

	}

	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		   if ("date".equals(evt.getPropertyName())) {
           	Date fecha = (Date) evt.getNewValue();
           	
           	vc.veoFecha(fecha);
           	
               
           }
		
	}

}
