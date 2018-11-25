package com.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EmployeesController {

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //201
    public void create(
            @RequestParam("name") String name,
            @RequestParam("position") String position,
            @RequestParam("salary") Integer salary) {

    }
}
