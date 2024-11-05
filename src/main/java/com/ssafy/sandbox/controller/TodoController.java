package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.*;
import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<GetTodoResponse> getTodos() {
        List<Todo> todos = todoService.getTodos();
        return ResponseEntity.ok(new GetTodoResponse(todos));
    }


    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody CreateTodoRequest createTodoRequest) {
        todoService.createTodo(createTodoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<Void> toggleStatus(@PathVariable Long todoId) throws Exception {
        todoService.toggleStatus(todoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) throws Exception {
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }

}