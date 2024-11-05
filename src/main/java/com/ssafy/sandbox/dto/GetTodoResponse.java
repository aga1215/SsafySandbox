package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.domain.Todo;

import java.util.List;

public class GetTodoResponse {
    List<Todo> todos;

    public GetTodoResponse(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}