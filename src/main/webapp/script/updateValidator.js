const form = document.getElementById('updateForm');

form.addEventListener("submit", function(e) {

    e.preventDefault();

    const firstName = document.getElementById('firstname').value;
    const lastName = document.getElementById('lastname').value;
    const email = document.getElementById('email').value;
    const newPass = document.getElementById('newPass').value;
    const confirmPass = document.getElementById('confirmPass').value;
    const country = document.getElementById('country').value;
    const street = document.getElementById('street').value;
    const civic = document.getElementById('civic').value;
    const cap = document.getElementById('cap').value;


    if (isValid(firstName) && isValid(lastName)
        && validateEmail(email) && validatePasswords(newPass,confirmPass)
        && isValid(country) && isValid(street)
        && isValid(civic) && isValid(cap)) {

        HTMLFormElement.prototype.submit.call(form);
    }
    else {
        document.getElementById('error-js').innerHTML = 'Some fields are invalid or empty';
    }
});

function isValid(parameter) {

    return parameter != null && parameter.trim() !== '';
}

function validateEmail(parameter) {

    let pattern = /^[\w.!#$%&'*+/=?^`{|}~-]+@[a-z\d-]+(?:\.[a-z\d-]+)*$/i;
    return pattern.test(parameter);
}

function validatePasswords(newPass, confirmPass) {

    let pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$/;

    if(newPass === confirmPass){

        //no password changes
        if(confirmPass == ''){ return true; }

        return pattern.test(newPass) && pattern.test(confirmPass);
    }

    document.getElementById('errorPass-js').innerHTML = 'passwords do not match';
    return false;
}


