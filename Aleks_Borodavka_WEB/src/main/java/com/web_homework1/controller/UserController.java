package com.web_homework1.controller;

import com.web_homework1.dao.UserRepository;
import com.web_homework1.domain.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public @ResponseBody
    Integer sign_in(
            @RequestParam("login") String login,
            @RequestParam("password") String password) {
        User user = repository.findByLoginAndPasswordEquals(login, password);
        if (user != null) {
            return 1;
        }
        return 0;
    }

    //0 - login already exist
    //1 - passwords does not match
    //2 - ok
    @RequestMapping(value = "/register/new/user", method = RequestMethod.POST)
    public @ResponseBody
    Integer sign_up(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("confirm_password") String confirmPassword,
            @RequestParam("e_mail") String e_mail) {
        if (!password.equals(confirmPassword)) {
            return 1;
        } else if (repository.findByLogin(login) != null) {
            return 0;
        } else {
            repository.saveAndFlush(new User(login, password, e_mail));
            return 2;
        }
    }

    @RequestMapping(value = "/get/all/users", method = RequestMethod.GET)
    public @ResponseBody
    String userList() {
        List<User> userList = repository.findAll();

        JSONArray body = new JSONArray();
        for (User user : userList) {
            JSONObject item = new JSONObject();
            item.put("id", user.getId());
            item.put("login", user.getLogin());
            item.put("e_mail", user.geteMail());
            item.put("creation_date", user.getCreationDate().toString());
            body.add(item);
        }
        return body.toJSONString();

    }

    @RequestMapping(value = "/restore/password", method = RequestMethod.GET)
    public @ResponseBody
    String restorePassword(
            @RequestParam("login") String login) {
        return repository.findByLogin(login).getLogin();
    }
}
