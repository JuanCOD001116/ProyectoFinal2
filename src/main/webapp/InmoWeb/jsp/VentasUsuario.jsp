<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ventas por Usuario</title>
</head>
<body>
    <h2>Ventas por Usuario</h2>
    <form action="ventasUsuario" method="post">
        <label for="idUsuario">ID del Usuario:</label>
        <input type="text" id="idUsuario" name="idUsuario" required>
        <button type="submit">Buscar</button>
    </form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Dirección</th>
            <th>Ciudad</th>
            <th>Estado</th>
            <th>Código Postal</th>
            <th>Precio</th>
            <th>Tipo</th>
            <th>Descripción</th>
            <th>Propietario</th>
        </tr>
            <c:forEach var="venta" items="${ventas}">
                <tr>
                    <td>${venta.id_inmueble}</td>
                    <td>${venta.direccion}</td>
                    <td>${venta.ciudad}</td>
                    <td>${venta.estado}</td>
                    <td>${venta.codigo_postal}</td>
                    <td>${venta.precio}</td>
                    <td>${venta.tipo}</td>
                    <td>${venta.descripcion}</td>
                    <td>${venta.propietario}</td>
                </tr>
            </c:forEach>
    </table>
    <a href="index.jsp">Regresar</a>
</body>
</html>