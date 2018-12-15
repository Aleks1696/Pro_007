package com.service.client.controller;

import com.service.client.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(name = "/create", method = RequestMethod.POST)
    public String createStudentRecord(@ModelAttribute StudentModel student) {
        System.out.println(student);
        return "redirect:/index.html";
    }
}
