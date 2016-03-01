package objetos;

public class Venta {
	
	int idVenta;
	String fecha;
	int idCliente;
	int idGarante;
	int idVendedor;
	
	public Venta(int idVenta, String fecha, int idCliente, int idGarante,
			int idVendedor) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idGarante = idGarante;
		this.idVendedor = idVendedor;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdGarante() {
		return idGarante;
	}
	public void setIdGarante(int idGarante) {
		this.idGarante = idGarante;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	
	
}
