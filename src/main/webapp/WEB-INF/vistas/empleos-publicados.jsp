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
                                   <button type="submit" class="btn btn-lg btn-primary btn-block">Postularme</button>
                                   <input id="idAsistencia" name="idAsistencia" type="hidden" value= "${empleo.id}" >
                               </form>
                           </td>
                           <td>
                               <div>
                                   <button type="button" asistenciaId="${empleo.id}"   class="btn btn-info btn-lg botonPreguntar" data-id="10"
                                       btn-sm" data-toggle="modal">
                                       Preguntar
                                   </button>
                              </form>
                                  <!-- Modal -->
                                    <div class="modal fade" id="myModal" role="dialog">
                                      <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                          <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Formule su pregunta</h4>
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

    <script>
        $(".botonPreguntar").click(function () {
            let id = $(this).attr('asistenciaId');
            $(".idAsistencia").val(id);
            $('#myModal').modal('show');
        });
            $("#botonCerrarModal").click(function(){
                $("#mensaje").val('');
            });
    </script>
</body>
</html>
