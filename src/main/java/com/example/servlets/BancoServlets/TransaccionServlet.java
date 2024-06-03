package com.example.servlets.BancoServlets;

import com.example.dao.BancoDAO.TransaccionDAO;
import com.example.model.banco.Transaccion;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/banco web/jsp/transaccion")
public class TransaccionServlet extends HttpServlet {
    private static final long serialVersionUID = 4L;
    private TransaccionDAO transaccionDAO;

    public void init() {
        transaccionDAO = new TransaccionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            int idTransaccion = Integer.parseInt(request.getParameter("id_transaccion"));
            int numeroCuentaEntrante = Integer.parseInt(request.getParameter("numero_cuenta_entrante"));
            int numeroCuentaSaliente = Integer.parseInt(request.getParameter("numero_cuenta_saliente"));
            Timestamp fecha = Timestamp.valueOf(request.getParameter("fecha").replace("T", " ") + ":00");
            float monto = Float.parseFloat(request.getParameter("monto"));

            // Crear un nuevo objeto Transaccion con los datos del formulario
            Transaccion nuevaTransaccion = new Transaccion(idTransaccion, numeroCuentaEntrante, numeroCuentaSaliente, fecha, monto);

            // Insertar la nueva transacción en la base de datos
            transaccionDAO.insertarTransaccion(nuevaTransaccion);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("transaccion.jsp?error=Error al registrar la transacción");
        }
    }
    protected void Transaccion(){
    

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    TransaccionDAO transaccionDAO = new TransaccionDAO();
    int idCuentaOrigen = Integer.parseInt(request.getParameter("id_cuenta_origen"));
    Timestamp fecha_inicio = Timestamp.valueOf(request.getParameter("fecha_inicio").replace("T", " ") + ":00");
    Timestamp fecha_final = Timestamp.valueOf(request.getParameter("fecha_final").replace("T", " ") + ":00");
    List<Transaccion> transacciones = new ArrayList<>();
    transacciones = transaccionDAO.seleccionarTransaccionCO(idCuentaOrigen, fecha_inicio, fecha_final);
    System.out.println(transacciones);
    request.setAttribute("transacciones", transacciones);
    request.getRequestDispatcher("./TCP.jsp").forward(request, response);
      }

}