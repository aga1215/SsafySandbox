package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    // 추가적인 쿼리가 필요하면 메서드 정의 가능
}