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

    document.getElementById("button-orders")?.classList.remove("active");
    document.getElementById("button-dashboard")?.classList.remove("active");
    document.getElementById("button-data")?.classList.add("active");
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

            const tableName = "orders-table";
            createOrdersTable(data.ordersInfo, tableName);

        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });

    document.querySelector(".data-container").style.display = "none";
    document.querySelector(".orders-container").style.display = "block";

    document.getElementById("button-data")?.classList.remove("active");
    document.getElementById("button-orders")?.classList.add("active");
}


function switchToDashboard() {

    const basePath = window.location.pathname.split('/')[1];

    fetch(`/${basePath}/admin/DashboardInfoServlet`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {

            document.getElementById("gross-revenues").innerHTML = data.grossRevenues + " $";
            document.getElementById("total-order").innerHTML = data.totalOrders;
            document.getElementById("spares-sold").innerHTML = data.sparesSold;
            document.getElementById("average-revenue").innerHTML = data.averageRevenue + " $";

            const tableName = "dashboard-orders";
            createOrdersTable(data.ordersInfo, tableName);
            createSalesChart(data.ordersInfo);

        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });


    document.querySelector(".data-container").style.display = "none";
    document.querySelector(".dashboard-container").style.display = "block";

    document.getElementById("button-data")?.classList.remove("active");
    document.getElementById("button-dashboard")?.classList.add("active");
}


function createOrdersTable(ordersInfo, tableName){

    const table = document.querySelector("." + tableName + " tbody");
    table.innerHTML = "";

    ordersInfo.forEach(orderInfo => {

        const tr = document.createElement("tr");

        const tdId = document.createElement("td");
        tdId.textContent = orderInfo.id;
        tr.appendChild(tdId);

        const tdQuantity = document.createElement("td");
        tdQuantity.textContent = orderInfo.quantita;
        tr.appendChild(tdQuantity);

        const tdCost = document.createElement("td");
        tdCost.textContent = orderInfo.costoTotale + " $";
        tr.appendChild(tdCost);

        const tdDate = document.createElement("td");

        const dateArray = orderInfo.data;
        const date = new Date(dateArray[0], dateArray[1] - 1, dateArray[2], dateArray[3], dateArray[4]);
        tdDate.textContent = date.toLocaleDateString("it-IT");
        tr.appendChild(tdDate);

        table.appendChild(tr);
    });
}


function createSalesChart(ordersInfo) {

    const salesForMonth = {};

    ordersInfo.forEach(order => {
        const dateArray = order.data;
        const date = new Date(dateArray[0], dateArray[1] - 1, dateArray[2], dateArray[3], dateArray[4]);

        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const key = `${year}-${month}`;

        if (!salesForMonth[key]) {
            salesForMonth[key] = 0;
        }
        salesForMonth[key] += order.costoTotale;
    });

    const labels = Object.keys(salesForMonth).sort();
    const values = labels.map(month => salesForMonth[month]);

    const ctx = document.getElementById("sales-chart").getContext("2d");

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Monthly Sales ($)',
                data: values,
                borderColor: 'rgb(54, 162, 235)',
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                fill: true,
                pointRadius: 5
            }]
        },
        options: {
            responsive: true,
            plugins: {
                title: {
                    display: true,
                    text: 'Sales Performance',
                    font: {
                        size: 18,
                        family: "Nanum Myeongjo, Tahoma, Geneva, Verdana, sans-serif",
                        weight: 'bold'

                    }
                },
                legend: {
                    position: 'bottom',
                    labels: {
                        font: {
                            size: 14,
                            family: "Nanum Myeongjo, Tahoma, Geneva, Verdana, sans-serif",
                            weight: 'bold'
                        }
                    }
                },
                tooltip: {
                    bodyFont: {
                        size: 12,
                        family: "Nanum Myeongjo, Tahoma, Geneva, Verdana, sans-serif"
                    },
                    titleFont: {
                        size: 12,
                        family: "Nanum Myeongjo, Tahoma, Geneva, Verdana, sans-serif"
                    }
                }
            },
            scales: {
                x: {
                    type: 'time',
                    time: {
                        unit: 'month',
                        displayFormats: {
                            day: 'MM-yyyy'
                        }
                    },
                    title: {
                        display: true,
                        text: 'Date'
                    }
                },
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Sales ($)'
                    }
                }
            }
        }
    });
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