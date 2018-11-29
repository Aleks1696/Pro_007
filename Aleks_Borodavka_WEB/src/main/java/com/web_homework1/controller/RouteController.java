package com.web_homework1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    @RequestMapping(value = "/userAuthorization.html", method = RequestMethod.GET)
    public String userAuthorizationPage() {
        return "userAuthorization";
    }

    @RequestMapping(value = "/userPage.html", method = RequestMethod.GET)
    public String userPage() {
        return "userPage";
    }

    @RequestMapping(value = "/userRegistration.html", method = RequestMethod.GET)
    public String userRegistrationPage() {
        return "userRegistration";
    }

}
