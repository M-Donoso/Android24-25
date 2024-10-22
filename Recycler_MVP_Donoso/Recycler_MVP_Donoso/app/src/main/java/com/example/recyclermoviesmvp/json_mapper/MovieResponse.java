package com.example.recyclermoviesmvp.json_mapper;

import java.util.List;

public class MovieResponse {
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
