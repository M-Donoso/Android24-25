package com.example.loginandroid_29_09_2023.login_user.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.model.data.MyData;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiResponse;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.LoginParams;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {
     private static final String IP_BASE = "192.168.1.41:3000";
    //private static final String IP_BASE = "127.0.0.1:3000";
    private LoginUserPresenter presenter;
    public LoginUserModel(LoginUserPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void loginAPI(User user, final OnLoginUserListener onLoginUserListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE).
                create(ApiService.class);

        // Verificar que los valores de user no estén vacíos o null
        if (user.getEmail() == null || user.getEmail().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
            onLoginUserListener.onFailure("Correo o contraseña vacíos");
            return;
        }

        // Crear el objeto LoginParams con los valores correctos
        LoginParams loginParams = new LoginParams(user.getEmail(), user.getPassword());

        // Log para verificar el objeto LoginParams
        Log.d("LoginUserModel", "Datos de LoginParams: " + loginParams.getCorreo() + " / " + loginParams.getContraseña());

        // Realizar la solicitud al servidor
        Call<ApiResponse> call = apiService.login(loginParams);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = response.body();

                    if (apiResponse.getLstUsers() != null && !apiResponse.getLstUsers().isEmpty()) {
                        onLoginUserListener.onFinished(apiResponse.getLstUsers().get(0));
                    } else {
                        onLoginUserListener.onFailure("Credenciales incorrectas");
                    }
                } else {
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                        onLoginUserListener.onFailure("Error en la respuesta del servidor: " + response.code() + " - " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                        onLoginUserListener.onFailure("Error en la respuesta del servidor");
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("LoginUserModel", "Error de conexión: " + t.getMessage());
                onLoginUserListener.onFailure("Error de conexión: " + t.getMessage());
            }
        });
    }

}



