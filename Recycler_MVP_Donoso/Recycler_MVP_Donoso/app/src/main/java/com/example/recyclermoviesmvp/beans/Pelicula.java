package com.example.recyclermoviesmvp.beans;

public class Pelicula {
    private String titulo;

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}