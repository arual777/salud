<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
    <div id="solicitudBox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="../editarSolicitud" method="POST" modelAttribute="asistencia">

            <form:hidden path="id" id="id" />
            <form:hidden path="idTurno.id" id="idTurnoHidden" />
            <form:hidden path="idFrecuencia.id" id="idFrecuenciaHidden" />
            <form:hidden path="zona.id" id="idZonaHidden" />
            <form:hidden path="camaAdentro" id="idCamaHidden" />

            <h3 class="form-signin-heading">Nueva Solicitud ${parametro}</h3>
            <hr class="colorgraph"><br>

             <label for="nombre">Nombre de contacto:</label>
            <form:input path="nombre" id="nombre" class="form-control" />

             <label for="descripcion"> Descripción del empleo: </label>
             <br/>
             <form:textarea id="descripcion" name="descripcion" rows="5" cols="40" path="descripcion"/>

             <label for= "c"> Cama adentro: </h5>
             <br/>
             <input type="radio"  id="camaAdentro" name="camaAdentro" value="1">
             <label for="si">SI: </label>
               <br/>
             <input type="radio" id="camaAdentro" name="camaAdentro" value="0">
             <label for="no">NO: </label>
              <br/> <br/>

             <label for="tarifa"> Tarifa:</label>
             <form:input  path="tarifa" type="number" id="tarifa"/>

              <br/> <br/>

              <label for="turno"> Turno:</label>
                 <select id="idTurno" name="idTurno" required>
                     <option value="">  </option>
                    <option value="1"> MANANA </option>
                    <option value="2"> TARDE </option>
                    <option value="3">NOCHE</option>
                </select>
               <br/> <br/>

               <label for="frecuencia"> Frecuencia:</label>
                                <select name="idFrecuencia" id= "idFrecuencia" required>
                                    <option value="">  </option>
                                   <option value="1"> CUIDADO POR DIA </option>
                                   <option value="2"> CUIDADO POR SEMANA </option>
                                   <option value="3">CUIDADO POR MES</option>
                                   <option value="4">CUIDADO POR HORA</option>
                                   <option value="5">CUIDADO POR NOCHE</option>
                               </select>
                  <br/> <br/>
                <label for="zona"> Zona:</label>
                                                <select name="zona" id= "idZona" required>
                                                    <option value="">  </option>
                                                   <option value="1"> CABA </option>
                                                   <option value="2"> ZONA NORTE </option>
                                                   <option value="3">ZONA SUR</option>
                                                   <option value="4">ZONA ESTE</option>
                                                   <option value="4">ZONA OESTE</option>
                                               </select>

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Editar</button>
                </form:form>
        <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script>
// cuando la pagina se termina de cargar ejecuto esto
$( document ).ready(function() {

    //obtengo el valor que guardé en el hidden y lo guardo en una variable
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
</body>
</html>