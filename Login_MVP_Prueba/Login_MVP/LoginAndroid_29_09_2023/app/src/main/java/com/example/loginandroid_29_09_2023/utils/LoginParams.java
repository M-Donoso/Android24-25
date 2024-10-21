package com.example.loginandroid_29_09_2023.utils;

public class LoginParams {
    private String correo;
    private String contraseña;

    public LoginParams(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getters y setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
