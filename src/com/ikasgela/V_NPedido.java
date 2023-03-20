package com.ikasgela;

import javax.swing.*;
import java.util.List;

public class V_NPedido {
    JPanel panel;
    private JComboBox<String> clientes_comboBox;
    private JComboBox<String> productos_comboBox;
    private JTextField units_textField;
    private JTextField date_textField;
    private JButton save_Button;


    public V_NPedido() {
        List<Cliente> clientes = V_Principal.Clientes();
        List<Producto> productos = V_Principal.Productos();

        for (Cliente cliente : clientes) {
            clientes_comboBox.addItem(cliente.getNombre());
        }

        for (Producto producto : productos) {
            productos_comboBox.addItem(producto.getNombre());
        }


        save_Button.addActionListener(e -> {
            Cliente cliente = Cliente_Selected(clientes_comboBox.getSelectedItem().toString(), clientes);
            Producto producto = Producto_Selected(productos_comboBox.getSelectedItem().toString(), productos);
            try {
                int unidades = Integer.parseInt(units_textField.getText());
                String fecha = date_textField.getText();
                if (cliente != null && producto != null) {
                    Pedido actual = new Pedido(V_Principal.getId_Pedido(), fecha, unidades, cliente, producto);
                    boolean anadido = V_Principal.AddPedido_Clientes(cliente.getNombre(), actual);
                    if (anadido) {
                        JOptionPane.showMessageDialog(null, "Pedido añadido exitosamente",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                        V_Principal.setId_Pedido();
                    } else JOptionPane.showMessageDialog(null, "Algo ha fallado, " +
                            "intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Error al seleccionar Cliente o " +
                        "producto,\nIntente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Revise los campos ingresados",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }


        });
    }

    private static Cliente Cliente_Selected(String nombre, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) return cliente;
        }
        return null;
    }

    private static Producto Producto_Selected(String nombre, List<Producto> productos) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) return producto;
        }
        return null;
    }
}
