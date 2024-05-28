package com.example.servlets;

import com.example.dao.UsuarioInmoDAO;
import com.example.model.UsuarioInmo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginUsuarioServlet extends HttpServlet {

    private UsuarioInmoDAO usuarioInmoDAO;

    public void init() {
        usuarioInmoDAO = new UsuarioInmoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String contraseña = request.getParameter("password");

        UsuarioInmo usuario = usuarioInmoDAO.verificarCredenciales(email, contraseña);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("principal.jsp");
        } else {
            response.sendRedirect("loginInmo.jsp?error=Invalid email or password");
        }
    }
}