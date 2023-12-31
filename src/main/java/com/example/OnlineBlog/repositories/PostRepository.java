package com.example.OnlineBlog.repositories;

import com.example.OnlineBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
