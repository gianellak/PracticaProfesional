package moduloLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connections.ConnectionProvider;
import exceptions.DBException;
import objetos.Usuario;
import utilitarios.DBUtil;

public class LoginDB  {

	private static final String SQL_UPDATE =
			 "UPDATE Usuario SET password=?, nombre=?, apellido=?, permisos=?, email=?, bloqueo =? WHERE username=?";

	
	private static final String SQL_FIND_BY_ID =
	        "SELECT * FROM Usuario WHERE username=?";
	
	 private static final String SQL_LIST =
		        "SELECT * FROM Usuario ";
	 
	private static final int MYSQL_DUPLICATE_PK = -104;
			  
	
	private ConnectionProvider connectionProvider;
	

	 
	  public LoginDB(ConnectionProvider connection) {
	    this.connectionProvider = connection;
	  }
	
	public void update(Usuario user) throws DBException {

        Object[] values = {
        		user.getPassword(),
        		user.getNombre(),
        		user.getApellido(),
        		user.getPermisos(),
        		user.isBloqueo(),
                user.getEmail(),
                user.getUsername(),
            };
    
	
        try (
        		
            Connection connection = this.connectionProvider.getConnection();
        		
            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE, false, values);
        ) {
           
        	int affectedRows = statement.executeUpdate();
        	
            if (affectedRows == 0) {
            	
                throw new DBException("Updating user failed, no rows affected.");
            }
           
           
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

	public Usuario findId(String idUser) throws DBException {
		
		Usuario user = null;
		
		Object[] values = {
                idUser
            };

        try (
            Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_FIND_BY_ID, false, values);
            ResultSet resultSet = statement.executeQuery();
        		) {
        	if (resultSet.next()) {
        		user = map(resultSet);
        	}
    		
        } catch (SQLException e) {
            throw new DBException(e);
        } 

      
       
        return user;
	}

	public List<Usuario> findAll() throws DBException {
		
		List<Usuario> users = new ArrayList<>();

        try (
            Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_LIST);
            ResultSet resultSet = statement.executeQuery();
        ) {
        	while (resultSet.next()){
    			
        		String name = resultSet.getString(1);
        		String pass = resultSet.getString(2);
        		int permisos = resultSet.getInt(5);
        		String nombre = resultSet.getString(3);
        		String apellido = resultSet.getString(4);
        		String email = resultSet.getString(6);
        		Boolean bloqueo = resultSet.getBoolean(7);
        		
        		Usuario unUsuario = new Usuario(name, pass, permisos, nombre, apellido, email, bloqueo);
        		
        		users.add(unUsuario);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }

        return users;
		}
		
	
	private static Usuario map(ResultSet resultSet) throws SQLException {
        Usuario user = new Usuario(resultSet.getString("username"),resultSet.getString("password"), resultSet.getInt("permisos"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("email"), resultSet.getBoolean("bloqueo"));
        
        return user;
    }



}
