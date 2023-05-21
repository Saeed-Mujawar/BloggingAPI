package com.geekster.Blogging.Platform.Api.service;

import com.geekster.Blogging.Platform.Api.Repository.IFollowerRepo;
import com.geekster.Blogging.Platform.Api.model.Follower;
import com.geekster.Blogging.Platform.Api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    IFollowerRepo followerRepo;

    public void saveFollower(User otheruser, User myuser) {
        Follower followerrecord=new Follower(null,otheruser,myuser);
        followerRepo.save(followerrecord);
    }
}
