<!DOCTYPE html>

<%@include file="header.jsp" %>

	<section id="register" class="d-flex align-items-center">

		<div class="container">
			<div class="row gy-4">
				<div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
					<h1>Registrate</h1>
			<div id="loginbox" style="margin-top:50px;margin-left: 50%;" class="mainbox col-md-8 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				<form:form action="validar-login" method="POST" modelAttribute="datosLogin">

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<label>Email</label>
					<form:input path="email" id="email" type="email" class="form-control" />
					<label>Clave</label>
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					
					<button class="btn-get-started scrollto" Type="Submit"/>Login</button>
				</form:form>
					<br>
				<a style="color: #00282E;" href="ir-a-registrarme">Registrarme</a>
				<%--Bloque que es visible si el elemento error no esta vacio	--%>
					<c:if test="${not empty msg}">
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
<%@include file="footer.jsp" %>

</html>
