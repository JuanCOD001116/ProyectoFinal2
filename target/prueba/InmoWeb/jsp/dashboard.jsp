<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Inmobiliaria</title>
    <link type="text/css" rel="stylesheet" href="../css/stylesDashboard.css">
</head>
<body>
     
    <div class="container">
        <div class="background-image"></div>
        <div class="header">
            <h1>Bienvenido a la Inmobiliaria</h1>        
            <nav>
                <ul>
                    <li><a href="matricula.jsp">Matricula del Inmueble</a></li>
                    <li><a href="venta_directa.jsp">Venta Directa</a></li>
                    <li><a href="subasta.jsp">Subasta</a></li>          
                    <li><a href="VentasUsuario.jsp">Registro de Venta</a></li>
                    <li><a href="inventario.jsp">Inventario de Bienes</a></li>
                    <form action="inmuebles" method="get"> <!-- Reemplaza 'post' con el método que desees -->
                        <li>
                            <button type="submit">Inventario de Bienes</button>
                        </li>
                    </form>
                 </ul>
            </nav>
        </div>
    </div>
</body>
</html>