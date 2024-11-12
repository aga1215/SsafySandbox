package com.ssafy.sandbox.auth.authdto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailAuthResponseDto {
    private Boolean isSuccess;
}