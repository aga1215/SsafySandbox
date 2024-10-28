package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Todo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Todo> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public boolean deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Todo updateTodo(int id) {
        if (repository.existsById(id)) {
            Todo todo = repository.findById(id).get();
            todo.setCompleted(!todo.isCompleted());
            repository.save(todo);
            return todo;
        }
        return null;
    }
}