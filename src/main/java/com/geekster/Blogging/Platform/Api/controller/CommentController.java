package com.geekster.Blogging.Platform.Api.controller;

import com.geekster.Blogging.Platform.Api.model.Comment;
import com.geekster.Blogging.Platform.Api.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping(value = "/comment")
    public String addcomment(@Valid @RequestBody Comment comment){
        return commentService.addcomment(comment);
    }
}
