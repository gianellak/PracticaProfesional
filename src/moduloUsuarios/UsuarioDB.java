package moduloUsuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import connections.ConnectionProvider;
import exceptions.DBException;
import objetos.Usuario;
import objetos.Venta;
import utilitarios.DBUtil;
import moduloPrincipal.PrincipalController;
import moduloPrincipal.PrincipalView;
import moduloPrincipal.paneles.PanelAux;

public class UsuarioDB  {

	private static final String SQL_USERS =
	        "SELECT * FROM Usuario";
	
	private static final String SQL_INSERT =
			 "INSERT INTO Usuario VALUES (?, ?, ?, ?, ?)";
	
	private static final String SQL_DELETE =
	        "DELETE FROM Usuario WHERE username = ?";
	
	private static final String SQL_FIND_BY_ID =
	        "SELECT * FROM Usuario WHERE username=?";
	
	private static final String SQL_UPDATE =
			 "UPDATE Usuario SET password=?, permisos=?, nombre=?, apellido=?, email=?, bloqueo=? WHERE username=?";
	
	
	private static final int MYSQL_DUPLICATE_PK = -104;

	private ConnectionProvider connectionProvider;
	

	 
	  public UsuarioDB(ConnectionProvider connection) {
		    this.connectionProvider = connection;
		  }
	

	
	  public boolean update(Usuario user) throws DBException {

	        Object[] values = {
	        		user.getPassword(),
	        		user.getPermisos(),
	        		user.getNombre(),
	        		user.getApellido(),
	        		user.getEmail(),
	        		user.isBloqueo(),
	                user.getUsername(),
	            };
	    
		
	        try (
	        		
	            Connection connection = this.connectionProvider.getConnection();
	        		
	            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE, false, values);
	        ) {
	           
	        	int affectedRows = statement.executeUpdate();
	        	
	            if (affectedRows == 0) {
	            	
	                throw new DBException("Updating user failed, no rows affected.");
	            } else{
	            	return true;
	            }
	           
	           
	        } catch (SQLException e) {
	            throw new DBException(e);
	        }
	    }
	  
	  
	public boolean delete(String u) throws DBException {
		
		Object[] values = { 
	            u
	            };

	        try (
	        	Connection connection = this.connectionProvider.getConnection();
	            		
	            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_DELETE, false, values);
	        ) {
	        	 int affectedRows = statement.executeUpdate();
	             if (affectedRows == 0) {
	                 throw new DBException("Deleting user failed, no rows affected.");
	               
	             }else{
	            	 return true;
	             }

	        } catch (SQLException e) {
	            throw new DBException(e);
	        }
	

	}


	public List<Usuario> findAll() throws DBException {
		
		List<Usuario> users = new ArrayList<>();

        try (
        	Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_USERS);
            ResultSet resultSet = statement.executeQuery();
        ) {
        	while (resultSet.next()){
    			
        		String name = resultSet.getString(1);
        		String pass = resultSet.getString(2);
        		int permisos = resultSet.getInt(3);
        		String nombre = resultSet.getString(4);
        		String apellido = resultSet.getString(5);
        		String email = resultSet.getString(6);
        		Boolean bloqueo = resultSet.getBoolean(7);
        		
        		System.out.println(name);
        		Usuario unUsuario = new Usuario(name, pass, permisos, nombre, apellido, email, bloqueo);
        		
        		users.add(unUsuario);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }

        return users;
	}



	
	public boolean insert(Usuario user) throws DBException {
		
        

        Object[] values = {
            user.getUsername(),
            user.getPassword(),
            user.getPermisos(),
            user.getNombre(),
            user.getApellido(),
            user.getEmail(),
            user.isBloqueo()
            };
           
        

        		
        		System.out.println(this.connectionProvider);
				
        		try (
					Connection connection = this.connectionProvider.getConnection();
					PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_INSERT, false, values);
				) {
		        	 int affectedRows = statement.executeUpdate();
		             if (affectedRows == 0) {
		                 throw new DBException("Inserting user failed, no rows affected.");
		               
		             } else {
		            	 return true;
		             }
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
        		
         
        	
    
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
	
	private static Usuario map(ResultSet resultSet) throws SQLException {
        Usuario user = new Usuario(resultSet.getString("username"),resultSet.getString("password"), resultSet.getInt("permisos"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getString("email"), resultSet.getBoolean("bloqueo"));
        
        return user;
    }
	
	
}
