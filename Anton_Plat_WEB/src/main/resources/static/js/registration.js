/* JQuery - JavaScript фреймворк для удобной работы
*  AJAX   - технология асинхронных запросов к серверу*/



function redirection(){
    window.location.href = "http://google.com.ua"} // в случае отмены регистрации посылает на Гугл

function create() {

    if(password.value == '' ||passwordConfirm.value == '' ||login.value == ''){
        jQuery('#login').val('');
        jQuery('#password').val('');
        jQuery('#passwordConfirm').val('');
        alert("Заполните все поля")

    }
    if (password.value !== passwordConfirm.value) {
        jQuery('#password').val('');
        jQuery('#passwordConfirm').val('');
        alert("Пароли не совпадают")
    }else {
        if(login.value != '')
        createMember();
    }
}

function createMember() {
    jQuery.ajax({
        type: 'POST',
        url: '/member/create',
        data:{
            login: jQuery ('#login').val(),
            password: jQuery('#password').val()
        },
        success: function () {
            jQuery('#login').val('');
            jQuery('#password').val('');
            jQuery('#passwordConfirm').val('');
            // cleanFilds();
        },
        error: function  () {
            jQuery('#login').val('');
            jQuery('#password').val('');
            jQuery('#passwordConfirm').val('');
            alert("Этот логин уже существует")

        }
        }
    )



}



function getAllMembers(){
    jQuery.ajax({
        type:"GET",
        url:"/members/get/all",
        success: function (response) {
            var result = jQuery.parseJSON(response);

            jQuery('#workspace')
                .empty
                .append('<table id="members>');
            jQuery('#members')
                .append('<caption>Members</caption>')
                .append('<thead><tr id="header"></tr></thead>')
                .append('<tbody id="body"></tbody>');
            jQuery('#header')
                .append('<th>ID</th>')
                .append('<th>Login</th>')
                .append('<th>Password</th>');

            for (var i= 0; i < result.length; i++) {
                jQuery('#body')
                    .append('<tr id="cur_row' + i + '"></tr>')
                jQuery('#cur_row' + i)
                    .append('<td id="member_id">' + result[i].id + '</td>')
                    .append('<td id="member_login">' + result[i].login + '</td>')
                    .append('<td id="member_password">' + result[i].password + '</td>')
            }


        }
    })
}

