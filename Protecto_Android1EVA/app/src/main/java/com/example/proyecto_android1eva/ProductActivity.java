package com.example.proyecto_android1eva;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.EditText;
import android.widget.Button;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Camiseta> camisetaList;
    private Button btnFilterByTeam, btnFilterByLeague, btnTopVendidas;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.rvProducts);
        btnFilterByTeam = findViewById(R.id.btnFilterByTeam);
        btnFilterByLeague = findViewById(R.id.btnFilterByLeague);
        btnTopVendidas = findViewById(R.id.btnTopVendidas); // Nuevo botón
        etSearch = findViewById(R.id.etSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        camisetaList = new ArrayList<>();

        // Configuración del adaptador con listener de compra
        adapter = new ProductAdapter(camisetaList, camiseta -> realizarCompra(camiseta));
        recyclerView.setAdapter(adapter);

        fetchCamisetas();

        setupListeners();
    }

    private void setupListeners() {
        btnFilterByLeague.setOnClickListener(v -> {
            String liga = etSearch.getText().toString();
            if (!liga.isEmpty()) {
                fetchCamisetasByLiga(liga);
            } else {
                Toast.makeText(this, "Introduce una liga para filtrar", Toast.LENGTH_SHORT).show();
            }
        });

        btnFilterByTeam.setOnClickListener(v -> {
            String equipo = etSearch.getText().toString();
            if (!equipo.isEmpty()) {
                fetchCamisetasByEquipo(equipo);
            } else {
                Toast.makeText(this, "Introduce un equipo para filtrar", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnTopVendidas = findViewById(R.id.btnTopVendidas);
        btnTopVendidas.setOnClickListener(v -> fetchTopVendidas());

    }

    private void fetchCamisetas() {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        Call<List<Camiseta>> call = apiService.getCamisetas();
        call.enqueue(new Callback<List<Camiseta>>() {
            @Override
            public void onResponse(Call<List<Camiseta>> call, Response<List<Camiseta>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    camisetaList.clear();
                    camisetaList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ProductActivity.this, "No se pudieron cargar las camisetas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Camiseta>> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchCamisetasByLiga(String liga) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        Call<List<Camiseta>> call = apiService.getCamisetasByLiga(liga);
        call.enqueue(new Callback<List<Camiseta>>() {
            @Override
            public void onResponse(Call<List<Camiseta>> call, Response<List<Camiseta>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    camisetaList.clear();
                    camisetaList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ProductActivity.this, "No se encontraron camisetas para la liga: " + liga, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Camiseta>> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchCamisetasByEquipo(String equipo) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        Call<List<Camiseta>> call = apiService.getCamisetasByEquipo(equipo);
        call.enqueue(new Callback<List<Camiseta>>() {
            @Override
            public void onResponse(Call<List<Camiseta>> call, Response<List<Camiseta>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    camisetaList.clear();
                    camisetaList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ProductActivity.this, "No se encontraron camisetas para el equipo: " + equipo, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Camiseta>> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchTopVendidas() {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        Call<List<Camiseta>> call = apiService.getTopVendidas();
        call.enqueue(new Callback<List<Camiseta>>() {
            @Override
            public void onResponse(Call<List<Camiseta>> call, Response<List<Camiseta>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    camisetaList.clear();
                    camisetaList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ProductActivity.this, "Top 10 camisetas más vendidas cargadas", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProductActivity.this, "No se pudieron cargar las camisetas más vendidas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Camiseta>> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void realizarCompra(Camiseta camiseta) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

        int idUsuario = 1; // ID del usuario autenticado
        String email = "usuario@example.com"; // Correo del usuario
        int idCamiseta = camiseta.getIdCamiseta(); // Obtener el ID de la camiseta

        Compra compra = new Compra(idUsuario, idCamiseta, email);

        Call<Void> call = apiService.realizarCompra(compra);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ProductActivity.this, "Compra realizada con éxito. Revisa tu correo.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProductActivity.this, "Error al realizar la compra.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}






