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
import objetos.Empleado;
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
			 "INSERT INTO Usuario VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_INSERT_EMP =
			"INSERT INTO Empleado VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_DELETE =
	        "DELETE FROM Usuario WHERE username = ?";
	
	private static final String SQL_DELETE_EMP =
			"DELETE FROM Empleado WHERE idEmpleado = ?";
	
	private static final String SQL_FIND_BY_ID =
	        "SELECT * FROM Usuario WHERE username=?";
	
	private static final String SQL_FIND_BY_DNI =
			"SELECT * FROM Usuario WHERE dniUsuario=?";
	
	private static final String SQL_FIND_EMP_BY_ID =
			"SELECT * FROM Empleado WHERE idEmpleado=?";
	
	private static final String SQL_UPDATE =
			 "UPDATE Usuario SET username=?, password=?, permisos=?, nombre=?, apellido=?, bloqueo=? WHERE dniusuario=?";
	
	private static final String SQL_UPDATE_EMP =
			"UPDATE Empleado SET nombre=?, apellido=?, idCargo=?, direccion=?, telefono=?, email=? WHERE idEmpleado=?";
	
	
	private static final int MYSQL_DUPLICATE_PK = -104;

	private ConnectionProvider connectionProvider;
	

	 
	  public UsuarioDB(ConnectionProvider connection) {
		    this.connectionProvider = connection;
		  }
	

	
	  public boolean update(Usuario user) throws DBException {

	        Object[] values = {
	        		user.getUsername(),
	        		user.getPassword(),
	        		user.getPermisos(),
	        		user.getNombre(),
	        		user.getApellido(),
	        		user.getBloqueo(),
	                user.getDniUsuario()
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
	  
	  public boolean updateEmpleado(Empleado e) throws DBException {
		  
		  Object[] values = {
				 e.getNombre(),
				 e.getApellido(),
				 e.getIdCargo(),
				 e.getDireccion(),
				 e.getTelefono(),
				 e.getEmail(),
				 e.getIdEmpleado()
		  };
		  
		  
		  try (
				  
				  Connection connection = this.connectionProvider.getConnection();
				  
				  PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_UPDATE_EMP, false, values);
				  ) {
			  
			  int affectedRows = statement.executeUpdate();
			  
			  if (affectedRows == 0) {
				  
				  throw new DBException("Updating user failed, no rows affected.");
			  } else{
				  return true;
			  }
			  
		  } catch (SQLException i) {
			  throw new DBException(i);
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
	
	public boolean deleteEmpleado(int dni) throws DBException {
		
		Object[] values = { 
				dni
		};
		
		try (
				Connection connection = this.connectionProvider.getConnection();
				
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_DELETE_EMP, false, values);
				) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DBException("Deleting empleado failed, no rows affected.");
				
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
    			
        		users.add(map(resultSet));
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
            user.getDniUsuario(),
            user.getPermisos(),
            user.getNombre(),
            user.getApellido(),
            user.getBloqueo()
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
	
	public Usuario findDNIu(int idUser) throws DBException {
		
		Usuario user = null;
		
		Object[] values = {
				idUser
		};
		
		try (
				Connection connection = this.connectionProvider.getConnection();
				PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_FIND_BY_DNI, false, values);
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
        Usuario user = new Usuario(resultSet.getString("username"),resultSet.getString("password"), resultSet.getInt("dniUsuario"), resultSet.getInt("permisos"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getBoolean("bloqueo"));
        
        return user;
    }



	public Empleado findIdEmpleado(int dni) throws DBException {

		Empleado empleado = null;
		
		Object[] values = {
                dni
            };

        try (
            Connection connection = this.connectionProvider.getConnection();
            PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_FIND_EMP_BY_ID, false, values);
            ResultSet resultSet = statement.executeQuery();
        		) {
        	if (resultSet.next()) {
        		empleado = mapE(resultSet);
        	}
    		
        } catch (SQLException e) {
            throw new DBException(e);
        } 

      
       
        return empleado;
	}



	private Empleado mapE(ResultSet rs) throws SQLException {
		Empleado e= new Empleado(rs.getInt("idEmpleado"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"),
				rs.getString("idCargo"), rs.getInt("telefono"), rs.getString("email"));
		
		return e;
	}



	public boolean inserE(Empleado e) throws DBException {
		
		Object[] values = {
	            e.getIdEmpleado(),
	            e.getNombre(),
	            e.getApellido(),
	            e.getDireccion(),
	            e.getIdCargo(),
	            e.getTelefono(),
	            e.getEmail()
	            
	            };
	           
	        

	        		
	        		System.out.println(this.connectionProvider);
					
	        		try (
						Connection connection = this.connectionProvider.getConnection();
						PreparedStatement statement = DBUtil.prepareStatement(connection, SQL_INSERT_EMP, false, values);
					) {
			        	 int affectedRows = statement.executeUpdate();
			             if (affectedRows == 0) {
			                 throw new DBException("Inserting emp failed, no rows affected.");
			               
			             } else {
			            	 return true;
			             }
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return false;
	        		
	         
	}




	
	
}
