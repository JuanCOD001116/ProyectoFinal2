<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Transferencia Fallida</title>
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
    <h1>Transferencia Fallida</h1>
    <p>
      Ocurrió un error durante la transferencia. Por favor, inténtelo de nuevo.
    </p>
    <a href="transferir-dinero.jsp">Volver al formulario de transferencia</a>
  </body>
</html>
