package objetos;

public class DetalleVenta {
	
	int idVenta;
	String idVehiculo;
	Double precio;
	int cuotas;
	Double deuda;
	Double adelanto;
	Double comision;
	Double descuento;
	String detalle;
	
	
	
	public DetalleVenta(int idVenta, String idVehiculo, Double precio,
			int cuotas, Double deuda, Double adelanto, Double comision, Double descuento,
			String detalle) {
		super();
		this.idVenta = idVenta;
		this.idVehiculo = idVehiculo;
		this.precio = precio;
		this.cuotas = cuotas;
		this.deuda = deuda;
		this.adelanto = adelanto;
		this.comision = comision;
		this.descuento =descuento;
		this.detalle = detalle;
	}
	
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public String getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public Double getDeuda() {
		return deuda;
	}
	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}
	public Double getAdelanto() {
		return adelanto;
	}
	public void setAdelanto(Double adelanto) {
		this.adelanto = adelanto;
	}
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Double getDescuento() {
		return descuento;
	}


	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	

}
