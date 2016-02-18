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

public class LoginDB implements LoginInterface {

	private static final String SQL_DELETE =
	        "DELETE FROM Usuario WHERE username = ?";
	private static final String SQL_INSERT =
			 "INSERT INTO Usuario (username, password, permisos, nombre, apellido) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE =
			 "UPDATE Usuario SET password=?, nombre=?, apellido=? WHERE username=?";

	
	private static final String SQL_FIND_BY_ID =
	        "SELECT * FROM Usuario WHERE username=?";
	
	 private static final String SQL_LIST =
		        "SELECT * FROM Usuario ";
	 
	private static final int MYSQL_DUPLICATE_PK = -104;
			  
	
	private ConnectionProvider connectionProvider;
	

	 
	  public LoginDB(ConnectionProvider connection) {
	    this.connectionProvider = connection;
	  }


	
	public void insert(Usuario user) throws IllegalArgumentException, DBException {
		
        

        Object[] values = {
            user.getUsername(),
            user.getPassword(),
            user.getPermisos(),
            user.getNombre(),
            user.getApellido(),
           
        };

        try (
            Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_INSERT, true, values);
        ) 
            
        	{
	        	 statement.executeUpdate();
	       } catch (SQLException e) {
	    	   if(e.getErrorCode() == MYSQL_DUPLICATE_PK){
	    		   throw new DBException("Duplicated Key, cannot insert user");
	    	    }else{
            throw new DBException(e);}
        }
    }

	public void delete(Usuario usuario) throws DBException {
		
		Object[] values = { 
	            usuario.getUsername()
	            };

	        try (
	            Connection connection = this.connectionProvider.getConnection();
	        		
	            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_DELETE, false, values);
	        ) {
	        	 int affectedRows = statement.executeUpdate();
	             if (affectedRows == 0) {
	                 throw new DBException("Deleting user failed, no rows affected.");
	               
	             }

	        } catch (SQLException e) {
	            throw new DBException(e);
	        }
	    

	}


	
	public void update(Usuario user) throws DBException {

        Object[] values = {
        		user.getPassword(),
        		user.getNombre(),
        		user.getApellido(),
                user.getUsername(),
                user.getPermisos()
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
        		
        		
        		Usuario unUsuario = new Usuario(name, pass, permisos, nombre, apellido);
        		
        		users.add(unUsuario);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }

        return users;
		}
		
	
	private static Usuario map(ResultSet resultSet) throws SQLException {
        Usuario user = new Usuario(resultSet.getString("username"),resultSet.getString("password"), resultSet.getInt("permisos"), resultSet.getString("nombre"), resultSet.getString("apellido"));
        
        return user;
    }



	@Override
	public Usuario login(String usernameInput, String passwordInput) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void close() throws SQLException {
		connectionProvider.close();
	}



	@Override
	public void showLogin(LoginController loginController) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void closeLogin() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String getPasswordInput() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getUsernameInput() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean loginSuccessful(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void loginFailed() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void viewLogin(LoginController loginController) {
		// TODO Auto-generated method stub
		
	}




		

}
