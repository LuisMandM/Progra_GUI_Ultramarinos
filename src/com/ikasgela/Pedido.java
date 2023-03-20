package com.ikasgela;

public class Pedido {

    private int id;
    private String fecha;
    private int cantidad;

    //Asociations
    private Cliente cliente;
    private Producto producto;

    public Pedido() {
    }

    public Pedido(int id, String fecha, int cantidad, Cliente cliente, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.producto = producto;
    }

    public Pedido(int id, String fecha, int cantidad) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
