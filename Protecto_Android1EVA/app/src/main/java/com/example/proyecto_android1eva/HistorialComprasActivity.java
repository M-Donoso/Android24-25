package com.example.proyecto_android1eva;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialComprasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistorialComprasAdapter adapter;
    private List<Historial_Compra> comprasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_compras);

        recyclerView = findViewById(R.id.rvHistorialCompras);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comprasList = new ArrayList<>();
        adapter = new HistorialComprasAdapter(comprasList);
        recyclerView.setAdapter(adapter);

        fetchHistorialCompras();
    }

    private void fetchHistorialCompras() {
        // Obtener el ID del usuario desde SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        int idUsuario = preferences.getInt("id_usuario", -1);

        if (idUsuario == -1) {
            Toast.makeText(this, "Error al obtener usuario. Por favor, inicia sesión nuevamente.", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        Call<List<Historial_Compra>> call = apiService.getHistorialCompras(idUsuario);

        call.enqueue(new Callback<List<Historial_Compra>>() {
            @Override
            public void onResponse(Call<List<Historial_Compra>> call, Response<List<Historial_Compra>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    comprasList.clear();
                    comprasList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(HistorialComprasActivity.this, "No se pudo obtener el historial de compras.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Historial_Compra>> call, Throwable t) {
                Toast.makeText(HistorialComprasActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
