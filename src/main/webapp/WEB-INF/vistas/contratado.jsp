<%@include file="header.jsp" %>

<div class="container">
    <h1>${titulo}</h1>

    <div class="row" >
        <div class="col-md-10">
            <c:if test="${not empty msg}">
                <h4><span>${msg}</span></h4>
                <br>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
