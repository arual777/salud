<%@include file="header.jsp" %>


<div class="container">
    <br>
    <br>
    <br>
    <h1>${titulo}</h1>
    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
            <h2 style="color: green"> ${msg} </h2>
                <thead>
                    <tr>
                        <th scope="col">Pregunta</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Asistencia</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach  items="${preguntas}" var="pregunta">
                <tr>
                    <td>
                        ${pregunta.pregunta}
                    </td>
                    <td>
                        ${pregunta.usuario.email}
                    </td>
                    <td>
                        <a href="detalle-asistencia/${pregunta.asistencia.id}">${pregunta.asistencia.descripcion}</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:form action="responder" method="POST" modelAttribute="datosMensajeria">
                           <label for="respuesta"> Formule su respuesta: </label>
                               <br />
                                <textarea <c:if test="${not empty pregunta.respuesta}">readonly</c:if> class="form-control" id="mensaje" name="mensaje" rows="5" cols="100" >${pregunta.respuesta}</textarea>
                                    <br /><br />
                                <input id="idMensaje" name="idMensaje" type="hidden" value="${pregunta.idMensaje}" >
                            <c:choose>
                                <c:when test="${empty pregunta.respuesta}">
                                     <button id="btn-responder" class="btn btn-lg btn-primary" Type="Submit" onclick="javascript:document.getElementById('btn_submit').style.visibility = 'hidden'"/>Responder</button>
                                </c:when>
                            </c:choose>
                        </form:form>
                  </td>
                </tr>
                </c:forEach>
                </body>
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
