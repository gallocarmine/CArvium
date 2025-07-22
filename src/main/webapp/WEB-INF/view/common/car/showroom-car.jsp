<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Showroom</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/wishlist.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/car/showroom-car.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>

<jsp:include page="navbar-home-car.jsp"/>

<div class="filter-group">

    <form id="filter-form">
        <label for="brand-filter">Brand</label>
        <select onchange=filterCar() name="brand" id="brand-filter">
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
        <select onchange=filterCar() name="category" id="category-filter">
            <option value="all">All</option>
            <option value="supercar">Supercar</option>
            <option value="suv">SUV</option>
            <option value="coupe">Coupe</option>
            <option value="cabrio">Cabrio</option>
        </select>

        <label for="year-filter">Year</label>
        <select onchange=filterCar() name="year" id="year-filter">
            <option value="0">All</option>
        </select>

        <label for="min-price">Min ($)</label>
        <input oninput=filterCar() type="number" name="min-price" id="min-price" placeholder="0">

        <label for="max-price">Max ($)</label>
        <input oninput=filterCar() type="number" name="max-price" id="max-price" placeholder="Max">
    </form>

</div>


<div class="showroom-container">

</div>


<div class="wishlist-container">

</div>


<jsp:include page="../footer.jsp"/>

<script src="${pageContext.request.contextPath}/script/showroomFilters.js"></script>
<script src="${pageContext.request.contextPath}/script/wishlistShowroom.js"></script>
<script>  const isUserLoggedIn = ${user == null ? 'false' : 'true'}; </script>
<script>

    document.addEventListener("DOMContentLoaded", () => {

        const brand = '${requestScope.selectedBrand}';
        const category = '${requestScope.selectedCategory}';

        if (brand && category) { filterCar(brand, category); }
    });

</script>

</body>
</html>

