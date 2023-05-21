package com.geekster.Blogging.Platform.Api.service;

import com.geekster.Blogging.Platform.Api.Repository.IAuthenticationRepo;
import com.geekster.Blogging.Platform.Api.Repository.IPostRepo;
import com.geekster.Blogging.Platform.Api.model.Post;
import com.geekster.Blogging.Platform.Api.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public List<Post> getallpost(String token) {
        User user= authenticationRepo.findFirstByToken(token).getUser();
        List<Post> list= postRepo.findByUser(user);
        return list;
    }

    @Transactional
    public void updatePost(Long postid,String data) {
        postRepo.updatePost(postid,data);
    }

    public void addpost(Post post) {
        postRepo.save(post);
    }

    public void deletePost(Long postid) {
        postRepo.deleteById(postid);
    }

}
