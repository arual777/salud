<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/menu.css" rel="stylesheet">
</head>
<body>
    <c:choose>
        <c:when test="${idRol==1}">
            <ul>
                <li><a href="ir-a-crear-solicitud">Nueva Solicitud</a></li>
                <li><a href="ver-postulados">Postulantes</a></li>
                <li><a href="ir-a-asistencias">Empleos</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul>
                <li><a href="ir-a-asistencias">Empleos</a></li>
                <li><a href="#">Mi perfil</a></li>
            </ul>
        </c:otherwise>
    </c:choose>
    <title>Postulaciones</title>
<div class="container">
    <h1>${titulo}</h1>


    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Mail Profesional</th>
                    <th scope="col">Descripcion Asistencia</th>
                    <th scope="col">Cliente</th>

                    <c:choose>
                    <c:when test="${idRol==1}">
                        <th scope="col">Contratar</th>
                    </c:when>
                    </c:choose>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${postulaciones}" var="postulacion">
                    <tr>
                        <td>  ${postulacion.profesional.email}</td>
                        <td>  ${postulacion.asistencia.descripcion}</td>
                        <td>  ${postulacion.asistencia.usuario.id}</td>
                        <c:choose>
                        <c:when test="${idRol==1}">
                        <td>
                            <form action="contratado" method="POST" modelAttribute="datosPostulacion">
                                <button class="btn btn-lg btn-primary btn-block" onclick="parentNode.submit();">Contratar</button>
                                <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${postulacion.profesional.id}" >
                            </form>
                        </td>
                        </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

      <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>

</body>
</html>
