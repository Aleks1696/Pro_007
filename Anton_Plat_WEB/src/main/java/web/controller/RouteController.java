package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    /* @RequestMapping - позволяет нам указать путь к странице либо на функции
    на backend.

    @RequestMethod - позволяет нам указать ти запроса
    GET- для получения используется для получения данных от сервера
    POST - используется когда необходимо создать какие либо данные на сервере
    PUT - используется для модификации данных на сервере
    DELETE - удаление каких лиюл данных на сервере
     */

    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }


    @RequestMapping(value = "/js_example.html",method = RequestMethod.GET)
    public String jsExamplePage(){
        return "js_example";
    }

    @RequestMapping(value = "/js_forms.html",method = RequestMethod.GET)
    public String jsFormsPage(){
        return "js_forms";
    }

    @RequestMapping(value = "/calculater.html",method = RequestMethod.GET)
    public String calculator(){
        return "calculater";
    }
}
