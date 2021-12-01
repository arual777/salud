<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"></script>

    <script src="js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!--<link href="css/menu.css" rel="stylesheet">-->
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

        <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Cuidarnos</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">




    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!--
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <!-- Vendor CSS Files -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!--
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>


    <!-- Template Main CSS File -->
    <link href="css/style.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->

    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<header id="header" class="fixed-top d-flex align-items-center">
<div class="container d-flex align-items-center justify-content-between">

<div class="logo">
    <h1 class="text-light"><a href="index"><span>Cuidandonos</span></a></h1>
    <!-- Uncomment below if you prefer to use an image logo -->
    <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
</div>
<nav id="navbar" class="navbar">
<c:choose>
    <c:when test="${idRol==1}">
        <ul>
            <li><a href="ir-a-crear-solicitud">Nueva Solicitud</a></li>
            <li><a href="ver-postulados">Postulantes</a></li>
            <li><a href="historial">Historial</a></li>
            <li><a href="ir-a-mis-asistencias">Empelos sin postulados</a></li>
            <!--<li><a href="ir-a-asistencias">Empleos</a></li>-->
            <li><a href="ver-mis-empleos-coordinados">Empleos Coordinados</a></li>
            <li><a href="ver-mi-perfil-publico-cliente">Mi perfil</a></li>
            <li> <a href="./buzon"><i class="far fa-envelope fa-2x" style="color: green" ><label class="badge badge-light" id="mensajePendientes"/></i> </a></li>
            <li><a href="cerrar-sesion" class="link-light">Salir <i class="fas fa-sign-out-alt"></i></a></li>
        </ul>
        </nav>
    </c:when>
    <c:when test="${idRol==2}">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="ir-a-asistencias">Empleos</a></li>
            <li><a href="ir-a-registrar-perfil-profesional">Registrar perfil</a></li>
            <li><a href="ir-a-registrar-perfil-profesional">Editar perfil</a></li>
            <li><a href="ver-mi-perfil-publico-profesional">Mi perfil</a></li>
            <li><a href="ver-resenias-profesional">Ver mis rese&ntilde;as</a></li>
            <li> <a href="respuestas"><i class="far fa-envelope fa-2x" style="color: green"><label id="mensajePendientes" class="badge badge-light"/></i> </a></li>
            <li><a href="cerrar-sesion" class="link-light">Salir <i class="fas fa-sign-out-alt"></i></a></li>
        </ul>
    </c:when>
    <c:otherwise>
        <ul>
            <li><a class="nav-link scrollto active" href="index#hero">Home</a></li>
            <li><a class="nav-link scrollto" href="index#about">Nosotros</a></li>
            <li><a class="nav-link scrollto" href="index#services">Servicios</a></li>
            <li><a class="nav-link scrollto" href="index#contact">Contacto</a></li>
            <li><a class="getstarted scrollto" href="login">Log in</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
    </c:otherwise>
    </c:choose>
    </nav><!-- .navbar -->
    <script>
    $(document).ready(function(){
            $.ajax({ url: "pendientes",
                success: function(data){
                    $("#mensajePendientes").html(data);
                }
            });
        });
    </script>
</div>
</header>