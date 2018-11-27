/* jQuery - JavaScript фреймворк для удобной работы
*  AJAX   - технология асинхронных запросов к серверу
*  JSON   - формат передачи данных в вебе
*  */
function createEmployee() {
    jQuery.ajax({
        type: 'POST',
        url: '/employee/create',
        data: {
            name: jQuery('#name').val(),
            position: jQuery('#position').val(),
            salary: jQuery('#salary').val()
        },
        success: function() {
            jQuery('#name').val('');
            jQuery('#position').val('');
            jQuery('#salary').val('');
        }
    })
}

function getAllEmployees() {
    jQuery.ajax({
        type: 'GET',
        url: '/employee/get/all',
        success: function(response) {
            var result = jQuery.parseJSON(response);

            jQuery('#workspace')
                .empty()
                .append('<table id="employees">');
            jQuery('#employees')
                .append('<caption>Employees</caption>')
                .append('<thead><tr id="header"></tr></thead>')
                .append('<tbody id="body"></tbody>');
            jQuery('#header')
                .append('<th>ID</th>')
                .append('<th>Имя</th>')
                .append('<th>Должность</th>')
                .append('<th>Зарплата</th>');

            for (var i = 0; i < result.length; i++) {
                jQuery('#body')
                    .append('<tr id="cur_row' + i + '"></tr>')
                jQuery('#cur_row' + i)
                    .append('<td id="employee_id">' + result[i].id + '</td>')
                    .append('<td id="employee_name">' + result[i].name + '</td>')
                    .append('<td id="employee_position">' + result[i].position + '</td>')
                    .append('<td id="employee_salary">' + result[i].salary + '</td>')
            }
        }
    })
}