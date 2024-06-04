<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inventario de Inmuebles</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h2>Inventario de Inmuebles</h2>
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
        <c:forEach var="inmueble" items="${inmuebles}">
            <tr>
                <td>${inmueble.idInmueble}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.ciudad}</td>
                <td>${inmueble.estado}</td>
                <td>${inmueble.codigoPostal}</td>
                <td>${inmueble.precio}</td>
                <td>${inmueble.tipo}</td>
                <td>${inmueble.descripcion}</td>
                <td>${inmueble.propietario}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="dashboard.jsp">Regresar</a>
</body>
</html>