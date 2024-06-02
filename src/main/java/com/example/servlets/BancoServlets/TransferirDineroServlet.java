package com.example.servlets.BancoServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
import com.example.dao.BancoDAO.*;

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

        try {
            cuentaDAO.transferirDinero(idCuentaOrigen, idCuentaDestino, monto, fecha);
            response.sendRedirect("transferencia-exitosa.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("transferencia-fallida.jsp");
        }

    }
}
