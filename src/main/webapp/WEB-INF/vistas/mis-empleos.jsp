<%@include file="header.jsp" %>

<title>Postulaciones</title>
<div class="container">
    <h1>${titulo}</h1>
    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Franja Horaria</th>
                    <th scope="col">Zona</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${empleos}" var="empleo">
                    <tr>
                        <td>  ${empleo.descripcion}</td>
                        <td>  ${empleo.idTurno.franja}</td>
                        <td>  ${empleo.zona.nombre}</td>
                        <td>
                            <a href="detalle-asistencia/${empleo.id}">
                                <button class="btn btn-lg btn-primary btn-block">Editar</button>
                            </a>
                        </td>
                        <td>
                            <a href="eliminar/${empleo.id}">
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

</body>
</html>
