<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Matricula del Inmueble</title>
</head>
<body>
    <h2>Registrar Matricula del Inmueble</h2>
    <form action="RegistrarMatriculaServlet" method="post">
        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br>
        <label for="propietario">Propietario:</label>
        <input type="text" id="propietario" name="propietario" required><br>
        <label for="valor">Valor:</label>
        <input type="number" id="valor" name="valor" required><br>
        <button type="submit">Registrar</button>
    </form>
    <button onclick="window.history.back()">Regresar</button>
</body>
</html>