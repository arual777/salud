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
                        <th scope="col">Respuestas</th>
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
                        ${pregunta.respuesta}
                    </td>

                    <td>
                        <a href="detalle-asistencia/${pregunta.asistencia.id}">${pregunta.asistencia.id}</a>
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
