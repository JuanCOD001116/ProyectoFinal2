package com.example.model;

import java.io.Serializable;

public class UsuarioInmo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id_usuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String contraseña;

    // Constructor con todos los campos
    public UsuarioInmo(int id_usuario, String nombre, String apellido, String email, String telefono, String direccion, String contraseña) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }

    // Constructor sin id_usuario (para inserciones donde el ID es auto_increment)
    public UsuarioInmo(String nombre, String apellido, String email, String telefono, String direccion, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }

    // Constructor vacío
    public UsuarioInmo() {
    }

    // Getters y Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "UsuarioInmo: { id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", contraseña=" + contraseña + " }";
    }
}
