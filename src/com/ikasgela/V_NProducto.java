package com.ikasgela;

import javax.swing.*;

public class V_NProducto {
    private JTextField name_textField;
    private JTextField price_textField;
    private JButton save_Button;
    JPanel panel;

    public V_NProducto() {
        save_Button.addActionListener(e -> {
            String nombre = name_textField.getText();
            try {
                double precio = Double.parseDouble(price_textField.getText());
                if (!nombre.equals("") && !nombre.equals(" ")) {
                    Producto actual = new Producto(V_Principal.getId_producto(), nombre, precio);
                    V_Principal.AddProducto(actual);
                    JOptionPane.showMessageDialog(null, "Producto Guardado Exitosamente",
                            "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    V_Principal.setId_producto();
                } else JOptionPane.showMessageDialog(null, "Campo nombre con errores",
                        "Error", JOptionPane.ERROR_MESSAGE);
                name_textField.setText("");
                price_textField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campo precio con errores",
                        "Error", JOptionPane.ERROR_MESSAGE);
                name_textField.setText("");
                price_textField.setText("");
            }
        });
    }
}
