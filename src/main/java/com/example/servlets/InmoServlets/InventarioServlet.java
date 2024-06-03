package com.example.servlets.InmoServlets;

import com.example.dao.InmoDAO.InmuebleDAO;
import com.example.model.Inmo.Inmueble;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InmoWeb/jsp/inmuebles")
public class InventarioServlet extends HttpServlet {

    private InmuebleDAO inmuebleDAO;

    public void init() {
        inmuebleDAO = new InmuebleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Inmueble> inmuebles = inmuebleDAO.obtenerTodosInmuebles();
        request.setAttribute("inmuebles", inmuebles);
        request.getRequestDispatcher("inventario.jsp").forward(request, response);
    }
}