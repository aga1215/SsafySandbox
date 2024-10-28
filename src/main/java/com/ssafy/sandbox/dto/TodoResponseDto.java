package com.ssafy.sandbox.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TodoResponseDto {
    private int id;
    private String content;
    private boolean completed;
}