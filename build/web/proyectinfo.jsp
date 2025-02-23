<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student & Course Information</title>
    </head>
    <body>
        <h1>Informacion Proyectos</h1>
        <form action="./ProyectoServlet" method="POST">
            <table>
                <tr><td>Proyecto ID</td><td><input type="text" name="proyectoId" value="${proyecto.proyectoId}" /></td></tr>
                <tr><td>Nombre</td><td><input type="text" name="nombre" value="${proyecto.nombre}" /></td></tr>
                <tr><td>Descripción</td><td><input type="text" name="descripcion" value="${proyecto.descripcion}" /></td></tr>
                <tr><td>Presupuesto</td><td><input type="text" name="presupuesto" value="${proyecto.presupuesto}" /></td></tr>
                <tr><td>Número de Habitantes</td><td><input type="text" name="numHabitantes" value="${proyecto.numHabitantes}" /></td></tr>
                <tr><td colspan="2">
                    <input type="submit" name="action" value="Add" />
                    <input type="submit" name="action" value="Edit" />
                    <input type="submit" name="action" value="Delete" />
                    <input type="submit" name="action" value="Search" />
                </td></tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th><th>Nombre</th><th>Descrpción</th><th>Presupuesto</th><th>Número de Habitantes</th>
            <c:forEach items="${allProyectos}" var="pro">
                <tr>
                    <td>${pro.proyectoId}</td><td>${pro.nombre}</td><td>${pro.descripcion}</td><td>${pro.presupuesto}</td><td>${pro.numHabitantes}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>