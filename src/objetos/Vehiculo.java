package objetos;

import java.util.Date;

public class Vehiculo {
	
	String patente;
	String marca;
	String modelo;
	Date fechaIngreso;
	Date fechaVenta;
	String comentarios;
	String rachel;
	
	
	
	public Vehiculo(String patente, String marca, String modelo,
			Date fechaIngreso, Date fechaVenta, String comentarios) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaIngreso = fechaIngreso;
		this.fechaVenta = fechaVenta;
		this.comentarios = comentarios;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
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
		public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	

}
