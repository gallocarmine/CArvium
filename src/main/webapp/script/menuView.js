document.addEventListener('DOMContentLoaded', function () {

    const menuButton = document.querySelector('.menu-button');
    const dropdownMenu = document.querySelector('.dropdown-menu');
    const menuContent = document.querySelector('.menu-content');

    const submenuBrand = document.querySelector('.submenu-brand');
    const submenuModels = document.querySelector('.submenu-models');

    const brand = document.getElementById('brand');
    const models = document.getElementById('models');

    let brandTimeout, modelsTimeout;


    menuButton.addEventListener('mouseenter', function (event) {

        event.stopPropagation();

        if(menuButton.classList.contains('show')){

            submenuModels.classList.remove('show');
            submenuBrand.classList.remove('show');
            menuContent.classList.remove('show');
            menuButton.classList.remove('show');
        }
        else{

            menuContent.classList.add('show');
            menuButton.classList.add('show');
        }
    });

    brand.addEventListener('mouseenter', () => {

        clearTimeout(brandTimeout);
        clearTimeout(modelsTimeout);
        submenuModels.classList.remove('show');
        submenuBrand.classList.add('show');
    });

    brand.addEventListener('mouseleave', () => {

        brandTimeout = setTimeout(() => {
            submenuBrand.classList.remove('show');
        }, 200);
    });

    submenuBrand.addEventListener('mouseenter', () => {
        clearTimeout(brandTimeout);
    });

    submenuBrand.addEventListener('mouseleave', () => {

        brandTimeout = setTimeout(() => {
            submenuBrand.classList.remove('show');
        }, 200);
    });

    models.addEventListener('mouseenter', () => {

        clearTimeout(brandTimeout);
        clearTimeout(modelsTimeout);
        submenuBrand.classList.remove('show');
        submenuModels.classList.add('show');
    });

    models.addEventListener('mouseleave', () => {

        modelsTimeout = setTimeout(() => {
            submenuModels.classList.remove('show');
        }, 200);
    });

    submenuModels.addEventListener('mouseenter', () => {
        clearTimeout(modelsTimeout);
    });

    submenuModels.addEventListener('mouseleave', () => {

        modelsTimeout = setTimeout(() => {
            submenuModels.classList.remove('show');
        }, 200);
    });

    document.addEventListener('click', function (event) {

        if (!dropdownMenu.contains(event.target)) {

            submenuBrand.classList.remove('show');
            submenuModels.classList.remove('show');
            menuContent.classList.remove('show');
        }
    });
});