package com.example.pasodeparametros1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pasodeparametros1.beans.Usuario;
import com.example.pasodeparametros1.datos.SeasData;

public class Pantalla1Activity extends AppCompatActivity {

    private EditText edtUser;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = (EditText)findViewById(R.id.edtUsuario);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

            btnEnviar.setOnClickListener((v) -> {
                Intent navegarEntrePantallas = new Intent(getBaseContext(), Pantalla2Activity.class);

                Usuario miUsuario = new Usuario();
                miUsuario.setEmail(edtUser.getText().toString());

                SeasData.setUsuario(miUsuario);
                startActivity(navegarEntrePantallas);

            });

        }
    }