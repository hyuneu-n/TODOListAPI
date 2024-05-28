package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_table_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "member_table_id", nullable = false)
    private Member member;
    private String content;
    private Boolean completed;

    @CreationTimestamp
    private LocalDateTime created_at;
}
