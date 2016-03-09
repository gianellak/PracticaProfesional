package objetos;

public class Persona {
	
	int dni;
	String telefonoP;
	String email;
	String telefonoL;
	String nombre;
	String apellido;
	String domicilio;
	String ciudad;
	String provincia;
	String domicilioL;
	String empresa;
	
	
	public Persona(int dni, String telefonoP, String email, String telefonoL,
			String nombre, String apellido, String domicilio, String ciudad,
			String provincia, String domicilioL, String empresa) {
		super();
		this.dni = dni;
		this.telefonoP = telefonoP;
		this.email = email;
		this.telefonoL = telefonoL;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.domicilioL = domicilioL;
		this.empresa = empresa;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getTelefonoP() {
		return telefonoP;
	}


	public void setTelefonoP(String telefonoP) {
		this.telefonoP = telefonoP;
	}


	public String getEmail() {
		return email;
	}


	public void setTelefonoC(String email) {
		this.email = email;
	}


	public String getTelefonoL() {
		return telefonoL;
	}


	public void setTelefonoL(String telefonoL) {
		this.telefonoL = telefonoL;
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


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDomicilioL() {
		return domicilioL;
	}


	public void setDomicilioL(String domicilioL) {
		this.domicilioL = domicilioL;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
}
