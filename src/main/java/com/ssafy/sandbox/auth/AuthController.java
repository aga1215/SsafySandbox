package com.ssafy.sandbox.auth;

import com.ssafy.sandbox.auth.authdto.*;
import com.ssafy.sandbox.auth.service.VerificationEmailService;
import com.ssafy.sandbox.member.service.MemberService;
import com.ssafy.sandbox.auth.service.EmailAuthTokenService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class AuthController {
    private final MemberService memberService;
    private final VerificationEmailService emailVerificationService;
    private final EmailAuthTokenService emailTokenService;

    @PostMapping
    public ResponseEntity<RegisterResponseDto> register(
            @RequestBody RegisterRequestDto emailVerificationRequestDto) {
        String email = emailVerificationRequestDto.getEmail();
        MemberAuthDto memberVerificationDto = new MemberAuthDto(
                emailVerificationRequestDto.getEmail());
        emailTokenService.saveAuthToken(memberVerificationDto);
        emailVerificationService.sendAuthCode(email, memberVerificationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterResponseDto());
    }

    @PostMapping("/authentication")
    public ResponseEntity<EmailAuthResponseDto> authenticateUser(
            @RequestBody EmailAuthRequestDto emailAuthenticationRequestDto) {
        String email = emailAuthenticationRequestDto.getEmail();
        MemberAuthDto tempUser = emailTokenService.getValidAuthToken(email);
        if (tempUser == null
                || !tempUser.getAuthCode().equals(emailAuthenticationRequestDto.getAuthentication())) {
            return ResponseEntity.ok(new EmailAuthResponseDto(Boolean.FALSE));
        }

        memberService.registerMember(email);
        emailTokenService.deleteAuthToken(email);

        return ResponseEntity.ok(new EmailAuthResponseDto(Boolean.TRUE));
    }
}