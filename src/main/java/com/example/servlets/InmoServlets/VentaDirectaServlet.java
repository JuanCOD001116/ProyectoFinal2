package com.example.servlets.InmoServlets;

import com.example.dao.InmoDAO.VentaDAO;
import com.example.model.Inmo.Venta;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InmoWeb/jsp/ventaDirectaServlet")
public class VentaDirectaServlet extends HttpServlet {

    private VentaDAO ventaDAO;

    public void init() {
        ventaDAO = new VentaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idInmueble = Integer.parseInt(request.getParameter("idInmueble"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        String moneda = request.getParameter("moneda");

        Venta venta = new Venta(idInmueble, idUsuario, precio, moneda, new Date());

        try {
            ventaDAO.insertarVenta(venta);
            response.sendRedirect("../../success.jsp?success=Venta registrada exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ventaDirecta.jsp?error=Error al registrar la venta");
        }
    }
}
