package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.domain.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TodosResponseDto {
    private List<TodoDTO> todos;

    public TodosResponseDto(List<Todo> todos) {
        this.todos = todos.stream()
                .map(TodoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Getter
    @Setter
    public static class TodoDTO {
        private int id;
        private String content;
        private boolean completed;

        public static TodoDTO fromEntity(Todo todo) {
            TodoDTO dto = new TodoDTO();
            dto.setId(todo.getId());
            dto.setContent(todo.getContent());
            dto.setCompleted(todo.isCompleted());
            return dto;
        }
    }
}