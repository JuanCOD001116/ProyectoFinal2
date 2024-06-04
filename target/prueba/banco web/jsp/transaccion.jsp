<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Transacción</title>
    <link rel="stylesheet" type="text/css" href="banco web/menu.css">
    <link rel="stylesheet" type="text/css" href="../css/transaccion.css">
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h1>Banco JSP</h1>
        </div>
        <div class="menu">
            <ul>
                <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banco JSP</title>
    <link rel="stylesheet" type="text/css" href="../css/menu.css">
    <script src="script.js"></script>
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h1>Banco JSP</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="./inicioBanco.jsp">Inicio</a></li>
                <li><a href="./cuenta-asignada.jsp">Cuentas</a></li>
                <li><a href="./transaccion.jsp">Transferencias</a></li>
                <li><a href="./Politicas.jsp">Políticas</a></li>
                <li><a href="./TCP.jsp">Transacciones Hechas</a></li>
                <li><a href="../../initialPageInmo.jsp">Salir</a></li>
            </ul>
        </div>
    </div>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="transaction-form">
            <h3>Registrar Nueva Transacción</h3>
            <form action="transferirdinero" method="post">
                <div class="form-group">
                    <label for="idCuentaOrigen">Número Cuenta Origen:</label>
                    <input type="number" id="idCuentaOrigen" name="idCuentaOrigen" required>
                </div>
                <div class="form-group">
                    <label for="idCuentaDestino">Número Cuenta Destino:</label>
                    <input type="number" id="idCuentaDestino" name="idCuentaDestino" required>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="datetime-local" id="fecha" name="fecha" required>
                </div>
                <div class="form-group">
                    <label for="monto">Monto a Transferir:</label>
                    <input type="number" id="monto" name="monto" required>
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
