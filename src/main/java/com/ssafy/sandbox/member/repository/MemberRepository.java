package com.ssafy.sandbox.member.repository;

import com.ssafy.sandbox.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}