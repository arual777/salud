<%@include file="header.jsp" %>

<title>Postulaciones</title>
<div class="container">
    <h1>${titulo}</h1>


    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Mail Profesional</th>
                    <th scope="col">Descripcion Asistencia</th>
                    <th scope="col">Cliente</th>

                    <c:choose>
                    <c:when test="${idRol==1}">
                        <th scope="col">Contratar</th>
                    </c:when>
                    </c:choose>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${postulaciones}" var="postulacion">
                    <tr>
                        <td>  ${postulacion.profesional.email}</td>
                        <td>  ${postulacion.asistencia.descripcion}</td>
                        <td>  ${postulacion.asistencia.usuario.id}</td>
                        <c:choose>
                        <c:when test="${idRol==1}">
                        <td>
                            <form action="contratado" method="POST" modelAttribute="datosPostulacion">
                                <button class="btn btn-lg btn-primary btn-block" onclick="parentNode.submit();">Contratar</button>
                                <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${postulacion.profesional.id}" >
                            </form>
                        </td>
                        </c:when>
                        </c:choose>
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
