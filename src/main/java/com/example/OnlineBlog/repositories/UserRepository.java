package com.example.OnlineBlog.repositories;

import com.example.OnlineBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
