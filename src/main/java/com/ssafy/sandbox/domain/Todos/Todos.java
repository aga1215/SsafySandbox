package com.ssafy.sandbox.domain.Todos;

import com.ssafy.sandbox.domain.Users.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "user_id"),
        @Index(columnList = "completed")
})
//@EntityListeners(AuditingEntityListener.class)
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // mysql에서는 타입을 IDENTITY로 해야 autoincrement가된다.
    private int id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private boolean completed;

//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @CreatedBy
//    private String createdBy;
    protected Todos() {}

    public static Todos of(Users user, String comment, boolean completed) {  // new쓰지않고 편하게 팩토리메소드
        Todos todos = new Todos();
        todos.user = user;
        todos.comment = comment;
        todos.completed = completed;
        return todos;
    }

    @Override
    public boolean equals(Object o) { // 컬렉션 사용 시 객체의 중복요소 제거 정렬 시 비교 가능. 동일성,동등성 검사
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todos todos = (Todos) o;
        return id == todos.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
