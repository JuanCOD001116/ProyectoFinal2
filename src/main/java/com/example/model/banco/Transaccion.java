package com.example.model.banco;
import java.sql.Timestamp;

public class Transaccion {
    private int id_transaccion;
    private int numero_cuenta_entrante;
    private int numero_cuenta_saliente;
    private Timestamp fecha;
    private float monto;

    public Transaccion(int id_transaccion, int numero_cuenta_entrante, int numero_cuenta_saliente, Timestamp fecha, float monto) {
        this.id_transaccion = id_transaccion;
        this.numero_cuenta_entrante = numero_cuenta_entrante;
        this.numero_cuenta_saliente = numero_cuenta_saliente;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Transaccion() {
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getNumero_cuenta_entrante() {
        return numero_cuenta_entrante;
    }

    public void setNumero_cuenta_entrante(int numero_cuenta_entrante) {
        this.numero_cuenta_entrante = numero_cuenta_entrante;
    }

    public int getNumero_cuenta_saliente() {
        return numero_cuenta_saliente;
    }

    public void setNumero_cuenta_saliente(int numero_cuenta_saliente) {
        this.numero_cuenta_saliente = numero_cuenta_saliente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id_transaccion=" + id_transaccion + ", numero_cuenta_entrante=" + numero_cuenta_entrante + ", numero_cuenta_saliente=" + numero_cuenta_saliente + ", fecha=" + fecha + ", monto=" + monto + '}';
    }
    
}
