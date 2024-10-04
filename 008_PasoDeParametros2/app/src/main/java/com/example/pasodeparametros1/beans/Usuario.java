package com.example.pasodeparametros1.beans;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String email;
    private String password;

    public Usuario(){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
