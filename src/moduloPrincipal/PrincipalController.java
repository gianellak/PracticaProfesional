package moduloPrincipal;

import connections.ConnectionProvider;
import objetos.Usuario;

public class PrincipalController {

	private PrincipalInterface principal;
	private ConnectionProvider conn;
	private Usuario user;

	public PrincipalController(Usuario user, PrincipalInterface p,
			ConnectionProvider conn) {
		super();
		this.user = user;
		this.principal = p;
		this.conn = conn;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void showPrincipal() {

		principal.showPrincipal(this);

	}

	public void onCancel() {

		principal.closePrincipal();

	}

	public ConnectionProvider getConn() {
		return conn;
	}

}
