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

	public FormStock() {

		this.setLayout(null);

		tablaStock = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		tablaStock.setModel(modelo);
		

		String columnNames[] = { "Patente", "Marca", "Modelo", "Color", "Año",
				"PVC", "Condición" };

		for (int fila = 0; fila < listaStock.size(); fila++) {
				
				tablaStock.setValueAt(listaStock.get(fila).getPatente(), fila, 0);
				tablaStock.setValueAt(listaStock.get(fila).getMarca(), fila, 1);
				tablaStock.setValueAt(listaStock.get(fila).getModelo(), fila, 2);
				tablaStock.setValueAt(listaStock.get(fila).getColor(), fila, 3);
				tablaStock.setValueAt(listaStock.get(fila).getYear(), fila, 4);
				tablaStock.setValueAt(listaStock.get(fila).getPvc(), fila, 5);
				tablaStock.setValueAt(listaStock.get(fila).getCondicion(), fila, 6);
		}

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
