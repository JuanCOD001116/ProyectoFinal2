package com.example.servlets;

import com.example.dao.UsuarioInmoDAO;
import com.example.model.Usuario;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/IniciarSesion/login1")
public class LoginUsuarioServlet extends HttpServlet {

    private UsuarioInmoDAO usuarioInmoDAO;

    public void init() {
        usuarioInmoDAO = new UsuarioInmoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String contraseña = request.getParameter("password");

        Usuario usuario = usuarioInmoDAO.verificarCredenciales(email, contraseña);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("../initialPageInmo.jsp");// aqui antes estaba principal.jsp, estaba dashboard.jsp
        } else {
            response.sendRedirect("loginInmo.jsp?error=Invalid email or password");
        }
    }
}