package com.example.servlets.BancoServlets;

import java.io.IOException;
import java.sql.SQLException;

import com.example.dao.BancoDAO.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/banco web/jsp/transferir-dinero")
public class TransferirDineroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CuentaDAO cuentaDAO;

    public void init() {
        cuentaDAO = new CuentaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCuentaOrigen = Integer.parseInt(request.getParameter("idCuentaOrigen"));
        int idCuentaDestino = Integer.parseInt(request.getParameter("idCuentaDestino"));
        int monto = Integer.parseInt(request.getParameter("monto"));

        try {
            cuentaDAO.transferirDinero(idCuentaOrigen, idCuentaDestino, monto);
            response.sendRedirect("transferencia-exitosa.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("transferencia-fallida.jsp");
        }

    }
}
