package com.example.OnlineBlog.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "grade_post")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GradePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_post")
    private int idPost;
    @Column(name = "id_grade")
    private int idGrade;
}
