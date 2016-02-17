package moduloUsuarios;

import java.util.List;

import exceptions.DBException;
import objetos.Usuario;
import moduloPrincipal.PrincipalController;

public interface UsuarioInterface {

	void showMenuUsuario(UsuarioController usuarioController);

	void dispose();

	List<Usuario> findAll() throws DBException;

}
