package com.example.recyclermoviesmvp.data;

import com.example.recyclermoviesmvp.beans.Pelicula;

import java.util.ArrayList;

public class MovieData {
    public static ArrayList<Pelicula> getMovieList() {
        ArrayList<Pelicula> movies = new ArrayList<>();
        movies.add(new Pelicula("300"));
        movies.add(new Pelicula("El Último Samurai"));
        movies.add(new Pelicula("Braveheart"));
        movies.add(new Pelicula("Gladiator"));
        movies.add(new Pelicula("Troya"));
        movies.add(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo"));
        movies.add(new Pelicula("El Rey Arturo"));
        movies.add(new Pelicula("Espartacus"));
        movies.add(new Pelicula("Roma"));
        movies.add(new Pelicula("Prison Break"));

        return movies;
    }
}

