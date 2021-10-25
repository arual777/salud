<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class = "container">
    <div class="text-align-center">
        <h1>Registro de Resenia</h1>
    </div>

    <h3>Resenia a Usuario Profesional</h3>
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">


        <form:form action="registrarResenia" method="POST" modelAttribute="datosResenia">

            <form:hidden path="idUsuarioCliente" id="id" />

            <h4 class="my-2">Ingrese una calificacion</h4>
            <form:input path="calificacion" type="number" id="text" class="form-control"/>
            <h4 class="my-2">Comentario</h4>
            <form:textarea path="comentario" type="text-area" id="text" class="form-control"/>
            <h4 class="my-2">Usuario Profesional</h4>
            <form:input path="idUsuarioProfesional" type="number" id="text" class="form-control"/>
            <button id="btn-registroProfesional" class="btn btn-lg btn-primary btn-block my-3" Type="Submit"/>Registrar Resenia</button>
        </form:form>

        <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>

    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>