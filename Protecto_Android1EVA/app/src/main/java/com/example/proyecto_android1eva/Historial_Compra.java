package com.example.proyecto_android1eva;

public class Historial_Compra {
    private int numeroPedido;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String equipo;
    private String liga;
    private String descripcion_camiseta;
    private String imagen_camiseta;
    private double precioUnitario;
    private double total_compra;
    private String fecha_compra;

    // Constructor vacío (por si lo necesitas)
    public Historial_Compra() {
    }

    // Constructor completo
    public Historial_Compra(int numeroPedido, String nombreUsuario, String apellidoUsuario, String emailUsuario,
                           String equipo, String liga, String descripcionCamiseta, String imagenCamiseta,
                           double precioUnitario, double totalCompra, String fechaCompra) {
        this.numeroPedido = numeroPedido;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.equipo = equipo;
        this.liga = liga;
        this.descripcion_camiseta = descripcionCamiseta;
        this.imagen_camiseta = imagenCamiseta;
        this.precioUnitario = precioUnitario;
        this.total_compra = totalCompra;
        this.fecha_compra = fechaCompra;
    }

    // Getters y Setters
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getDescripcionCamiseta() {
        return descripcion_camiseta;
    }

    public void setDescripcionCamiseta(String descripcionCamiseta) {
        this.descripcion_camiseta = descripcionCamiseta;
    }

    public String getImagenCamiseta() {
        return imagen_camiseta;
    }

    public void setImagenCamiseta(String imagenCamiseta) {
        this.imagen_camiseta = imagenCamiseta;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotalCompra() {
        return total_compra;
    }

    public void setTotalCompra(double totalCompra) {
        this.total_compra = totalCompra;
    }

    public String getFechaCompra() {
        return fecha_compra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fecha_compra = fechaCompra;
    }
}

