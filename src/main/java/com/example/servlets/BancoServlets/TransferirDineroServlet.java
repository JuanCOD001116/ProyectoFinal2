package com.example.servlets.BancoServlets;

import java.io.IOException;
import java.sql.*;
import com.example.dao.BancoDAO.*;
import com.example.model.banco.Transaccion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/banco web/jsp/transferirdinero")
public class TransferirDineroServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;
    private CuentaDAO cuentaDAO;
    private TransaccionDAO transaccionDAO;
    private Transaccion transaccion;
    private Transaccion transaccionBanco;
    private float interes;
    public void init() {
        cuentaDAO = new CuentaDAO();
        transaccionDAO = new TransaccionDAO();
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCuentaOrigen = Integer.parseInt(request.getParameter("idCuentaOrigen"));
        int idCuentaDestino = Integer.parseInt(request.getParameter("idCuentaDestino"));
        int monto = Integer.parseInt(request.getParameter("monto"));
        Timestamp fecha = Timestamp.valueOf(request.getParameter("fecha").replace("T", " ") + ":00");
        int idTransaccion = (int) (Math.random()*100000000);
        int idTransaccionBanco = (int) (Math.random()*100000000);
        interes = Interes(monto);
        transaccion = new Transaccion(idTransaccion, idCuentaOrigen, idCuentaDestino, fecha, monto);
        transaccionBanco=new Transaccion(idTransaccionBanco,idCuentaOrigen,1010,fecha,interes);

        
        try {
            cuentaDAO.transferirDinero(idCuentaOrigen, idCuentaDestino, monto, fecha);
            transaccionDAO.insertarTransaccion(transaccion);
            transaccionDAO.insertarTransaccion(transaccionBanco);
            response.sendRedirect("transferencia-exitosa.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("transferencia-fallida.jsp");
        }

    }
    public float Interes(int monto){
        float interes;
        if (monto>50000){
            interes=(float)(monto*0.1);
        }else{
            interes=100;
        }

        return interes;
    }
}
