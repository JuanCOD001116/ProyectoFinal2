<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Transferencia Exitosa</title>
    <script>
      // Función para redireccionar a la página principal
      function redireccionar() {
        setTimeout(function () {
          window.location.href = "index.jsp";
        }, 5000); // El tiempo se mide en ms, por lo que 5000 ms = 5 segundos
      }

      // Se llama a la función de redireccionar cuando la página se cargó completamente
      window.onload = redireccionar;
    </script>
  </head>
  <body>
    <h1>Transferencia Exitosa</h1>
    <a href="index.jsp">Volver al Inicio</a>
  </body>
</html>
