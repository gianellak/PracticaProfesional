package moduloPrincipal;

import javax.swing.JFrame;

import moduloCobranzas.ventas.VentasInterface;
import moduloPrincipal.paneles.PanelGeneral;

public interface PrincipalInterface {

	public void showPrincipal(PrincipalController principalController);

	public void closePrincipal();

	public JFrame getPView();

	PanelGeneral getGeneral();

	public void getBack();

	
}
