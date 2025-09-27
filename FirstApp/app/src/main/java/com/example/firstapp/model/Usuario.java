package com.example.firstapp.model;


import androidx.annotation.NonNull;

public class Usuario {

    private int id;
    private String nombre;
    private String email;


    public Usuario(int id, @NonNull String nombre, @NonNull String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
