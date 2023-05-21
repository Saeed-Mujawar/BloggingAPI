package com.geekster.Blogging.Platform.Api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDateTime tokenCreatedDate;

    @OneToOne
    @JoinColumn(name = "fk_User_ID")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.tokenCreatedDate=LocalDateTime.now();
        this.token= UUID.randomUUID().toString();
    }

}
