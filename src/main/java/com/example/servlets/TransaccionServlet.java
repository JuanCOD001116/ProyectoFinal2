package com.example.servlets;

import com.example.dao.TransaccionDAO;
import com.example.dao.UsuarioInmoDAO;
import com.example.banco.Transaccion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class TransaccionServlet extends HttpServlet {

    private TransaccionDAO transaccionDAO;

    public void init() {
        transaccionDAO = new TransaccionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String contraseña = request.getParameter("password");

        Usuario usuario = transaccionDAO.verificarCredenciales(email, contraseña);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("principal.jsp");
        } else {
            response.sendRedirect("loginInmo.jsp?error=Invalid email or password");
        }
    }
}