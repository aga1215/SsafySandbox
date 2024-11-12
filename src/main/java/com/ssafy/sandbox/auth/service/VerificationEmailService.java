package com.ssafy.sandbox.auth.service;

import com.ssafy.sandbox.auth.authdto.MemberAuthDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationEmailService {

    private final JavaMailSender emailSender;

    public void sendAuthCode(String recipientEmail, MemberAuthDto authDto) {
        SimpleMailMessage verificationMessage = createVerificationMessage(recipientEmail, authDto.getAuthCode());
        emailSender.send(verificationMessage);
    }

    private SimpleMailMessage createVerificationMessage(String toEmail, String authCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("이메일 인증");
        message.setText("인증 코드: " + authCode);

        return message;
    }
}
