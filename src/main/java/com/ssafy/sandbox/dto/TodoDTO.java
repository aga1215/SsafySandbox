package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoDTO {
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