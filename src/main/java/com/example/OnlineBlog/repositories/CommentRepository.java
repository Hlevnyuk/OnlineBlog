package com.example.OnlineBlog.repositories;

import com.example.OnlineBlog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment\n" +
            "WHERE post_id IN(SELECT id FROM post\n" +
            "\t\t\t\tWHERE id = ?)", nativeQuery = true)
    List<Comment> findByPostId(Long id);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO comment(text, post_id)\n" +
            "VALUES(?, ?)", nativeQuery = true)
    void saveByPostId(String text, Long id);
}