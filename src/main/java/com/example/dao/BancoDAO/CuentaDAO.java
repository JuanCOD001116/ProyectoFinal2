package com.example.dao.BancoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.banco.Cuenta;
import com.example.TestConnection.ConexionBD;

public class CuentaDAO {

    private static final String INSERT_CUENTA_SQL = "INSERT INTO cuentas (saldo, id_cuenta, id_usuario) VALUES (?, ?, ?)";
    private static final String SELECT_CUENTA_BY_ID = "SELECT * FROM cuentas WHERE id_cuenta = ?";
    private static final String SELECT_CUENTA_BY_USUARIO_ID = "SELECT * FROM cuentas WHERE id_usuario = ?";
    private static final String UPDATE_SALDO_SQL = "UPDATE cuentas SET saldo = ? WHERE id_cuenta = ?";
    private static final String SELECT_SALDO_BY_ID = "SELECT saldo FROM cuentas WHERE id_cuenta = ?";

    public void insertarCuenta(Cuenta cuenta) throws SQLException {
        try (Connection connection = ConexionBD.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUENTA_SQL)) {
            preparedStatement.setInt(1, cuenta.getSaldo());
            preparedStatement.setInt(3, cuenta.getIdUsuario());
            int id_Cuenta = (int) (Math.random()*100000000);
            preparedStatement.setInt(2, id_Cuenta);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en CuentaDAO.insertarCuenta: " + e.getMessage());
        }
    }

    public Cuenta seleccionarCuentaPorId(int idCuenta) {
        Cuenta cuenta = null;
        try (Connection connection = ConexionBD.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUENTA_BY_ID)) {
            preparedStatement.setInt(1, idCuenta);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                int saldo = rs.getInt("saldo");
                cuenta = new Cuenta(idUsuario, saldo);
                cuenta.setIdCuenta(idCuenta);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar la cuenta" + e.getMessage());
        }
        return cuenta;
    }

    public Cuenta seleccionarCuentaPorUsuarioId(int idUsuario) {
        Cuenta cuenta = null;
        try (Connection connection = ConexionBD.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUENTA_BY_USUARIO_ID)) {
            preparedStatement.setInt(1, idUsuario);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCuenta = rs.getInt("id_cuenta");
                int saldo = rs.getInt("saldo");
                cuenta = new Cuenta(idUsuario, saldo);
                cuenta.setIdCuenta(idCuenta);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar la cuenta" + e.getMessage());
        }
        return cuenta;
    }

    public void actualizarSaldo(int idCuenta, int saldo) throws SQLException {
        try (Connection connection = ConexionBD.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SALDO_SQL)) {
            preparedStatement.setInt(1, saldo);
            preparedStatement.setInt(2, idCuenta);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar saldo" + e.getMessage());
        }
    }

    public void transferirDinero(int idCuentaOrigen, int idCuentaDestino, int monto) throws SQLException {
        Connection connection = null;
        PreparedStatement actualizarCuentaOrigen = null;
        PreparedStatement actualizarCuentaDestino = null;

        try {
            connection = ConexionBD.getConnection();
            connection.setAutoCommit(false);

            // Obtener saldo de la cuenta origen
            int saldoOrigen = obtenerSaldo(connection, idCuentaOrigen);

            // Obtener saldo de la cuenta destino
            int saldoDestino = obtenerSaldo(connection, idCuentaDestino);

            // Verificar que haya suficiente dinero en la cuenta origen
            if (saldoOrigen < monto) {
                throw new SQLException("Saldo insuficiente en la cuenta origen.");
            }

            // Actualizar saldos
            actualizarCuentaOrigen = connection.prepareStatement(UPDATE_SALDO_SQL);
            actualizarCuentaDestino = connection.prepareStatement(UPDATE_SALDO_SQL);

            actualizarCuentaOrigen.setInt(1, saldoOrigen - monto);
            actualizarCuentaOrigen.setInt(2, idCuentaOrigen);

            actualizarCuentaDestino.setInt(1, saldoDestino + monto);
            actualizarCuentaDestino.setInt(2, idCuentaDestino);

            actualizarCuentaOrigen.executeUpdate();
            actualizarCuentaDestino.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (actualizarCuentaOrigen != null) {
                actualizarCuentaOrigen.close();
            }
            if (actualizarCuentaDestino != null) {
                actualizarCuentaDestino.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }

    private int obtenerSaldo(Connection connection, int idCuenta) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SALDO_BY_ID)) {
            preparedStatement.setInt(1, idCuenta);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("saldo");
            }
        }
        throw new SQLException("Cuenta no encontrada.");
    }
}
