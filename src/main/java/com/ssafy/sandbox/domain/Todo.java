package com.ssafy.sandbox.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean completed;


  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 외래 키 컬럼명 지정
    private User user;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoComment> comments;

    public Todo(String content){
        this.content = content;
        this.completed = false;
    }*/
}