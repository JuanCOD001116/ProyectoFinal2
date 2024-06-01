package com.example.model.Inmo;

public class Inmueble {
    private int idInmueble;
    private String direccion;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private double precio;
    private String tipo;
    private String descripcion;
    private String propietario;

    public Inmueble() {
        // Constructor vacío
    }

    public Inmueble(int idInmueble, String direccion, String ciudad, String estado, String codigoPostal, double precio, String tipo, String descripcion, String propietario) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.precio = precio;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.propietario = propietario;
    }

    public Inmueble( String direccion, String ciudad, String estado, String codigoPostal, double precio, String tipo, String descripcion, String propietario) {
        
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.precio = precio;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.propietario = propietario;
    }


    // Getters y setters
    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
