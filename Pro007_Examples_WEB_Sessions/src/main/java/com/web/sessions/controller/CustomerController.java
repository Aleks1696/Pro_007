package com.web.sessions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @RequestMapping(value = "/customer.html", method = RequestMethod.GET)
    public String customerPage() {
        return "customer";
    }

}
