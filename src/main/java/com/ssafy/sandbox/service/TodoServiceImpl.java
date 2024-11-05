package com.ssafy.sandbox.service;

import com.ssafy.sandbox.config.exception.dtoException.DomainNotFoundException;
import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.dto.CreateTodoRequest;
import com.ssafy.sandbox.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    final TodoRepository todoRepository;
    final String DOMAIN_NAME = "TODO";

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Long createTodo(CreateTodoRequest createTodoRequest) {
        return todoRepository
                .save(Todo.of(createTodoRequest.getContent()))
                .getId();
    }

    @Transactional
    @Override
    public void toggleStatus(Long todoId) {
        todoRepository
                .findById(todoId)
                .orElseThrow(() -> new DomainNotFoundException(DOMAIN_NAME, todoId))
                .toggleCompleted();
    }

    @Override
    public void deleteTodo(Long todoId) throws Exception {
        todoRepository.delete(todoRepository
                .findById(todoId)
                .orElseThrow(() -> new DomainNotFoundException(DOMAIN_NAME, todoId)));
    }
}