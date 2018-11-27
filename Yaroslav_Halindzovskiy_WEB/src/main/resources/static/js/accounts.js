function  createAccount() {
    jQuery.ajax({

        type: 'POST',
        url: '/account/create',
        data: {
            login: jQuery('#login').val(),
            password: jQuery('#password').val(),

        },
        success: function () {
            jQuery('#login').val('');
            jQuery('#password').val('');
            jQuery('#passwordD').val('');

        }
    })
}
    function  showKu() {

        alert('Ku')

    }







// jQuery('#password, #confirm_password').on('keyup', function () {
//     if ($('#password').val() == $('#passwordD').val()) {
//         $('#message').html('Matching').css('color', 'green');
//         createAccount();
//     } else
//         $('#message').html('Not Matching').css('color', 'red');
// });