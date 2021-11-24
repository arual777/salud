<%@include file="header.jsp" %>

<div class = "container">


    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="./editarPerfilProfesional" method="POST" modelAttribute="datosRegistroProfesional">
            <form:hidden path="id" id="id" />

            <div class="text-align-center">
                <h1 style="margin-top: 4em">Editar Perfil Profesional</h1>
            </div>

            <h4 class="my-2">Ingrese Su Nombre Completo</h4>
            <form:input path="nombreCompleto" id="text" class="form-control" value="${curriculum.nombreCompleto}"/>
            <h4 class="my-2">Ingrese su fecha de nacimiento</h4>
            <form:input path="fechaNacimiento" type="date" id="fechaNacimiento" class="form-control" value="${curriculum.fechaNacimiento}"/>
            <h4 class="my-2">Ingrese Su Email de contacto</h4>
            <form:input path="email" id="email" class="form-control" value="${curriculum.email}"/>
            <h4 class="my-2">Escriba aqui sus estudios y sus experiencias laborales como cuidador</h4>
            <form:textarea path="experiencia" type="text-area" id="clave" class="form-control" value="${curriculum.experiencia}"/>
            <h4 class="my-2">Ingrese un numero de telefono de contacto</h4>
            <form:input path="numeroTelefono" type="text" id="clave" class="form-control" value="${curriculum.numeroTelefono}"/>
            <button id="btn-editarPerfilProfesional" class="btn-light-blue" Type="Submit"/>Registrar mi Perfil Profesional</button>
        </form:form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>
