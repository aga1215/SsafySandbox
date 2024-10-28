package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.*;
import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public TodosResponseDto selectAll() {
        return new TodosResponseDto(service.findAll());
    }

    @PostMapping("/todos")
    public TodoResponseDto save(@RequestBody Todo todo) {
        Todo savedTodo = service.save(todo);
        return new TodoResponseDto(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
    }

    @DeleteMapping("/todos/{todoId}")
    public DeleteResponseDto delete(@PathVariable int todoId) {
        int resultId = service.deleteById(todoId) ? todoId : -1;
        return new DeleteResponseDto(resultId);
    }

    @PatchMapping("/todos/{todoId}")
    public UpdateResponseDto fetch(@PathVariable int todoId) {
        Todo updatedTodo = service.updateTodo(todoId);
        int resultId = updatedTodo != null ? todoId : -1;
        return new UpdateResponseDto(resultId);
    }
}