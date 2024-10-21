package com.example.loginandroid_29_09_2023.login_user.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.MainActivity;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;

public class LoginUserM extends AppCompatActivity implements ContractLoginUser.View{

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private LoginUserPresenter presenter =
            new LoginUserPresenter(this);

    /* PATRÓN SINGLETON*/
    private static LoginUserM mainActivity = null;
    public static LoginUserM getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);
        mainActivity = this;
        initComponents();
    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(mainActivity, "Por favor, ingresa un correo y contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User("", email, password);
                    Toast.makeText(mainActivity, user.getPassword() + user.getEmail(), Toast.LENGTH_LONG);
                    presenter.login(user);
                }
            }
        });

    }


    @Override
    public void successLogin(User user) {
        String message = (user.getPassword() != null && !user.getPassword().isEmpty())
                ? user.getPassword()
                : "Inicio de sesión exitoso";
        Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void failureLogin(String err) {
        Toast.makeText(mainActivity, err, Toast.LENGTH_SHORT).show();
    }

}