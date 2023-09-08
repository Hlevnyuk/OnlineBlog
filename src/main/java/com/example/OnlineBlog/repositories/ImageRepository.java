package com.example.OnlineBlog.repositories;

import com.example.OnlineBlog.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
