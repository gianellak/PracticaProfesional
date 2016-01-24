package objetos;

public class Persona {
	
	int dni;
	int telefonoP;
	int telefonoC;
	int telefonoL;
	String nombre;
	String apellido;
	String domicilio;
	String ciudad;
	String provincia;
	String domicilioL;
	String empresa;
	
	
	public Persona(int dni, int telefonoP, int telefonoC, int telefonoL,
			String nombre, String apellido, String domicilio, String ciudad,
			String provincia, String domicilioL, String empresa) {
		super();
		this.dni = dni;
		this.telefonoP = telefonoP;
		this.telefonoC = telefonoC;
		this.telefonoL = telefonoL;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.domicilioL = domicilioL;
		this.empresa = empresa;
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
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
	public int getTelefonoP() {
		return telefonoP;
	}
	public void setTelefonoP(int telefonoP) {
		this.telefonoP = telefonoP;
	}
	public int getTelefonoC() {
		return telefonoC;
	}
	public void setTelefonoC(int telefonoC) {
		this.telefonoC = telefonoC;
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
	public int getTelefonoL() {
		return telefonoL;
	}
	public void setTelefonoL(int telefonoL) {
		this.telefonoL = telefonoL;
	}
	
	
	
	
	
	
	

}
