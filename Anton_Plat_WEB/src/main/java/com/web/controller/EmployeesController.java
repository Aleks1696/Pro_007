package com.web.controller;

import com.web.dao.EmployeeRepository;
import com.web.domain.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class EmployeesController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //201
    public void create(
            @RequestParam("name") String name,
            @RequestParam("position") String position,
            @RequestParam("salary") Integer salary) {
        employeeRepository.saveAndFlush(new Employee(name, position, salary));
    }

    @RequestMapping(value = "/employee/get/all", method = RequestMethod.GET)
    public @ResponseBody String getAll() {
        List<Employee> employees = employeeRepository.findAll();

        JSONArray body = new JSONArray();
        for (Employee employee : employees) {
            JSONObject item = new JSONObject();
            item.put("id", employee.getId());
            item.put("name", employee.getName());
            item.put("position", employee.getPosition());
            item.put("salary", employee.getSalary());
            body.add(item);
        }
        return body.toJSONString();
    }
}