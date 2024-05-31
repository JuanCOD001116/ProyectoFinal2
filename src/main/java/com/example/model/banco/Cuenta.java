package com.example.model.banco;

import java.sql.Timestamp;

public class Cuenta {
    private int saldo;
    private int id_Cuenta;
    private int clave;
    private int cedula;
    private String estado;
    private String tipo_cuenta;

    public Cuenta() {
    }

    public Cuenta(int saldo, int id_Cuenta, int clave, int cedula, String estado, String tipo_cuenta) {
        this.saldo = saldo;
        this.id_Cuenta = id_Cuenta;
        this.clave = clave;
        this.cedula = cedula;
        this.estado = estado;
        this.tipo_cuenta = tipo_cuenta;
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

    public void setId_Cuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + ", id_Cuenta=" + id_Cuenta + ", clave=" + clave + ", cedula=" + cedula + ", estado=" + estado + ", tipo_cuenta=" + tipo_cuenta + '}';
    }

    public void TransaccionCuenta(Cuenta cuenta, int monto, Timestamp fecha) {
        this.saldo = this.saldo - monto;
        int saldoActualizado = cuenta.getSaldo() + monto;
        int id_transaccion = (int)(Math.random()*1000000000);
        cuenta.setSaldo(saldoActualizado);

        
    }
}


