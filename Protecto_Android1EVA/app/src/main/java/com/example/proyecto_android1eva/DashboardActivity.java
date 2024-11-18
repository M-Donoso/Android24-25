package com.example.proyecto_android1eva;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        Button btnLogout = findViewById(R.id.btnLogout);
        Button btnGoToProducts = findViewById(R.id.btnGoToProducts);
        Button btnHistorialCompras = findViewById(R.id.btnHistorialCompras); // Botón para historial de compras

        // Recuperar el nombre de usuario de las preferencias
        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        String usuario = preferences.getString("usuario", "Usuario");

        // Mostrar mensaje de bienvenida
        tvWelcomeMessage.setText("Bienvenido, " + usuario + "!");

        // Botón para cerrar sesión
        btnLogout.setOnClickListener(v -> {
            preferences.edit().clear().apply();
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Sesión cerrada correctamente", Toast.LENGTH_SHORT).show();
        });

        // Botón para ir al listado de productos
        btnGoToProducts.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProductActivity.class);
            startActivity(intent);
        });

        // Botón para ir al historial de compras
        btnHistorialCompras.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, HistorialComprasActivity.class);
            startActivity(intent);
        });
    }
}

