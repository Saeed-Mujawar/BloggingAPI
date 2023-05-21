package com.geekster.Blogging.Platform.Api.service;

import com.geekster.Blogging.Platform.Api.Repository.IAuthenticationRepo;
import com.geekster.Blogging.Platform.Api.Repository.IPostRepo;
import com.geekster.Blogging.Platform.Api.model.AuthenticationToken;
import com.geekster.Blogging.Platform.Api.model.Post;
import com.geekster.Blogging.Platform.Api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authenticationRepo;

    @Autowired
    IPostRepo postRepo;

    public void savetoken(AuthenticationToken token) {
        authenticationRepo.save(token);
    }

    public AuthenticationToken gettoken(User user) {
        return authenticationRepo.findByUser(user);
    }

    public boolean authenticate(String email, String token) {
        AuthenticationToken authtoken= authenticationRepo.findFirstByToken(token);
        String expectedemail=authtoken.getUser().getUserEmail();
        return expectedemail.equals(email);
    }

    public User findUserByToken(String token) {
        return authenticationRepo.findFirstByToken(token).getUser();
    }

    public boolean owner(String token,Long postid) {
        AuthenticationToken auth= authenticationRepo.findFirstByToken(token);
        Long userid=auth.getUser().getUserId();
        Optional<Post> post= postRepo.findById(postid);
        Long postuserid=post.get().getUser().getUserId();
        if(userid!=postuserid){
            return false;
        }else{
            return true;
        }
    }
}
