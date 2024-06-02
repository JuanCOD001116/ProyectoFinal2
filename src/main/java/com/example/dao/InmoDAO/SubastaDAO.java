package com.example.dao.InmoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Inmo.Subasta;

public class SubastaDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/prueba";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    // Sentencias SQL
    private static final String INSERTAR_SUBASTA = "INSERT INTO subastas (id_inmueble, id_usuario, precio_inicial, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_OFERTA = "UPDATE subastas SET precio_actual = ?, id_ganador = ? WHERE id_subasta = ?";
    private static final String OBTENER_SUBASTAS_ACTIVAS = "SELECT * FROM subastas WHERE fecha_fin > NOW()";
    private static final String OBTENER_SUBASTA_POR_ID = "SELECT * FROM subastas WHERE id_subasta = ?";

    // Método para obtener la conexión
    protected Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para insertar una subasta
    public void insertarSubasta(Subasta subasta) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_SUBASTA)) {
            pstmt.setInt(1, subasta.getIdInmueble());
            pstmt.setInt(2, subasta.getIdUsuario());
            pstmt.setDouble(3, subasta.getPrecioInicial());
            pstmt.setDate(4, new java.sql.Date(subasta.getFechaInicio().getTime()));
            pstmt.setDate(5, new java.sql.Date(subasta.getFechaFin().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una oferta
    public void actualizarOferta(int idSubasta, double precioActual, int idGanador) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(ACTUALIZAR_OFERTA)) {
            pstmt.setDouble(1, precioActual);
            pstmt.setInt(2, idGanador);
            pstmt.setInt(3, idSubasta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener subastas activas
    public List<Subasta> obtenerSubastasActivas() {
        List<Subasta> subastas = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(OBTENER_SUBASTAS_ACTIVAS);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Subasta subasta = new Subasta(
                        rs.getInt("id_inmueble"),
                        rs.getInt("id_usuario"),
                        rs.getDouble("precio_inicial"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin")
                );
                subasta.setIdSubasta(rs.getInt("id_subasta"));
                subasta.setPrecioActual(rs.getDouble("precio_actual"));
                subasta.setIdGanador(rs.getInt("id_ganador"));
                subastas.add(subasta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subastas;
    }

    // Método para obtener una subasta por ID
    public Subasta obtenerSubastaPorId(int idSubasta) {
        Subasta subasta = null;
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(OBTENER_SUBASTA_POR_ID)) {
            pstmt.setInt(1, idSubasta);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    subasta = new Subasta(
                            rs.getInt("id_inmueble"),
                            rs.getInt("id_usuario"),
                            rs.getDouble("precio_inicial"),
                            rs.getDate("fecha_inicio"),
                            rs.getDate("fecha_fin")
                    );
                    subasta.setIdSubasta(rs.getInt("id_subasta"));
                    subasta.setPrecioActual(rs.getDouble("precio_actual"));
                    subasta.setIdGanador(rs.getInt("id_ganador"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subasta;
    }
}