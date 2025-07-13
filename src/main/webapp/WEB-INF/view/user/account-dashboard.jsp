<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account - Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/account-dashboard.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<div class="dashboard-container">

    <h2>
        Dashboard
        <i class="bi bi-graph-up"></i>
    </h2>

    <div class="dashboard-top">
        <div class="gross-revenues-container">
            <h3>
                Gross Revenues
                <i class="bi bi-cash-coin"></i>
            </h3>
            <p id="gross-revenues"></p>
        </div>

        <div class="total-order-container">
            <h3>
                <i class="bi bi-box-seam-fill"></i>
                Total Orders
            </h3>
            <p id="total-order"></p>
        </div>

        <div class="spares-sold-container">
            <h3>
                Spares Sold
                <i class="bi bi-nut"></i>
            </h3>
            <p id="spares-sold"></p>
        </div>

        <div class="average-revenue-container">
            <h3>
                Average Revenue
                <i class="bi bi-bar-chart-line-fill"></i>
            </h3>
            <p id="average-revenue"></p>
        </div>
    </div>

    <div class="dashboard-bottom">
        <h3>Orders</h3>
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

        <canvas id="sales-chart" width="700" height="400"></canvas>
    </div>
</div>
</body>
</html>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns"></script>