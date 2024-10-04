package com.example.a004singleton;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a004singleton.data.GlovoData;
import com.example.a004singleton.listeners.MyListener;
import com.example.a004singleton.services.ServicePantallaPrincipal;

public class MainActivity extends AppCompatActivity {

    private Button btnSaludar;

    /////////PATRÓN SINGLETON
    private static MainActivity padre;
    public static MainActivity getInstance(){
        return padre;
    }

    ////// FIN
    // onload: Javascript //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SINGLETON
        this.padre = this;
        // FIN SINGLETON
        ServicePantallaPrincipal service = new ServicePantallaPrincipal(); // 0x5454af
        btnSaludar = findViewById(R.id.btnSaludar01);
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.saludar();
            }
        });

        // SIMULAR UN BOTON
        service.simularAccionDeListener();
        service.setMyListener(new MyListener() {
            @Override
            public void onSaludar() {
                Toast.makeText(MainActivity.this,
                        "Saludar myListener",
                        Toast.LENGTH_SHORT).show();
            }
        });

        if(GlovoData.getEmail()!= null && GlovoData.getEmail().length()>0){
            String email = GlovoData.getEmail();
            Toast.makeText(getBaseContext(), "Gracias: " + email,
                            Toast.LENGTH_SHORT).show();
        }
        // setContentView(R.layout.activity_main);

    }
}