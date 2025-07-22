function addToCart(spareId, quantityInput, clickedIcon) {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/common/CartServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams({
            spare: spareId,
            quantity: quantityInput,
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

            const container = clickedIcon.closest('#spare-card');

            if(data.overflow === 'overflow') {

                if (!container.querySelector('#quantity-error-msg')) {

                    const errorMsg = document.createElement('p');
                    errorMsg.textContent = 'Quantity exceeds available stock when combined with current cart quantity.';
                    errorMsg.id = 'quantity-error-msg'

                    setTimeout(() => { errorMsg.remove(); }, 3000);

                    const quantityInput = container.querySelector('#quantity-spare');
                    quantityInput.insertAdjacentElement('afterend', errorMsg);
                }
            }
            else {

                container.querySelector('#quantity-error-msg')?.remove();
                updateCart();
            }
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


function addUICart(spares, addQuantity) {

    const cart = document.querySelector('.spare-container');

    const spare = document.createElement('div');
    spare.id = 'c-spare-card';

    const brand = document.createElement('h3');
    brand.textContent = spares.idmarcaAuto;
    brand.id = 'c-brand-title'
    spare.appendChild(brand);

    const model = document.createElement('h2');
    model.textContent = spares.id;
    model.id = 'c-spare-id';
    spare.appendChild(model);

    const contextPath = '/' + window.location.pathname.split('/')[1];
    const img = document.createElement('img');
    const sanitizedId = spares.id.toLowerCase().replace(/\s+/g, '-');
    img.src = `${contextPath}/images/shop/model-spare/${sanitizedId}.png`
    img.id = 'c-img-spare';
    spare.appendChild(img);

    const category = document.createElement('p');
    category.textContent = spares.categoria;
    category.id = 'c-category-title';
    spare.appendChild(category);

    const year = document.createElement('p');
    year.textContent = spares.anno;
    year.id = 'c-year-model';
    spare.appendChild(year);

    const quantity = document.createElement('p');
    if(spares.quantita === 0){

        quantity.textContent = 'Out of stock';
        quantity.style.color = '#ad0707';
        quantity.id = 'c-quantity-spare'
        spare.appendChild(quantity);
    }
    else{

        const price = document.createElement('p');
        price.textContent = spares.prezzo + ' $';
        price.id = 'c-price-spare'
        spare.appendChild(price);

        quantity.textContent = 'x' + addQuantity;

        const icon = document.createElement('i');
        icon.className = 'bi-cart-dash';
        icon.id = 'c-cart-icon';
        quantity.id = 'c-quantity-spare'
        spare.appendChild(quantity);

        icon.addEventListener('click', function (event) {

            removeFromCart(spares.id);
        });

        spare.appendChild(icon);
    }

    cart.appendChild(spare);
}


function removeFromCart(spareId) {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/common/CartServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: new URLSearchParams({
            spare: spareId,
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

                updateCart();
            }
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


function updateCart() {

    const cart = document.querySelector('.cart-container');
    const spareContainer = document.querySelector('.spare-container');
    spareContainer.textContent = '';

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/common/CartServlet`, {
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

            if(data.result === true){

                data.spares.forEach((spare, index) => {

                    const quantity = data.addQuantity[index];
                    addUICart(spare, quantity);
                });
            }

            const orderButton = document.getElementById('order-button');
            const secondLine = document.getElementById('second-line');
            secondLine.textContent = `${data.totalCost} $ • ${data.totalQuantity} spare`;
            orderButton.disabled = false;

            if(data.totalQuantity === 0){

                orderButton.disabled = true;
            }
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


function orderCheckout() {

    const basePath = window.location.pathname.split('/')[1];
    window.location.href = `/${basePath}/user/CheckoutServlet`;
}


function confirmPayment() {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/user/OrderServlet`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            const button = document.getElementById('pay-button');
            button.textContent = '';

            const confirmContainer = document.querySelector('.confirm-payment');


            if(data.result === 'accepted'){

                button.innerHTML = 'Payment Accepted <i class="bi bi-bag-check-fill"></i>';
                const result = document.createElement('p');
                result.innerHTML = 'Order confirmed <i class="bi bi-box2-fill"></i>';
                result.id = 'result-order';
                confirmContainer.appendChild(result);
            }
            else{

                button.innerHTML = 'Payment Declined <i class="bi bi-bag-x"></i>';
                const result = document.createElement('p');
                result.innerHTML = 'Order not confirmed <i class="bi bi-box2-fill"></i>';
                result.id = 'result-order';
                confirmContainer.appendChild(result);
            }

            button.onclick = null;
            button.disabled = true;


            const back = document.createElement('button');
            back.innerHTML = 'Back to Shop <i class="bi bi-cart2"></i>';
            back.id = 'back-shop';

            const basePath = window.location.pathname.split('/')[1];
            back.addEventListener('click', () => {
                window.location.href = `/${basePath}/common/ShopServlet`;
            });

            confirmContainer.appendChild(back);

        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


document.addEventListener('DOMContentLoaded', () => {

    const cartButton = document.getElementById('cart-button');
    const cart = document.querySelector('.cart-container');

    cartButton.addEventListener('mouseenter', function (event) {

        event.stopPropagation();

        if (cart.classList.contains('show')) {

            cart.classList.remove('show');
        }
        else {
            updateCart();
            cart.classList.add('show');
        }
    });
});

