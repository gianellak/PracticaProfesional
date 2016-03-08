package utilitarios;

import javax.swing.JOptionPane;

public class StringMsj {
	
	//VARIOS
	
	public static final String MSG_DNI_NOT_VALID =
			"No ha ingresado un DNI v�lido. Por favor reingrese.";	
	
	public static final String MSG_NEW_CLIENT =
		"Dni no registrado en el sistema. �Desea dar de alta a la persona?";
	

	//CLIENTES
	
	public static final String MSG_CLI_NOT_FOUND =
			"El cliente ingresado no se encuentra en la base de datos. Por favor reintente.";	
	
	public static final String MSG_CLI_MOD_OK =
			"Los datos del cliente han sido modificados correctamente.";	

	public static final String MSG_CLI_INS_OK =
			"El cliente cliente ha sido agregado correctamente.";	
	
	public static final String MSG_CLI_DEL_OK =
			"El cliente hasido borrado correctamente.";	
	
	public static final String MSG_CLI_DEL_BAD =
			"Ha ocurrido un error al intentar borrar cliente. Por favor reintente.";	
	
	public static final String MSG_CLI_MOD_BAD =
			"Ha ocurrido un error al intentar modificar el cliente. Por favor reintente.";	
	
	public static final String MSG_CLI_INS_BAD =
			"Ha ocurrido un error al intentar dar de alta el cliente. Por favor reintente.";	

	public static final String MSG_CLI_NOT_OBLI = 
			"Algunos de los campos obligatorios no ha sido completados o resultan inv�lidos. Por favor, revise los datos y vuelva a intentarlo.";	
	
	//CAJA
	
	public static final String MSG_CJA_NOT_MOV =
			"No hay movimientos registrados para el d�a seleccionado. Intente con otra fecha";
	
	//VENTAS

	public static final String MSG_GTE_INS_BAD = 
			"Ha ocurrido un error al intentar dar de alta el garante. Por favor reintente.";
	
	public static final String MSG_GTE_INS_OK = 
			"Ha ocurrido un error al intentar dar de alta el garante. Por favor reintente.";

	public static final String MSG_VTA_OK = 
			"Venta generada con �xito. Por favor, complete los datos de pago.";

	
}