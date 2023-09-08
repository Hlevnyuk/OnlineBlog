package com.example.OnlineBlog.controllers;

import com.example.OnlineBlog.Services.CommentService;
import com.example.OnlineBlog.Services.PostService;
import com.example.OnlineBlog.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        Post post = postService.getById(id);
        model.addAttribute("info", post);
        model.addAttribute("images", post.getImages());
        model.addAttribute("comments", commentService.findByPostId(id));
        return "post-info";
    }
    @PostMapping("/post/create")
    public String postCreate(@RequestParam("file1") MultipartFile file1,
                             @RequestParam("file2") MultipartFile file2,
                             @RequestParam("file3") MultipartFile file3, Post post) throws IOException {
        postService.savePost(post, file1, file2, file3);
        return "redirect:/";
    }
    @PostMapping("/post/delete/{id}")
    public String postDelete(@PathVariable Long id){
        postService.deletePost(id);
        return "redirect:/";
    }
}
