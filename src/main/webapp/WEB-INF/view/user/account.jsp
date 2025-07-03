<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
</head>
<body>

<div class="btn-group">

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





