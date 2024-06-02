package com.example.model.Inmo;

import java.util.Date;

public class Venta {
    private int idInmueble;
    private int idUsuario;
    private double precio;
    private String moneda;
    private Date fechaVenta;

    public Venta(int idInmueble, int idUsuario, double precio, String moneda, Date fechaVenta) {
        this.idInmueble = idInmueble;
        this.idUsuario = idUsuario;
        this.precio = precio;
        this.moneda = moneda;
        this.fechaVenta = fechaVenta;
    }

    // Getters y setters
    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
