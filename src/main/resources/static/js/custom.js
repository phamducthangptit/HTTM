function checkLogin(){
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var errorMessage = document.getElementById('errorMessage');
    if(username === '' || password === ''){
        errorMessage.innerHTML = 'Please enter username and password';
        return false;
    }
    return true;
}
function checkPasswordsMatch() {
    var password = document.getElementById("passwordRegister").value;
    var retypePassword = document.getElementById("retypePasswordRegister").value;
    var message = document.getElementById("passwordMessage");

    if (password === retypePassword) {
        message.innerHTML = "";
    } else {
        message.innerHTML = "Password does not match";
        message.style.color = "red";
    }
}
function checkChangePasswordsMatch() {
    var oldPass = document.getElementById("oldPass").value;
    var newPass = document.getElementById("newPass").value;
    var retypenewPass = document.getElementById("retypenewPass").value;
    var message = document.getElementById("passwordMessage");
    var messageNewPass = document.getElementById("passwordNewMessage");
    if (newPass === oldPass) {
            messageNewPass.innerHTML = "The new password must not be the same as the old password!";
            messageNewPass.style.color = "red";
        } else {
            messageNewPass.innerHTML = "";
        }

    if (newPass === retypenewPass) {
        message.innerHTML = "";
    } else {
        message.innerHTML = "Password does not match";
        message.style.color = "red";
    }
}
function validationPass(){
    var password = document.getElementById("passwordRegister").value;
    var retypePassword = document.getElementById("retypePasswordRegister").value;

     if (password === retypePassword) {
        return true;
    } else {
        return false;
    }
}

function validationChangePass(){
    var oldPass = document.getElementById("oldPass").value;
    var newPass = document.getElementById("newPass").value;
    var retypeNewPass = document.getElementById("retypenewPass").value;

     if ((oldPass !== newPass) &&  (newPass === retypeNewPass)) {
        return true;
    } else {
        return false;
    }
}



