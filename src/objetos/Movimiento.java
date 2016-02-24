package objetos;

import java.time.LocalDate;

public class Movimiento {
	
	int id;
	String descripcion;
	int monto;
	String fecha;
	String usuario;
	boolean marca;
	
	
	public Movimiento(int id, String descripcion, int monto, String string,
			String usuario, boolean marca) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.monto = monto;
		this.fecha = string;
		this.usuario = usuario;
		this.marca = marca;
	}
	
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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
