package com.web.sessions.controller;

import com.web.sessions.model.CustomerModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(types = CustomerModel.class)
public class CustomerController {

    @RequestMapping(value = "/customer.html", method = RequestMethod.GET)
    public String customerPage(Model model) {
        model.addAttribute(new CustomerModel());
        return "customer";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    private String customer(CustomerModel customerModel, SessionStatus sessionStatus) {
        System.out.println("***** CUSTOMER BLOCK *****");
        System.out.println("Name       : " + customerModel.getName());
        System.out.println("Surname    : " + customerModel.getSurname());
        System.out.println("Age        : " + customerModel.getAge());
        System.out.println("Login      : " + customerModel.getLogin());
        System.out.println("Password   : " + customerModel.getPassword());
        System.out.println("CreditCard : " + customerModel.getCreditCard());
        System.out.println("**************************");
        System.out.println("Session complete: " + sessionStatus.isComplete());
        System.out.println("***** CUSTOMER BLOCK *****");
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    private String user(CustomerModel customerModel, SessionStatus sessionStatus) {
        System.out.println("***** ACCOUNT BLOCK *****");
        System.out.println("Name       : " + customerModel.getName());
        System.out.println("Surname    : " + customerModel.getSurname());
        System.out.println("Age        : " + customerModel.getAge());
        System.out.println("Login      : " + customerModel.getLogin());
        System.out.println("Password   : " + customerModel.getPassword());
        System.out.println("CreditCard : " + customerModel.getCreditCard());
        System.out.println("**************************");
        System.out.println("Session complete: " + sessionStatus.isComplete());
        System.out.println("***** ACCOUNT BLOCK *****");
        return "credit";
    }

    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    private String credit(CustomerModel customerModel, SessionStatus sessionStatus) {
        System.out.println("***** CREDIT CARD BLOCK *****");
        System.out.println("Name       : " + customerModel.getName());
        System.out.println("Surname    : " + customerModel.getSurname());
        System.out.println("Age        : " + customerModel.getAge());
        System.out.println("Login      : " + customerModel.getLogin());
        System.out.println("Password   : " + customerModel.getPassword());
        System.out.println("CreditCard : " + customerModel.getCreditCard());
        System.out.println("**************************");
        System.out.println("Session complete: " + sessionStatus.isComplete());
        System.out.println("***** CREDIT CARD BLOCK *****");
        return "redirect:/complete";
    }

    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    public String complete(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "complete";
    }
}
