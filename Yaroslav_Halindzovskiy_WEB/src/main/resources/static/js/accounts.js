function check() {

    if ($('#password').val() == $('#passwordD').val()) {

        createAccount();
    } else {
        passwordNotConfig()

    }

}

function passwordNotConfig() {
    alert("Пароли не совпадают")
    jQuery('#password').val('');
    jQuery('#passwordD').val('');

}

function createAccount() {


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

function login() {
    jQuery.ajax({
        type: 'POST',
        url: '//account/get/all/',
        data: {
            login: jQuery('#loginL').val(),
            password: jQuery('#passwordL').val(),

        },
        success: function  (response) {
            var result = jQuery.parseJSON(response);
            jQuery('#loginL').val('');
            jQuery('#passwordL').val('');

autorization(result.result)
        }

    })

}
  function  autorization (checkLogin){
    if ( checkLogin == true){
        getAllLogin();
    }

  }



function getAllLogin() {

    jQuery.ajax({
        type: 'GET',
        url: '//account/get/login/',
        success: function (responce) {
            var result = jQuery.parseJSON(responce);
            jQuery('#workspace')
                .empty()
                .append('<table id="account">');
            jQuery('#account')
                .append('<caption>Users</caption>')
                .append('<thead><tr id="header"></tr></thead>')
                .append('<tbody id="body"></tbody>')
            jQuery('#header')
                .append('<th>ID</th>')
                .append('<th>Login</th>')
            for (var i = 0; i < result.length; i++) {
                jQuery('#logine')
                    .append('<tr id="cur_row' + i + '"></tr>')
                jQuery('#cur_row' + i)
                    .append('<tr id ="account_id">' + result[i].id + '</tr>')
                    .append('<tr id ="account_login">' + result[i].login + '</tr>')

            }

        }
    })

}


// jQuery('#password, #confirm_password').on('keyup', function () {
//     if ($('#password').val() == $('#passwordD').val()) {
//         $('#message').html('Matching').css('color', 'green');
//         createAccount();
//     } else
//         $('#message').html('Not Matching').css('color', 'red');
// });