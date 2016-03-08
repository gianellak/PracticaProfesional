package moduloVehiculos.paneles;

import java.awt.Dimension;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import objetos.Stock;
import objetos.Usuario;

public class FormStock extends JPanel {

	private JTable tablaStock;
	private JScrollPane jp;

	public JTable getTablaStock() {
		return tablaStock;
	}

	public void setTablaStock(JTable tablaStock) {
		this.tablaStock = tablaStock;
	}


	public FormStock(List<Stock> listaStock) {
		
		
		this.setPreferredSize(new Dimension(1000, 300));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
	

		tablaStock = new JTable();
		
		DefaultTableModel modelo = new DefaultTableModel(){
		
		
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;
		    }
		
		};
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		tablaStock.setRowSorter(sorter);
		tablaStock.setModel(modelo);
		
		tablaStock.getTableHeader().setReorderingAllowed(false);
		
		tablaStock.setFocusable(false);
		
		
		String columnNames[] = { "Patente", "Marca", "Modelo", "Color", "A�o",
				"PVC", "Condici�n" };
		
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
		
		jp= new JScrollPane(tablaStock);
		

		jp.setBounds(0, 80, 1000, 300);
	}
	

	


	public JScrollPane getJp() {
		return jp;
	}


	public void setJp(JScrollPane jp) {
		this.jp = jp;
	}


	public String getRowSelected() {
		// TODO Auto-generated method stub
		return null;
	}


	


}