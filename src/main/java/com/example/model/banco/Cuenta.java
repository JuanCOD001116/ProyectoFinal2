package com.example.model.banco;

import java.sql.Timestamp;

public class Cuenta {
    private int saldo;
    private int id_Cuenta;
    private int clave;
    private int id_usuario;
    private String estado;
    private String tipo_cuenta;
    private String email;
    public Cuenta() {
    }
    

    public Cuenta( int id_usuario, int saldo) {
        this.saldo = saldo;
        this.id_usuario = id_usuario;
    }


    public Cuenta(int saldo, int id_Cuenta, int clave, int id_usuario, String estado, String tipo_cuenta,
            String email) {
        this.saldo = saldo;
        this.id_Cuenta = id_Cuenta;
        this.clave = clave;
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.tipo_cuenta = tipo_cuenta;
        this.email = email;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getId_Cuenta() {
        return id_Cuenta;
    }
    public void setIdCuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }
    public int getClave() {
        return clave;
    }
    public void setClave(int clave) {
        this.clave = clave;
    }
    public int getIdUsuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipo_cuenta() {
        return tipo_cuenta;
    }
    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Cuenta [saldo=" + saldo + ", id_Cuenta=" + id_Cuenta + ", clave=" + clave + ", id_usuario=" + id_usuario
                + ", estado=" + estado + ", tipo_cuenta=" + tipo_cuenta + ", email=" + email + "]";
    }
    

}


