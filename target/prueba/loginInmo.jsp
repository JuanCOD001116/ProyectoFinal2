<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Inmobiliaria</title>
    <link rel="stylesheet" href="styleLoginInmo.css">
</head>
<body>
    <div class="loginview">
        <div class="login-panel">
            <div class="labels">
                <h3>Iniciar Sesión</h3>
            </div>
            <div class="fields">
                <form action="login" method="post">
                    <div class="v-slot">
                        <input type="text" name="username" placeholder="Usuario" required>
                    </div>
                    <div class="v-slot">
                        <input type="password" name="password" placeholder="Contraseña" required>
                    </div>
                    <div class="v-slot">
                        <button type="submit">Entrar</button>
                    </div>
                </form>
                <div class="v-slot">
                    <button onclick="history.back()">Regresar</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>