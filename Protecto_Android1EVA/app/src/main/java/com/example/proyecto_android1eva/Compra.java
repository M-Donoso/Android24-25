package com.example.proyecto_android1eva;

public class Compra {
    private int id_usuario;
    private int id_camiseta;
    private String email;
    private String NombreCamiseta;
    private double total;
    private String fecha_pedido;

    // Constructor para crear una compra (compra directa)
    public Compra(int id_usuario, int id_camiseta, String email) {
        this.id_usuario = id_usuario;
        this.id_camiseta = id_camiseta;
        this.email = email;
    }

    // Constructor para el historial de compras
    public Compra(int id_usuario, int id_camiseta, String email, String NombreCamiseta, double total, String fechaCompra) {
        this.id_usuario = id_usuario;
        this.id_camiseta = id_camiseta;
        this.email = email;
        this.NombreCamiseta = NombreCamiseta;
        this.total = total;
        this.fecha_pedido = fechaCompra;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getIdCamiseta() {
        return id_camiseta;
    }

    public void setIdCamiseta(int id_camiseta) {
        this.id_camiseta = id_camiseta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCamiseta() {
        return NombreCamiseta;
    }

    public void setNombreProducto(String nombreProducto) {
        this.NombreCamiseta = nombreProducto;
    }

    public double getTotal() {
        return total;
    }

    public void setPrecio(double total) {
        this.total = total;
    }

    public String getFechaCompra() {
        return fecha_pedido;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fecha_pedido = fechaCompra;
    }
}



