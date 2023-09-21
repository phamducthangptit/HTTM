function checkLogin(){
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var errorMessage = document.getElementById('errorMessage');
    if(email === '' || password === ''){
        errorMessage.innerHTML = 'Vui lòng nhập đủ email và password';
        return false;
    }
    return true;
}