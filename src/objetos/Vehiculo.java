package objetos;


public class Vehiculo {
	
	String patente;
	String marca;
	String modelo;
	String year;
	String color;
	Integer km;
	String motor;
	String dominio;
	Integer pvc;
	String fechaIngreso;
	String fechaVenta;
	String condicion;
	Integer idProveedor;
	Integer idCliente; //cuando vende o reserva 
	String comentarios;
	
	

	

	
	public Vehiculo(String patente, String marca, String modelo, String year,
			String color, Integer km, String motor, String dominio,
			Integer pvc, String fechaIngreso, String fechaVenta,
			String condicion, Integer idProveedor, Integer idCliente,
			String comentarios) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.year = year;
		this.color = color;
		this.km = km;
		this.motor = motor;
		this.dominio = dominio;
		this.pvc = pvc;
		this.fechaIngreso = fechaIngreso;
		this.fechaVenta = fechaVenta;
		this.condicion = condicion;
		this.idProveedor = idProveedor;
		this.idCliente = idCliente;
		this.comentarios = comentarios;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Integer getPvc() {
		return pvc;
	}

	public void setPvc(Integer pvc) {
		this.pvc = pvc;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
