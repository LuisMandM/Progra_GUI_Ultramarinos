package com.ikasgela;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class V_PedidoTable {
    JPanel panel;
    private JList<String> clientes_JList;
    private JScrollPane list_Scroll;
    private JScrollPane table_Scroll;

    private List<Cliente> clientes;
    private JTable pedidos_Tabla;

    public V_PedidoTable() {
        clientes = V_Principal.Clientes();
        SetClientes();

        pedidos_Tabla = new JTable();
        pedidos_Tabla.setModel(new PedidoTableModel());
        table_Scroll.setViewportView(pedidos_Tabla);


        clientes_JList.addListSelectionListener(e -> {
            String seleccion = clientes_JList.getSelectedValue();
            Cliente actual = Cliente_Selected(seleccion, V_Principal.Clientes());
            Map<String, List<Pedido>> pedidos_cliente = V_Principal.Clientes_Pedido();
            List<Pedido> pedidoList = new ArrayList<>();

            if (actual != null) {
                pedidos_cliente.get(actual.getNombre());
                if (pedidos_cliente.containsKey(actual.getNombre())) {
                    pedidoList = new ArrayList<>(pedidos_cliente.get(actual.getNombre()));
                }

                if (pedidoList.size() > 0) {
                    pedidos_Tabla.setModel(new PedidoTableModel(pedidoList));
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente sin pedidos registrados", "Error", JOptionPane.INFORMATION_MESSAGE);
                    pedidos_Tabla.setModel(new PedidoTableModel());
                }
            } else JOptionPane.showMessageDialog(null, "Error al seleccionar Cliente," +
                    "\nIntente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);


        });
    }

    public void SetClientes() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Cliente cliente : clientes) {
            model.addElement(cliente.getNombre());
        }
        clientes_JList.setModel(model);
    }

    private static Cliente Cliente_Selected(String nombre, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) return cliente;
        }
        return null;
    }
}
