package com.ssafy.sandbox.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequest {

    @NotNull(message = "User ID는 필수입니다.")
    @Min(value = 1, message = "User ID는 1 이상이어야 합니다.")
    private int userId;

    @NotBlank(message = "Content는 필수입니다.")
    private String content;

    private String comment;

    private boolean completed;
}
