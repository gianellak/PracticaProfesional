package objetos;

public class Venta {
	
	int idVenta;
	int dniComprador;
	String patente;
	int dniGarante;
	String desc;

	
	
	public Venta(int idVenta, int dniComprador, String patente, int dniGarante,
			String desc) {
		super();
		this.idVenta = idVenta;
		this.dniComprador = dniComprador;
		this.patente = patente;
		this.dniGarante = dniGarante;
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdVenta() {
		return idVenta;
	}
	
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	
	public int getDniComprador() {
		return dniComprador;
	}
	
	public void setDniComprador(int dniComprador) {
		this.dniComprador = dniComprador;
	}
	
	public int getDniGarante() {
		return dniGarante;
	}
	
	public void setDniGarante(int dniGarante) {
		this.dniGarante = dniGarante;
	}
	
	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}

	
}
