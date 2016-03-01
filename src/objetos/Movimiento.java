package objetos;


public class Movimiento {
	
	int id;
	String descripcion;
	Double ingreso;
	Double egreso;
	String fecha;
	String usuario;
	boolean marca;
	
	
	public Movimiento(int id, String descripcion, Double i, Double e,
			String fecha, String usuario, boolean marca) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.ingreso = i;
		this.egreso = e;
		this.fecha = fecha;
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


	public Double getIngreso() {
		return ingreso;
	}


	public void setIngreso(Double ingreso) {
		this.ingreso = ingreso;
	}


	public Double getEgreso() {
		return egreso;
	}


	public void setEgreso(Double egreso) {
		this.egreso = egreso;
	}
	
}
