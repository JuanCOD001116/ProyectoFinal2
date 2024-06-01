<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario - Inmobiliaria</title>
    <link rel="stylesheet" href="./stylesRegistry.css">
    <script>
        function validarFormulario() {
            var password = document.forms["registerForm"]["password"].value;
            var confirmPassword = document.forms["registerForm"]["confirm_password"].value;
            if (password !== confirmPassword) {
                alert("Las contraseñas no coinciden");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div class="loginview">
        <div class="login-panel">
            <div class="labels">
                <h3 class="h3">Registrar Nuevo Usuario</h3>
            </div>
            <div class="fields">
                <form name="registerForm" action="register" method="post" onsubmit="return validarFormulario()">
                    <div class="v-slot">
                        <input type="text" name="id_usuario" placeholder="ID de Usuario" required>
                    </div>
                    <div class="v-slot">
                        <input type="text" name="nombre" placeholder="Nombre" required>
                    </div>
                    <div class="v-slot">
                        <input type="text" name="apellido" placeholder="Apellido" required>
                    </div>
                    <div class="v-slot">
                        <input type="email" name="email" placeholder="Correo Electrónico" required>
                    </div>
                    <div class="v-slot">
                        <input type="text" name="telefono" placeholder="Teléfono" required>
                    </div>
                    <div class="v-slot">
                        <input type="text" name="direccion" placeholder="Dirección" required>
                    </div>
                    <div class="v-slot">
                        <input type="password" name="password" placeholder="Contraseña" required>
                    </div>
                    <div class="v-slot">
                        <input type="password" name="confirm_password" placeholder="Confirmar Contraseña" required>
                    </div>
                    <div class="v-slot">
                        <button type="submit">Registrar</button>
                    </div>
                </form>
                <div class="v-slot">
                <a href="../index.jsp">
                    <button>Regresar</button>
                </a>
                </div>
                <div>
                    <c:if test="${not empty param.error}">
                        
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>