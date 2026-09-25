package com.example.demo.model;

public class Persona {

    private String usuario = "cliente@nexus.com";
    private String password = "123456";

    public Persona() {
    }

    public Persona(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}