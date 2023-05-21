package com.geekster.Blogging.Platform.Api.service;

import com.geekster.Blogging.Platform.Api.Repository.IFollowingRepo;
import com.geekster.Blogging.Platform.Api.model.Following;
import com.geekster.Blogging.Platform.Api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
    @Autowired
    IFollowingRepo fingr;

    public void savefollowing(User myuser, User otheruser) {
        Following followingrecord=new Following(null,myuser,otheruser);
        fingr.save(followingrecord);
    }
}
