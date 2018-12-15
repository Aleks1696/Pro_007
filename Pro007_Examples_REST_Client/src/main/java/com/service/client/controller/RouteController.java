package com.service.client.controller;

import com.service.client.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("student", new StudentModel());
        return "index";
    }
}
