package com.example.OnlineBlog.controllers;

import com.example.OnlineBlog.Services.CommentService;
import com.example.OnlineBlog.Services.PostService;
import com.example.OnlineBlog.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final PostService postService;
    private final CommentService commentService;
    @PostMapping("/comment/create/{id}")
    public String commentCreate(@PathVariable Long id, @RequestParam String text, Comment comment){
        postService.getById(id);
        commentService.saveByPostId(text, id);
        return "redirect:/post/{id}";
    }
    @PostMapping("/comment/delete/{id}")
    public String deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
        return "redirect:/post-info";
    }
}
