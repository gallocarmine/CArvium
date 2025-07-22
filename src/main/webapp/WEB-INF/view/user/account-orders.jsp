<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Account - Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/account-orders.css">
</head>
<body>

<div class="orders-container">

    <h2>My Orders</h2>

    <table class="orders-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Quantity</th>
            <th>Total Cost</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

</body>
</html>
