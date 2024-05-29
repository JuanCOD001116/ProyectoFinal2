package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.UsuarioInmo;

public class UsuarioInmoDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/prueba";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    // Sentencias SQL
    private static final String INSERTAR_USUARIO = "INSERT INTO USERINMO (id_usuario, nombre, apellido, email, telefono, direccion, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_USUARIO_ID = "SELECT * FROM USERINMO WHERE id_usuario = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM USERINMO";
    private static final String ELIMINAR_USUARIO = "DELETE FROM USERINMO WHERE id_usuario = ?";
    private static final String ACTUALIZAR_USUARIO = "UPDATE USERINMO SET nombre = ?, apellido = ?, email = ?, telefono = ?, direccion = ?, contraseña = ? WHERE id_usuario = ?";

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

    // Método para insertar un usuario
    public void insertarUsuario(UsuarioInmo nuevoUsuario) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_USUARIO)) {
            pstmt.setInt(1, nuevoUsuario.getId_usuario());
            pstmt.setString(2, nuevoUsuario.getNombre());
            pstmt.setString(3, nuevoUsuario.getApellido());
            pstmt.setString(4, nuevoUsuario.getEmail());
            pstmt.setString(5, nuevoUsuario.getTelefono());
            pstmt.setString(6, nuevoUsuario.getDireccion());
            pstmt.setString(7, nuevoUsuario.getPassword());
            
            pstmt.executeUpdate();
            System.out.println("Usuario insertado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public UsuarioInmo seleccionarUsuarioPorId(int idUsuario) {
        UsuarioInmo usuario = null;
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(SELECCIONAR_USUARIO_ID)) {
            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String email = rs.getString("email");
                    String telefono = rs.getString("telefono");
                    String direccion = rs.getString("direccion");
                    String password = rs.getString("password");
                    

                    usuario = new UsuarioInmo(idUsuario, nombre, apellido, email, telefono, direccion, password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    public List<UsuarioInmo> seleccionarTodosLosUsuarios() {
        List<UsuarioInmo> usuarios = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(SELECCIONAR_TODOS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String contraseña = rs.getString("contraseña");

                UsuarioInmo usuario = new UsuarioInmo(idUsuario, nombre, apellido, email, telefono, direccion, contraseña);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean eliminarUsuario(int idUsuario) {
        boolean filaEliminada = false;
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(ELIMINAR_USUARIO)) {
            pstmt.setInt(1, idUsuario);

            filaEliminada = pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return filaEliminada;
    }

    public boolean actualizarUsuario(UsuarioInmo usuario) {
        boolean filaActualizada = false;
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(ACTUALIZAR_USUARIO)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getTelefono());
            pstmt.setString(5, usuario.getDireccion());
            pstmt.setString(6, usuario.getPassword());
            pstmt.setInt(7, usuario.getId_usuario());

            filaActualizada = pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return filaActualizada;
    }

    public UsuarioInmo verificarCredenciales(String email, String password) {
        UsuarioInmo usuario = null;
        String query = "SELECT * FROM USERINMO WHERE email = ? AND password = ?";
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
    
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int idUsuario = rs.getInt("id_usuario");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String telefono = rs.getString("telefono");
                    String direccion = rs.getString("direccion");
                    usuario = new UsuarioInmo(idUsuario, nombre, apellido, email, telefono, direccion, password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }



    // Otros métodos para seleccionar, eliminar y actualizar usuarios pueden ser implementados aquí
}