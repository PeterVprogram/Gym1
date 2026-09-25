package com.example.demo.model;

public class Trabajador {

    private String usuario = "peter@XPORT.com";
    private String password = "admin123";
    private String cargo = "Personal Fitness";

    public Trabajador() {
    }

    public Trabajador(String usuario, String password, String cargo) {
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}