<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Servicios Ofrecidos</title>
</head>
<body>


<div class="container">
    <h1>${titulo}</h1>

    <div>
        <a href="#"><button class="btn btn-primary">Empleos</button></a>
        <a href="./ir-a-crear-solicitud"><button class="btn btn-primary">Crear nueva solicitud</button></a>
    </div>

    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Frecuencia</th>
                    <th scope="col">Cama</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Tarifa</th>
                    <th scope="col">Zona</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${empleo}" var="a">
                    <tr>
                        <td>  ${a.nombre}</td>
                        <td>  ${a.idFrecuencia.nombre}</td>
                        <td>  ${a.camaAdentro}</td>
                        <td>  ${a.descripcion}</td>
                        <td>  ${a.tarifa}</td>
                        <td>  ${a.zona.nombre}</td>
                        <td>
                            <a href="detalle-asistencia/${a.id}">
                               <button class="btn btn-lg btn-primary btn-block">Editar</button>
                            </a>
                        </td>
                        <td>
                            <a href="eliminar/${a.id}">
                                <button class="btn btn-lg btn-primary btn-block">Eliminar</button>
                            </a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
