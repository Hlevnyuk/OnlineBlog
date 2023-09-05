package com.example.OnlineBlog.Services;

import com.example.OnlineBlog.model.Comment;
import com.example.OnlineBlog.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    public List<Comment> listComment(){
        return commentRepository.findAll();
    }
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
    public List<Comment> findByPostId(Long id){
        return commentRepository.findByPostId(id);
    }
    public void saveByPostId(String text, Long id){
        commentRepository.saveByPostId(text, id);
    }
}
