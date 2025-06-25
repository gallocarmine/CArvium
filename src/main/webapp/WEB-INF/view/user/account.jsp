<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
</head>
<body>

<h2>My Account</h2>

<div class="btn-group">
    <button>My Data</button>
    <c:if test="${empty admin}">
        <button>Orders</button>
    </c:if>
    <c:if test="${not empty admin}">
        <button>Dashboard</button>
    </c:if>
</div>


<jsp:include page="account-data.jsp"/>


</body>
</html>





