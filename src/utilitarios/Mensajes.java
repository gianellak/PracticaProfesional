package utilitarios;

import javax.swing.JOptionPane;

import moduloClientes.paneles.PanelClientes;
import objetos.Persona;

public class Mensajes {

	//CLIENTES

	public static void showNotFound() {
		
		JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos. Por favor reintente");

	}
	

	public static int showToDelete(Persona p) {
		
		String s = new String("¿Esta seguro que desea eliminar el cliente: " + p.getApellido() + " " + p.getNombre() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;	
		
	}
	
	public static void deleteOk(PanelClientes panelClientes) {
		JOptionPane.showMessageDialog(null, "Cliente borrado correctamente.");
		
		PantallaUtil.remove(panelClientes);
		
	}

	public static void deleteBad() {
		
		JOptionPane.showMessageDialog(null, "Error al borrar cliente. Revise los datos ingresados.");
		
	}
	

	public static void updateOk(PanelClientes p) {

		JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
		
		PantallaUtil.remove(p);
		
	}



	public static void updateBad() {
		
		JOptionPane.showMessageDialog(null, "Error al modificar el cliente. Revise los datos ingresados");
		
	}


	public static void insertOk(PanelClientes p) {
		
		JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
		
		PantallaUtil.remove(p);
		
	}

	public static void insertBad() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al dar de alta el cliente. Por favor reintente");
		
	}
	
	public static int showToUpdate(Persona cliente) {
		String s = new String("¿Esta seguro que desea modificar los datos del cliente: " + cliente.getApellido() + " " +cliente.getNombre()+ "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Modificar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
	}
	
	//VEHICULOS

	public static int msjSinPatente() {
		
		String s = new String("No se ha registrado el ingreso de una patente válida. ¿Desea ver los autos en stock?");
		
		int codigo=JOptionPane.showConfirmDialog(null, s , "Not Found", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
		
	}


}
