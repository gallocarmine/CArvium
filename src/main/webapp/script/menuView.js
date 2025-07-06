document.addEventListener('DOMContentLoaded', function () {

    const menuButton = document.querySelector('.menu-button');
    const menuContent = document.querySelector('.menu-content');

    menuButton.addEventListener('mouseenter', function (event) {
        event.stopPropagation();
        menuContent.classList.toggle('show');
    });

    document.addEventListener('click', function (event) {
        if (!menuContent.contains(event.target) && !menuButton.contains(event.target)) {
            menuContent.classList.remove('show');
        }
    });
});