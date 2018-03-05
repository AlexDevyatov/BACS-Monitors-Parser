package com.example.bparser.controller;

import com.example.bparser.model.ContestantData;
import com.example.bparser.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private ApiService service;

    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @RequestMapping("/contest")
    public List<ContestantData> getContestData(@RequestParam(value = "day") Integer day) {
        return service.getContestData(day);
    }
}
