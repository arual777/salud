<!DOCTYPE html>

<%@include file="header.jsp" %>
<section id="register" class="d-flex align-items-center">

    <div class="container">
        <div class="row gy-4">
            <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="registrarme" method="POST" modelAttribute="datos">
            <h3 class="form-signin-heading">Nuevo Usuario ${parametro}</h3>
            <br>
            <label>Email</label>
            <form:input path="email" id="email" class="form-control" />
            <label>Clave</label>
            <form:input path="clave" type="password" id="clave" class="form-control" />
            <label>Repite clave</label>
            <form:input path="repiteClave" type="password" id="clave" class="form-control"/>

            <label for="rol">Rol:</label>
                 <select id="rolId" name="rolId" required>
                       <option value="">  </option>
                        <option value="1"> CLIENTE </option>
                        <option value="2"> PROFESIONAL </option>
                </select>
                           <br/> <br/>
            <button id="btn-registrarme" class="btn-light-blue" Type="Submit"/>Registrarme</button>

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
        </div>
</div>
</section>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>