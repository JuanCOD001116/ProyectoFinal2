<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banco JSP</title>
    <script src="script.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            background-color: #f4f4f4;
        }

        .sidebar {
            background-color: #333;
            color: white;
            padding-top: 10px;
            width: 250px;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
        }

        .logo h1 {
            margin: 0;
            padding-left: 20px;
            padding-bottom: 20px;
        }

        .menu ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .menu ul li {
            margin: 0;
            padding: 0;
        }

        .menu ul li a {
            color: white;
            text-decoration: none;
            padding: 15px 20px;
            display: block;
        }

        .menu ul li a:hover {
            background-color: #575757;
        }

        .content {
            margin-left: 250px;
            padding: 20px;
        }

        .buttons {
            margin-top: 20px;
        }

        .buttons button {
            padding: 10px 20px;
            margin-right: 10px;
            border: none;
            background-color: #007BFF;
            color: white;
            cursor: pointer;
            border-radius: 5px;
        }
        .content {
  margin-left: 250px;
  padding: 20px;
}

        .buttons button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h1>Banco JSP</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="./inicioBanco.jsp">Inicio</a></li>
                <li><a href="./cuenta-asignada.jsp">Cuentas</a></li>
                <li><a href="./transaccion.jsp">Transferencias</a></li>
                <li><a href="./Politicas.jsp">Políticas</a></li>
                <li><a href="./TCP.jsp">Transacciones Hechas</a></li>
                <li><a href="../../initialPageInmo.jsp">Salir</a></li>
            </ul>
        </div>
    </div>

    <!-- Política de Banco XYZ -->
    <div class="content"></div>
    <div class="policy">
        <h2>Política de Banco JSP</h2>
        <p>Política de Cultura Corporativa:
            Establece los valores, principios y comportamientos esperados de todos los empleados del banco.
            Fomenta la diversidad, la ética y la responsabilidad social.
            Política de Gestión de Riesgo Socioambiental y Climático:
            Define cómo el banco evalúa y gestiona los riesgos relacionados con el medio ambiente y el cambio climático en sus operaciones y préstamos.
            Promueve prácticas sostenibles y la mitigación de impactos negativos.
            Política de Banca Responsable y Sostenibilidad:
            Compromiso con la sostenibilidad y la inclusión financiera.
            Define cómo el banco apoya a comunidades, emprendedores y proyectos sociales.
            Política de Préstamos:
            Establece criterios para otorgar préstamos a individuos y empresas.
            Define tasas de interés, plazos, garantías y condiciones.
            Política de Seguridad y Salud en el Trabajo:
            Garantiza un entorno seguro para los empleados y clientes.
            Establece medidas de prevención y respuesta ante emergencias.
            Política de Privacidad y Protección de Datos:
            Protege la información personal de los clientes.
            Cumple con las regulaciones de privacidad y seguridad de datos.
            Política de Ética y Conducta:
            Define las expectativas de comportamiento ético para todos los empleados.
            Aborda temas como el conflicto de intereses, la corrupción y la transparencia.</p>
        <!-- ... (Agrega los valores fundamentales y las políticas específicas aquí) ... -->
        <p>Revisamos nuestras políticas anualmente para asegurar su vigencia y relevancia. El consejo de administración aprueba cualquier cambio o actualización.</p>
    </div>
    </div>
</body>
</html>