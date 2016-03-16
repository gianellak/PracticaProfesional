package utilitarios;



public class StringMsj {
	
	//VARIOS
	
	public static final String MSG_DNI_NOT_VALID =
			"No ha ingresado un DNI válido. Por favor reingrese.";	
	
	public static final String MSG_USER_NOT_VALID =
			"El usuario ingresado no es válido.";	
	
	public static final String MSG_NEW_CLIENT =
			"Dni no registrado en el sistema. ¿Desea dar de alta a la persona?";
	
	public static final String MSG_INPUT_MISSING = 
			"No se ha registrado el ingreso de datos válidos. Por favor reintente.";

	public static final String MSG_NOT_OBLI = 
			"Algunos de los campos obligatorios no ha sido completados o resultan inválidos. Por favor, revise los datos y vuelva a intentarlo.";	
	
	public static final String MSG_OBLI = 
			"Algunos de los campos obligatorios no ha sido completados. Por favor, revise los datos y vuelva a intentarlo.";	
	
	public static final String MSG_BAD_DATA = 
			"Algunos de los campos resultan inválidos. Por favor, revise los datos y vuelva a intentarlo.";	



	

	//CLIENTES
	
	public static final String MSG_CLI_NOT_FOUND =
			"El cliente ingresado no se encuentra en la base de datos. Por favor reintente.";	
	
	public static final String MSG_CLI_MOD_OK =
			"Los datos del cliente han sido modificados correctamente.";	

	public static final String MSG_CLI_INS_OK =
			"El cliente ha sido agregado correctamente.";	
	
	public static final String MSG_CLI_DEL_OK =
			"El cliente ha sido borrado correctamente.";	
	
	public static final String MSG_CLI_DEL_BAD =
			"Ha ocurrido un error al intentar borrar cliente. Por favor reintente.";	

	public static final String MSG_CLI_MOD_BAD =
			"Ha ocurrido un error al intentar modificar el cliente. Por favor reintente.";	
	
	public static final String MSG_CLI_INS_BAD =
			"Ha ocurrido un error al intentar dar de alta el cliente. Por favor reintente.";	
	
	//CAJA
	
	public static final String MSG_CJA_NOT_MOV =
			"No hay movimientos registrados para el día seleccionado. Intente con otra fecha";
	
	public static final String MSG_MOD_MOV = 
			"¿Está de acuerdo con los cambios en el movimiento?";
	
	public static final String MSG_MOD_MOV_OK = 
			"El movimiento ha sido modificado correctamente.";
	
	public static final String MSG_MOV_NOT_MOD = 
			"No está autorizado a modificar este movimiento. ";
	
	public static final String MSG_MOD_MOV_BAD = 
			"Ha ocurrido un problema al intentar modificar el movimiento. Por favor reintente.";

	public static final String MSG_DEL_MOV = 
			"¿Está seguro que desea eliminar el movimiento seleccionado?";

	public static final String MSG_DEL_MOV_OK = 
			"El movimiento se ha eliminado correctamente.";

	public static final String MSG_DEL_MOV_BAD = 
			"No es posible eliminar el movimiento seleccionado.";

	public static final String MSG_FIRST_MOV= 
			"No hay movimientos registrados al día de la fecha. Deberá realizar la apertura de la caja para continuar.";

	public static final String MSG_LAST_MOV= 
			"¿Está seguro de que desea cerrar la caja? No podrá ingresar nuevos movimientos por este día.";

	public static final String MSG_MOV_INS_OK= 
			"Movimiento agregado correctamente.";
	
	public static final String MSG_MOV_INS_BAD= 
			"Ha ocurrido un error al intentar ingresar el movimiento. Por favor, revise los datos ingresados y reintente.";
	
	
	//VENTAS

	public static final String MSG_GTE_INS_BAD = 
			"Ha ocurrido un error al intentar dar de alta el garante. Por favor reintente.";
	
	public static final String MSG_GTE_INS_OK = 
			"Garante registrado correctamente.";

	public static final String MSG_VTA_OK = 
			"Venta generada con éxito. Por favor, complete los datos de pago.";
	
	//USUARIO
	
	public static final String MSG_EMP_MOD_OK =
			"Los datos del empleado han sido modificados correctamente.";	

	public static final String MSG_EMP_MOD_BAD =
			"Ha ocurrido un error al intentar modificar el empleado. Por favor reintente.";	
	
	public static final String MSG_EMP_NOT_FOUND = 
			"El DNI ingresado no corresponde a un empleado registrado. Por favor, revise y vuelva a intentarlo.";
	
	public static final String MSG_USER_NOT_FOUND = 
			"El nombre de usuario ingresado no se encuentra registrado en el sistema. Por favor, revise y vuelva a intentarlo.";

	public static final String MSG_EMP_INS_OK =
			"El empleado ha sido agregado correctamente.";	
	
	public static final String MSG_EMP_INS_BAD =
			"Ha ocurrido un error al intentar registrar el empleado. Por favor reintente.";	
	
	public static final String MSG_USER_DEL_BAD =
			"Ha ocurrido un error al intentar eliminar el usuario. Por favor reintente.";	

	public static final String MSG_USER_DEL_OK =
			"El usuario se ha eliminado correctamente.";	
	
	public static final String MSG_EMP_DEL_BAD =
			"Ha ocurrido un error al intentar dar de baja al empleado y usuario asociado. Por favor reintente.";	
	
	public static final String MSG_EMP_DEL_OK =
			"El empleado ha sido dado de baja correctamente.";	
	
	public static final String MSG_BAD_ROW = 
			"No se ha registrado la selección de una unidad.";
			
	//VEHICULOS

	public static final String MSG_VEH_DUP = 
			"Ya existe una unidad ingresada con la misma patente y/o mismo motor.";
	
	public static final String MSG_VEH_INS_OK = 
			"La nueva unidad ha sido registrada exitosamente.";
	
	public static final String MSG_VEH_INS_BAD = 
			"No ha sido posible registrar la nueva unidad. Por favor verifique los datos ingresados y reintente.";
	
	
}
