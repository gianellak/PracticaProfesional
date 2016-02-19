package moduloUsuarios;

import java.util.List;

import javax.swing.JFrame;

import exceptions.DBException;
import objetos.Usuario;

public interface UsuarioInterface {

	public void dispose();

	public List<Usuario> findAll() throws DBException;

	public void showMenuUsuario(UsuarioController uc, JFrame frame, Usuario u);

	public void onAlta();

}
