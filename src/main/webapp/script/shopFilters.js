function fetchFilterShop(brandFilter, categoryFilter) {

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

    return fetch(`/${basePath}/common/ShopFilterServlet`, {
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


function filterShop(brandFilter, categoryFilter) {

    fetchFilterShop(brandFilter, categoryFilter)
        .then(data => {

            changeOptionFilter(data);

            const shop = document.querySelector('.shop-container');
            shop.textContent = '';

            data.sparesInfo.forEach(spareInfo => {

                const spare = document.createElement('div');
                spare.id = 'spare-card';

                const brand = document.createElement('h3');
                brand.textContent = spareInfo.idmarcaAuto;
                brand.id = 'brand-title'
                spare.appendChild(brand);

                const model = document.createElement('h2');
                model.textContent = spareInfo.id;
                model.id = 'spare-id';
                spare.appendChild(model);

                const contextPath = '/' + window.location.pathname.split('/')[1];
                const img = document.createElement('img');
                const sanitizedId = spareInfo.id.toLowerCase().replace(/\s+/g, '-');
                img.src = `${contextPath}/images/home-car/models-auto/${sanitizedId}.png`
                img.id = 'img-spare';
                spare.appendChild(img);

                const category = document.createElement('p');
                category.textContent = spareInfo.categoria;
                category.id = 'category-title';
                spare.appendChild(category);

                const price = document.createElement('p');
                price.textContent = spareInfo.prezzo + ' $';
                price.id = 'price-spare'
                spare.appendChild(price);

                const year = document.createElement('p');
                year.textContent = spareInfo.anno;
                year.id = 'year-model';
                spare.appendChild(year);

                shop.appendChild(spare);
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

            fetchFilterShop(brand, 'all')
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
            fetchFilterShop('all', category)
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

        fetchFilterShop(brand, category)
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