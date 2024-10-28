package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.domain.TodoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<TodoComment, Integer> {
    // 추가적인 쿼리가 필요하면 메서드 정의 가능
}
