package com.web.controller;


import com.web.dao.AccountRepository;
import com.web.domain.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AccountController {
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "password") String password
    ) {
        accountRepository.saveAndFlush(new Account(login, password));
    }

    @RequestMapping(value = "/account/get/login", method = RequestMethod.GET)
    public @ResponseBody
    String getAllLogins() {

        List<Account> accounts = accountRepository.findAll();
        JSONArray body = new JSONArray();
        for (Account account : accounts) {
            JSONObject item = new JSONObject();
            item.put("id", account.getId());
            item.put("login", account.getLogin());
            body.add(item);
        }
            return body.toJSONString();


    }
}

