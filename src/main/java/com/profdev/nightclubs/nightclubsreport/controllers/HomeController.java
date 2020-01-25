package com.profdev.nightclubs.nightclubsreport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nightclub")
public class HomeController {

    @GetMapping
    public String getHomePage(){
        return "home";
    }
}
