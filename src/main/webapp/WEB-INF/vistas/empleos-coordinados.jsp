<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class = "container">

    <h2>Empleos Coordinados</h2>


    <c:forEach  items="${empleos}" var="empleo">
        <div class="my-5">
            <div class = "d-flex justify-content-center">
                <div class="col-sm-8 my-5">
                    <div class="card mb-3" >
                        <div class="row no-gutters">
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h3 class="card-title">Empleo ID ${empleo.id}</h3>
                                    <p class="card-text"> Profesional Contratado: ${empleo.profesional.email}</p>
                                    <p class="card-text"> Descripción: ${empleo.asistencia.descripcion}</p>
                                    <a href="./ir-a-reseniar?idProf=${empleo.profesional.id}"><button class="btn-primary">Reseniar</button></a>
                                    <hr>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>
