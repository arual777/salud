<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <li><a href="#">Home</a></li>
            <li><a href="ir-a-asistencias">Empleos</a></li>
            <li><a href="ir-a-registrar-perfil-profesional">Registrar perfil</a></li>
            <li><a href="ir-a-registrar-perfil-profesional">Editar perfil</a></li>
            <li><a href="#">Mi perfil</a></li>
        </ul>
    </c:otherwise>
</c:choose>