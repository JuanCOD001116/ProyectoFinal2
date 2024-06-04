<%@ page contentType="text/html; charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultados de Ventas por Usuario</title>
    <link rel="stylesheet" href="../css/stylesDashboard.css">
</head>
<body>
    <h2>Resultados de Ventas por Usuario</h2>
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
                <td>${venta.idImueble}</td>
                <td>${venta.direccion}</td>
                <td>${venta.ciudad}</td>
                <td>${venta.estado}</td>
                <td>${venta.codigoPostal}</td>
                <td>${venta.precio}</td>
                <td>${venta.tipo}</td>
                <td>${venta.descripcion}</td>
                <td>${venta.propietario}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="ventasUsuario.jsp">Regresar</a>
</body>
</html>