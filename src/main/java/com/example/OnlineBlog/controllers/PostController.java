package com.example.OnlineBlog.controllers;

import com.example.OnlineBlog.Services.CommentService;
import com.example.OnlineBlog.Services.PostService;
import com.example.OnlineBlog.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    @GetMapping("/")
    public String postPage(Model model){
        model.addAttribute("posts", postService.listPost());
        return "main";
    }
    @GetMapping("/post/{id}")
    public String postById(@PathVariable Long id, Model model){
        model.addAttribute("info", postService.getById(id));
        model.addAttribute("comments", commentService.findByPostId(id));
        return "post-info";
    }
    @PostMapping("/post/create")
    public String postCreate(Post post){
        postService.savePost(post);
        return "redirect:/";
    }
    @PostMapping("/post/delete/{id}")
    public String postDelete(@PathVariable Long id){
        postService.deletePost(id);
        return "redirect:/";
    }
}
