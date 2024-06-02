<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transferencia Exitosa</title>
    <link rel="stylesheet" href="../../Registro/stylesRegistry.css">
    <script>
      // Función para redireccionar a la página principal
      function redireccionar() {
        setTimeout(function () {
          window.location.href = "./inicioBanco.jsp";
        }, 5000); // El tiempo se mide en ms, por lo que 5000 ms = 5 segundos
      }

      // Se llama a la función de redireccionar cuando la página se cargó completamente
      window.onload = redireccionar;
    </script>
</head>
<body>
    <div class="loginview">
        <div class="login-panel">
            <div class="labels">
                <h3 class="h3">Transferencia Exitosa</h3>
            </div>
            <div class="fields">
                <p>¡Felicidades! Tu Transferencia ha sido exitosa.</p>
                <a href="./inicioBanco.jsp">
                    <button>Ir a Inicio</button>
                </a>
            </div>
        </div>
    </div>
</body>
</html>