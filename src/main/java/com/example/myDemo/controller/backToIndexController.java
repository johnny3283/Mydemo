package com.example.myDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class backToIndexController {
    @GetMapping("/")
    public String landIngPage (){
        return "landing";
    }
    @GetMapping("/index")
    public String backIndex (){
        return "index";
    }

    @GetMapping("/frontIndex")
    public String frontIndex (){
        return "frontIndex";
    }
    @GetMapping("/leaders")
    public String showLeaders (){
        return "/test/leaders";
    }
    @GetMapping("/systems")
    public String showSystems (){
        return "/test/systems";
    }

}
