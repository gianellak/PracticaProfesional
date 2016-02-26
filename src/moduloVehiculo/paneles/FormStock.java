package moduloVehiculo.paneles;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import moduloVehiculo.vehiculoController;
import objetos.Stock;
import objetos.Usuario;

public class FormStock extends JPanel {

	private JTable tablaStock;
	private JButton btnCancelar, btnVerDetalle;
	private List<Stock> listaStock;
	private JScrollPane jp;

	public FormStock(List<Stock> listaStock) {
		
		this.listaStock = listaStock;

		this.setLayout(null);

		tablaStock = new JTable();
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		tablaStock.setModel(modelo);
		
		tablaStock.getTableHeader().setReorderingAllowed(false);
		
		jp= new JScrollPane(tablaStock);
		
		

		String columnNames[] = { "Patente", "Marca", "Modelo", "Color", "Año",
				"PVC", "Condición" };
		
		modelo.setColumnIdentifiers(columnNames);
		

		for (Stock v : listaStock) {
			
			Object[] o = new Object[7];
			o[0] = v.getPatente();
			o[1] = v.getMarca();
			o[2] = v.getModelo();
			o[3] = v.getColor();
			o[4] = v.getYear();
			o[5] = v.getPvc();
			o[6] = v.getCondicion();
			
			modelo.addRow(o);
		}
		
		jp.setBounds(150, 50, 600, 200);

	}


	public JScrollPane getJp() {
		return jp;
	}


	public void setJp(JScrollPane jp) {
		this.jp = jp;
	}


	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnVerDetalle() {
		return btnVerDetalle;
	}

	public void setBtnVerDetalle(JButton btnVerDetalle) {
		this.btnVerDetalle = btnVerDetalle;
	}

}
