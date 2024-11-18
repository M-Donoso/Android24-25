package com.example.proyecto_android1eva;

public class UserResponse {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String correo;

    public String getNombre() {
        return nombre;
    }
    // Otros getters y setters


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


}
