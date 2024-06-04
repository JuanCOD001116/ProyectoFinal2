<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banco JSP</title>
    <link rel="stylesheet" type="text/css" href="../css/menu.css">
    <link rel="stylesheet" href="../css/cuenta.css">
    <style>
        
    </style>
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
    <div class="content">
        <h1>Asignar Cuenta</h1>
        <form action="asignarcuenta" method="post">
            <label for="idUsuario">ID Usuario:</label>
            <input type="number" id="idUsuario" name="idUsuario" required>
            <br>
            <label for="saldo">Saldo Inicial:</label>
            <input type="number" id="saldo" name="saldo" required>
            <br>
            <input type="submit" value="Asignar Cuenta">
        </form>
    </div>
</body>
</html>