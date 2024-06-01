<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Asignar Cuenta</title>
</head>
<body>
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
</body>
</html>
