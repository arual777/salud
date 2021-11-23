<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>

<div class = "container">
    <div id="solicitudBox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="crearSolicitud" method="POST" modelAttribute="datos">
        <h3 class="form-signin-heading">Nueva Solicitud ${parametro}</h3>
        <hr class="colorgraph"><br>

        <label for="nombre">Nombre de contacto:</label>
        <form:input path="nombre" id="nombre" class="form-control" />

        <label for="descripcion"> Descripción del empleo: </label>
        <br/>
        <textarea id="descripcion" name="descripcion" rows="5" cols="40">
              </textarea>

        <label for= "c"> Cama adentro: </h5>
            <br/>
            <input type="radio" name="camaAdentro" id="si" value="1">
            <label for="si">SI: </label>
            <br/>
            <input type="radio" name="camaAdentro" id="no" value="0">
            <label for="no">NO: </label>
            <br/> <br/>

            <label for="tarifa"> Tarifa:</label>
            <input type="number" id="tarifa" name="tarifa">

            <br/> <br/>

            <label for="turno"> Turno:</label>
            <select name="idTurno" required>
                <option value="">  </option>
                <option value="1"> MANANA </option>
                <option value="2"> TARDE </option>
                <option value="3">NOCHE</option>
            </select>
            <br/> <br/>

            <label for="frecuencia"> Frecuencia:</label>
            <select name="idFrecuencia" required>
                <option value="">  </option>
                <option value="1"> CUIDADO POR DIA </option>
                <option value="2"> CUIDADO POR SEMANA </option>
                <option value="3">CUIDADO POR MES</option>
                <option value="4">CUIDADO POR HORA</option>
                <option value="5">CUIDADO POR NOCHE</option>
            </select>
            <br/> <br/>
            <label for="zona"> Zona:</label>
            <select name="zona" required>
                <option value="">  </option>
                <option value="1"> CABA </option>
                <option value="2"> ZONA NORTE </option>
                <option value="3">ZONA SUR</option>
                <option value="4">ZONA ESTE</option>
                <option value="5">ZONA OESTE</option>
            </select>

            <div class="form-group">
                <!--<label for="latitudinput">Latitud</label>-->
                <form:input type="hidden" required="" path="latitud" name="latitud" id="latitudinput" class="form-control"/>
            </div>
            <div class="form-group">
                <!--<label for="longitudinput">Longitud</label>-->
                <form:input type="hidden" required="" path="longitud" name="longitud" id="longitudinput" class="form-control" />
            </div>

            <label for="mapa">Indique una ubicaci&oacute;n de referencia en el mapa arrastrando el puntero</label>
            <div class="form-group">
                <div class="col-6" id="mapa" style="width:500px; height:400px;"></div>
            </div>


            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Publicar</button>
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


<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAiq3xISXSZYgkd9GDAOdajy4NK2d3L7dY"></script>

<script type="text/javascript">
    function initialize() {
        // Creating map object
        var map = new google.maps.Map(document.getElementById('mapa'), {
            zoom: 12,
            center: new google.maps.LatLng(-34.6537328, -58.5429665),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        // creates a draggable marker to the given coords
        var vMarker = new google.maps.Marker({
            position: new google.maps.LatLng(-34.6537328, -58.5429665),
            draggable: true
        });

        // adds a listener to the marker
        // gets the coords when drag event ends
        // then updates the input with the new coords
        google.maps.event.addListener(vMarker, 'dragend', function (evt) {
            $("#latitudinput").val(evt.latLng.lat().toFixed(6));
            $("#longitudinput").val(evt.latLng.lng().toFixed(6));

            map.panTo(evt.latLng);
        });

        // centers the map on markers coords
        map.setCenter(vMarker.position);

        // adds the marker on the map
        vMarker.setMap(map);
    }
    initialize();
</script>

<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>