<%@include file="header.jsp" %>

<title>Postulaciones</title>

<div class="container">
    <h1>${titulo}</h1>

    <div class="container">
        <div class="row gy-4">
            <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Mail Profesional</th>
                    <th scope="col">Descripcion Asistencia</th>

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
                        <c:choose>
                        <c:when test="${idRol==1}">
                        <td>
                            <form action="contratado" method="POST" modelAttribute="datosPostulacion">
                                <input type="submit" class="btn-light-blue" value="Contratar"/>
                                <input id="idPostulacion" name="idPostulacion" type="hidden" value= "${postulacion.id}" >
                            </form>
                        </td>
                        <td> <a href="ver-perfil-publico-profesional?idProf=${postulacion.profesional.id}"><button class="btn-light-blue">Ver Perfil</button></a></td>
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
<%@include file="footer.jsp" %>
</body>
</html>
