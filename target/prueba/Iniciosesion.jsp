<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <meta>
  <body>
    <h2>Ingresa tus datos</h2>
    <div>
      <form action="registro" method="post">
        <input
          type="text"
          name="usuario"
          class="cajon-input"
          placeholder="Usuario"
        />
          <input
            type="password"
            name="password"
            class="cajon-input"
            placeholder="Password"
          />
          <input type="submit" value="Registrar" class="button" />
      </form>
    </div>
    <div class="contenedor-botones">
      <a href="LoginBanco.jsp">
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

    form {
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 1rem;
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
    .cajon-input {
      width: 250px;
      height: 40px;
      border-radius: 5px;
      border: 2px solid #000;
      background-color: #fff;
      box-shadow: 4px 4px #000000;
      font-size: 15px;
      font-weight: 600;
      color: #323232;
      padding: 5px 10px;
      outline: none;
    }

    .cajon-input::placeholder {
      color: #666;
      opacity: 0.8;
    }
    .button {
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

    .cajon-input:focus {
      border: 2px solid #4caf50;
    }
    
    input[type="number"]::-webkit-inner-spin-button,
    input[type="number"]::-webkit-outer-spin-button {
      -webkit-appearance: none;
      -moz-appearance: none;
      appearance: none;
      margin: 0;
    }
  </style>
</html>