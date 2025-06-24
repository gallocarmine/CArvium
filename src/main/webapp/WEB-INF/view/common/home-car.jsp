<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home-Car</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar-car.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home-car.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<jsp:include page="navbar-home-car.jsp"/>

<div class="intro-section">
    <div class="intro-text">
        <h2>Benvenuto su Carvium</h2>
        <p>
            Carvium è il tuo punto di riferimento esclusivo per auto di alta gamma e componenti esclusivi. Offriamo una selezione meticolosa dei migliori brand automobilistici, garantendo veicoli che rappresentano l'apice di qualità e prestazioni.
            La nostra dedizione si riflette nell'esperienza che offriamo: un team di professionisti appassionati, impegnati a guidarti con serietà e trasparenza verso l'auto perfetta per te. Ogni acquisto è supportato da consulenza personalizzata
            e un servizio clienti impeccabile, perché crediamo che l'eccellenza non debba riguardare solo l'auto, ma l'intera esperienza.
            Scopri le nostre categorie e trova la vettura dei tuoi sogni. Da Carvium, la tua prossima auto di prestigio ti aspetta.
        </p>
    </div>
    <div class="intro-image">
        <img src="${pageContext.request.contextPath}/images/car-desc.jpg" alt="Carvium Project">
    </div>
</div>

<div class="main-content">
    <div class="divider"><span>Brand Auto</span></div>

    <div class="divider-section">
        <div class="card-grid">
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Porsche-logo.png" alt="Card 1"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Ferrari-logo.png" alt="Card 2"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Lamborghini-logo.svg" alt="Card 3"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/RollsRoyce-logo.png" alt="Card 4"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Bugatti-logo.jpg" alt="Card 5"></div>
        </div>
    </div>

    <div class="divider-section">
        <div class="card-grid">
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Maserati-logo.png" alt="Card 6"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/McLaren-logo.jpg" alt="Card 7"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Mercedes-logo.png" alt="Card 8"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Audi-logo.png" alt="Card 9"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/BMW-logo.jpg" alt="Card 10"></div>
        </div>
    </div>
    <div class="divider"></div>
</div>

<jsp:include page="footer.jsp"/>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const menuButton = document.querySelector('.menu-button');
        const menuContent = document.querySelector('.menu-content');

        menuButton.addEventListener('click', function (event) {
            event.stopPropagation();
            menuContent.classList.toggle('show');
        });

        document.addEventListener('click', function (event) {
            if (!menuContent.contains(event.target) && !menuButton.contains(event.target)) {
                menuContent.classList.remove('show');
            }
        });
    });
</script>

</body>
</html>




