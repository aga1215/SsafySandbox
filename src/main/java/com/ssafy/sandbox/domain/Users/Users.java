package com.ssafy.sandbox.domain.Users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true, nullable = true, length = 100)
    private String email;

    @Column(nullable = true, length = 100)
    private String pw;

    @Column(name = "auth_type", nullable = false, length = 10)
    private String authType = "local";

    @Column(name = "oauth_provider", nullable = true, length = 20)
    private String oauthProvider;

    @Column(name = "oauth_id", nullable = true, length = 100)
    private String oauthId;
}
