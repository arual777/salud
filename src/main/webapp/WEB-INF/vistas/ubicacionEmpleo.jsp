<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class = "container">

    <a href="ir-a-asistencias"><button class="btn-light-blue" style="margin-top: 5em;">Volver</button></a>


        <div class="">
            <h2>Detalle de Empleo</h2>
            <div class = "d-flex justify-content-center">
                <div class="col-sm-8 my-5">

                    <div class="card-body">
                        <h3 class="card-title">Descripci&oacute;n: ${empleo.descripcion}</h3>
                        <h3 class="card-title"> Empleo ofrecido por: ${empleo.usuario.email}</h3>
                        <h3 class="card-title"> Tarifa por d&iacute;a: $${empleo.tarifa}</h3>
                        <hr>
                    </div>
                </div>
                <div style="margin: auto;">
                    <div>
                        <div class="col-12" id="mapa" style="width:500px; height:400px;"></div>
                    </div>

                </div>
            </div>

        </div>

    <div class="container-md" >

    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAiq3xISXSZYgkd9GDAOdajy4NK2d3L7dY"></script>
<script type="text/javascript">
    function initialize() {
        // Creating map object
        var map = new google.maps.Map(document.getElementById('mapa'), {
            zoom: 16,
            center: new google.maps.LatLng(${empleo.latitud}, ${empleo.longitud}),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        // creates a draggable marker to the given coords
        var vMarker = new google.maps.Marker({
            position: new google.maps.LatLng(${empleo.latitud}, ${empleo.longitud}),
            draggable: false
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


</body>
</html>