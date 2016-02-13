package objetos;

import java.util.Date;

public class Vehiculo {
	
	String patente;
	String marca;
	String modelo;
	Integer year;
	String color;
	Integer km;
	String motor;
	String dominio;
	Integer pvc;
	Date fechaIngreso;
	Date fechaVenta;
	Integer idCondicion;
	Integer idProveedor;
	Integer idCliente; //cuando vende o reserva 
	String comentarios;
	
	public Vehiculo(String patente, String marca, String modelo, Integer year,
			String color, Integer km, String motor, String dominio,
			Integer pvc, Date fechaIngreso, Date fechaVenta,
			Integer idCondicion, Integer idProveedor, Integer idCliente,
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
		this.idCondicion = idCondicion;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Integer getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(Integer idCondicion) {
		this.idCondicion = idCondicion;
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
