package moduloUsuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DBException;
import objetos.Usuario;
import objetos.Venta;
import utilitarios.DBUtil;
import moduloPrincipal.PrincipalController;

public class UsuarioDB implements UsuarioInterface {

	private static final String SQL_USERS =
	        "SELECT * FROM Usuario";
	
	private PrincipalController pc;
	
	
	public UsuarioDB(PrincipalController pc) {
		this.pc = pc;
	}

	public void showMenuUsuario(UsuarioController usuarioController) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public List<Usuario> findAll() throws DBException {
		
		List<Usuario> users = new ArrayList<>();

        try (
            Connection connection = pc.getConn().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_USERS);
            ResultSet resultSet = statement.executeQuery();
        ) {
        	while (resultSet.next()){
    			
        		String name = resultSet.getString(1);
        		String pass = resultSet.getString(2);
        		int permisos = resultSet.getInt(3);
        		String nombre = resultSet.getString(4);
        		String apellido = resultSet.getString(5);
        		
        		System.out.println(name);
        		Usuario unUsuario = new Usuario(name, pass, permisos, nombre, apellido);
        		
        		users.add(unUsuario);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }

        return users;
		}

	

	


}
