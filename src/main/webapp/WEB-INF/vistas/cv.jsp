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
    <div class="text-align-center">
        <h1>CV de ${curriculum.nombreCompleto}</h1>

        <p>${curriculum.experiencia}</p>
    </div>

</div>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
