package com.example.demo2.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class StartController {

    @GetMapping("/")
    public String start(){
        return "index";
    }
}
