<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todos los Perfiles Profesionales</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>



<div class="container">
    <h1>Perfiles de todos los profesionales </h1>
    <div class="row" >
        <div class="col-md-10">

            <c:forEach  items="${cvs}" var="curriculum">
                <div class="my-5">
                <div class = "d-flex justify-content-center">
                    <div class="col-sm-8 my-5">
                        <div class="card mb-3" >
                            <div class="row no-gutters">
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h3 class="card-title">CV de ${curriculum.nombreCompleto}</h3>
                                        <p class="card-text">Fecha de Nacimiento: ${curriculum.fechaNacimiento}</p>
                                        <p class="card-text">Experiencia: ${curriculum.experiencia}</p>
                                        <p class="card-text">Email: ${curriculum.email}</p>
                                        <p class="card-text">Telefono de contacto: ${curriculum.numeroTelefono}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>
