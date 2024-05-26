<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <meta>
  <body>
    <h2>Bienvenido al banco</h2>
    <h2>¿Que quieres hacer?</h2>
    <div class="contenedor-botones">
      <a href="Iniciosesion.jsp">
        <button>Iniciar Sesión</button>
      </a>
      <a href="lista-usuarios">
        <button>Registrarse</button>
      </a>
      <a href="index.jsp">
        <button>Devolverse</button>
      </a>
    </div>
  </body>

  <style>
    body {
      text-align: center;
      margin-top: 20%;
      font-family: "Courier New", Courier, monospace;
      background-color: #171717;
    }

    h2 {
      font-weight: 800;
      font-size: 1.5rem;
      color: #8c8c8c;
    }
    
    .contenedor-botones{
      display: flex;
      flex-direction: column;
      justify-content: center;
      gap: 1rem;
    }

    button {
      background: #4caf50;
      font-family: inherit;
      padding: 0.6em 1.3em;
      font-weight: 900;
      font-size: 18px;
      border: 2px solid black;
      border-radius: 0.4em;
      box-shadow: 0.1em 0.1em;
      cursor: pointer;
    }

    button:hover {
      transform: translate(-0.05em, -0.05em);
      box-shadow: 0.15em 0.15em;
    }

    button:active {
      transform: translate(0.05em, 0.05em);
      box-shadow: 0.05em 0.05em;
    }
  </style>
</html>
