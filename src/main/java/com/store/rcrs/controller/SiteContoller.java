package com.store.rcrs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteContoller {

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/careers")
    public String careers(){
        return "careers";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

}
