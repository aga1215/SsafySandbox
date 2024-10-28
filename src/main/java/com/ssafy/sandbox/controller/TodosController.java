package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.TodoRequest;
import com.ssafy.sandbox.dto.TodosResponse;
import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.service.TodosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosController {

    private final TodosService todosService;

    @Autowired
    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    // 모든 할 일 조회 (Read)
    @GetMapping
    public ResponseEntity<TodosResponse> getAllTodos(){
        List<Todo> todos = todosService.getAllTodos();
        TodosResponse response = new TodosResponse(todos);
        return ResponseEntity.ok(response);
    }

    // 새로운 할 일 생성 (Create)
    @PostMapping
    public ResponseEntity<?> createTodo(@Valid @RequestBody TodoRequest todoRequest) {
        Todo savedTodo = todosService.createTodo(todoRequest.getUserId(), todoRequest.getContent(), todoRequest.getComment());
        TodosResponse.TodoDTO dto = TodosResponse.TodoDTO.fromEntity(savedTodo);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // 특정 할 일 업데이트 (Update)
    @PatchMapping("/{todoId}")
    public ResponseEntity<?> updateTodo(@PathVariable int todoId, @RequestBody TodoRequest todoRequest) {
        Todo updatedTodo = todosService.updateTodo(todoId, todoRequest.isCompleted());
        TodosResponse.TodoDTO dto = TodosResponse.TodoDTO.fromEntity(updatedTodo);
        return ResponseEntity.ok(dto);
    }

    // 특정 할 일 삭제 (Delete)
    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable int todoId) {
        todosService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo with id " + todoId + " has been deleted successfully.");
    }
}
