$(document).ready(function () {

    $('#loginButton').on('click', function () {
        var $email = $("#email"),
            $pass = $("#password"),
            email = $email.val(),
            pass = $pass.val();

        if(DB_MOCKS.getUser(email, pass)) {
            window.location.href = "./bootstrap/index.html";
        } else {
            if(email == '') {
                $('.error-msg').html('Please enter your email!');
            } else if(pass == '') {
                $('.error-msg').html('Please enter your password!');
            } else {
                $email.val("");
                $pass.val("");
                $('.error-msg').html('Invalid user or password!');
            }
        }
    });
});
