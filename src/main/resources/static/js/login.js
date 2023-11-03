$(document).ready(function() {
    var generatedCode;
    $("#submitEmailButton").click(function(event) {
        event.preventDefault(); // Ngăn form gửi đi một cách thông thường
        var formData = new FormData($("#submitEmailForm")[0]);
        $.ajax({
            type: "POST",
            url: "/send-email",
            data: formData,
            contentType: false, // Không cần set contentType khi sử dụng FormData
            processData: false, // Không cần xử lý dữ liệu
            success: function(response) {
                if(response === 'Please enter correct username and email'){
                    document.getElementById('errorF').innerHTML = 'Please enter correct username and email';
                    document.getElementById('submitEmailButton').style.display = 'block';
                    document.getElementById('divCodeEmail').style.display = 'none';
                    document.getElementById('confirmCodeButton').style.display = 'none';
                } else {
                    document.getElementById('errorF').innerHTML = '';
                    generatedCode = response;
                    document.getElementById('submitEmailButton').style.display = 'none';
                    document.getElementById('divCodeEmail').style.display = 'block';
                    document.getElementById('confirmCodeButton').style.display = 'block';
                }

            },
            error: function(error) {
                // Xử lý lỗi (nếu có)
                alert('error')
            }
        });
    });
    $("#testAPI").click(function(event) {
        $.ajax({
            type: "GET",
            url: "/connect-use-socket",
            contentType: 'application/json', // Không cần set contentType khi sử dụng FormData
            success: function(data) {
                console.log(data)
            },
            error: function(error) {
                // Xử lý lỗi (nếu có)
                alert('error')
            }
        });
    });
    $("#confirmCodeButton").click(function(event) {
        event.preventDefault();
        var userEnteredCode = $("#code").val();
        if (generatedCode === userEnteredCode) {
            // Mã trùng khớp, cho phép submit form
            $("#submitEmailForm").submit();
            document.getElementById('errorC').innerHTML = '';
            alert('Please check your email!')

        } else {
            document.getElementById('errorC').innerHTML = 'Please enter correct code';
        }
    });
});

document.addEventListener('DOMContentLoaded', function() {
    // Lấy tham chiếu đến các phần tử
    var registerLink = document.getElementById('registerLink');
    var registerForm = document.getElementById('registerForm');
    var loginForm = document.getElementById('loginForm');
    var divNoAccount = document.getElementById('divNoAccount');
    var divHaveAccount = document.getElementById('divHaveAccount');
    var forgotPasswordLink = document.getElementById('forgotPasswordLink');
    var submitEmailForm = document.getElementById('submitEmailForm');
    var submitEmailButton = document.getElementById('submitEmailButton');
    var confirmCodeButton = document.getElementById('confirmCodeButton');
    var divCodeEmail = document.getElementById('divCodeEmail');


    //click register
    registerLink.addEventListener('click', function(e) {
        e.preventDefault(); // Ngăn chặn hành động mặc định của link
        registerForm.style.display = 'block';
        loginForm.style.display = 'none';
        divNoAccount.style.display = 'none'
        divHaveAccount.style.display = 'block'
        submitEmailForm.style.display = 'none'
    });

    // khi click vào login
    loginLink.addEventListener('click', function(e) {
        e.preventDefault(); // Ngăn chặn hành động mặc định của link
        registerForm.style.display = 'none';
        loginForm.style.display = 'block';
        divNoAccount.style.display = 'block'
        divHaveAccount.style.display = 'none'
        submitEmailForm.style.display = 'none'
    });

    //click forgot pass
    forgotPasswordLink.addEventListener('click', function(e) {
        e.preventDefault(); // Ngăn chặn hành động mặc định của link
        registerForm.style.display = 'none';
        loginForm.style.display = 'none';
        divNoAccount.style.display = 'block'
        divHaveAccount.style.display = 'none'
        submitEmailForm.style.display = 'block'
        confirmCodeButton.style.display = 'none'
        submitEmailButton.style.display = 'block'
        divCodeEmail.style.display = 'none'
    });

    //click send email
    submitEmailButton.addEventListener('click', function(e) {
        e.preventDefault(); // Ngăn chặn hành động mặc định của link
        var str = document.getElementById('emailForgotPass').value; //check xem da nhap email chua
        var errorEmailForgotPass = document.getElementById('errorEmailForgotPass');
        if(str === ''){
            errorEmailForgotPass.style.display = 'block'
            errorEmailForgotPass.innerHTML = 'Please enter email';
        } else {
            registerForm.style.display = 'none';
            loginForm.style.display = 'none';
            divNoAccount.style.display = 'block'
            divHaveAccount.style.display = 'none'
            submitEmailForm.style.display = 'block'
            errorEmailForgotPass.style.display = 'none'
        }

    });
});

document.getElementById('imageInput').addEventListener('change', function() {
    var selectedImage = document.getElementById('selectedImage');
    var imageInput = document.getElementById('imageInput');

    if (imageInput.files.length > 0) {
        var reader = new FileReader();
        reader.onload = function(e) {
            selectedImage.src = e.target.result;
        }
        reader.readAsDataURL(imageInput.files[0]);
    } else {
        selectedImage.src = "/img/user/default.jpg"; // Nếu không có file nào được chọn, sử dụng ảnh mặc định
    }
});