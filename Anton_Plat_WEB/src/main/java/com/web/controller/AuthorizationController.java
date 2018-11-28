//package com.web.controller;
//
//
//import com.web.dao.RegistrationRepository;
//import com.web.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.List;
//
//@Controller
//public class AuthorizationController {
//    private RegistrationRepository registrationRepository;
//
//    @RequestMapping(value = "/member/authorization",method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.FOUND) //201
//    public void authorization(
//            @RequestParam("login") String login,
//            @RequestParam("password") String password){
//        List<Member> members = registrationRepository.findAll();
//        for (Member member: members){
//            if (member.getLogin().equalsIgnoreCase(login)) {
//                if (member.getPassword().equalsIgnoreCase(password)){
//return true;
//                }
//            }
//            }
//        }
//    }
//
//}
