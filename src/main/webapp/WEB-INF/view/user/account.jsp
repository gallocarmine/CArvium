<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/account.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<div class="btn-group">

    <a href="${pageContext.request.contextPath}/common/StartServlet">
        <i class="bi bi-house-fill"></i>
    </a>

    <button id="button-data" onclick=switchToData()>My Data</button>

    <button id="button-orders" onclick=switchToOrder()>Orders</button>

    <c:if test="${not empty admin}">
        <button id="button-dashboard" onclick=switchToDashboard()>Dashboard</button>
    </c:if>

</div>

<jsp:include page="account-data.jsp"/>
<jsp:include page="account-orders.jsp"/>
<jsp:include page="account-dashboard.jsp"/>

</body>
</html>

<script>document.addEventListener('DOMContentLoaded', function () { switchToData() }); </script>
