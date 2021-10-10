<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Rodrigo
  Date: 26/9/2021
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
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

<div class="navbar navbar-default">
    <div class="container-fluid">
        <a class="navbar-brand" href="./home">Cuidados</a>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="./ir-a-asistencias">Todos Los Servicios</a></li>
                <li><a href="./ir-a-asistencias-mensuales">Servicios Mensuales</a></li>
                <li><a href="./ir-a-asistencias-diarias">Servicios Diarios</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">
    <h1>${titulo}</h1>

<%--    <div>--%>
<%--    <a href="./ir-a-asistencias"><button class="btn btn-primary">Todos Los Servicios</button></a>--%>
<%--    <a href="./ir-a-asistencias-mensuales"><button class="btn btn-primary">Servicios Mensuales</button></a>--%>
<%--    <a href="./ir-a-asistencias-diarias"><button class="btn btn-primary">Servicios Diarios</button></a>--%>
<%--    </div>--%>

<%--    <h1>Servicios Ofrecidos</h1>--%>
    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Servicio</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${servicio}" var="a">
                <tr>
                <td>  ${a.nombre}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
