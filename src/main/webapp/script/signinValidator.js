const form = document.getElementById("signinForm");

form.addEventListener("submit", function(e) {
    e.preventDefault();

    const firstName = document.getElementById("firstname").value;
    const lastName = document.getElementById("lastname").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const country = document.getElementById("country").value;
    const street = document.getElementById("street").value;
    const civic = document.getElementById("civic").value;
    const cap = document.getElementById("cap").value;


    if (isValid(firstName) && isValid(lastName)
        && validateEmail(email) && validatePassword(password)
        && isValid(country) && isValid(street)
        && isValid(civic) && isValid(cap)) {

        HTMLFormElement.prototype.submit.call(form);
    }
    else {
        document.getElementById("error-js").innerHTML = "Some fields are invalid or empty";
    }
});

function isValid(parameter) {

    return parameter != null && parameter.trim() !== '';
}

function validateEmail(parameter) {

    let pattern = /^[\w.!#$%&'*+/=?^`{|}~-]+@[a-z\d-]+(?:\.[a-z\d-]+)*$/i;
    return pattern.test(parameter);
}

function validatePassword(parameter) {

    let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$/;
    return pattern.test(parameter);
}


