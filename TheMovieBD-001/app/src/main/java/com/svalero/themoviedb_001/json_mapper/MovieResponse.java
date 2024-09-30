package com.svalero.themoviedb_001.json_mapper;

import java.util.List;

public class MovieResponse {
    // URL: https://api.themoviedb.org/3/movie/popular?api_key=a89a8abec897ac3e864832fb23b8ec30

    private List<Movie> results;

    // Getters y Setters aquí


    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
