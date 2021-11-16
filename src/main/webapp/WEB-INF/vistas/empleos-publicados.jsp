<%@include file="header.jsp" %>

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
                       <c:when test="${idRol==2}">
                           <td>
                               <form action="postularme" method="POST" modelAttribute="datosPostulacion">
                                   <button type="submit" class="btn btn-lg btn-primary btn-block">Postularme</button>
                                   <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${empleo.id}" >
                               </form>
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
