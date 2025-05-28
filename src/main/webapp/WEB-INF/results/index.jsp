<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>HomePage</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar-start.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/card.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<!-- Navbar-->
<div class="navbar-index">
    <a href="${pageContext.request.contextPath}/StartServlet" class="logo">
        <img src="${pageContext.request.contextPath}/images/white-logo.png" alt="Logo">
    </a>
    <div class="login-icon">
        <a href="${pageContext.request.contextPath}/LoginServlet">
            <c:if test = "${empty user}">
                <i class="bi bi-person-fill" style="font-size: 1.8rem; color: #F5F5F5;"></i>
            </c:if>
            <c:if test = "${not empty user}">
                <i class="bi bi-person-gear" style="font-size: 1.8rem; color: #F5F5F5;"></i>
            </c:if>
        </a>
    </div>
</div>

<!-- Cards -->
<div class="card-container">
    <div class="card">
        <a href="${pageContext.request.contextPath}/CarServlet">
            <img src="${pageContext.request.contextPath}/images/car.png" alt="Car">
        </a>
    </div>
    <div class="card">
        <a href="${pageContext.request.contextPath}/ShopServlet">
            <img src="${pageContext.request.contextPath}/images/shop.png" alt="Shop">
        </a>
    </div>
</div>

<!-- Footer -->
<footer class="site-footer">
    <div class="footer-content">
        <div class="footer-logo">
            <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo Footer">
        </div>
        <div class="footer-info">
            <p>&copy; 2025 CArvium. All rights reserved.</p>
            <p>Email: info@carvium.com | Tel: +39 0123 456789</p>
            <p>123 Example Street, Milan, Italy</p>
        </div>
    </div>
</footer>

</body>
</html>