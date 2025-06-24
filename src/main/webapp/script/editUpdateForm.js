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

    const form= document.getElementById("updateForm");
    const saveChanges= document.createElement("input");
    saveChanges.type = "submit";
    saveChanges.value = "Save Changes";

    form.appendChild(saveChanges);
}