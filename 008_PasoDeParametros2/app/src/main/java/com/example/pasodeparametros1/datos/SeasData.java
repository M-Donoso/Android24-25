package com.example.pasodeparametros1.datos;

import com.example.pasodeparametros1.beans.Usuario;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SeasData {

    private static Usuario usuario;
    private static ArrayList<Usuario> listaUsuarios;

    public static Usuario getUsuario(){
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        SeasData.usuario = usuario;
    }

}

