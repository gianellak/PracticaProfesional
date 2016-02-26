package moduloVenta.listener;

import javax.swing.JComponent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class RequestFocusListener implements AncestorListener {

	public RequestFocusListener(boolean b) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ancestorAdded(AncestorEvent event) {
	      
		JComponent component = event.getComponent();
	 
	     component.removeAncestorListener( this );
	
	}

	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ancestorMoved(AncestorEvent event) {
		// TODO Auto-generated method stub

	}

}
