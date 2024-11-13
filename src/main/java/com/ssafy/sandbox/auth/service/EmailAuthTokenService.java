package com.ssafy.sandbox.auth.service;

import com.ssafy.sandbox.auth.authdto.MemberAuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class EmailAuthTokenService {

    private final Map<String, MemberAuthDto> authTokenStorage = new ConcurrentHashMap<>();

    public void saveAuthToken(MemberAuthDto authToken) {
        authTokenStorage.put(authToken.getEmail(), authToken);
    }

    public MemberAuthDto getValidAuthToken(String email) {
        MemberAuthDto authToken = authTokenStorage.get(email);
        if (authToken == null || authToken.hasExpired()) {
            authTokenStorage.remove(email); // 만료 시 삭제
            return null;
        }
        return authToken;
    }

    public void deleteAuthToken(String email) {
        authTokenStorage.remove(email);
    }


}
