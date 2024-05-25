package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_table_id")
    private int id;

    @Column(unique = true)
    private String memberId;

    private String name;

    private String passwd;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Todo> todoList;
}
