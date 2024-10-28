package com.ssafy.sandbox.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteResponseDto {
    private String message;

    public DeleteResponseDto(int id) {
        if (id == -1) {
            this.message = "정상적이지 않은 요청입니다.";
        } else {
            this.message = id + "의 Todo가 삭제되었습니다.";
        }
    }
}