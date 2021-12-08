<%@include file="header.jsp" %>

<div class = "container">
    <div class="text-align-center">
    <h1 style="margin-top: 4em">Registro de Perfil Profesional</h1>
    </div>

    <h3>Ingrese sus datos en el formulario para que los demas usuarios puedan saber su experiencia</h3>
    <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

        <form:form action="registroProfesional" method="POST" modelAttribute="datosRegistroProfesional">

            <h4 class="my-2">Ingrese Su Nombre Completo</h4>
            <form:input path="nombreCompleto" id="text" class="form-control"/>
            <h4 class="my-2">Ingrese su fecha de nacimiento</h4>
            <form:input path="fechaNacimiento" type="date" id="fechaNacimiento" class="form-control"/>
            <h4 class="my-2">Ingrese Su Email de contacto</h4>
            <form:input path="email" id="email" class="form-control"/>
            <h4 class="my-2">Escriba aqui sus estudios y sus experiencias laborales como cuidador</h4>
            <form:textarea path="experiencia" type="text-area" id="clave" class="form-control"/>
            <h4 class="my-2">Ingrese un numero de telefono de contacto</h4>
            <form:input path="numeroTelefono" type="text" id="clave" class="form-control"/>
            <button id="btn-registroProfesional" class="btn-light-blue" Type="Submit"/>Registrar mi Perfil Profesional</button>
        </form:form>

        <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>
    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>

<script src="js/bootstrap.min.js" type="text/javascript"></script>
<%@include file="footer.jsp" %>
</body>
</html>