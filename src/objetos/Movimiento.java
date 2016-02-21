package objetos;

import java.time.LocalDate;

public class Movimiento {
	
	int id;
	String descripcion;
	int monto;
	LocalDate fecha;
	String usuario;
	boolean marca;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public boolean isMarca() {
		return marca;
	}
	public void setMarca(boolean marca) {
		this.marca = marca;
	}
	


}
