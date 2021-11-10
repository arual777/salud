<%@include file="header.jsp" %>


<div class="container">
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
                        <a href="detalle-asistencia/${pregunta.asistencia.id}">${pregunta.asistencia.id}</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <form:form action="responder" method="POST" modelAttribute="datosMensajeria">
                           <label for="respuesta"> Formule su respuesta: </label>
                           <br/>
                           <textarea id="mensaje" name="mensaje" rows="5" cols="100" >${pregunta.respuesta}</textarea>
                           <br /><br />
                          <input id="idMensaje" name="idMensaje" type="hidden" value= "${pregunta.idMensaje}" >
                          <button id="btn-responder" class="btn btn-lg btn-primary" Type="Submit"/>Responder</button>
                        </form:form>
                  </td>
                </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>

</body>
</html>
