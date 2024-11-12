package com.ssafy.sandbox.member.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    protected Member() {}

    private Member(String email) {
        this.email = email;
    }

    public static Member create(String email) {
        return new Member(email);
    }

}