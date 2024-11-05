package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.dto.CreateTodoRequest;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getTodos();

    Long createTodo(CreateTodoRequest createTodoRequest);

    void toggleStatus(Long todoId) throws Exception;

    void deleteTodo(Long todoId) throws  Exception;
}