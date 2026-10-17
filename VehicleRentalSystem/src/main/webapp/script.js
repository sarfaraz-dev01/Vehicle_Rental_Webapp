// =============================
// REGISTER VALIDATION
// =============================

function validateRegister() {

    let name = document.getElementById("name").value.trim();

    let email = document.getElementById("email").value.trim();

    let password = document.getElementById("password").value;

    let mobile = document.getElementById("mobile").value.trim();


    if (name.length < 3) {

        alert("Name must contain at least 3 characters.");

        return false;
    }


    if (password.length < 5) {

        alert("Password must contain at least 5 characters.");

        return false;
    }


    if (!/^[0-9]{10}$/.test(mobile)) {

        alert("Please enter a valid 10-digit mobile number.");

        return false;
    }


    if (email === "") {

        alert("Please enter your email.");

        return false;
    }


    return true;
}


// =============================
// LOGIN VALIDATION
// =============================

function validateLogin() {

    let email =
        document.getElementById("loginEmail").value.trim();

    let password =
        document.getElementById("loginPassword").value;


    if (email === "") {

        alert("Please enter your email.");

        return false;
    }


    if (password === "") {

        alert("Please enter your password.");

        return false;
    }


    return true;
}