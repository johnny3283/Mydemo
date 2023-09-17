package com.example.myDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class backToIndexController {

    @GetMapping("index")
    public String backIndex (){
        return "index";
    }
    @GetMapping("/leaders")
    public String showLeaders (){
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystems (){
        return "systems";
    }

}
