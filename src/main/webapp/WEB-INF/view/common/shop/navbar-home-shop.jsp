<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/navbar-shop.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<div class="navbar-shop">

    <a href="${pageContext.request.contextPath}/common/StartServlet" class="logo">
        <img src="${pageContext.request.contextPath}/images/white-logo.png" alt="Logo">
    </a>

    <div class="icons">

        <i id="cart-button" class="bi bi-cart2"></i>

        <c:if test="${empty user}">
            <a href="${pageContext.request.contextPath}/auth/LoginServlet">
                <i class="bi bi-person-fill"></i>
            </a>
        </c:if>

        <c:if test="${not empty user}">
            <a href="${pageContext.request.contextPath}/user/AccountServlet">
                <i class="bi bi-person-gear"></i>
            </a>
        </c:if>

        <c:if test="${not empty user}">
            <a href="${pageContext.request.contextPath}/user/LogoutServlet">
                <i class="bi bi-box-arrow-right"></i>
            </a>
        </c:if>
    </div>
</div>

</body>
</html>
