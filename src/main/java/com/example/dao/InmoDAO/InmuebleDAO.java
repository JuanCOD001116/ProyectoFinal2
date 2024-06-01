package com.example.dao.InmoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Inmo.Inmueble;

public class InmuebleDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/prueba";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    // Sentencias SQL
    private static final String INSERTAR_INMUEBLE = "INSERT INTO inmuebles (direccion, ciudad, estado, codigo_postal, precio, tipo, descripcion, propietario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_INMUEBLE = "UPDATE inmuebles SET direccion = ?, ciudad = ?, estado = ?, codigo_postal = ?, precio = ?, tipo = ?, descripcion = ?, propietario = ? WHERE id_inmueble = ?";
    private static final String ELIMINAR_INMUEBLE = "DELETE FROM inmuebles WHERE id_inmueble = ?";
    private static final String OBTENER_INMUEBLE_POR_ID = "SELECT * FROM inmuebles WHERE id_inmueble = ?";
    private static final String OBTENER_TODOS_INMUEBLES = "SELECT * FROM inmuebles";
    
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

    // Método para insertar un inmueble
    public void insertarInmueble(Inmueble nuevoInmueble) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_INMUEBLE)) {
            pstmt.setString(1, nuevoInmueble.getDireccion());
            pstmt.setString(2, nuevoInmueble.getCiudad());
            pstmt.setString(3, nuevoInmueble.getEstado());
            pstmt.setString(4, nuevoInmueble.getCodigoPostal());
            pstmt.setDouble(5, nuevoInmueble.getPrecio());
            pstmt.setString(6, nuevoInmueble.getTipo());
            pstmt.setString(7, nuevoInmueble.getDescripcion());
            pstmt.setString(8, nuevoInmueble.getPropietario());
            
            pstmt.executeUpdate();
            System.out.println("Inmueble insertado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar inmueble: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para actualizar un inmueble
    public void actualizarInmueble(Inmueble inmueble) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(ACTUALIZAR_INMUEBLE)) {
            pstmt.setString(1, inmueble.getDireccion());
            pstmt.setString(2, inmueble.getCiudad());
            pstmt.setString(3, inmueble.getEstado());
            pstmt.setString(4, inmueble.getCodigoPostal());
            pstmt.setDouble(5, inmueble.getPrecio());
            pstmt.setString(6, inmueble.getTipo());
            pstmt.setString(7, inmueble.getDescripcion());
            pstmt.setString(8, inmueble.getPropietario());
            pstmt.setInt(9, inmueble.getIdInmueble());
            
            pstmt.executeUpdate();
            System.out.println("Inmueble actualizado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar inmueble: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para eliminar un inmueble
    public void eliminarInmueble(int idInmueble) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(ELIMINAR_INMUEBLE)) {
            pstmt.setInt(1, idInmueble);
            
            pstmt.executeUpdate();
            System.out.println("Inmueble eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar inmueble: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para obtener un inmueble por ID
    public Inmueble obtenerInmueblePorId(int idInmueble) {
        Inmueble inmueble = null;
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(OBTENER_INMUEBLE_POR_ID)) {
            pstmt.setInt(1, idInmueble);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                inmueble = new Inmueble();
                inmueble.setIdInmueble(rs.getInt("id_inmueble"));
                inmueble.setDireccion(rs.getString("direccion"));
                inmueble.setCiudad(rs.getString("ciudad"));
                inmueble.setEstado(rs.getString("estado"));
                inmueble.setCodigoPostal(rs.getString("codigo_postal"));
                inmueble.setPrecio(rs.getDouble("precio"));
                inmueble.setTipo(rs.getString("tipo"));
                inmueble.setDescripcion(rs.getString("descripcion"));
                inmueble.setPropietario(rs.getString("propietario"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener inmueble por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return inmueble;
    }

    // Método para obtener todos los inmuebles
    public List<Inmueble> obtenerTodosInmuebles() {
        List<Inmueble> inmuebles = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(OBTENER_TODOS_INMUEBLES);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Inmueble inmueble = new Inmueble();
                inmueble.setIdInmueble(rs.getInt("id_inmueble"));
                inmueble.setDireccion(rs.getString("direccion"));
                inmueble.setCiudad(rs.getString("ciudad"));
                inmueble.setEstado(rs.getString("estado"));
                inmueble.setCodigoPostal(rs.getString("codigo_postal"));
                inmueble.setPrecio(rs.getDouble("precio"));
                inmueble.setTipo(rs.getString("tipo"));
                inmueble.setDescripcion(rs.getString("descripcion"));
                inmueble.setPropietario(rs.getString("propietario"));
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los inmuebles: " + e.getMessage());
            e.printStackTrace();
        }
        return inmuebles;
    }
}