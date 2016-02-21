package moduloVehiculo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import objetos.Stock;


@SuppressWarnings("serial")
public class StockTableModel extends AbstractTableModel {

	private static final int colPatente = 0;
	private static final int colMarca = 1;
	private static final int colModelo = 2;
	private static final int colColor = 3;
	private static final int colYear = 4;
	private static final int colPvc = 5;
	private static final int colCondicion = 6;

	private String[] columnNames = { "Patente", "Marca", "Modelo", "Color", "Year", "Pvc", "Condicion" };
	private List<Stock> stockActual;


	public StockTableModel(List<Stock> stockActual) {
		super();
		this.stockActual = stockActual;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return stockActual.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (stockActual.isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Stock unVehiculo = stockActual.get(rowIndex);
		Object returnValue = null;

		switch (columnIndex) {
		case colPatente:
			returnValue = unVehiculo.getPatente();
			break;
		case colMarca:
			returnValue = unVehiculo.getMarca();
			break;
		case colModelo:
			returnValue = unVehiculo.getModelo();
			break;
		case colColor:
			returnValue = unVehiculo.getColor();
			break;
		case colYear:
			returnValue = unVehiculo.getYear();
			break;
		case colPvc:
			returnValue = unVehiculo.getPvc();
			break;
		case colCondicion:
			returnValue = unVehiculo.getCondicion();
			break;
		
		default:
			throw new IllegalArgumentException("Invalid column index");
		}

		return returnValue;
	
	}

}
