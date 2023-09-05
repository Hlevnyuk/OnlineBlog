package com.example.OnlineBlog.repositories;

import com.example.OnlineBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
