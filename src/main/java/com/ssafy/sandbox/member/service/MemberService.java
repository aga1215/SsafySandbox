package com.ssafy.sandbox.member.service;

import com.ssafy.sandbox.member.model.Member;
import com.ssafy.sandbox.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void registerMember(String email) {
        // 새로운 회원을 생성하고 저장
        Member newMember = Member.create(email);
        memberRepository.save(newMember);
    }
}