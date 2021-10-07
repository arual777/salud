<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
    <div id="solicitudBox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="crearSolicitud" method="POST" modelAttribute="datos">
            <h3 class="form-signin-heading">Nueva Solicitud ${parametro}</h3>
            <hr class="colorgraph"><br>

             <h5> Nombre de contacto: </h5>
            <form:input path="nombre" id="nombre" class="form-control" />

             <h5> Tipo de servicio: </h5>
            <form:input path="tipo"  id="tipo" class="form-control"/>

            <h5> Turno: </h5>
            <select name="idTurno" required>
                <option value="">  </option>
              <option value="1"> MANANA </option>
              <option value="2"> TARDE </option>
              <option value="3">NOCHE</option>
            </select>
               <br> <br>
             <a href="empleos-publicados">
                 <button class="btn btn-primary">Empleos</button>
             </a>
        </form:form>

        <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>