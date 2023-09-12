package com.example.OnlineBlog.repositories;

import com.example.OnlineBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query(value = "SELECT * FROM post\n" +
            "WHERE user_id = (SELECT id FROM users\n" +
            "\t\t   WHERE id = ?)", nativeQuery = true)
    User findByPostId(Long id);
}
