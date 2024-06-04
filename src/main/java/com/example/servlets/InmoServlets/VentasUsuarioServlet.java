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

@WebServlet("/InmoWeb/jsp/ventasUsuario")
public class VentasUsuarioServlet extends HttpServlet {

    private InmuebleDAO inmuebleDAO;

    public void init() {
        inmuebleDAO = new InmuebleDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            List<Inmueble> ventas = inmuebleDAO.listarVentasPorUsuario(idUsuario);
            System.out.println(ventas);
            request.setAttribute("ventas", ventas);
            request.setAttribute("test", "Hola");
            request.getRequestDispatcher("ventasUsuarioResultado.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("ventasUsuario.jsp?error=ID de usuario no válido");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ventasUsuario.jsp?error=Error al obtener ventas por usuario");
        }
    }
}