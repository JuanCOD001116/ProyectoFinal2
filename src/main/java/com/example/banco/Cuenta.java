package com.example.banco;
import com.example.banco.Transaccion;
public class Cuenta {
    private double saldo;
    private double id_Cuenta;
    private int clave;
    private int cedula;
    private String estado;
    private String tipo_cuenta;

    public Cuenta() {
    }

    public Cuenta(double saldo, double id_Cuenta, int clave, int cedula, String estado, String tipo_cuenta) {
        this.saldo = saldo;
        this.id_Cuenta = id_Cuenta;
        this.clave = clave;
        this.cedula = cedula;
        this.estado = estado;
        this.tipo_cuenta = tipo_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(double id_Cuenta) {
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

    public 
    
}
