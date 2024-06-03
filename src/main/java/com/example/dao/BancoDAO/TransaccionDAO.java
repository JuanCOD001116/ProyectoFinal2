package com.example.dao.BancoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//hello
//....
import com.example.model.Usuario;
import com.example.model.banco.Transaccion;

public class TransaccionDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/prueba";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    // Sentencias SQL
    private static final String INSERTAR_TRANSACCION = "INSERT INTO TRANSACCION (id_transaccion, id_cuenta_origen, id_cuenta_saliente, fecha, monto) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_TRANSACCION_ID = "SELECT * FROM TRANSACCION WHERE id_transaccion = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM TRANSACCION";
    private static final String ELIMINAR_TRANSACCION = "DELETE FROM TRANSACCION WHERE id_transaccion = ?";
    private static final String ACTUALIZAR_TRANSACCION = "UPDATE USERINMO SET id_transaccion = ?, id_cuenta_origen = ?, id_cuenta_saliente = ?, fecha = ?, monto = ? WHERE id_transaccion = ?";
    private static final String SELECCIONAR_TRANSACCION_FECHA = "SELECT * FROM transaccion WHERE id_cuenta_origen =? AND fecha BETWEEN? AND?";
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
    public void insertarTransaccion(Transaccion nuevoTransaccion) {
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_TRANSACCION)) {
            pstmt.setInt(1, nuevoTransaccion.getId_transaccion());
            pstmt.setInt(2, nuevoTransaccion.getNumero_cuenta_entrante());
            pstmt.setInt(3, nuevoTransaccion.getNumero_cuenta_saliente());
            pstmt.setTimestamp(4, nuevoTransaccion.getFecha());
            pstmt.setFloat(5, nuevoTransaccion.getMonto());
            
            pstmt.executeUpdate();
            System.out.println("Transaccion insertada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar transaccion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Transaccion> seleccionarTransaccionCO(int idCuentaOrigen, Timestamp fecha_inicio, Timestamp fecha_final ) {

    List<Transaccion> transaciones= new ArrayList<>();
    try (Connection conexion = getConnection();
    PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TRANSACCION_FECHA)) {
        preparedStatement.setInt(1, idCuentaOrigen);
        preparedStatement.setTimestamp(2, fecha_inicio);
        preparedStatement.setTimestamp(3, fecha_final);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
          Transaccion transaccion = new Transaccion();
          transaccion.setId_transaccion(resultSet.getInt("id_transaccion"));
          transaccion.setNumero_cuenta_entrante(resultSet.getInt("id_cuenta_origen"));
          transaccion.setNumero_cuenta_saliente(resultSet.getInt("id_cuenta_saliente"));
          transaccion.setFecha(resultSet.getTimestamp("fecha"));
          transaccion.setMonto(resultSet.getInt("monto"));
          transaciones.add(transaccion);
        }
      } catch (SQLException e) {
        System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
      }
      return transaciones;
    }

    public List<Usuario> seleccionarTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
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

                Usuario usuario = new Usuario(idUsuario, nombre, apellido, email, telefono, direccion, contraseña);
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
             PreparedStatement pstmt = conexion.prepareStatement(ELIMINAR_TRANSACCION)) {
            pstmt.setInt(1, idUsuario);

            filaEliminada = pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return filaEliminada;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        boolean filaActualizada = false;
        try (Connection conexion = getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(ACTUALIZAR_TRANSACCION)) {
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

    public Usuario verificarCredenciales(String email, String password) {
        Usuario usuario = null;
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
                    usuario = new Usuario(idUsuario, nombre, apellido, email, telefono, direccion, password);
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