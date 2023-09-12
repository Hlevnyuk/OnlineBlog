package com.example.OnlineBlog.controllers;

import com.example.OnlineBlog.Services.PostService;
import com.example.OnlineBlog.Services.UserService;
import com.example.OnlineBlog.model.Post;
import com.example.OnlineBlog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PostService postService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/login";
    }
    @GetMapping("/user/{user}")
    public String userProfile(@PathVariable("user") User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("posts", user.getPostList());
        return "user-profile";
    }
}
