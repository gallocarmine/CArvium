<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account - Dashboard</title>
</head>
<body>

<div class="dashboard-container">

    <h2>Dashboard</h2>

    <div class="gross-revenues-container">
        <h3>Gross Revenues</h3>
        <p id="gross-revenues"></p>
    </div>

    <div class="total-order-container">
        <h3>Total Orders</h3>
        <p id="total-order"></p>
    </div>

    <div class="spares-sold-container">
        <h3>Spares Sold</h3>
        <p id="spares-sold"></p>
    </div>

    <div class="average-revenue-container">
        <h3>Average Revenue</h3>
        <p id="average-revenue"></p>
    </div>


    <table class="dashboard-orders">
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
