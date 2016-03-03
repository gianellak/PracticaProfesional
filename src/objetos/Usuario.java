package objetos;

public class Usuario {
	
	private String username;
	private String password;
	int dniUsuario;
	private int permisos;
	String nombre;
	String apellido;
	Boolean bloqueo;
	
	public Usuario(String username, String password, int dniUsuario,
			int permisos, String nombre, String apellido, Boolean bloqueo) {
		super();
		this.username = username;
		this.password = password;
		this.dniUsuario = dniUsuario;
		this.permisos = permisos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.bloqueo = bloqueo;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(int dniUsuario) {
		this.dniUsuario = dniUsuario;
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
	public Boolean getBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(Boolean bloqueo) {
		this.bloqueo = bloqueo;
	}


}
