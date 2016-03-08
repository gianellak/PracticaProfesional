package objetos;

public class Cuota {
	
	 int cuota;
	 String vencimiento;
	 Double valor;
	 Double adelanto;
	 
	public Cuota(int cuota, String vencimiento, Double valor, Double adelanto) {
		super();
		this.cuota = cuota;
		this.vencimiento = vencimiento;
		this.valor = valor;
		this.adelanto = adelanto;
	}
	
	
	public int getCuota() {
		return cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getAdelanto() {
		return adelanto;
	}
	public void setAdelanto(Double adelanto) {
		this.adelanto = adelanto;
	}

}
