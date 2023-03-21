package com.ikasgela;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V_Principal {
    private JPanel panel1;
    private JButton newProducto_Button;
    private JButton newPedido_Button;
    private JButton pedidosList_Button;
    private JButton newClient_Button;

    private static Map<String, List<Pedido>> pedido_Clientes = new HashMap<>();
    private static List<Producto> productos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static int id_producto = 0;
    private static int id_Cliente = 0;
    private static int id_Pedido = 0;

    public V_Principal() {
        newProducto_Button.addActionListener(e -> {

            JFrame frame = new JFrame("Nuevo Producto");
            frame.setContentPane(new V_NProducto().panel);
            frame.pack();
            frame.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);

        });
        newClient_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Nuevo Cliente");
            frame.setContentPane(new V_NCliente().panel);
            frame.pack();
            frame.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);
        });
        newPedido_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Nuevo Pedido");
            frame.setContentPane(new V_NPedido().panel);
            frame.pack();
            frame.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);
        });
        pedidosList_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Ver Pedidos");
            frame.setContentPane(new V_PedidoTable().panel);
            frame.pack();
            frame.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int x = (screenSize.width - frame.getWidth()) / 2;
            int y = (screenSize.height - frame.getHeight()) / 2;
            frame.setLocation(x, y);
        });
    }

    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        JFrame frame = new JFrame("V_Principal");
        frame.setContentPane(new V_Principal().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    public static Map<String, List<Pedido>> Clientes_Pedido() {
        return pedido_Clientes;
    }

    public static boolean AddPedido_Clientes(String key, Pedido pedido_Cliente) {
        if (pedido_Clientes.containsKey(key)) {
            pedido_Clientes.get(key).add(pedido_Cliente);
            return true;
        } else return false;

    }

    public static boolean IsCreated(String nombre) {
        return pedido_Clientes.containsKey(nombre);
    }

    public static void AddProducto(Producto producto) {
        productos.add(producto);
    }

    public static List<Producto> Productos() {
        return productos;
    }

    public static List<Cliente> Clientes() {
        return clientes;
    }

    public static void AddClientes(Cliente cliente) {
        clientes.add(cliente);
        pedido_Clientes.put(cliente.getNombre(), new ArrayList<>());
    }

    public static int getId_producto() {
        return id_producto;
    }

    public static void setId_producto() {
        id_producto++;
    }

    public static int getId_Cliente() {
        return id_Cliente;
    }

    public static void setId_Cliente() {
        id_Cliente++;
    }

    public static int getId_Pedido() {
        return id_Pedido;
    }

    public static void setId_Pedido() {
        id_Pedido++;
    }


}
