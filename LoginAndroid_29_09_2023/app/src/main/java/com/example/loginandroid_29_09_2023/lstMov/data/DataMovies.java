package com.example.loginandroid_29_09_2023.lstMov.data;

import com.example.loginandroid_29_09_2023.beans.Pelicula;

import java.util.ArrayList;

public class DataMovies {
        private String message;
        private ArrayList<Pelicula> lstPeliculas;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ArrayList<Pelicula> getLstPeliculas() {
            return lstPeliculas;
        }

        public void setLstPeliculas(ArrayList<Pelicula> lstPeliculas) {
            this.lstPeliculas = lstPeliculas;
        }
        // Getters y setters de la clase JsonResponse (omitiendo por simplicidad)
    }


