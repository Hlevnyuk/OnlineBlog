package com.example.OnlineBlog.Services;

import com.example.OnlineBlog.model.Post;
import com.example.OnlineBlog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    public List<Post> listPost(){
        return postRepository.findAll();
    }
    public void savePost(Post post){
        log.info("Save me {}", post);
        postRepository.save(post);
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    public Post getById(Long id){
        return postRepository.findById(id).orElse(null);
    }
}
