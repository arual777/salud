<%@include file="header.jsp" %>

    <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>

<div class="container">
    <h1>${titulo}</h1>
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


                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${empleos}" var="empleo">
                    <tr>
                        <td>  ${empleo.nombre}</td>
                        <td>  ${empleo.idFrecuencia.nombre}</td>
                        <td>  ${empleo.camaAdentro}</td>
                        <td>  ${empleo.descripcion}</td>
                        <td>  ${empleo.tarifa}</td>
                        <td>  ${empleo.zona.nombre}</td>

                        <c:choose>
                       <c:when test="${idRol==1}">
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
                          </c:when>
                          <c:otherwise>
                         <td>
                          <form action="postularme" method="POST" modelAttribute="datosPostulacion">
                             <button type="submit" class="btn btn-lg btn-primary btn-block">Postularme</button>
                             <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${empleo.id}" >
                          </form>
                        </td>

                          <td>
                                <form action= "ir-a-crear-pregunta" method="GET" modelAttribute="datosMensajeria">
                                       <button type="submit" class="btn btn-lg btn-primary btn-block">Preguntar</button>
                                        <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${empleo.id}" >
                                 </form>
                            </td>
                         </c:otherwise>
                     </c:choose>
                    </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>

</body>
</html>
