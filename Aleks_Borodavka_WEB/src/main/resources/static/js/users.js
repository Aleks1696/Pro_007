function signIN() {
    jQuery.ajax({
        type: 'GET',
        url: '/sign_in',
        data: {
            login: jQuery('#login').val(),
            password: jQuery('#password').val(),
        },
        success: function (response) {
            if (response == 1) {
                jQuery('#login').val('');
                jQuery('#password').val('');

                window.location.href = "/userPage.html";
            } else {
                jQuery('#message_field')
                    .empty()
                    .append('<h4>Either login or password wrong. Please try again</h4>');
            }
        }
    })
}

function signUP() {
    jQuery.ajax({
        type: 'POST',
        url: '/register/new/user',
        data: {
            login: jQuery('#login').val(),
            password: jQuery('#password').val(),
            confirm_password: jQuery('#confirm_password').val(),
            e_mail: jQuery('#e_mail').val()
        },
        success: function (response) {
            if (response == 2) {
                jQuery('#login').val('');
                jQuery('#password').val('');
                jQuery('#e_mail').val('');
                jQuery('#confirm_password').val('');

                window.location.href = "/userPage.html";

            } else if (response == 0) {
                jQuery('#registration_status')
                    .empty()
                    .append('<h4>This login is already taken</h4>');
            } else if (response == 1) {
                jQuery('#registration_status')
                    .empty()
                    .append('<h4>Passwords does not match</h4>');
            }
        }
    })
}

function getAllUsers() {
    jQuery.ajax({
        type: 'GET',
        url: '/get/all/users',
        success: function (response) {
            var result = jQuery.parseJSON(response);

            jQuery('#list_of_users')
                .empty()
                .append('<table id="users">');
            jQuery('#users')
                .append('<caption>Users</caption>')
                .append('<thead><tr id="header"></tr></thead>')
                .append('<tbody id="body"></tbody>');
            jQuery('#header')
                .append('<th>ID</th>')
                .append('<th>Login</th>')
                .append('<th>E-mail</th>')
                .append('<th>Registration Date</th>');


            for (var i = 0; i < result.length; i++) {
                jQuery('#body')
                    .append('<tr id="cur_row' + i + '" ></tr>');
                jQuery('#cur_row' + i)
                    .append('<td id="user_id">' + result[i].id + '</td>')
                    .append('<td id="user_login">' + result[i].login + '</td>')
                    .append('<td id="user_email">' + result[i].e_mail + '</td>')
                    .append('<td id="user_registration_date">' + result[i].creation_date + '</td>')
            }
        }
    })
}

function forgotThePassword() {
    jQuery.ajax({
        method: 'GET',
        url: '/restore/password',
        data: {
            login: jQuery('#login').val()
        },
        success: function (response) {
            window.alert('Here is your password: ' + response)
        }
    })
}