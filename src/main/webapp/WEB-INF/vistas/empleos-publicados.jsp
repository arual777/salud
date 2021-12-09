<%@include file="header.jsp" %>

<div class="container">

    <h1>${titulo}</h1><br>
    <h3> Buscar empleos por: </h3>

     <form action="buscarEmpleos" method="GET" class="form-inline">

    <div class="form-group mb-2">
     <label for="zona" class="sr-only"> Zona:</label>
                <select name="zona" id="zona" class="form-control-plaintext" style="width:auto;">
                    <option value="TODOS">Zona</option>
                    <option value="1">CABA</option>
                    <option value="2">ZONA NORTE</option>
                    <option value="3">ZONA SUR</option>
                    <option value="4">ZONA ESTE</option>
                    <option value="5">ZONA OESTE</option>
                </select>
    </div>
    <div class="form-group mx-sm-3 mb-2">
    <label for="turno" class="sr-only">Turno:</label>
        <select name="turno" id="turno"  class="form-control-plaintext" style="width:auto;">
            <option value="TODOS">Turno</option>
            <option value="1">MANANA</option>
            <option value="2">TARDE</option>
            <option value="3">NOCHE</option>
        </select>
     </div>
         <div class="form-group mx-sm-3 mb-2">
     <label for="camaAdentro" class="sr-only">Cama adentro:</label>
         <select name="camaAdentro" id="camaAdentro"  class="form-control-plaintext" style="width:auto;">
             <option value="TODOS">Cama adentro</option>
             <option value="1">SI</option>
             <option value="0">NO</option>
         </select>
      </div>

      <input type=hidden value="${hTurno}" id="hTurno"/>
      <input type=hidden value="${hCama}" id="hCama"/>
      <input type=hidden value="${hZona}" id="hZona"/>
<div>
<td><button type="submit" class="btn-light-blue mb-2" value="zona">Buscar</button></td>
</div>
<br>
         <br>

</form>
    <div>
        <h2>${msg} </h2><br>
    </div>
    <div class="row d-flex justify-content-center" >
        <div class="col-md-12">
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
                        <td>  $${empleo.tarifa}</td>
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
                            <a href="ver-perfil-publico-cliente?idCli=${empleo.usuario.id}"><button class="btn-light-blue">Ver empleador</button></a>
                           </td>
                           <td><a href="ver-ubicacion-empleo?empleo=${empleo.id}"><button class="btn-light-blue">Ver ubicacion</button></a></td>
                               </form>
                                <td>
                                   <div>
                                       <button type="button" asistenciaId="${empleo.id}" class="btn-light-blue botonPreguntar" data-id="10"
                                           btn-sm" data-toggle="modal"  data-target="#myModal">
                                           Preguntar
                                       </button>
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
    <br>
    <br>
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

    let valorZona = $('#hZona').val();
    let valorCama = $('#hCama').val();
    let valorTurno = $('#hTurno').val();

    if(valorZona == ""){
        valorZona ="TODOS";
    }

    if(valorCama == ""){
        valorCama ="TODOS";
    }

    if(valorTurno == ""){
        valorTurno ="TODOS";
    }

    $('#zona').val(valorZona);
    $('#turno').val(valorTurno);
    $('#camaAdentro').val(valorCama);
</script>

<%@include file="footer.jsp" %>
</body>
</html>

