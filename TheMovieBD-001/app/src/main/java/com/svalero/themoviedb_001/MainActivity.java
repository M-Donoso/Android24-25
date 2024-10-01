package com.svalero.themoviedb_001;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.themoviedb_001.json_mapper.Movie;
import com.svalero.themoviedb_001.json_mapper.MovieResponse;
import com.svalero.themoviedb_001.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private static final String API_KEY = "a89a8abec897ac3e864832fb23b8ec30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPopularMovies = findViewById(R.id.btnPopularMovies);
        Button btnSearchMovie = findViewById(R.id.btnSearchMovie);
        Button btnMovieDetails = findViewById(R.id.btnMovieDetails);

        btnPopularMovies.setOnClickListener(v -> fetchPopularMovies());
        btnSearchMovie.setOnClickListener(v -> searchMovie());
        btnMovieDetails.setOnClickListener(v -> getMovieDetails());
    }

    private void fetchPopularMovies() {
        String language = "es-ES";
        int page = 1;
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies(API_KEY, language, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    movieList.clear();
                    movieList.addAll(movies);
                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void getMovieDetails() {
        int movieId = 550;
        String language = "es-ES";
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId, API_KEY, language);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Movie movie = response.body();
                    Toast.makeText(MainActivity.this, "Movie Title: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void searchMovie() {
        String query = "titanic";
        String language = "es-ES";
        int page = 1; // or any other page number
        Call<MovieResponse> call = RetrofitClient.getInstance().searchMovie(API_KEY, query, language, page);
        call.enqueue(new Callback<MovieResponse>() {
        @Override
        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
            if (response.isSuccessful() && response.body() != null) {
                List<Movie> movies = response.body().getResults();
                movieList.clear();
                movieList.addAll(movies);
            } else {
                Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<MovieResponse> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}

}