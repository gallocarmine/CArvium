<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home-Car</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar-car.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home-car.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<jsp:include page="navbar-home-car.jsp"/>

<div class="intro-section-1">
    <div class="intro-text">
        <h2>Carvium is your exclusive destination for high-end vehicles.</h2>
        <p>
            We offer a meticulously curated selection of the world’s finest automotive brands, ensuring vehicles that
            represent the pinnacle of quality and performance.
            Our dedication is reflected in the experience we provide: a team of passionate professionals, committed to
            guiding you with integrity and transparency toward the perfect car for you.
            Every purchase is backed by personalized consultation and impeccable customer service because we believe
            excellence should define not only the vehicle, but the entire journey.
            Explore our categories and find the car of your dreams.
            At Carvium, your next prestigious vehicle is waiting.
        </p>
    </div>
    <div class="intro-image">
        <img src="${pageContext.request.contextPath}/images/home-car/car-desc-2.png" alt="Carvium Project">
    </div>
</div>

<div class="intro-section-2">
    <div class="intro-image">
        <img src="${pageContext.request.contextPath}/images/home-car/car-desc-2.png" alt="Carvium Project">
    </div>
    <div class="intro-text">
        <h3>Where Excellence Takes Shape</h3>
        <p>
            We don’t just sell cars we cultivate a true passion for automotive excellence. We are a team of dedicated
            professionals, united by the belief that every luxury vehicle deserves a level of service and attention to
            detail worthy of its greatness.
            Our mission goes beyond the simple transaction: we build lasting relationships founded on trust,
            transparency, and expertise.
            Carvium’s story is one of dedication and deep industry knowledge. Every member of our team brings years of
            experience and a genuine passion for high-end automobiles. This unique combination allows us to hand-pick
            only the best, ensuring that every vehicle in our showroom reflects our highest standards of quality,
            performance, and sophistication.
            Choosing Carvium means trusting experts who share your passion. We are here to guide you with personalized
            consultations, to answer every question, and to make the process of purchasing your car smooth, enjoyable,
            and truly unforgettable.
            Welcome to Carvium where your satisfaction is our highest priority.
        </p>
    </div>
</div>

<div class="intro-section-3">
    <div class="intro-text">
        <h3>We don’t choose cars. We choose icons.</h3>
        <p>
            At Carvium we believe that true luxury is not a matter of options, but of standards.Each vehicle in our
            collection is more than a car: it is a statement of identity, design and engineering excellence. We don't
            follow trends. We curate the legacy.
            Our passion drives us to offer only the most distinctive, high-performance models, selected for those who
            expect more than movement: they expect excitement.
        </p>
    </div>
    <div class="intro-image">
        <img src="${pageContext.request.contextPath}/images/home-car/car-desc-2.png" alt="Carvium Project">
    </div>
</div>


<div class="main-content">
    <div class="divider"><span>Brand Auto</span></div>

    <div class="divider-section">
        <div class="card-grid">
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Porsche-logo.png"
                                   alt="Card 1"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Ferrari-logo.png"
                                   alt="Card 2"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Lamborghini-logo.svg"
                                   alt="Card 3"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/RollsRoyce-logo.png"
                                   alt="Card 4"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Bugatti-logo.jpg"
                                   alt="Card 5"></div>
        </div>
    </div>

    <div class="divider-section">
        <div class="card-grid">
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Maserati-logo.png"
                                   alt="Card 6"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/McLaren-logo.jpg"
                                   alt="Card 7"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Mercedes-logo.png"
                                   alt="Card 8"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Audi-logo.png"
                                   alt="Card 9"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/BMW-logo.jpg"
                                   alt="Card 10"></div>
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