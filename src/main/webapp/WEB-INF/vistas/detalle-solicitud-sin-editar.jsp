<%@include file="header.jsp" %>
<div class ="container">
    <h1>${titulo}</h1>
    <div id="solicitudBox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="../editarSolicitud" method="POST" modelAttribute="asistencia">

        <form:hidden path="id" id="id" />
        <form:hidden path="idTurno.id" id="idTurnoHidden" />
        <form:hidden path="idFrecuencia.id" id="idFrecuenciaHidden" />
        <form:hidden path="zona.id" id="idZonaHidden" />
        <form:hidden path="camaAdentro" id="idCamaHidden" />

        <h3 class="form-signin-heading">Ver detalle ${parametro}</h3>
        <hr class="colorgraph"><br>

        <label for="nombre">Nombre de contacto:</label>
        <form:input path="nombre" id="nombre" class="form-control" disabled="true"/>

        <label for="descripcion"> Descripci&oacute;n del empleo: </label>
        <br/>
        <form:textarea id="descripcion" name="descripcion" rows="5" cols="40" path="descripcion" disabled="true"/>
<br>
            <label for= "c"> Cama adentro: </label>
            <br/>
            <input type="radio"  id="camaAdentro" name="camaAdentro" value="1">
            <label for="si" disabled="true">SI: </label>
            <br/>
            <input type="radio" id="camaAdentro" name="camaAdentro" value="0">
            <label for="no" disabled="true">NO: </label>
            <br/> <br/>

            <label for="tarifa"> Tarifa:</label>
                <form:input  path="tarifa" type="number" id="tarifa" disabled="true"/>

            <br/> <br/>

            <label for="turno"> Turno:</label>
            <select id="idTurno" name="idTurno" required disabled="true">
                <option value="">  </option>
                <option value="1"> MANANA </option>
                <option value="2"> TARDE </option>
                <option value="3">NOCHE</option>
            </select>
            <br/> <br/>

            <label for="frecuencia"> Frecuencia:</label>
            <select name="idFrecuencia" id= "idFrecuencia" required disabled="true">
                <option value="">  </option>
                <option value="1"> CUIDADO POR DIA </option>
                <option value="2"> CUIDADO POR SEMANA </option>
                <option value="3">CUIDADO POR MES</option>
                <option value="4">CUIDADO POR HORA</option>
                <option value="5">CUIDADO POR NOCHE</option>
            </select>
            <br/> <br/>
            <label for="zona"> Zona:</label>
            <select name="zona" id= "idZona" required disabled="true">
                <option value="">  </option>
                <option value="1"> CABA </option>
                <option value="2"> ZONA NORTE </option>
                <option value="3">ZONA SUR</option>
                <option value="4">ZONA ESTE</option>
                <option value="5">ZONA OESTE</option>
            </select>

            <br>
            <br><br>
            </form:form>
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
    </div>
</div>
<br>
<br><br>
<script>
    // cuando la pagina se termina de cargar ejecuto esto
    $( document ).ready(function() {

        //obtengo el valor que guard?? en el hidden y lo guardo en una variable
        var idTurnoHidden= $("#idTurnoHidden").val();
        //uso las funciones de jquery para poder
        //seleccionar la opcion correcta del selector
        //en funcion del id que tengo en el hidden selecciono la opcion
        //del selector
        $('#idTurno').val(idTurnoHidden);

        var idFrecuenciaHidden= $("#idFrecuenciaHidden").val();
        $('#idFrecuencia').val(idFrecuenciaHidden);

        var idZonaHidden= $("#idZonaHidden").val();
        $('#idZona').val(idZonaHidden);

        var idCamaHidden = $("#idCamaHidden").val();

        if(idCamaHidden) {
            $("#camaAdentro").prop("checked", true);
        } else {
            $("#camaAdentro").prop("checked", false);
        }
    });
</script>
<%@include file="footer.jsp" %>
</body>
</html>