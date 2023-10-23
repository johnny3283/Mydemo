package com.example.myDemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "/login/backendLogin";
    }

    @GetMapping("/frontLoginPage")
    public String frontLoginPage() {

        return "/login/frontLogin";
    }
    @GetMapping("/access-denied")
    public String AccessDenied() {

        return "/login/accessDenied";
    }

}
