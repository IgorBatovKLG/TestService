package com.example.demo2.controllers;

import com.example.demo2.models.Test;
import com.example.demo2.models.User;
import com.example.demo2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequiredArgsConstructor
public class StartController {

    private final UserService userService;

    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user){
        userService.createUser(user);
        return "redirect:/";
    }


}
