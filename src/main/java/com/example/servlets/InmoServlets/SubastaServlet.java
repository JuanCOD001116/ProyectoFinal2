package com.example.servlets.InmoServlets;

import com.example.dao.InmoDAO.SubastaDAO;
import com.example.model.Inmo.Subasta;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InmoWeb/jsp/subasta")
public class SubastaServlet extends HttpServlet {

    private SubastaDAO subastaDAO;

    public void init() {
        subastaDAO = new SubastaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("subasta.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idInmuebleStr = request.getParameter("idInmueble");
        String idUsuarioStr = request.getParameter("idUsuario");
        String precioInicialStr = request.getParameter("precioInicial");
        String fechaInicioStr = request.getParameter("fechaInicio");
        String fechaFinStr = request.getParameter("fechaFin");

        int idInmueble = Integer.parseInt(idInmuebleStr);
        int idUsuario = Integer.parseInt(idUsuarioStr);
        double precioInicial = Double.parseDouble(precioInicialStr);
        Date fechaInicio = java.sql.Date.valueOf(fechaInicioStr);
        Date fechaFin = java.sql.Date.valueOf(fechaFinStr);

        Subasta subasta = new Subasta(idInmueble, idUsuario, precioInicial, fechaInicio, fechaFin);

        try {
            subastaDAO.insertarSubasta(subasta);
            response.sendRedirect("../../success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("subasta.jsp?error=Error al registrar la subasta");
        }
    }
}
