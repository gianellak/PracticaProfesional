package objetos;

public class Usuario {
	
	private String username;
	private String password;
	private int permisos;
	String nombre;
	String apellido;
	

	

	public Usuario(String username, String password, int permisos,
			String nombre, String apellido) {
		super();
		this.username = username;
		this.password = password;
		this.permisos = permisos;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermisos() {
		return permisos;
	}

	public void setPermisos(int permisos) {
		this.permisos = permisos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	
	

}
