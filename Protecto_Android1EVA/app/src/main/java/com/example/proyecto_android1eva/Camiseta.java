package com.example.proyecto_android1eva;

public class Camiseta {
        private int id_camiseta;
        private String nombre_equipo;
        private String liga;
        private String descripcion;
        private String imagen;
        private double precio;
        private double promedioCalificacion;



        public int getIdCamiseta() {
            return id_camiseta;
        }

        public void setIdCamiseta(int id_camiseta) {
            this.id_camiseta = id_camiseta;
        }

        public String getNombreEquipo() {
            return nombre_equipo;
        }

        public void setNombreEquipo(String nombreEquipo) {
            this.nombre_equipo = nombreEquipo;
        }

        public String getLiga() {
            return liga;
        }

        public void setLiga(String liga) {
            this.liga = liga;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getImagen() {
            return imagen;
        }

        public void setImagen(String imagen) {
            this.imagen = imagen;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
        public double getPromedioCalificacion() {
        return promedioCalificacion;
        }

        public void setPromedioCalificacion(double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
        }
    }


