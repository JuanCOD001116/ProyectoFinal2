package com.example.servlets;

import com.example.dao.UsuarioInmoDAO;
import com.example.model.UsuarioInmo;
//import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistroUsuarioServlet extends HttpServlet {

    private UsuarioInmoDAO usuarioInmoDAO;

    public void init() {
        usuarioInmoDAO = new UsuarioInmoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String idUsuarioStr = request.getParameter("id_usuario");
        int idUsuario = Integer.parseInt(idUsuarioStr); // Convertir idUsuario a int
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String password = request.getParameter("password");
        String confirmContraseña = request.getParameter("confirm_password");

        // Validar que las contraseñas coincidan
        if (!password.equals(confirmContraseña)) {
            response.sendRedirect("register.jsp?error=Las contraseñas no coinciden");
            return;
        }

        // Encriptar la contraseña
        //String hashedPassword = BCrypt.hashpw(contraseña, BCrypt.gensalt());

        // Crear un nuevo objeto UsuarioInmo con los datos del formulario
        UsuarioInmo nuevoUsuario = new UsuarioInmo(idUsuario, nombre, apellido, email, telefono, direccion,password);
        
        // Insertar el nuevo usuario en la base de datos
        try {
            usuarioInmoDAO.insertarUsuario(nuevoUsuario);
            nuevoUsuario.toString();
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("+"+idUsuario+"+"+nombre+"+"+apellido+"+"+email+"+"+telefono+"+"+direccion+"+"+password);
            response.sendRedirect("registryInmo.jsp?error=Error al registrar el usuario");
        }
    }
}