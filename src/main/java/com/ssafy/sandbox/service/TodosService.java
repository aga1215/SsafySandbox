// src/main/java/com/ssafy/sandbox/service/TodosService.java

package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Todo;
import com.ssafy.sandbox.domain.User;
import com.ssafy.sandbox.repository.TodoRepository;
import com.ssafy.sandbox.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Autowired
    public TodosService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    // 모든 할 일 조회
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 새로운 할 일 생성
    public Todo createTodo(int userId, String content, String comment) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found."));
        Todo todo = new Todo();
        todo.setContent(content);
        todo.setCompleted(false);
        todo.setUser(user);
        // comment가 필요한 경우 별도의 로직 추가 가능
        return todoRepository.save(todo);
    }

    // 특정 할 일 업데이트 (예: 완료 상태 변경)
    public Todo updateTodo(int todoId, boolean completed) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new EntityNotFoundException("Todo with id " + todoId + " not found."));
        todo.setCompleted(completed);
        return todoRepository.save(todo);
    }

    // 특정 할 일 삭제
    public void deleteTodo(int todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new EntityNotFoundException("Todo with id " + todoId + " not found."));
        todoRepository.delete(todo);
    }
}
