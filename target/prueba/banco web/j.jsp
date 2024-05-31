<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banco JSP</title>
    <link rel="stylesheet" type="text/css" href="menu.css">
    <script src="script.js"></script>
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h1>Banco JSP</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="#">Inicio</a></li>
                <li><a href="#">Cuentas</a></li>
                <li><a href="#">Transferencias</a></li>
                <li><a href="#">Pagos</a></li>
                <li><a href="#">Perfil</a></li>
                <li><a href="#">Salir</a></li>
            </ul>
        </div>
    </div>
    <div class="content">
        <h2>Bienvenido a su Banco</h2>
        <p>Seleccione una opción del menú para continuar.</p>
        <div class="buttons">
            <button onclick="alert('Botón 1 presionado')">Botón 1</button>
            <button onclick="alert('Botón 2 presionado')">Botón 2</button>
            <button onclick="alert('Botón 3 presionado')">Botón 3</button>
        </div>
    </div>
</body>
</html>
