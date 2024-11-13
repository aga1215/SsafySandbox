package com.ssafy.sandbox.auth.authdto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;

@Data
public class MemberAuthDto {

    private String email;
    private String authCode;
    private final LocalDateTime expirationTime;

    public MemberAuthDto(String email) {
        this.email = email;
        this.authCode = generateAuthCode();
        this.expirationTime = LocalDateTime.now().plusMinutes(10); // 만료시간
    }

    public boolean hasExpired() {
        return LocalDateTime.now().isAfter(this.expirationTime);
    }

    private String generateAuthCode() {
        int code = 100000 + new Random().nextInt(900000); // 난수생성
        return String.format("%06d", code);
    }
}