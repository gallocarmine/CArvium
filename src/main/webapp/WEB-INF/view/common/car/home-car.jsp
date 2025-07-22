<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home-Car</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/car/home-car.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<jsp:include page="navbar-home-car.jsp"/>

<div class="video-container">
    <h2>Your exclusive destination <br>
        for high-end vehicles</h2>
    <video autoplay loop muted oncontextmenu="return false;">
        <source src="${pageContext.request.contextPath}/video/home-car.mp4" type="video/mp4">
    </video>
</div>

<div class="intro-image">
    <img src="${pageContext.request.contextPath}/images/home-car/car-intro.png" alt="intro-collage">
</div>

<div class="intro-section">

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
        <br><br>
        <h3>We don’t choose cars. We choose icons.</h3>
        <p>
            At Carvium we believe that true luxury is not a matter of options, but of standards. Each vehicle in our
            collection is more than a car: it is a statement of identity, design and engineering excellence. We don't
            follow trends. We curate the legacy.
            Our passion drives us to offer only the most distinctive, high-performance models, selected for those who
            expect more than movement: they expect excitement.
        </p>
    </div>

    <div class="intro-video">
        <video autoplay loop muted oncontextmenu="return false;">
            <source src="${pageContext.request.contextPath}/video/car-intro.mp4" type="video/mp4">
        </video>
    </div>
</div>


<div class="brand-container">
    <div class="divider-section">
        <div class="card-grid">
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Porsche-logo.png"
                                   alt="Porsche"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Ferrari-logo.png"
                                   alt="Ferrari"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Lamborghini-logo.svg"
                                   alt="Lamborghini"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/RollsRoyce-logo.png"
                                   alt="RollsRoyce"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Bugatti-logo.jpg"
                                   alt="Bugatti"></div>
        </div>
    </div>

    <div class="divider-section">
        <div class="card-grid">
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Maserati-logo.png"
                                   alt="Maserati"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/McLaren-logo.jpg"
                                   alt="McLaren"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Mercedes-logo.png"
                                   alt="Mercedes"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/Audi-logo.png"
                                   alt="Audi"></div>
            <div class="card"><img src="${pageContext.request.contextPath}/images/brand-auto/BMW-logo.jpg"
                                   alt="BMW"></div>
        </div>
    </div>
    <div class="divider"></div>
</div>

<jsp:include page="../footer.jsp"/>

</body>
</html>