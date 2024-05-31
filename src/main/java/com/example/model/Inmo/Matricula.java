package com.example.model.Inmo;

public class Matricula {
    private String direccion;
    private String propietario;
    private int valor;

    public Matricula(String direccion, String propietario, int valor) {
        this.direccion = direccion;
        this.propietario = propietario;
        this.valor = valor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
