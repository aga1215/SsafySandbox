package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findAll();
    Optional<Todo> findById(int id);
    Todo save(Todo todo);
    boolean deleteById(int id);
    Todo updateTodo(int id);
}