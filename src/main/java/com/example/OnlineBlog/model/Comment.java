package com.example.OnlineBlog.model;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text", columnDefinition = "text")
    private String text;
}
