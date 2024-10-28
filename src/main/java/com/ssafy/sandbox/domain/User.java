/*
package com.ssafy.sandbox.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "UK_users_email", columnNames = "email"),
        @UniqueConstraint(name = "UK_users_oauth", columnNames = {"oauth_provider", "oauth_id"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = true, unique = true, length = 100)
    private String email;

    @Column(nullable = true, length = 100)
    private String pw;

    @Column(name = "auth_type", nullable = false, length = 10)
    private String authType = "local";

    @Column(name = "oauth_provider", nullable = true, length = 20)
    private String oauthProvider;

    @Column(name = "oauth_id", nullable = true, length = 100)
    private String oauthId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos;
}
*/
