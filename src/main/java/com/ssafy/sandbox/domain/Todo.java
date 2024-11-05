package com.ssafy.sandbox.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "todo")
@Getter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id = null;
    @Column(name = "content", nullable = false)
    String content;
    @Column(name = "completed", nullable = false)
    Boolean completed = Boolean.FALSE;

    public Todo() {
    }

    private Todo(String content) {
        this.content = content;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    public static Todo of(String content) {
        return new Todo(content);
    }

    public Long getId() {
        return id;
    }


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