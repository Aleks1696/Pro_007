package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {
    /* @RequestMapping - позволяет нам указать путь к странице либо
    *                    функции на backend
    *  RequestMethod   - позволяет нам указать тип запроса
    *
    *  GET - чаще всего используется для получения данных от сервера
    *  POST - используется когда необходимо  создать какие либо данные на сервере
    *  PUT  - используется для модификации данных на сервере
    *  DELETE - удалние каких либо данных на сервере*/
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/js-example.html", method = RequestMethod.GET)
    public String jsExamplePage() {
        return "js-example";
    }
    @RequestMapping(value = "/js-forms.html", method = RequestMethod.GET)
    public String jsFormsPage() {
        return "js-forms";
    }
    @RequestMapping(value = "/calc.html", method = RequestMethod.GET)
    public String calcPage() {
        return "calc";
    }
    @RequestMapping(value = "/employees.html", method = RequestMethod.GET)
    public String employeesPage() {
        return "employees";
    }
}
