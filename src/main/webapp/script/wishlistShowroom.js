function addToWishlist(modelId, brandId, clickedIcon) {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/user/WishlistServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams({
            model: modelId,
            brand: brandId,
            action: 'add'
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            clickedIcon.classList.replace('bi-heart', 'bi-heart-fill');
            addUIWishList(data.model);

        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


function addUIWishList(models){

    const wishlist = document.querySelector('.wishlist-container');

    const car = document.createElement('div');
    car.id = 'car-container';

    const brand = document.createElement('h3');
    brand.textContent = models.idmarcaAuto;
    brand.id = 'w-brand-title'
    car.appendChild(brand);

    const model = document.createElement('h3');
    model.textContent = models.id;
    model.id = 'w-model-id';
    car.appendChild(model);

    const contextPath = '/' + window.location.pathname.split('/')[1];
    const img = document.createElement('img');
    const sanitizedId = models.id.toLowerCase().replace(/\s+/g, '-');
    img.src = `${contextPath}/images/home-car/models-auto/${sanitizedId}.png`
    img.id = 'w-img-model';
    car.appendChild(img);

    const price = document.createElement('p');
    price.textContent = models.prezzo + ' $';
    price.id = 'w-price-model'
    car.appendChild(price);

    const category = document.createElement('p');
    category.textContent = models.categoria;
    category.id = 'w-category-title';
    car.appendChild(category);

    const year = document.createElement('p');
    year.textContent = models.anno;
    year.id = 'w-year-model';
    car.appendChild(year);

    wishlist.appendChild(car);
}


function removeFromWishlist(modelId, brandId, clickedIcon) {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/user/WishlistServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams({
            model: modelId,
            brand: brandId,
            action: 'remove'
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            if (data.result === true) {

                clickedIcon.classList.replace('bi-heart-fill', 'bi-heart');
                updateWishlist();
            }
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


function isWishlisted(modelId, brandId) {

    const basePath = window.location.pathname.split('/')[1];

    return fetch(`/${basePath}/user/WishlistServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams({
            model: modelId,
            brand: brandId,
            action: 'info'
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
}


document.addEventListener('DOMContentLoaded', () => {

    if (isUserLoggedIn) {

        const navbarIcons = document.querySelector('.icons');
        const icon = document.createElement('i');
        icon.id = 'wishlist-button';
        icon.className = 'bi bi-heart';

        navbarIcons.prepend(icon);

        const wishlistButton = document.getElementById('wishlist-button');
        const wishlist = document.querySelector('.wishlist-container');

        wishlistButton.addEventListener('mouseenter', function (event) {

            event.stopPropagation();

            if (wishlist.classList.contains('show')) {

                wishlist.classList.remove('show');
            }
            else {
                updateWishlist();
            }
        });
    }
});


function updateWishlist(){

    const wishlist = document.querySelector('.wishlist-container');

    wishlist.textContent = '';
    const title = document.createElement('h3');
    title.textContent = 'Wishlist';
    wishlist.append(title);

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/user/WishlistServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams({
            action: 'list'
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            data.models.forEach(model => {

                addUIWishList(model);
            });

            wishlist.classList.add('show');
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


