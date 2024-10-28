package com.ssafy.sandbox.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateResponseDto {
    private String message;

    public UpdateResponseDto(int id) {
        if (id == -1) {
            this.message = "정상적이지 않은 요청입니다.";
        } else {
            this.message = id + "의 completed가 정상적으로 토글되었습니다.";
        }
    }
}