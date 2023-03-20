package com.ikasgela;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PedidoTableModel extends AbstractTableModel {
    private String[] columnas = {"ID", "Fecha", "Cantidad", "Producto"};
    //private int cliente;
    private List<Pedido> items;

    public PedidoTableModel() {
        items = new ArrayList<>();
    }

    public PedidoTableModel(List<Pedido> pedidoList) {
        this.items = pedidoList;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Pedido actual = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return actual.getId();
            case 1:
                return actual.getFecha();
            case 2:
                return actual.getCantidad();
            case 3:
                return actual.getProducto().getNombre();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
