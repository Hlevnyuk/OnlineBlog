package com.example.OnlineBlog.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "grade")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "likee")
    private boolean like;
    @Column(name = "dislike")
    private boolean dislike;
}
