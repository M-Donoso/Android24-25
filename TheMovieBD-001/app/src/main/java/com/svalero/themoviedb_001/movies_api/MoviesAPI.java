package com.svalero.themoviedb_001.movies_api;

import com.svalero.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
    // Routerss!!! express.js
    @GET("movie/popular?api_key=a89a8abec897ac3e864832fb23b8ec30")
    Call<MovieResponse> getPopularMovies();

}
