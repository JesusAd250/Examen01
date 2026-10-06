package com.upiiz.examen_jatc_01.model;

public class Usuario {
    private final String nombre;
    private final String usuario;

    public Usuario(String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getNombre() { return nombre; }
    public String getUsuario() { return usuario; }
}
