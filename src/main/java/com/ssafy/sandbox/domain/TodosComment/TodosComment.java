package com.ssafy.sandbox.domain.TodosComment;


import com.ssafy.sandbox.domain.Todos.Todos;
import com.ssafy.sandbox.domain.Users.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "user_id"),
        @Index(columnList = "todo_id")
})
@Entity
public class TodosComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "todo_id")
    private Todos todos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private Users users;

    @Setter @Column(nullable = false) private String content;

    protected TodosComment() {}

    private TodosComment(Todos todos, Users users, String content) {
        this.todos = todos;
        this.users = users;
        this.content = content;
    }

    public static TodosComment of(Todos todos, Users users, String content) {
        TodosComment todosComment = new TodosComment();
        todosComment.todos = todos;
        todosComment.users = users;
        todosComment.content = content;

        return todosComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodosComment that = (TodosComment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
