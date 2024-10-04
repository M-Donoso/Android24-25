package com.example.a004singleton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a004singleton.data.GlovoData;
import com.example.a004singleton.services.ServicePantallaPrincipal;

public class MainActivity2 extends AppCompatActivity {

    private ServicePantallaPrincipal spPrincipal;
    /////////PATRÓN SINGLETON
    private static MainActivity2 padre;
    public static MainActivity2 getInstance(){
        return padre;
    }
    ////// FIN
    private Button btnSaludar2;
    private EditText txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_segunda_activity);
        // SINGLETON
            this.padre = this;
        // FIN SINGLETON
        btnSaludar2 = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txtEmail);
        spPrincipal = new ServicePantallaPrincipal();
        btnSaludar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this,
                        "Hola desde pantalla 2",
                        Toast.LENGTH_SHORT).show();
    GlovoData.setEmail(txtEmail.getText().toString());
                Intent navegar = new Intent(getBaseContext(),
                                    MainActivity.class);
                startActivity(navegar);

            }
        });
    }
}