package moduloUsuarios;

import java.awt.BorderLayout;

import utilitarios.PantallaUtil;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objetos.Empleado;
import objetos.Usuario;
import moduloUsuarios.UsuarioController;
import moduloUsuarios.UsuarioInterface;
import moduloUsuarios.listener.*;
import moduloUsuarios.paneles.PanelUsuario;
import moduloUsuarios.paneles.UsuarioMenu;
import moduloPrincipal.paneles.PanelGeneral;

public class UsuarioView implements UsuarioInterface {
	
	private JFrame frame;
	private PanelUsuario panelUsuario;
	private ListenerUsuarioVolver listenerVolver;
	private ListenerUsuarioVer listenerVer;
	private UsuarioMenu panelUsuarioMenu;
	private ListenerUsuarioAlta listenerAlta;
	private ListenerBuscarUnUsuario listenerBuscarUnUsuario;
	private ListenerMenuUsuarioVolver listenerAltaVolver;
	private UsuarioController userController;
	private ListenerUsuarioBaja listenerBaja;
	private ListenerModAceptar listenerModAceptar;
	private ListenerMenuUsuarioVolver listenerModVolver;
	private ListenerMenuUsuarioVolver listenerVerVolver;
	private ListenerUsuarioMod listenerMod;
	private ListenerBuscarUsuario listenerBuscar;
	private ListenerAltaAceptar listenerAltaAceptar;
	private ListenerEmpleadoMod listenerModE;
	private ListenerEmpleadoBaja listenerBajaE;
	private ListenerValidarE listenerValidarE;
	private ListenerModAceptarE listenerModAceptarE;
	private ListenerAltaAceptarE listenerAltaAceptarE;
	private ListenerEmpleadoAlta listenerAltaE;
	private ListenerResetearUsuario listenerReset;

	public UsuarioView(){
	
		panelUsuarioMenu= new UsuarioMenu();
		panelUsuario = new PanelUsuario();
	
	}
	
	//Muestrala lista de todos los usuarios. Viene desde el controller con la lista cargada, y pasa la lista al panelUsuario,
	//donde lo carga en la tabla. 

	@Override
	public void mostrarListaUsuario(List<Usuario> lista) {
		
		panelUsuario.mostrarListaUsuario(lista);
		
	}

	@Override
	public void showMenuUsuario(UsuarioController uc,
			JFrame f, Usuario u) {
		userController = uc;
		frame = f;
		PanelGeneral panelGeneral = new PanelGeneral(u);
		
		listenerVolver = new ListenerUsuarioVolver(uc);
		listenerVer = new ListenerUsuarioVer(uc);
		listenerAlta = new ListenerUsuarioAlta(uc);
		listenerBuscar = new ListenerBuscarUsuario(uc);
		listenerAltaE = new ListenerEmpleadoAlta(uc);
		
		
		
		panelUsuarioMenu.getBtnVolver().addActionListener(listenerVolver);
		panelUsuarioMenu.getBtnAltaU().addActionListener(listenerAlta);
		panelUsuarioMenu.getBtnListaU().addActionListener(listenerVer);
		panelUsuarioMenu.getBtnVerU().addActionListener(listenerBuscar);
		panelUsuarioMenu.getBtnAltaE().addActionListener(listenerAltaE);
		
		
		//frame.setVisible(false);
		frame.setTitle("Menu Usuarios");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelGeneral, BorderLayout.PAGE_START);
		frame.getContentPane().add(panelUsuarioMenu, BorderLayout.WEST);
		frame.getContentPane().add(panelUsuario, BorderLayout.LINE_END);
		
		PantallaUtil.refresh(frame);
		
	}

//*************************
//	MENU PRINCIPAL Listener -> Controller -> Interface:
//	showAlta - onAlta
//	showUsuarios - onVerLista
//	showUnUsuario - onBuscarUsuario

	@Override
	public void onAlta() {
		
		PantallaUtil.remove(panelUsuario);
		
		panelUsuario.onAlta();
		
		listenerAltaAceptar = new ListenerAltaAceptar(userController);
		listenerAltaVolver = new ListenerMenuUsuarioVolver(userController);
		listenerValidarE = new ListenerValidarE(userController);
		
		panelUsuario.getBtnValidarE().addActionListener(listenerValidarE);
		
		panelUsuario.getBtnAceptar().addActionListener(listenerAltaAceptar);
		panelUsuario.getBtnVolver().addActionListener(listenerAltaVolver);
		
		
		PantallaUtil.refresh(frame);
		
	
		
	}

	@Override
	public void onVerLista(List<Usuario> lista) {
		
		PantallaUtil.remove(panelUsuario);
		
		panelUsuario.onVer(lista);
		
		
		listenerVerVolver = new ListenerMenuUsuarioVolver(userController);
		panelUsuario.getBtnVolver().addActionListener(listenerVerVolver);
		
		
		PantallaUtil.refresh(frame);
			
	}
	
	@Override
	public void onBuscarUsuario() {

		PantallaUtil.remove(panelUsuario);
		
		panelUsuario.onBuscar();
		
		listenerBuscarUnUsuario = new ListenerBuscarUnUsuario(userController);
		listenerAltaVolver = new ListenerMenuUsuarioVolver(userController);
		
		panelUsuario.getBtnBuscar().addActionListener(listenerBuscarUnUsuario);
		panelUsuario.getBtnVolver().addActionListener(listenerAltaVolver);
		
		
		PantallaUtil.refresh(frame);
		
	}
	
//*******************************
//	OPCION ALTA - altaUsuario()
// 	insertOk()
//	insertBad()
	
	@Override
	public Usuario getNuevoUsuario(){
		
		String s = new String(panelUsuario.getPasswordText().getPassword());
		
		int permisos;
		int dni;
		try {
			permisos = Integer.parseInt(panelUsuario.getPermisosText().getText());
			dni = Integer.parseInt(panelUsuario.getDniText().getText());
		    }
		    catch (NumberFormatException e) {
		       permisos = 99;
		       dni = 0;
		    }
		Usuario u = new Usuario(panelUsuario.getUserText().getText(), s, dni,
				permisos, 
				panelUsuario.getNombreText().getText(),
				panelUsuario.getApellidoText().getText(), false);
		
		return u;
		
	}
	
	@Override
	public void insertOk() {
		
		JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
		
		PantallaUtil.remove(panelUsuario);
		
	}

	@Override
	public void insertBad() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar el usuario. Por favor reintente");
	}
	
//**********************
// OPCION VOLVER - cleanUsuario

	@Override
	public void cleanPanelUsuario() {
		PantallaUtil.remove(panelUsuario);
		
	}
	
//*************************
// OPCION VER USUARIO - showUnUsuario() [ListenerBuscarUnUsuario]
//	VER USUARIO
//	NOT FOUND
	
	@Override
	public void verUsuario(Usuario u) {
		
		
		
		panelUsuario.verUnUsuario(u);
		
		listenerAltaVolver = new ListenerMenuUsuarioVolver(userController);
		listenerMod = new ListenerUsuarioMod(userController);
		listenerBaja = new ListenerUsuarioBaja(userController);
		listenerReset = new ListenerResetearUsuario(userController);
		
		panelUsuario.getBtnModificar().addActionListener(listenerMod);
		panelUsuario.getBtnResetear().addActionListener(listenerReset);
		panelUsuario.getBtnEliminar().addActionListener(listenerBaja);
		panelUsuario.getBtnVolver().addActionListener(listenerAltaVolver);
		
		PantallaUtil.refresh(frame);
		
		
	}
	
	@Override
	public void showNotFound() {
		
		JOptionPane.showMessageDialog(null, "Usuario no encontrado. Por favor reintente");

	}
	
	public void showMensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	
//*************
//	OPCION BUSCAR USUARIO MENU
//	BAJA
	
	@Override
	public void onBaja() {
		
		PantallaUtil.remove(panelUsuario);
		
		panelUsuario.onBaja();
		
		PantallaUtil.refresh(frame);
				
	}
	

	@Override
	public String getBajaUsuario() {

		return panelUsuario.getUserText().getText();
		
	}
	
	@Override
	public int showToDelete(Usuario user) {
		
		String s = new String("�Esta seguro que desea eliminar el usuario: " + user.getUsername() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
				
	}
	
	
	public int showToDeleteBoth(Usuario user) {
		
		String s = new String("Para eliminar el empleado debe eliminar el usuario asociado �Esta seguro que desea eliminar el usuario: " + user.getUsername() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
				
	}



//	MODIFICAR 
	@Override
	public void onMod() {
		
		
		panelUsuario.onMod();
		
		listenerModAceptar = new ListenerModAceptar(userController);
		listenerModVolver = new ListenerMenuUsuarioVolver(userController);
		
		panelUsuario.getBtnAceptarMod().addActionListener(listenerModAceptar);
		panelUsuario.getBtnVolver().addActionListener(listenerModVolver);
		
		
		
	}

		@Override
	public String getUsuarioABuscar(){
			
		return panelUsuario.getUserText().getText();
		
	}



	@Override
	public int showToUpdate(Usuario user) {
		String s = new String("�Esta seguro que desea modificar los datos del usuario: " + user.getUsername() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Modificar usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
	}

	@Override
	public int showToReset(Usuario user) {
		String s = new String("�Esta seguro que desea resetear el bloqueo del usuario: " + user.getUsername() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Resetear usuario", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
	}




	@Override
	public Usuario getModUsuario() {
		return panelUsuario.getModUsuario();
	}


	public String getResetUsuario(){
		return panelUsuario.getResetUsuario();
	}

	@Override
	public void updateOk() {

		JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
		
		PantallaUtil.remove(panelUsuario);
		
	}




	@Override
	public void updateBad() {
		
		JOptionPane.showMessageDialog(null, "Error al borrar usuario. Revise los datos ingresados");
		
	}

	@Override
	public int getEmpleadoABuscar() {
		try {
			return Integer.parseInt(panelUsuario.getEmpText().getText());
		    }
		    catch (NumberFormatException e) {
		        return 0;
		    }
		
	}

	@Override
	public void verEmpleado(Empleado e) {
		
		
		
		panelUsuario.verUnEmpleado(e);
		
		listenerModE = new ListenerEmpleadoMod(userController);
		listenerBajaE = new ListenerEmpleadoBaja(userController);
		
		
		panelUsuario.getBtnModificarE().addActionListener(listenerModE);
		panelUsuario.getBtnEliminarE().addActionListener(listenerBajaE);

		
		PantallaUtil.refresh(frame);
		
		
	}

	@Override
	public void msjNoIngresoBusqueda() {
		JOptionPane.showMessageDialog(null, "No se ha detectado un valor valido. Por favor, revise los datos ingresados");
		
	}

	@Override
	public void onModE() {
		
		panelUsuario.onModE();
		
		listenerModAceptarE = new ListenerModAceptarE(userController);
		
		panelUsuario.getBtnAceptarModE().addActionListener(listenerModAceptarE);
		
		
	}

	@Override
	public int getBajaEmpleado() {
		return Integer.parseInt(panelUsuario.getDniEText().getText());
	}

	@Override
	public int showToDelete(Empleado e) {
		String s = new String("�Esta seguro que desea eliminar el Empleado:  " + e.getApellido() + " " + e.getNombre() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Eliminar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
	}

	@Override
	public int getEmpNuevoUsuario() {
		return Integer.parseInt(panelUsuario.getDniText().getText());
	}

	@Override
	public void lockDni(String nombre, String apellido) {
		panelUsuario.getDniText().setEditable(false);
		panelUsuario.getBtnValidarE().setEnabled(false);
		panelUsuario.getApellidoText().setText(apellido);
		panelUsuario.getNombreText().setText(nombre);
		panelUsuario.getNombreText().setEditable(false);
		panelUsuario.getApellidoText().setEditable(false);


		
	}

	@Override
	public Empleado getModEmpleado() {
		return panelUsuario.getModEmpleado();
	}

	@Override
	public int showToUpdateE(Empleado e) {
		String s = new String("�Esta seguro que desea modificar los datos del Empleado: " + e.getApellido() + " " + e.getNombre() + "?");
		int codigo=JOptionPane.showConfirmDialog(null, s , "Modificar empleado", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
		return codigo;
	}

	@Override
	public void onAltaE() {

		PantallaUtil.remove(panelUsuario);
		
		panelUsuario.onAltaE();
		
		listenerAltaAceptarE = new ListenerAltaAceptarE(userController);
		listenerAltaVolver = new ListenerMenuUsuarioVolver(userController);
		
		
		panelUsuario.getBtnAceptarE().addActionListener(listenerAltaAceptarE);
		panelUsuario.getBtnVolver().addActionListener(listenerAltaVolver);
		
		
		PantallaUtil.refresh(frame);
		
	}
	
	
	@Override
	public void insertOkE() {
		
		JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");
		
		PantallaUtil.remove(panelUsuario);
		
	}

	@Override
	public void insertBadE() {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar el empleado. Por favor reintente");
	}

	@Override
	public void empleadoSinUsuario() {
		panelUsuario.empleadoSinUsuario();
		
	}


}
