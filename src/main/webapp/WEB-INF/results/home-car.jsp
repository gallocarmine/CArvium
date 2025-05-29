<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home-Car</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar-car.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<!-- Navbar-->
<div class="navbar-car">
    <a href="${pageContext.request.contextPath}/StartServlet" class="logo">
        <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo">
    </a>
    <div class="login-icon">
        <a href="${pageContext.request.contextPath}/LoginServlet">
            <c:if test = "${empty user}">
                <i class="bi bi-person-fill" style="font-size: 1.8rem; color: #000000;"></i>
            </c:if>
            <c:if test = "${not empty user}">
                <i class="bi bi-person-gear" style="font-size: 1.8rem; color: #000000;"></i>
            </c:if>
        </a>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>



