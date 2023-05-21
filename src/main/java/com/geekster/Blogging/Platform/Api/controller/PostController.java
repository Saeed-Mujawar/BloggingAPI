package com.geekster.Blogging.Platform.Api.controller;

import com.geekster.Blogging.Platform.Api.model.Post;
import com.geekster.Blogging.Platform.Api.model.User;
import com.geekster.Blogging.Platform.Api.service.AuthenticationService;
import com.geekster.Blogging.Platform.Api.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/post")
    public ResponseEntity<String> addPost(@Valid @RequestParam String email, @RequestParam String token, @RequestBody Post post){
        HttpStatus status;
        String message="";
        if(authenticationService.authenticate(email,token)){
            User user= authenticationService.findUserByToken(token);
            post.setUser(user);
            postService.addpost(post);
            message="Post added successfully";
            status=HttpStatus.OK;
        }else{
            message="Invalid user";
            status=HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(message,status);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> getallpost(@Valid @RequestParam String email,@RequestParam String token){
        HttpStatus status;
        List<Post> postList=null;
        if(authenticationService.authenticate(email,token)){
            postList= postService.getallpost(token);
            status=HttpStatus.OK;
        }else{
            status=HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Post>>(postList,status);
    }

    @PutMapping(value = "/update/{postid}/{data}")
    public ResponseEntity<String> updatePost(@Valid @PathVariable Long postId,@RequestParam String email,@RequestParam String token,@PathVariable String data){
        HttpStatus status;
        String message="";
        if(authenticationService.owner(token,postId)){
            postService.updatePost(postId,data);
            status=HttpStatus.OK;
            message="post updated successfully";
        }else{
            status=HttpStatus.FORBIDDEN;
            message="Cannot update...!";
        }
        return new ResponseEntity<String>(message,status);
    }

    @DeleteMapping(value = "/delete/{postid}")
    public void deletepost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

}
