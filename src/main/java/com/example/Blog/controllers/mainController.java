package com.example.Blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("title", "Main Page");
        return "main";
    }
}
