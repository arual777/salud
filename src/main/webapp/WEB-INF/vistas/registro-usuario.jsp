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
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="registrarme" method="POST" modelAttribute="datos">
            <h3 class="form-signin-heading">Nuevo Usuario ${parametro}</h3>
            <hr class="colorgraph"><br>

            <form:input path="email" id="email" class="form-control" />
            <form:input path="clave" type="password" id="clave" class="form-control"/>
            <form:input path="repiteClave" type="password" id="clave" class="form-control"/>

            <label for="rol">Rol:</label>
                 <select id="rolId" name="rolId" required>
                       <option value="">  </option>
                        <option value="1"> CLIENTE </option>
                        <option value="2"> PROFESIONAL </option>
                </select>
                           <br/> <br/>
            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registrarme</button>
        </form:form>

        <c:if test="${not empty msg}">
            <div class="container">
                <div class="row mb-3">
                    <div class="col-md-8">
                        <c:choose>
                            <c:when test="${mensaje==1}">
                                <div class="alert alert-info">
                                    <span>${msg}</span>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger">
                                    <span>${msg}</span>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
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