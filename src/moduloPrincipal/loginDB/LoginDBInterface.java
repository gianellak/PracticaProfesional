package moduloPrincipal.loginDB;

import java.sql.SQLException;
import java.util.List;

import exceptions.DBException;
import exceptions.LoginException;
import objetos.Usuario;



public interface LoginDBInterface {
	

	public void insert(Usuario usuario) throws DBException;
    
    public void delete(Usuario usuario) throws DBException;
    
    public void update(Usuario usuario) throws DBException;
    
    public Usuario findId(String idUser) throws DBException;
    
    public List<Usuario> findAll() throws DBException;

	public Usuario login(String usernameInput, String passwordInput) throws LoginException;

	public void close() throws SQLException;
	
}
