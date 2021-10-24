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
                    <li><a href="#">Postulantes</a></li>
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
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>

	</body>
</html>