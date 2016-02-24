package moduloVehiculo.paneles;

import javax.swing.*;

public class FormVerDetalleVehiculo extends JPanel {

	private JButton btnVentas, btnVolver;
	
	
	public FormVerDetalleVehiculo() {
		this.setLayout(null);

		JLabel lblPatente = new JLabel("Patente: ");
		lblPatente.setBounds(100, 10, 160, 25);
		this.add(lblPatente);

		JLabel lblPatente2 = new JLabel(); // llenar con patente del vehiculo seleccionado en grilla 
		lblPatente2.setBounds(100, 30, 160, 25);
		this.add(lblPatente2);

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(100, 50, 160, 25);
		this.add(lblMarca);

		JLabel lblMarca2 = new JLabel(); 
		lblMarca2.setBounds(100, 70, 160, 25);
		this.add(lblMarca2);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(100, 90, 160, 25);
		this.add(lblModelo);

		JLabel lblModelo2 = new JLabel();
		lblModelo2.setBounds(100, 110, 160, 25);
		this.add(lblModelo2);

		JLabel lblYear = new JLabel("Año: ");
		lblYear.setBounds(100, 130, 160, 25);
		this.add(lblYear);

		JLabel lblYear2 = new JLabel();
		lblYear2.setBounds(100, 150, 260, 25);
		this.add(lblYear2);

		JLabel lblColor = new JLabel("Color: ");
		lblColor.setBounds(100, 170, 160, 25);
		this.add(lblColor);

		JLabel lblColor2 = new JLabel();
		lblColor.setBounds(100, 190, 260, 25);
		this.add(lblColor);

		JLabel lblKm = new JLabel("Km: ");
		lblKm.setBounds(100, 210, 160, 25);
		this.add(lblKm);

		JLabel lblKm2 = new JLabel();
		lblKm2.setBounds(100, 230, 260, 25);
		this.add(lblKm2);
		
		JLabel lblMotor = new JLabel("Motor: ");
		lblMotor.setBounds(100, 250, 160, 25);
		this.add(lblMotor);

		JLabel lblMotor2 = new JLabel();
		lblMotor2.setBounds(100, 270, 260, 25);
		this.add(lblMotor2);
		
		JLabel lblDominio = new JLabel("Dominio: ");
		lblDominio.setBounds(100, 290, 160, 25);
		this.add(lblDominio);

		JLabel lblDominio2 = new JLabel();
		lblDominio2.setBounds(100, 310, 260, 25);
		this.add(lblDominio2);
		
		JLabel lblPvc = new JLabel("PVC: ");
		lblPvc.setBounds(100, 330, 160, 25);
		this.add(lblPvc);

		JLabel lblPvc2 = new JLabel();
		lblPvc2.setBounds(100, 350, 260, 25);
		this.add(lblPvc2);
		
		JLabel lblfechaIngreso = new JLabel("Fecha de ingreso: ");
		lblfechaIngreso.setBounds(100, 370, 160, 25);
		this.add(lblfechaIngreso);

		JLabel lblfechaIngreso2 = new JLabel();
		lblfechaIngreso2.setBounds(100, 390, 260, 25);
		this.add(lblfechaIngreso2);
		
		JLabel lblFechaVenta = new JLabel("Fecha de venta: ");
		lblFechaVenta.setBounds(100, 410, 160, 25);
		this.add(lblFechaVenta);

		JLabel lblfechaVenta2 = new JLabel();
		lblfechaVenta2.setBounds(100, 430, 260, 25);
		this.add(lblfechaVenta2);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(100, 450, 160, 25);
		this.add(lblCondicion);

		JLabel lblCondicion2 = new JLabel();
		lblCondicion2.setBounds(100, 470, 260, 25);
		this.add(lblCondicion2);
		
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(100, 490, 160, 25);
		this.add(lblProveedor);

		JLabel lblProveedor2 = new JLabel();
		lblProveedor2.setBounds(100, 510, 260, 25);
		this.add(lblProveedor2);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(100, 530, 160, 25);
		this.add(lblCliente);

		JLabel lblCliente2 = new JLabel();
		lblCliente2.setBounds(100, 550, 260, 25);
		this.add(lblCliente2);
		
		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(100, 570, 160, 25);
		this.add(lblComentarios);

		JLabel lblComentarios2 = new JLabel();
		lblComentarios2.setBounds(100, 590, 260, 25);
		this.add(lblComentarios2);
		
		btnVentas = new JButton("Comprar");
		btnVentas.setBounds(500, 220, 100, 25);
		this.add(btnVentas);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(500, 250, 100, 25);
		this.add(btnVolver);

	}
	
}
