function fetchFilterCar(brandFilter, categoryFilter) {

    if (brandFilter != null) {

        document.getElementById("brand-filter").value = brandFilter;
    }

    if (categoryFilter != null) {

        document.getElementById('category-filter').value = categoryFilter;
    }

    const form = document.getElementById('filter-form');

    const formData = new FormData(form);
    const urlParams = new URLSearchParams(formData);
    const basePath = window.location.pathname.split('/')[1];

    return fetch(`/${basePath}/common/CarFilterServlet`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        body: urlParams.toString()
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
}


function filterCar(brandFilter, categoryFilter) {

    fetchFilterCar(brandFilter, categoryFilter)
        .then(data => {

            changeOptionFilter(data);

            const showroom = document.querySelector('.showroom-container');
            showroom.textContent = '';

            data.carsInfo.forEach(carInfo => {

                const car = document.createElement('div');
                car.id = 'car-card';

                const brand = document.createElement('h3');
                brand.textContent = carInfo.idmarcaAuto;
                brand.id = 'brand-title'
                car.appendChild(brand);

                const model = document.createElement('h2');
                model.textContent = carInfo.id;
                model.id = 'model-id';
                car.appendChild(model);

                const contextPath = '/' + window.location.pathname.split('/')[1];
                const img = document.createElement('img');
                const sanitizedId = carInfo.id.toLowerCase().replace(/\s+/g, '-');
                img.src = `${contextPath}/images/home-car/showroom/${sanitizedId}.png`
                img.id = 'img-model';
                car.appendChild(img);

                const price = document.createElement('p');
                price.textContent = carInfo.prezzo + ' $';
                price.id = 'price-model'
                car.appendChild(price);

                const category = document.createElement('p');
                category.textContent = carInfo.categoria;
                category.id = 'category-title';
                car.appendChild(category);

                const year = document.createElement('p');
                year.textContent = carInfo.anno;
                year.id = 'year-model';
                car.appendChild(year);

                const description = document.createElement('p');
                description.textContent = carInfo.descrizione;
                description.id = 'description-model';
                car.appendChild(description);

                if (isUserLoggedIn) {

                    const icon = document.createElement('i');

                    isWishlisted(carInfo.id, carInfo.idmarcaAuto)
                        .then(data => {

                            if(data.result === true){

                                icon.className = 'bi bi-heart-fill';
                            }
                            else{

                                icon.className = 'bi bi-heart';
                            }
                        })
                        .catch(error => {
                            console.error('There was a problem with the fetch operation:', error);
                        });


                    let clickTimeout = null;

                    icon.addEventListener('click', function (event) {

                        if (clickTimeout) return;
                        const clickedIcon = event.currentTarget;

                        clickTimeout = setTimeout(() => {

                            removeFromWishlist(carInfo.id, carInfo.idmarcaAuto, clickedIcon);
                            clickTimeout = null;
                        }, 250);
                    });

                    icon.addEventListener('dblclick', function (event) {

                        if (clickTimeout) {

                            clearTimeout(clickTimeout);
                            clickTimeout = null;
                        }

                        const clickedIcon = event.currentTarget;
                        addToWishlist(carInfo.id, carInfo.idmarcaAuto, clickedIcon);
                    });

                    icon.id = 'wishlist-icon';
                    car.appendChild(icon);
                }

                showroom.appendChild(car);
            })
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}


function changeOptionFilter(data) {

    const brand = document.getElementById('brand-filter').value;
    const category = document.getElementById('category-filter').value;

    const currentBrand = brand;
    const currentCategory = category;

    if (brand === 'all' && category === 'all') {

        const categoryFilter = document.getElementById('category-filter');
        categoryFilter.textContent = '';

        const optionCategory = document.createElement('option');
        optionCategory.value = 'all';
        optionCategory.textContent = 'All';
        categoryFilter.appendChild(optionCategory);

        data.categories.forEach(category => {
            const opt = document.createElement('option');
            opt.textContent = category[0].toUpperCase() + category.slice(1).toLowerCase();
            opt.value = category;
            categoryFilter.appendChild(opt);
        });

        const brandFilter = document.getElementById('brand-filter');
        brandFilter.textContent = '';

        const optionBrand = document.createElement('option');
        optionBrand.value = 'all';
        optionBrand.textContent = 'All';
        brandFilter.appendChild(optionBrand);

        data.brand.forEach(brand => {
            const opt = document.createElement('option');
            opt.textContent = brand[0].toUpperCase() + brand.slice(1).toLowerCase();
            opt.value = brand;
            brandFilter.appendChild(opt);
        });
    }
    else {

        if (brand !== 'all' && category === 'all') {

            const categoryFilter = document.getElementById('category-filter');
            categoryFilter.textContent = '';

            const option = document.createElement('option');
            option.value = 'all';
            option.textContent = 'All';
            categoryFilter.appendChild(option);

            data.categories.forEach(category => {
                const opt = document.createElement('option');
                opt.textContent = category[0].toUpperCase() + category.slice(1).toLowerCase();
                opt.value = category;
                categoryFilter.appendChild(opt);
            });

            if ([...categoryFilter.options].some(opt => opt.value === currentCategory)) {
                categoryFilter.value = currentCategory;
            }

        } else {

            fetchFilterCar(brand, 'all')
                .then(newData => {
                    insertDefaultOption('category-filter', newData.categories);

                    const categoryFilter = document.getElementById('category-filter');
                    if ([...categoryFilter.options].some(opt => opt.value === currentCategory)) {
                        categoryFilter.value = currentCategory;
                    }
                });
        }

        if (category !== 'all' && brand === 'all') {

            const brandFilter = document.getElementById('brand-filter');
            brandFilter.textContent = '';

            const option = document.createElement('option');
            option.value = 'all';
            option.textContent = 'All';
            brandFilter.appendChild(option);

            data.brand.forEach(brand => {
                const opt = document.createElement('option');
                opt.textContent = brand[0].toUpperCase() + brand.slice(1).toLowerCase();
                opt.value = brand;
                brandFilter.appendChild(opt);
            });

            if ([...brandFilter.options].some(opt => opt.value === currentBrand)) {
                brandFilter.value = currentBrand;
            }

        } else {
            fetchFilterCar('all', category)
                .then(newData => {
                    insertDefaultOption('brand-filter', newData.brand);

                    const brandFilter = document.getElementById('brand-filter');
                    if ([...brandFilter.options].some(opt => opt.value === currentBrand)) {
                        brandFilter.value = currentBrand;
                    }
                });
        }
    }

    const yearFilter = document.getElementById('year-filter');
    const currentYear = yearFilter.value;
    yearFilter.textContent = '';

    if (currentYear === 0) {

        const defaultYear = document.createElement('option');
        defaultYear.textContent = 'All';
        defaultYear.value = 0;
        yearFilter.appendChild(defaultYear);

        data.years.forEach(year => {

            const option = document.createElement('option');
            option.textContent = year;
            option.value = year;

            yearFilter.appendChild(option);
        })

        if ([...yearFilter.options].some(opt => opt.value === currentYear)) {
            yearFilter.value = currentYear;
        }
    } else {

        fetchFilterCar(brand, category)
            .then(newData => {

                const defaultYear = document.createElement('option');
                defaultYear.textContent = 'All';
                defaultYear.value = 0;
                yearFilter.appendChild(defaultYear);

                newData.years.forEach(year => {

                    const option = document.createElement('option');
                    option.textContent = year;
                    option.value = year;

                    yearFilter.appendChild(option);
                })

                if ([...yearFilter.options].some(opt => opt.value === currentYear)) {
                    yearFilter.value = currentYear;
                }
            });
    }

    const minPrice = document.getElementById('min-price');
    minPrice.placeholder = data.minPrice;

    const maxPrice = document.getElementById('max-price');
    maxPrice.placeholder = data.maxPrice;


    minPrice.addEventListener('change', function () {

        let min = Number(minPrice.placeholder);
        let max = Number(maxPrice.placeholder);

        const val = parseInt(minPrice.value);

        if (val < min || val > max) {

            minPrice.value = min;
        }
    });

    maxPrice.addEventListener('change', function () {

        let min = Number(minPrice.placeholder);
        let max = Number(maxPrice.placeholder);

        const val = parseInt(maxPrice.value);

        if (val > max || val < min) {

            maxPrice.value = max;
        }
    });
}


function insertDefaultOption(id, options) {

    const select = document.getElementById(id);
    select.textContent = '';

    const option = document.createElement('option');
    option.value = 'all';
    option.textContent = 'All';
    select.appendChild(option);

    options.forEach(opt => {
        const option = document.createElement('option');
        option.value = opt;
        option.textContent = opt[0].toUpperCase() + opt.slice(1).toLowerCase();
        select.appendChild(option);
    });
}