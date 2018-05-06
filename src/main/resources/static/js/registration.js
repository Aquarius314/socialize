
var loginButton = document.getElementById("loginButton");
var registerButton = document.getElementById("registerButton");
var emailInput = document.getElementById("emailInput");
var passwordInput = document.getElementById("passwordInput");
var nameInput = document.getElementById("nameInput");
var surnameInput = document.getElementById("surnameInput");

loginButton.onclick = function (e) {
    alert("Empty for now!");
}

registerButton.onclick = function (e) {
    var email = emailInput.value;
    var password = passwordInput.value;
    var name = nameInput.value;
    var surname = surnameInput.value;
    if (email && password && name && surname) {
        alert("Registering...");
        e.preventDefault();
        $.post({
            url : '/register-new-user',
            data : {
                'email' : email,
                'password' : password,
                'name' : name,
                'surname' : surname
            },
            success : function(res) {
                if (res.validated) {
                    window.location.href = '/all-profiles';
                }
            }
        })
    } else {
        alert("Please fill all forms to register");
    }
}
