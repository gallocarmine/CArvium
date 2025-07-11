<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/account.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="btn-group">

    <button onclick="window.location.href='${pageContext.request.contextPath}/common/StartServlet'" title="Home">
        <i class="fas fa-home"></i>
    </button>

    <button onclick=switchToData()>My Data</button>

    <c:if test="${empty admin}">
        <button onclick=switchToOrder()>Orders</button>
    </c:if>

    <c:if test="${not empty admin}">
        <button onclick=switchToDashboard()>Dashboard</button>
    </c:if>

</div>

<jsp:include page="account-data.jsp"/>
<jsp:include page="account-orders.jsp"/>
<jsp:include page="account-dashboard.jsp"/>

</body>
</html>

<script>document.addEventListener('DOMContentLoaded', function () { switchToData() }); </script>
