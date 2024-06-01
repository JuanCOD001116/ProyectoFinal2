package com.example.servlets.BancoServlets;

import java.io.IOException;
import java.sql.SQLException;

import com.example.dao.BancoDAO.*;
import com.example.model.banco.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/banco web/jsp/asignarcuenta")
public class AsignarCuentaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private CuentaDAO cuentaDAO;

  public void init() {
    cuentaDAO = new CuentaDAO();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        System.out.println("hola");
    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
    int saldo = Integer.parseInt(request.getParameter("saldo"));
    Cuenta cuenta = new Cuenta(idUsuario, saldo);

    try {
      cuentaDAO.insertarCuenta(cuenta);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    response.sendRedirect("./inicibanco.jsp");
  }
}
