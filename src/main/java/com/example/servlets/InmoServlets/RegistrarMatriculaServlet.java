package com.example.servlets.InmoServlets;

import com.example.dao.InmoDAO.MatriculaDAO;
import com.example.model.Inmo.Matricula;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarMatriculaServlet")
public class RegistrarMatriculaServlet extends HttpServlet {

    private MatriculaDAO matriculaDAO;

    public void init() {
        matriculaDAO = new MatriculaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String direccion = request.getParameter("direccion");
        String propietario = request.getParameter("propietario");
        int valor = Integer.parseInt(request.getParameter("valor"));

        Matricula matricula = new Matricula(direccion, propietario, valor);

        try {
            matriculaDAO.insertarMatricula(matricula);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("matricula.jsp?error=Error al registrar la matrícula");
        }
    }
}
