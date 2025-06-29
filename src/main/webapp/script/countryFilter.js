const basePath = window.location.pathname.split('/')[1];

fetch(`/${basePath}/api/countries.json`)
    .then(res => res.json())
    .then(countries => {
        const select = document.getElementById('country');
        countries.forEach(country => {
            const option = document.createElement('option');
            option.value = country.code;
            option.textContent = country.name;
            select.appendChild(option);
        });
    })
    .catch(error => console.error("Errore nel caricamento:", error));