function switchToData() {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/user/UserInfoServlet`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            document.getElementById("firstname").value = data.userInfo.nome;
            document.getElementById("lastname").value = data.userInfo.cognome;
            document.getElementById("email").value = data.userInfo.email;
            document.getElementById("country").value = data.userInfo.nazione;
            document.getElementById("street").value = data.userInfo.via;
            document.getElementById("civic").value = data.userInfo.civico;
            document.getElementById("cap").value = data.userInfo.cap;

        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

    document.querySelector(".orders-container").style.display = "none";
    document.querySelector(".dashboard-container").style.display = "none";
    document.querySelector(".data-container").style.display = "block";
}


function switchToOrder() {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/user/OrderInfoServlet`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            const table = document.querySelector(".orders-table tbody");
            table.innerHTML = "";

            data.ordersInfo.forEach(orderInfo => {

                const tr = document.createElement("tr");

                const tdId = document.createElement("td");
                tdId.textContent = orderInfo.id;
                tr.appendChild(tdId);

                const tdQuantity = document.createElement("td");
                tdQuantity.textContent = orderInfo.quantita;
                tr.appendChild(tdQuantity);

                const tdCost = document.createElement("td");
                tdCost.textContent = orderInfo.costoTotale;
                tr.appendChild(tdCost);

                const tdDate = document.createElement("td");

                const dataArray = orderInfo.data;
                const date = new Date(dataArray[0], dataArray[1] - 1, dataArray[2], dataArray[3], dataArray[4]);
                tdDate.textContent = date.toLocaleDateString("en-US");
                tr.appendChild(tdDate);

                table.appendChild(tr);
            });
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

    document.querySelector(".data-container").style.display = "none";
    document.querySelector(".dashboard-container").style.display = "none";
    document.querySelector(".orders-container").style.display = "block";
}


function switchToDashboard() {

    document.querySelector(".data-container").style.display = "none";
    document.querySelector(".orders-container").style.display = "none";
    document.querySelector(".dashboard-container").style.display = "block";
}


function editFields() {

    document.getElementById("firstname").removeAttribute("readonly");
    document.getElementById("lastname").removeAttribute("readonly");
    document.getElementById("email").removeAttribute("readonly");
    document.getElementById("newPass").removeAttribute("readonly");
    document.getElementById("confirmPass").removeAttribute("readonly");
    document.getElementById("country").removeAttribute("disabled");
    document.getElementById("street").removeAttribute("readonly");
    document.getElementById("civic").removeAttribute("readonly");
    document.getElementById("cap").removeAttribute("readonly");

    const form = document.getElementById("updateForm");
    const saveChanges = document.createElement("input");
    saveChanges.type = "submit";
    saveChanges.value = "Save Changes";

    document.getElementById("editFields").style.display = "none";
    form.appendChild(saveChanges);
}