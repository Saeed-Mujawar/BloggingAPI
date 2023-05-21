package com.geekster.Blogging.Platform.Api.service;

import com.geekster.Blogging.Platform.Api.Repository.ICommentRepo;
import com.geekster.Blogging.Platform.Api.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    ICommentRepo commentRepo;

    public String addcomment(Comment comment) {
        Comment bcomment= commentRepo.save(comment);
        if(bcomment==null){
            return "Comment is not saved";
        }else{
            return "comment saved successfully..!";
        }
    }
}
