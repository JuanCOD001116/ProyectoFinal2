<%@ page contentType="text/html; charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banco JSP</title>
    <link rel="stylesheet" type="text/css" href="../css/menu.css">
    <link rel="stylesheet" type="text/css" href="../css/transacciontiempo.css">
    <style>
        
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
    <div class="content">
        <h1>Lista de Transferencias</h1>
        <section>
            <table border="8">
                <tr>
                    <th>ID TRANSACCION</th>
                    <th>CUENTA ENTRANTE</th>
                    <th>CUENTA SALIENTE</th>
                    <th>FECHA</th>
                    <th>MONTO</th>
                </tr>
                <tbody>
                    <c:forEach items="${Transaccion}" var="Transaccion" varStatus="status">
                        <tr>
                            <td><c:out value="${Transaccion.id_transaccion}" /></td>
                            <td><c:out value="${Transaccion.numero_cuenta_entrante}" /></td>
                            <td><c:out value="${Transaccion.numero_cuenta_saliente}" /></td>
                            <td><c:out value="${Transaccion.fecha}" /></td>
                            <td><c:out value="${Transaccion.monto}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <section class="opciones">
            <form action="transaccion" method="get">
                <input type="number" name="id_cuenta_origen" placeholder="ID CUENTA" class="input-cajon" />
                <input type="datetime-local" name="fecha_inicio" placeholder="FECHA INICIO" class="input-cajon" />
                <input type="datetime-local" name="fecha_final" placeholder="FECHA FINAL" class="input-cajon" />
                <input type="submit" value="Buscar" class="button" />
            </form>
        </section>
    </div>
</body>
</html>