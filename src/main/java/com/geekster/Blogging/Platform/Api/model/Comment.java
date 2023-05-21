package com.geekster.Blogging.Platform.Api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "fk_PostID")
    private Post post;

    @ManyToOne
    @JoinColumn(nullable = false,name = "fk_User_ID")
    private User user;

}
