package com.web.controller;


import com.web.dao.RegistrationRepository;
import com.web.domain.Member;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistrationController {

    private RegistrationRepository registrationRepository;

    @Autowired

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @RequestMapping(value = "/member/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //201
    public void create(
            @RequestParam("login") String login,
            @RequestParam("password") String password) {
        registrationRepository.saveAndFlush(new Member(login, password));
    }

    @RequestMapping(value = "/members/get/all", method = RequestMethod.GET)
    public @ResponseBody String getAll() {
        List<Member> members = registrationRepository.findAll();

        JSONArray body = new JSONArray();
        for (Member member : members) {
            JSONObject item = new JSONObject();
            item.put("id", member.getId());
            item.put("login", member.getLogin());
            item.put("password", member.getPassword());
            body.add(item);
        }
        return body.toJSONString();
    }
}





