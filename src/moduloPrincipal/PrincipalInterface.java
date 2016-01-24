package moduloPrincipal;

import moduloCobranzas.ventas.VentasInterface;

public interface PrincipalInterface {

	public void showPrincipal(PrincipalController principalController);

	public void closePrincipal();

	public void showVenta(VentasInterface sc);

	
}
