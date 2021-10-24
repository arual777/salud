<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Postulaciones</title>
</head>
<body>


<div class="container">
    <h1>${titulo}</h1>


    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">ID Profesional</th>
                    <th scope="col">ID Asistencia</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${postulaciones}" var="postulacion">
                    <tr>
                        <td>  ${postulacion.profesional.id}</td>
                        <td>  ${postulacion.asistencia.id}</td>
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
