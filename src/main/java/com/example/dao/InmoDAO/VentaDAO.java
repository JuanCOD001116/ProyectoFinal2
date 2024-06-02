package com.example.dao.InmoDAO;

import com.example.model.Inmo.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentaDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/prueba";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    // Sentencias SQL
    private static final String INSERTAR_VENTA = "INSERT INTO ventas (id_inmueble, id_usuario, precio, moneda, fecha_venta) VALUES (?, ?, ?, ?, ?)";

    // Método para obtener la conexión
    protected Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para insertar una venta
    public void insertarVenta(Venta venta) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_VENTA)) {
            pstmt.setInt(1, venta.getIdInmueble());
            pstmt.setInt(2, venta.getIdUsuario());
            pstmt.setDouble(3, venta.getPrecio());
            pstmt.setString(4, venta.getMoneda());
            pstmt.setDate(5, new java.sql.Date(venta.getFechaVenta().getTime()));

            pstmt.executeUpdate();
            System.out.println("Venta registrada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
            e.printStackTrace();
        }
    }
}