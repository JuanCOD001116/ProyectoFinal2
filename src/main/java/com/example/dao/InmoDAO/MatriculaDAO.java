package com.example.dao.InmoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.example.model.Inmo.Matricula;

public class MatriculaDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/prueba";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    // Sentencias SQL
    private static final String INSERTAR_MATRICULA = "INSERT INTO matricula (direccion, propietario, valor) VALUES (?, ?, ?)";
    
    // Método para obtener la conexión
    protected Connection getConnection() {
        Connection conexion = null;
        try {
            // Importante esta línea para que el driver sepa que se va a conectar a una base de datos MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");
            // Le pasamos la URL de la base de datos, el usuario y la contraseña para conectarnos a la base de datos
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println(conexion);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para insertar una matrícula
    public void insertarMatricula(Matricula nuevaMatricula) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_MATRICULA)) {
            pstmt.setString(1, nuevaMatricula.getDireccion());
            pstmt.setString(2, nuevaMatricula.getPropietario());
            pstmt.setInt(3, nuevaMatricula.getValor());
            
            pstmt.executeUpdate();
            System.out.println("Matrícula insertada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar matrícula: " + e.getMessage());
            e.printStackTrace();
        }
    }
}