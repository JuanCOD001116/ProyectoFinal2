<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Subasta</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Registrar Subasta de Inmueble</h2>
        <form action="subasta" method="post">
            <div class="form-group">
                <label for="idInmueble">ID del Inmueble:</label>
                <input type="text" id="idInmueble" name="idInmueble" required>
            </div>
            <div class="form-group">
                <label for="idUsuario">ID del Usuario (Vendedor):</label>
                <input type="text" id="idUsuario" name="idUsuario" required>
            </div>
            <div class="form-group">
                <label for="precioInicial">Precio Inicial:</label>
                <input type="text" id="precioInicial" name="precioInicial" required>
            </div>
            <div class="form-group">
                <label for="fechaInicio">Fecha de Inicio:</label>
                <input type="date" id="fechaInicio" name="fechaInicio" required>
            </div>
            <div class="form-group">
                <label for="fechaFin">Fecha de Fin:</label>
                <input type="date" id="fechaFin" name="fechaFin" required>
            </div>
            <button type="submit">Registrar Subasta</button>
        </form>
        <a href="dashboard.jsp">Regresar</a>
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