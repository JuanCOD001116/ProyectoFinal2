<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Transacción</title>
    <link rel="stylesheet" type="text/css" href="banco web/menu.css">
    <link rel="stylesheet" type="text/css" href="transaccion.css">
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h1>Banco JSP</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="#">Cuentas</a></li>
                <li><a href="#">Transferencias</a></li>
                <li><a href="#">Pagos</a></li>
                <li><a href="#">Perfil</a></li>
                <li><a href="#">Salir</a></li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="transaction-form">
            <h3>Registrar Nueva Transacción</h3>
            <form action="transaccion" method="post">
                <div class="form-group">
                    <label for="id_transaccion">ID Transacción:</label>
                    <input type="number" id="id_transaccion" name="id_transaccion" required>
                </div>
                <div class="form-group">
                    <label for="numero_cuenta_entrante">Número Cuenta Entrante:</label>
                    <input type="number" id="numero_cuenta_entrante" name="numero_cuenta_entrante" required>
                </div>
                <div class="form-group">
                    <label for="numero_cuenta_saliente">Número Cuenta Saliente:</label>
                    <input type="number" id="numero_cuenta_saliente" name="numero_cuenta_saliente" required>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="datetime-local" id="fecha" name="fecha" required>
                </div>
                <div class="form-group">
                    <label for="monto">Monto:</label>
                    <input type="number" step="0.01" id="monto" name="monto" required>
                </div>
                <div class="form-group">
                    <button type="submit">Registrar</button>
                </div>
            </form>
            <div class="form-group">
                <button onclick="window.history.back();">Regresar</button>
            </div>
        </div>
    </div>
</body>
</html>
