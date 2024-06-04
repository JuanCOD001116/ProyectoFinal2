<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Venta Directa de Inmueble</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Venta Directa de Inmueble</h2>
        <form action="ventaDirectaServlet" method="post">
            <div class="form-group">
                <label for="idInmueble">ID del Inmueble:</label>
                <input type="text" id="idInmueble" name="idInmueble" required>
            </div>
            <div class="form-group">
                <label for="idUsuario">ID del Comprador:</label>
                <input type="text" id="idUsuario" name="idUsuario" required>
            </div>
            <div class="form-group">
                <label for="precio">Precio de Venta:</label>
                <input type="text" id="precio" name="precio" required>
            </div>
            <div class="form-group">
                <label for="moneda">Moneda:</label>
                <select id="moneda" name="moneda">
                    <option value="EUR">Euros</option>
                    <option value="USD">Dólares</option>
                    <option value="MXN">Pesos</option>
                </select>
            </div>
            <button type="submit">Realizar Venta</button>
        </form>
        <a href="dashboard.jsp">Regresar a Inmuebles</a>
        <div>
            <c:if test="${not empty param.error}">
                <p class="error">${param.error}</p>
            </c:if>
            <c:if test="${not empty param.success}">
                <p class="success">${param.success}</p>
            </c:if>
        </div>
    </div>
</body>
</html>