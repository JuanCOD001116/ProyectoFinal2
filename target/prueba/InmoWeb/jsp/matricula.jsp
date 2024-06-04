<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Inmueble</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="loginview">
        <div class="login-panel">
            <div class="labels">
                <h2>Registrar Inmueble</h2>
            </div>
            <div class="fields">
                <form action="RegistrarInmuebleServlet" method="post">
                    <div class="v-slot">
                        <label for="direccion">Dirección:</label>
                        <input type="text" id="direccion" name="direccion" required>
                    </div>
                    <div class="v-slot">
                        <label for="ciudad">Ciudad:</label>
                        <input type="text" id="ciudad" name="ciudad" required>
                    </div>
                    <div class="v-slot">
                        <label for="estado">Estado:</label>
                        <input type="text" id="estado" name="estado" required>
                    </div>
                    <div class="v-slot">
                        <label for="codigo_postal">Código Postal:</label>
                        <input type="text" id="codigo_postal" name="codigo_postal" required>
                    </div>
                    <div class="v-slot">
                        <label for="precio">Precio:</label>
                        <input type="number" step="0.01" id="precio" name="precio" required>
                    </div>
                    <div class="v-slot">
                        <label for="tipo">Tipo:</label>
                        <input type="text" id="tipo" name="tipo" required>
                    </div>
                    <div class="v-slot">
                        <label for="descripcion">Descripción:</label>
                        <textarea id="descripcion" name="descripcion" required></textarea>
                    </div>
                    <div class="v-slot">
                        <label for="propietario">Propietario:</label>
                        <input type="text" id="propietario" name="propietario" required>
                    </div>
                    <div class="v-slot">
                        <button type="submit">Registrar</button>
                    </div>
                </form>
                <button onclick="window.history.back()">Regresar</button>
            </div>
        </div>
    </div>
</body>
</html>