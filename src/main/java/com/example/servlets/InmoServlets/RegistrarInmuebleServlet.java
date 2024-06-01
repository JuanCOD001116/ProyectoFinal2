package com.example.servlets.InmoServlets;

import com.example.dao.InmoDAO.InmuebleDAO;
import com.example.model.Inmo.Inmueble;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InmoWeb/jsp/RegistrarInmuebleServlet")
public class RegistrarInmuebleServlet extends HttpServlet {

    private InmuebleDAO inmuebleDAO;

    public void init() {
        inmuebleDAO = new InmuebleDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String codigoPostal = request.getParameter("codigo_postal");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");
        String propietario = request.getParameter("propietario");

        Inmueble inmueble = new Inmueble(direccion, ciudad, estado, codigoPostal, precio, tipo, descripcion, propietario);

        try {
            inmuebleDAO.insertarInmueble(inmueble);
            response.sendRedirect("../../success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registroInmueble.jsp?error=Error al registrar el inmueble");
        }
    }
}