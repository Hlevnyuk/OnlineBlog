package com.example.OnlineBlog.Services;

import com.example.OnlineBlog.model.Image;
import com.example.OnlineBlog.model.Post;
import com.example.OnlineBlog.model.User;
import com.example.OnlineBlog.repositories.PostRepository;
import com.example.OnlineBlog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public List<Post> listPost() {
        return postRepository.findAll();
    }
    public void savePost(Principal principal, Post post, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        post.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            post.addImageToPost(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            post.addImageToPost(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            post.addImageToPost(image3);
        }
        log.info("Saving new Post. Author email: {}; Text: {}", post.getUser().getEmail(), post.getText());
        Post postFromDb = postRepository.save(post);
        postFromDb.setPreviewImageId(postFromDb.getImages().get(0).getId());
        postRepository.save(post);
    }
    public User getUserByPrincipal(Principal principal) {
        if(principal == null){
            return new User();
        }
        return userRepository.findByEmail(principal.getName());
    }
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    public Post getById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}