<%@include file="header.jsp" %>

<div class="container">
    <h1>${titulo}</h1>
    <div class="row" >
        <div class="col-md-10">
            <table class="table table-striped">
            <h2 style="color: green"> ${msg} </h2>
                <thead>
                    <tr>
                        <th scope="col">Mis preguntas</th>

                        <th scope="col">Servicio Consultado</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach  items="${preguntas}" var="pregunta">
                <tr>
                    <td>
                        ${pregunta.pregunta}
                    </td>

                    <td>
                        <a href="detalle-asistencia/${pregunta.asistencia.id}">${pregunta.asistencia.id}</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                           <label for="respuesta"> Respuesta: </label>
                                <br/>
                                <textarea <c:if test="${not empty pregunta.respuesta}">readonly</c:if> class="form-control" id="mensaje" name="mensaje" rows="5" cols="100" >${pregunta.respuesta}</textarea>
                                    <br /><br />
                                <input id="idMensaje" name="idMensaje" type="hidden" value="${pregunta.idMensaje}" >
                    </td>
                </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>