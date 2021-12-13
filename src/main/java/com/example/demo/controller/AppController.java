package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.annotations.Ip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public Result getPerson() {
        return Result.success(new Person("ff"));
    }

    @PostMapping
    public void post(@Ip String  ip) {


        System.out.println(ip);


    }

}