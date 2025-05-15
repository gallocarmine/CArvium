<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/card.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<!-- Navbar-->
<div class="navbar">
    <a href="${pageContext.request.contextPath}/StartServlet" class="logo">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo">
    </a>
    <div class="login-icon">
        <a href="${pageContext.request.contextPath}/LoginServlet">
            <i class="bi bi-person-fill" style="font-size: 1.8rem; color: #F5F5F5;"></i>
        </a>
    </div>
</div>

<!-- Cards -->
<div class="card-container">
    <div class="card">
        <a href="${pageContext.request.contextPath}/PrimaServlet">
            <img src="${pageContext.request.contextPath}/images/car.png" alt="Prima pagina">
        </a>
    </div>
    <div class="card">
        <a href="${pageContext.request.contextPath}/SecondaServlet">
            <img src="${pageContext.request.contextPath}/images/shop.png" alt="Seconda pagina">
        </a>
    </div>
</div>

<!-- Footer -->
<footer class="site-footer">
    <div class="footer-content">
        <div class="footer-logo">
            <img src="${pageContext.request.contextPath}/images/logo.svg" alt="Logo Footer">
        </div>
        <div class="footer-info">
            <p>&copy; 2025 CArvium. Tutti i diritti riservati.</p>
            <p>Email: info@carvium.com | Tel: +39 0123 456789</p>
            <p>Via Esempio 123, Milano, Italia</p>
        </div>
    </div>
</footer>
</body>
</html>