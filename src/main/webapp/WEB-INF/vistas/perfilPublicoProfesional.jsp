<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">-->
</head>

<body>

<div class = "container">

    <br><br>
    <div class="text-center" style="margin-top: 4em">
        <h2>${cv.nombreCompleto}</h2>
        <h1>Puntaje general ${calificacion} / 10</h1>
        <h1>${mensaje}</h1>
    </div>
    <br>
    <div class="text-center">
        <c:forEach begin="1" step="1" end="${calificacion}" >
            <i class="fas fa-star fa-3x"></i>
        </c:forEach>
        <c:forEach begin="1" step="1" end="${restante}" >
            <i class="far fa-star fa-3x"></i>
        </c:forEach>
    </div>
    <br>


    <div class="my-5 text-center">
        <h2>Bio:</h2>
        <h3 class="card-title"> Email: ${cv.email}</h3>
        <p class="card-text">Fecha de nacimiento: ${cv.fechaNacimiento}</p>
        <p class="card-text"> Numero de Telefono: ${cv.numeroTelefono}</p>
        <p class="card-text"> Experiencia: ${cv.experiencia}</p>
        <hr>
    </div>



    <h2>Rese&ntilde;as:</h2>

    <c:forEach  items="${resenias}" var="resenia">
        <div class="my-5">
            <div class = "d-flex justify-content-center">
                <div class="col-sm-8 my-5">
                    <div class="card mb-3" style="background: #B1D2CE;">
                        <div class="row no-gutters">
                            <div class="col-md-8">
                                <div class="card-body col-md-8">
                                    <h3 class="card-title">Calificacion: ${resenia.calificacion}</h3>
                                    <p class="card-text"> Por: ${resenia.idUsuarioCliente.email}</p>
                                    <p class="card-text"> Comentario: ${resenia.comentario}</p>
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