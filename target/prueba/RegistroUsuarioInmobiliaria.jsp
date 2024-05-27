<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario - Inmobiliaria</title>
    <link rel="stylesheet" href="stylesRegistry.css">
</head>
<body>
    <div class="loginview">
        <div class="login-panel">
            <div class="labels">
                <h3 class="h3">Registrar Nuevo Usuario</h3>
            </div>
            <div class="fields">
                <form action="register" method="post">
                    <div class="v-slot">
                        <input type="text" name="username" placeholder="Nombre de Usuario" required>
                    </div>
                    <div class="v-slot">
                        <input type="password" name="password" placeholder="Contraseña" required>
                    </div>
                    <div class="v-slot">
                        <input type="password" name="confirm_password" placeholder="Confirmar Contraseña" required>
                    </div>
                    <div class="v-slot">
                        <input type="email" name="email" placeholder="Correo Electrónico" required>
                    </div>
                    <div class="v-slot">
                        <button type="submit">Registrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>