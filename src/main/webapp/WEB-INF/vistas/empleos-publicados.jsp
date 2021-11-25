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
                    <th scope="col"></th>
                    <th scope="col"></th>
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
                                   <button type="submit" class="btn-light-blue">Postularme</button>
                                   <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${empleo.id}" >
                               </form>
                           </td>

                           <td>
                            <a href="ver-perfil-publico-cliente?idCli=${empleo.usuario.id}"><button class="btn-light-blue">Ver Perfil Empleador</button></a>
                           </td>
                           <td><a href="ver-ubicacion-empleo?empleo=${empleo.id}"><button class="btn-light-blue">Ver En El Mapa</button></a></td>
                               </form>
                                <td>
                                   <div>
                                       <button type="button" asistenciaId="${empleo.id}" class="btn btn-info btn-lg botonPreguntar" data-id="10"
                                           btn-sm" data-toggle="modal"  data-target="#myModal">
                                           Preguntar
                                       </button>
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

<!-- Modal -->
                 <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal" aria-hidden="true">
                   <div class="modal-dialog" role="document">
                     <!-- Modal content-->
                     <div class="modal-content">
                       <div class="modal-header">
                                                <h4 class="modal-title">Formule su pregunta</h4>

                         <button type="button" class="close" aria-label="Close" data-dismiss="modal">&times;</button>
                       </div>
                       <div class="modal-body">
                            <form action="preguntar" method="POST" modelAttribute="datosMensajeria">
                           <textarea class="form-control" style="resize:vertical;" id="mensaje" name="mensaje" rows="10" cols="40" required></textarea>
                            <input id="idAsistencia" name="idAsistencia" class="idAsistencia" type="hidden">
                           <div class="modal-footer">
                                <button id="botonCerrarModal" type="button" class="btn btn-lg btn-danger" data-dismiss="modal">Cerrar</button>
                                <button id="btn-registrarme" class="btn btn-lg btn-success" Type="Submit"/>Enviar pregunta</button>
                           </div>
                            </form>
                       </div>
                     </div>
                   </div>
                 </div>

    <script>
        $(".botonPreguntar").click(function ()
        {
                let id = $(this).attr('asistenciaId');
                $(".idAsistencia").val(id);
                $('#myModal').modal("show");
        });

        $("#botonCerrarModal").click(function(){
            $("#mensaje").val('');
            $('#myModal').modal("hide");

        });

    </script>



</body>
</html>

