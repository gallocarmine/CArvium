<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/car/navbar-car.css">
</head>
<body>

<div class="navbar-car">

    <div class="dropdown-menu">
        <button class="menu-button">☰</button>
        <div class="menu-content">
            <p id="brand">Brand</p>
            <p id="models">Category</p>
            <a href="${pageContext.request.contextPath}/common/ShopServlet">
                Shop <i class="bi bi-cart3"></i>
            </a>
        </div>

        <div class="submenu-brand">
            <div class="brand-grid">
                <div class="brand-logo">
                    <h3>Porsche</h3>
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=porsche&category=all">
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Porsche-logo.png" alt="Porsche">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=ferrari&category=all">
                        <h3>Ferrari</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Ferrari-logo.png" alt="Ferrari">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=lamborghini&category=all">
                        <h3>Lamborghini</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Lamborghini-logo.svg" alt="Lamborghini">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=rolls-royce&category=all">
                        <h3>Rolls-Royce</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/RollsRoyce-logo.png" alt="Rolls-Royce">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=bugatti&category=all">
                        <h3>Bugatti</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Bugatti-logo.jpg" alt="Bugatti">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=maserati&category=all">
                        <h3>Maserati</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Maserati-logo.png" alt="Maserati">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=mclaren&category=all">
                        <h3>McLaren</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/McLaren-logo.jpg" alt="McLaren">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=mercedes&category=all">
                        <h3>Mercedes</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Mercedes-logo.png" alt="Mercedes">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=audi&category=all">
                        <h3>Audi</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/Audi-logo.png" alt="Audi">
                    </a>
                </div>
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=bmw&category=all">
                        <h3>BMW</h3>
                        <img src="${pageContext.request.contextPath}/images/brand-auto/BMW-logo.jpg" alt="BMW">
                    </a>
                </div>
            </div>
        </div>

        <div class="submenu-models">
            <div class="models-grid">
                <div class="models-container">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=all&category=supercar">
                        <h3>Supercar</h3>
                        <img src="${pageContext.request.contextPath}/images/home-car/category-auto/supercar-model.png" alt="Supercar">
                    </a>
                </div>
                <div class="models-container">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=all&category=coupe">
                        <h3>Coupe'</h3>
                        <img src="${pageContext.request.contextPath}/images/home-car/category-auto/coupe-model.png" alt="Coupe">
                    </a>
                </div>
                <div class="models-container">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=all&category=cabrio">
                        <h3>Cabrio</h3>
                        <img src="${pageContext.request.contextPath}/images/home-car/category-auto/cabrio-model.png" alt="Cabrio">
                    </a>
                </div>
                <div class="models-container">
                    <a href="${pageContext.request.contextPath}/common/CarFilterServlet?brand=all&category=suv">
                        <h3>SUV</h3>
                        <img src="${pageContext.request.contextPath}/images/home-car/category-auto/suv-model.png" alt="SUV">
                    </a>
                </div>
            </div>
        </div>
    </div>

        <a href="${pageContext.request.contextPath}/common/StartServlet" class="logo">
            <img src="${pageContext.request.contextPath}/images/white-logo.png" alt="Logo">
        </a>

        <div class="login-icon">
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

<script src="${pageContext.request.contextPath}/script/menuView.js"></script>
</body>
</html>
