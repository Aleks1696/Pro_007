package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    /*@RequestMapping - позволяет указать путь к странице либо функции
    *                   на бэкэнде
    *
    *RequestMethod - позволяет указать тип запроса
    *   GET - получение данных от сервера
    *   POST - необходим для создания данных на сервере (когда необходимо)
    *   PUT - модификация данных на сервере
    *   DELETE - удалиение данных*/

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "/js_example.html", method = RequestMethod.GET)
    public String jsExamplePage(){
        return "js_example";
    }

    @RequestMapping(value = "/js_forms.html", method = RequestMethod.GET)
    public String jsFormsPage(){
        return "js_forms";
    }

    @RequestMapping(value = "/js_calculator.html", method = RequestMethod.GET)
    public String jsCalculatorPage(){
        return "js_calculator";
    }

    @RequestMapping(value = "/employees.html", method = RequestMethod.GET)
    public String employeesPage(){
        return "employees";
    }
}
