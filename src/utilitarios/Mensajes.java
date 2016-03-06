package utilitarios;

import javax.swing.JOptionPane;

import objetos.Persona;

public class Mensajes {

	//CLIENTES

	public static void mensajeInfo(String m) {
		
		JOptionPane.showMessageDialog(null, m);

	}
	
	public static void mensajeWarning(String m) {
		
		JOptionPane.showMessageDialog(null, m, "Error",
			    JOptionPane.WARNING_MESSAGE);
		
	}
	

	public static int showToDelete(Persona p) {
		
		String s = new String("¿Esta seguro que desea eliminar el cliente: " + p.getApellido() + " " + p.getNombre() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;	
		
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
