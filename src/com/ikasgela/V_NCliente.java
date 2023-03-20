package com.ikasgela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_NCliente {
    private JTextField name_textField;
    JPanel panel;
    private JButton guardarButton;

    public V_NCliente() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = name_textField.getText();
                if (!nombre.equals("") && !nombre.equals(" ") && !V_Principal.IsCreated(nombre)) {
                    Cliente actual = new Cliente(V_Principal.getId_Cliente(), nombre);
                    V_Principal.AddClientes(actual);
                    JOptionPane.showMessageDialog(null, "Cliente Guardado Exitosamente",
                            "Guardado Excitoso", JOptionPane.INFORMATION_MESSAGE);
                    V_Principal.setId_Cliente();
                } else JOptionPane.showMessageDialog(null, "Campo nombre con errores",
                        "Error", JOptionPane.ERROR_MESSAGE);
                name_textField.setText("");

            }
        });
    }
}
