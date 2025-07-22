<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home-Shop</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/home-shop.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/cart.css">
</head>
<body>

<jsp:include page="navbar-home-shop.jsp"/>


<div class="filter-group">

    <form id="filter-form">
        <label for="brand-filter">Brand</label>
        <select onchange=filterShop() name="brand" id="brand-filter">
            <option value="all">All</option>
            <option value="porsche">Porsche</option>
            <option value="ferrari">Ferrari</option>
            <option value="lamborghini">Lamborghini</option>
            <option value="rolls-royce">Rolls-Royce</option>
            <option value="bugatti">Bugatti</option>
            <option value="maserati">Maserati</option>
            <option value="mclaren">McLaren</option>
            <option value="mercedes">Mercedes</option>
            <option value="audi">Audi</option>
            <option value="bmw">BMW</option>
        </select>

        <label for="category-filter">Category</label>
        <select onchange="filterShop()" name="category" id="category-filter">
            <option value="all">All</option>
            <option value="breaks">Breaks</option>
            <option value="car-body">Car Body</option>
            <option value="chain">Chain</option>
            <option value="clutch">Clutch</option>
            <option value="cushioning">Cushioning</option>
            <option value="electrical-system">Electrical System</option>
            <option value="engine">Engine</option>
            <option value="filters">Filters</option>
            <option value="suspension">Suspension</option>
            <option value="tires">Tires</option>
        </select>

        <label for="year-filter">Year</label>
        <select onchange=filterShop() name="year" id="year-filter">
            <option value="0">All</option>
        </select>

        <label for="min-price">Min ($)</label>
        <input oninput=filterShop() type="number" name="min-price" id="min-price" placeholder="0">

        <label for="max-price">Max ($)</label>
        <input oninput=filterShop() type="number" name="max-price" id="max-price" placeholder="Max">
    </form>
</div>

<div class="shop-container">

</div>


<div class="cart-container">

    <h3>Cart</h3>

    <div class="spare-container">

    </div>


    <button onclick="orderCheckout()" id="order-button">
        <span>Fast Checkout</span><br>
        <span id="second-line"></span>
    </button>
</div>

<jsp:include page="../footer.jsp"/>

<script src="${pageContext.request.contextPath}/script/shopFilters.js"></script>
<script src="${pageContext.request.contextPath}/script/cartShop.js"></script>

</body>
</html>
