const form = document.getElementById("loginForm");

form.addEventListener("submit", function(e) {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    if (validateEmail(email) && validatePassword(password)) {

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


