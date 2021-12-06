<%@include file="header.jsp" %>

<title>Mensajería</title>

   <tbody>
  <form:form action="preguntar" method="POST" modelAttribute="datosMensajeria">

                 <label for="mensaje"> Formule su pregunta: </label>
                       <br/>
                   <textarea id="mensaje" name="mensaje" rows="5" cols="40">
                    </textarea>
                    <input id="idAsistencia" name="idAsistencia" type="hidden"
                     value= "${datosMensajeria.idAsistencia}" >

    <button id="btn-registrarme" class="btn-light-blue" Type="Submit"/>Preguntar</button>
</form:form>
  <%@include file="footer.jsp" %>
</body>
</html>
